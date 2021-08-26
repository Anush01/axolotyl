package com.example.anushmp.axolotyl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

public class firebaseauthtest extends AppCompatActivity {

    TextView signup;
    TextView signin;
    TextView displayName;
    TextView signoutbutton;

    FirebaseDatabase fbd;
    DatabaseReference dbr;
    FirebaseAuth auth;


    @Override
    protected void onStart() {
        super.onStart();

        if(auth.getCurrentUser()!= null){
            GenericTypeIndicator<UserModel> gti = new GenericTypeIndicator<UserModel>() {
            };

            dbr.child(auth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    UserModel currentuser = snapshot.getValue(gti);
                    displayName.append("\n" + currentuser.getEmail() +"\n" + currentuser.getPassword());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebaseauthtest);

        signin = findViewById(R.id.firebasesignin);
        signup = findViewById(R.id.firebasesignup);
        displayName = findViewById(R.id.signinsuccess);
        signoutbutton = findViewById(R.id.signoutbutton);
        fbd = FirebaseDatabase.getInstance();
        dbr = fbd.getReference("users");
        auth = FirebaseAuth.getInstance();



        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(firebaseauthtest.this,signintestview.class);

                startActivity(i);

            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(firebaseauthtest.this,signuptestview.class);

                startActivity(i);

            }
        });



        signoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                auth.signOut();

                Toast.makeText(firebaseauthtest.this, "signout successfull", Toast.LENGTH_SHORT).show();
                displayName.setText("signed out. sign in or sign up or relaunch this activity.");

            }
        });



    }
}