package com.pregnancy.fragments;

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
import com.pregnancy.utils.TextProgressBar77;

import java.util.Calendar;

import info.androidhive.instantapps.pregnency.R;

/**
 * Created by Saad on 7/12/17.
 */


public class BabyFragment extends Fragment {

    ImageButton next, previous;
    ImageView img1;
    TextView title, description, today, week, month, expected;
    TextProgressBar77 pb;
    private int[] textureArrayWin = {
            R.drawable.img1,
            R.drawable.ic_woman_white,
            R.drawable.ic_baby_white,
    };
    InterstitialAd mInterstitialAd;

    Calendar calendar2;

    String[] mWeekArray, mLengthArray, mWeightArray, mSizeOfArray;
    TypedArray fruitArray;

  private  int myProgress = 1;
   private int i = 0;


    //2
    public static BabyFragment newInstance() {
        return new BabyFragment();
    }




    //3

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_baby, container, false);

        title = (TextView) view.findViewById(R.id.title);
        description = (TextView) view.findViewById(R.id.description);
        img1 = (ImageView) view.findViewById(R.id.image1);

        return view;

    }




    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



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




        fruitArray = getResources().obtainTypedArray(R.array.pregnanncy_fruits);
        mWeekArray = getResources().getStringArray(R.array.note);
        mLengthArray = getResources().getStringArray(R.array.length);
        // mWeightArray = getResources().getStringArray(R.array.weight);
        // mSizeOfArray = getResources().getStringArray(R.array.sizeof);


        pb = new TextProgressBar77(getActivity());
        pb = (TextProgressBar77) getActivity().findViewById(R.id.pb9);
        next = (ImageButton) getActivity().findViewById(R.id.post);
        previous = (ImageButton) getActivity().findViewById(R.id.pre);
        pb.setScaleY(3.5f);
        Drawable draw = getResources().getDrawable(R.drawable.custom_progressbar);
        pb.setProgressDrawable(draw);


        img1.setImageResource(fruitArray.getResourceId(0, -1));
        title.setText(mWeekArray[i]);
        description.setText(mLengthArray[i]);
        // weightCalc.setText(mWeightArray[i]);
        //  sizeOfCalc.setText(mSizeOfArray[i]);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (i < 40 && i>=0) {
                    img1.setImageResource(fruitArray.getResourceId(i, -1));
                    title.setText(mWeekArray[i]);
                    description.setText(mLengthArray[i]);
                    pb.setProgress(myProgress);
                    pb.setText("Selected week " + myProgress + "/40");


                    myProgress++;
                    i++;


                    if(i==40 || i>40){
                        i=40;
                        myProgress=40;
                    }
                }
                else {
                    if (i >= 40) {

                        i=39;
                    }
                    if (i < 0) {

                        i = 0;
                    }
                }


            }
        });


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (i >= 0 && i<40) {
                    myProgress--;
                    i--;
                    img1.setImageResource(fruitArray.getResourceId(i, -1));
                    title.setText(mWeekArray[i]);
                    description.setText(mLengthArray[i]);


                    pb.setProgress(myProgress);
                    pb.setText("Selected week " + myProgress + "/40");



                    if(i==-1 || i<0){
                        i=0;
                        myProgress=0;
                    }
                }
                else{

                    if(i>=40){

                        i=39;
                    }
                    if(i<0){

                        i=0;
                    }
                }

            }
        });


    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }



    }


}
