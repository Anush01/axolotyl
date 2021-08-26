package com.example.anushmp.axolotyl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;

public class signintestview extends AppCompatActivity {

    private FirebaseAuth fba;
    private EditText email;
    private  EditText password;
    private TextView signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signintestview);

        signin = findViewById(R.id.signinbuttonact);

        email = findViewById(R.id.emailinputsignin);
        password = findViewById(R.id.passwordinputsignin);

        fba = FirebaseAuth.getInstance();


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailinput = email.getText().toString();
                String passwordInput  = password.getText().toString();

                Matcher isvalid = Patterns.EMAIL_ADDRESS.matcher(emailinput);
                boolean passValid = false;
                if(passwordInput.length()<50){passValid = true;}

               if(passValid && isvalid.matches()){
                   fba.signInWithEmailAndPassword(emailinput,passwordInput)
                   .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {

                           Intent i = new Intent(signintestview.this,firebaseauthtest.class);
                           i.putExtra("email",emailinput);
                           i.putExtra("password",passwordInput);
                           startActivity(i);

                       }
                   }).addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {

                           Log.d("authfail", "onFailure: something is wrong here ");

                           Toast.makeText(signintestview.this, "User does not exist", Toast.LENGTH_LONG).show();

                       }
                   });}

            }
        });


    }
}