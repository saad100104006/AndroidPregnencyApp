package com.pregnancy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pregnancy.fragments.BabyFragment;
import com.pregnancy.fragments.NotesFragment;
import com.pregnancy.fragments.PregnantWomenFragment;

/**
 * Created by Priyabrat on 21-08-2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new NotesFragment();
        }
        else if (position == 1)
        {
            fragment = new PregnantWomenFragment();
        }
        else if (position == 2)
        {
            fragment = new BabyFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    /*@Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Tab-1";
        }
        else if (position == 1)
        {
            title = "Tab-2";
        }
        else if (position == 2)
        {
            title = "Tab-3";
        }
        return title;
    }*/
}
