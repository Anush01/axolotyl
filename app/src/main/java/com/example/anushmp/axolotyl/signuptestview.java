package com.example.anushmp.axolotyl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;

public class signuptestview extends AppCompatActivity {

    private FirebaseAuth fba;
    private EditText email;
    private EditText password;
    private TextView signup;

    FirebaseDatabase fbd;
    DatabaseReference dbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuptestview);

        signup = findViewById(R.id.signupbutton);

        email = findViewById(R.id.emailinputsignup);
        password = findViewById(R.id.passwordinputsignup);

        fba = FirebaseAuth.getInstance();
        fbd = FirebaseDatabase.getInstance();
        dbr = fbd.getReference("users");



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailfromet = email.getText().toString();
                String passwordfromet = password.getText().toString();

               Matcher isValid = Patterns.EMAIL_ADDRESS.matcher(emailfromet);
               if(isValid.matches() && passwordfromet.length()>5) {

                   fba.createUserWithEmailAndPassword(emailfromet, passwordfromet)
                           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   if(task.isSuccessful()){

                                       UserModel newUser = new UserModel(emailfromet,passwordfromet);

                                       dbr.child(fba.getCurrentUser().getUid()).setValue(newUser)
                                       .addOnCompleteListener(new OnCompleteListener<Void>() {
                                           @Override
                                           public void onComplete(@NonNull Task<Void> task) {

                                               Intent i  = new Intent(signuptestview.this,firebaseauthtest.class);
                                               startActivity(i);

                                           }
                                       });

                                   }
                               }
                           });

               }else{

                   Toast.makeText(signuptestview.this, "invalid email and short password", Toast.LENGTH_LONG).show();

               }



            }
        });


        //tension
        //time
        //sleep deprivation
        //motivation management.
        //thinly veiled threat
        //railway station.
        //systematic train.
        //accent.
    }

    private boolean sanitize(String a, String b) {

        boolean isValid = true;

       // if(Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().matches())){}

        return isValid;

    }
}