package com.example.anushmp.axolotyl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class portfoliofragment extends Fragment {

    private boolean isLoggedIn;
    private TextView header;
    private ImageView closeButton;
    private EditText email;
    private EditText password;
    private TextView LoginButton;

    //FirebaseDatabase db = FirebaseDatabase.getInstance();
   // DatabaseReference dbref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View portfolioView = inflater.inflate(R.layout.portfolio,container,false);

        header = portfolioView.findViewById(R.id.headingport);
        closeButton = portfolioView.findViewById(R.id.closebuttonf);

        email = portfolioView.findViewById(R.id.email);
        password = portfolioView.findViewById(R.id.password);

        LoginButton = portfolioView.findViewById(R.id.loginbutton);

        //dbref = db.getReference("users");

       // dbref.setValue("test");




        isLoggedIn = false;

        if(isLoggedIn == true){

            email.setVisibility(View.INVISIBLE);
            password.setVisibility(View.INVISIBLE);
            LoginButton.setVisibility(View.INVISIBLE);

            //hack.

        }





        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().remove(portfoliofragment.this).commit();

            }
        });



        return portfolioView;
    }
}
