package com.example.anushmp.axolotyl;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cryptocurrency#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cryptocurrency extends Fragment {

    ArrayList<String> coindata;
    RecyclerView currencyRecycler;
    SwipeRefreshLayout refresher;
    List<currencyDataModel> currencyinfo;
    //currencyRecyclerAdapter cra;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public cryptocurrency() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment cryptocurrency.
     */
    // TODO: Rename and change types and number of parameters
    public static cryptocurrency newInstance(String param1, String param2) {
        cryptocurrency fragment = new cryptocurrency();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        /*
        Retrofit browser = networker.getRetrofitObject();

        coingeckoapi api = browser.create(coingeckoapi.class);



        api.getcurrencylist().enqueue(new Callback<List<currencyDataModel>>() {
            @Override
            public void onResponse(Call<List<currencyDataModel>> call, Response<List<currencyDataModel>> response) {

                currencyinfo = response.body();

                //fillCurrencyNames();



                for(int i =0; i<currencyinfo.size(); i++){

                    currencyDataModel currency = currencyinfo.get(i);

                    String name = currency.getName();
                    String symbol = currency.getSymbol();

                    coindata.add(name + " " + symbol);


                }





            }

            @Override
            public void onFailure(Call<List<currencyDataModel>> call, Throwable t) {

            }
        });

         */


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View currencyView =  inflater.inflate(R.layout.fragment_cryptocurrency, container, false);

        coindata = new ArrayList<>();
         //fillList();
        //fillCurrencyNames();

        currencyRecycler = currencyView.findViewById(R.id.currencyrecycler);
        refresher = currencyView.findViewById(R.id.swipelay);

       currencyRecyclerAdapter cra = new currencyRecyclerAdapter(getContext(),coindata);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        currencyRecycler.setLayoutManager(llm);
        currencyRecycler.setAdapter(cra);



        Retrofit browser = networker.getRetrofitObject();

        coingeckoapi api = browser.create(coingeckoapi.class);





        api.getcurrencylist().enqueue(new Callback<List<currencyDataModel>>() {
            @Override
            public void onResponse(Call<List<currencyDataModel>> call, Response<List<currencyDataModel>> response) {

                currencyinfo = response.body();

                String nameforlog = currencyinfo.get(0).getName();

                Log.d("retroanush", nameforlog);

                //fillCurrencyNames();



                for(int i =0; i<currencyinfo.size(); i++){

                    currencyDataModel currency = currencyinfo.get(i);

                    String name = currency.getName();
                    String symbol = currency.getSymbol();
                    String id = currency.getId();

                    int oneindexed = i + 1;

                    coindata.add(oneindexed + ".  Name: " + name + "\nSymbol: " + symbol + "\nid: " + id);


                }

               // String logging =

                Log.d("anushlogs", currencyinfo.size() + "");
                Log.d("anushlogs", Thread.currentThread().getName());

                cra.notifyDataSetChanged();





            }

            @Override
            public void onFailure(Call<List<currencyDataModel>> call, Throwable t) {

            }
        });



        //fillCurrencyNames();








        refresher.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //refreshList();
               // cra.notifyDataSetChanged();
                refresher.setRefreshing(false);
            }
        });








        return currencyView;
    }

    private void fillCurrencyNames() {

        //from currencyinfo into coindata.

        //kids

        for(int i =0; i<currencyinfo.size(); i++){

            currencyDataModel currency = currencyinfo.get(i);

            String name = currency.getName();
            String symbol = currency.getSymbol();
            String id = currency.getId();

            coindata.add("Name: " + name + "Symbol: " + symbol + "id: " + id);


        }



    }

    private void refreshList() {

        Random rand = new Random();

        coindata.remove(0);
        coindata.remove(1);

        coindata.add("MillionToken");
        coindata.add("MillionToken");
        coindata.add("MillionToken");
        coindata.add("MillionToken");
        coindata.add("MillionToken");


        for(int i =0; i<5; i++){

            coindata.add("name of coin" + rand.nextInt(100) + "" );
        }

    }

    private void fillList() {

        coindata.add("Bitcoin");
        coindata.add("Ethereum");
        coindata.add("Dogecoin");
        coindata.add("LeetCoin");
        coindata.add("Stellar");
        coindata.add("MillionToken");
        coindata.add("catcoin");
        coindata.add("polygon");

        Random rand = new Random();

        for(int i =0; i<100; i++){

            coindata.add("name of coin" + rand.nextInt(100) + "" );
        }
    }


}