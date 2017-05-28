package com.mycaker.panu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Carlos on 27/05/2017.
 */

public class AdaptadorPaginas extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments;

    public AdaptadorPaginas(FragmentManager fm) {
        super(fm);
    }

    public AdaptadorPaginas(FragmentManager fm, ArrayList<Fragment> fragments){
        super(fm);
        this.fragments=fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "pagina "+(position+1);
    }
}
