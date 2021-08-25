package com.example.anushmp.axolotyl;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class fragAdapter extends FragmentStateAdapter {
    public fragAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if(position == 1){return new exchanges();}
        if(position == 2){return new pools(); }
        if(position == 3){return  new balancesheet();}


        return new cryptocurrency();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
