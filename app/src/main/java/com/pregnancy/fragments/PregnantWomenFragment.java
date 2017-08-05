package com.pregnancy.fragments;


import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.pregnancy.utils.TextProgressBar44;
import com.pregnency.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;



/**
 * Created by Saad on 7/10/17.
 */


public class PregnantWomenFragment extends Fragment {

    ImageButton next, previous;
    ImageView img1;
    TextView title, description, today, week, month, expected;
    TextProgressBar44 pb;
    private int[] textureArrayWin = {
            R.drawable.img1,
            R.drawable.ic_woman_white,
            R.drawable.ic_baby_white,
    };

    Calendar calendar2;

    String[] mWeekArray, mLengthArray, mWeightArray, mSizeOfArray;
    TypedArray fruitArray;

    private int myProgress = 1;
    private int indicator = 0;

    InterstitialAd mInterstitialAd;

    String TAG = "AUTHENTICATION_FILE_NAME";

    public static PregnantWomenFragment newInstance() {
        return new PregnantWomenFragment();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //   return inflater.inflate(R.layout.fragment_test, container, false);

        View view = inflater.inflate(R.layout.fragment_women, container, false);




        return view;


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        title = (TextView) view.findViewById(R.id.title);
        description = (TextView) view.findViewById(R.id.description);
        img1 = (ImageView) view.findViewById(R.id.image1);
        //  next = (ImageButton) getActivity().findViewById(R.id.next);
        //  previous = (ImageButton) getActivity().findViewById(R.id.previous);


        today = (TextView) view.findViewById(R.id.today);
        week = (TextView) view.findViewById(R.id.week);
        month = (TextView) view.findViewById(R.id.month);
        expected = (TextView) view.findViewById(R.id.expected);

        fruitArray = getResources().obtainTypedArray(R.array.pregnant_women);
        mWeekArray = getResources().getStringArray(R.array.pregnant_women_string_title);
        mLengthArray = getResources().getStringArray(R.array.pregnant_women_string);
        //  mWeightArray=   getResources().getStringArray(R.array.weight);
        // mSizeOfArray=   getResources().getStringArray(R.array.sizeof);


        pb = new TextProgressBar44(getActivity());
        pb = (TextProgressBar44) getActivity().findViewById(R.id.pb5);
        next = (ImageButton) getActivity().findViewById(R.id.pup);
        previous = (ImageButton) getActivity().findViewById(R.id.tup);
        pb.setScaleY(3.5f);
        Drawable draw = getResources().getDrawable(R.drawable.custom_progressbar);
        pb.setProgressDrawable(draw);




        calendar2 = Calendar.getInstance(TimeZone.getDefault());
        int i5 = calendar2.get(Calendar.MONTH);
        int j = calendar2.get(Calendar.DAY_OF_MONTH);
        int k = calendar2.get(Calendar.YEAR);

        calendar2.set(k, i5, j);


        long milliseconds2 = calendar2.getTimeInMillis();

        SharedPreferences prfs = getActivity().getSharedPreferences(TAG, getActivity().MODE_PRIVATE);
        String Astatus = prfs.getString("DATE", "");
        long milliseconds1 = prfs.getLong("milliseconds1", 0);
        String expected_date = prfs.getString("expected_date", "");


        // editor.putString("expected_date",String.valueOf(myCalendar.getTime()));


        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        //lastDate.setText(sdf.format(myCalendar.getTime()));


        long diff = milliseconds2 - milliseconds1;
        int diffWeeks = (int) diff / (7 * 24 * 60 * 60 * 1000);
        int days = (int) (diff / (1000 * 60 * 60 * 24));
        int weeks = (int) days / 7;
        int mon = (int) weeks / 4;

        today.setText("Today is your " + days + " th " + "day");
        week.setText("You are in your " + weeks + " " + "weeks");
        month.setText("You are in your " + mon + " " + "months");
        expected.setText("Expected Delivery Date " + expected_date + " ");


        mInterstitialAd = new InterstitialAd(getActivity());

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });





        img1.setImageResource(fruitArray.getResourceId(0, -1));
        title.setText(mWeekArray[indicator]);
        description.setText(mLengthArray[indicator]);
        // weightCalc.setText(mWeightArray[indicator]);
        //  sizeOfCalc.setText(mSizeOfArray[indicator]);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (indicator < 40 && indicator >= 0) {
                    img1.setImageResource(fruitArray.getResourceId(indicator, -1));
                    title.setText(mWeekArray[indicator]);
                    description.setText(mLengthArray[indicator]);
                    pb.setProgress(myProgress);
                    pb.setText("Selected week " + myProgress + "/40");


                    myProgress++;
                    indicator++;


                    if (indicator == 40 || indicator > 40) {
                        indicator = 40;
                        myProgress = 40;
                    }
                } else {
                    if (indicator >= 40) {

                        indicator = 39;
                    }
                    if (indicator < 0) {

                        indicator = 0;
                    }
                }


            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (indicator >= 0 && indicator < 40) {

                    myProgress--;
                    indicator--;

                    if (indicator == -1 || indicator < 0) {
                        indicator = 0;
                        myProgress = 1;
                    }


                    img1.setImageResource(fruitArray.getResourceId(indicator, -1));
                    title.setText(mWeekArray[indicator]);
                    description.setText(mLengthArray[indicator]);
                    pb.setProgress(myProgress);
                    pb.setText("Selected week " + myProgress + "/40");




                } else {

                    if (indicator >= 40) {

                        indicator = 39;
                    }
                    if (indicator < 0) {

                        indicator = 0;
                    }
                }

            }
        });



    }

}



