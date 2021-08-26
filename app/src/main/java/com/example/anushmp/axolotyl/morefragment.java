package com.example.anushmp.axolotyl;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class morefragment extends Fragment {

    ImageView closebutton;
    TextView authentication;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.morefragment,container,false);

        closebutton = v.findViewById(R.id.closebuttonmore);
        authentication = v.findViewById(R.id.authentication);

        authentication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getContext(),firebaseauthtest.class);

                startActivity(i);


            }
        });


        closebutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getFragmentManager().beginTransaction().remove(morefragment.this).commit();

                    }
                }
        );


        return v;
    }
}
