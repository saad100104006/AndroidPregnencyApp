package info.androidhive.instantapps.pregnency.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.androidhive.instantapps.pregnency.R;

/**
 * Created by md.tanvirsaad on 7/17/17.
 */


public class CalendarFragment extends Fragment {
    //2
    public static CalendarFragment newInstance() {
        return new CalendarFragment();
    }

    //3

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_basic, container, false);
    }
}
