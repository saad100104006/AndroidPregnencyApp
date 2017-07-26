package com.pregnancy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

import com.pregnancy.model.Calendar;
import com.pregnancy.adapter.CalendarAdapter;
import com.pregnancy.utils.PregnancyDB;
import info.androidhive.instantapps.pregnency.R;
import com.pregnancy.utils.RecyclerTouchListener;

/**
 * Created by md.tanvirsaad on 7/19/17.
 */


public class CalendarNoteShowFragement extends Fragment {

    private List<Calendar> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CalendarAdapter mAdapter;
    EditText textView;
    Toolbar toolbar;
    PregnancyDB db;
    private AdView mAdView;
    private Button btnFullscreenAd;
    //2
    public static CalendarFragment newInstance() {
        return new CalendarFragment();
    }

    //3

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_note_show, container, false);


        mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);


        db=new PregnancyDB(getActivity());
        movieList=db.GetAllCalendar();

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mAdapter = new CalendarAdapter( movieList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Calendar movie = movieList.get(position);
                Toast.makeText(getActivity().getApplicationContext(), movie.getCal_date() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



        return  view;
    }
}
