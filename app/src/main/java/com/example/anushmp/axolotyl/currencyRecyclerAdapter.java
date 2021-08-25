package com.example.anushmp.axolotyl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

        holder.currencyText.setText(coindata.get(position));


        holder.currencyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "tapped on it", Toast.LENGTH_SHORT).show();

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



