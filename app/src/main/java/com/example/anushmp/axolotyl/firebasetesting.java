package com.example.anushmp.axolotyl;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

public class firebasetesting {

    //public speaking
    //randomlly assigned crypto app
    // people. masai cycle. compute storage networking. dsa.
    //firestore.
    //images.
    //comments
    //image upload.
    //intents fragments.


    FirebaseDatabase db = FirebaseDatabase.getInstance();

    DatabaseReference dbref = db.getReference("users");

    UserModel userAnush = new UserModel("anush","password");

   public void commit(){

       dbref.setValue(userAnush);
   }


   public void getfromdatabse(){

       dbref.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {

               GenericTypeIndicator<UserModel> gti = new GenericTypeIndicator<UserModel>() {
               };

               UserModel currentuser = snapshot.getValue(gti);

               String currentuserEmail = currentuser.getEmail();
               String currentUserPassword = currentuser.getPassword();

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });

   }


}
