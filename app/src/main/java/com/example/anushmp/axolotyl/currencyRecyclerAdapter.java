package com.example.anushmp.axolotyl;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class currencyRecyclerAdapter extends RecyclerView.Adapter<currencyRecyclerAdapter.currencyVh> {

    ArrayList<String> coindata = new ArrayList<>();
    Context context;

    public currencyRecyclerAdapter(Context context, ArrayList<String> coindata){

        this.coindata = coindata;
        this.context = context;


    }


    @NonNull
    @Override
    public currencyVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        View currencyview = LayoutInflater.from(parent.getContext()).inflate(R.layout.currencyitemview,parent,false);

        currencyVh cvh = new currencyVh(currencyview);


        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull currencyVh holder, int position) {

        String input = coindata.get(position);

        holder.currencyText.setText(input);


        holder.currencyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String output = "";
                String lookfor = "id:";

                for(int i = 0; i<input.length(); i++){

                    String current = "" + input.charAt(i) + input.charAt(i+1) + input.charAt(i+2);

                    if(current.equals(lookfor)){

                        String outputid = "";

                        for(int j = i+3; j<input.length(); j++){

                            outputid = outputid + input.charAt(j);

                        }

                        outputid = outputid.trim();

                        output = outputid;

                        break;

                    }

                }

                Toast.makeText(context, output, Toast.LENGTH_SHORT).show();


                //Intent i = new Intent(context,marketfragment.class);

                Intent i = new Intent(context,marketviewfull.class);
                i.putExtra("id",output);

                AppCompatActivity act = (AppCompatActivity) v.getContext();
                act.startActivity(i);

                //AppCompatActivity act = (AppCompatActivity) v.getContext();
                //Fragment marketfrag = new marketfragment();

               // act.getSupportFragmentManager().beginTransaction().replace(R.id.fvl,marketfrag)
                       // .addToBackStack(null).commit();

            }
        });



    }

    @Override
    public int getItemCount() {
        return coindata.size();
    }

    public class currencyVh extends RecyclerView.ViewHolder{

        TextView currencyText;


        public currencyVh(@NonNull View itemView) {
            super(itemView);

            currencyText = itemView.findViewById(R.id.currencytext);
        }
    }

}



