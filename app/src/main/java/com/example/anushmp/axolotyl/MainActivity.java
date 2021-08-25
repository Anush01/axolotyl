package com.example.anushmp.axolotyl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sf;

    TabLayout tablay;
    ViewPager2 vp;
    fragAdapter fa;
    BottomNavigationView bnv;
    TextView close;

   // ArrayList<String> coindata;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // coindata = new ArrayList<>();
        //fillList();


        tablay = findViewById(R.id.tablay);

        vp = findViewById(R.id.viewpager);

        bnv = findViewById(R.id.bottomnav);

        bnv.setOnNavigationItemSelectedListener(navlis);

        close = findViewById(R.id.close);


        FragmentManager fm = getSupportFragmentManager();
        fa = new fragAdapter(fm,getLifecycle());

        vp.setAdapter(fa);

        tablay.addTab(tablay.newTab().setText("cryptocurrency"));
        tablay.addTab(tablay.newTab().setText("exchanges"));
        tablay.addTab(tablay.newTab().setText("pools"));
        tablay.addTab(tablay.newTab().setText("balance sheet"));




        tablay.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tablay.selectTab(tablay.getTabAt(position));
            }
        });




        sf = getSharedPreferences("darkmode",MODE_PRIVATE);

        SharedPreferences.Editor writer = sf.edit();



    }

    /*

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

        for(int i =0; i<10; i++){

            coindata.add("name of coin" + rand.nextInt(100) );
        }


    }

    */

    private BottomNavigationView.OnNavigationItemSelectedListener navlis = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFrag = null;


            if(item.getItemId()== R.id.market){
                selectedFrag = new marketfragment();

            }
            if(item.getItemId() == R.id.portfolio){
                selectedFrag = new portfoliofragment();
            }
            if(item.getItemId() == R.id.search){
                selectedFrag = new searchfragment();
            }

            if(item.getItemId() == R.id.more){
                selectedFrag = new morefragment();
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fvl, selectedFrag).commit();

            return true;

        }

    };

}