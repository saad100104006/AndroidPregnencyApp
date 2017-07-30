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
import com.pregnency.R;

import java.util.Calendar;


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
   private int variable = 0;


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
        title.setText(mWeekArray[variable]);
        description.setText(mLengthArray[variable]);
        // weightCalc.setText(mWeightArray[variable]);
        //  sizeOfCalc.setText(mSizeOfArray[variable]);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (variable < 40 && variable >=0) {
                    img1.setImageResource(fruitArray.getResourceId(variable, -1));
                    title.setText(mWeekArray[variable]);
                    description.setText(mLengthArray[variable]);
                    pb.setProgress(myProgress);
                    pb.setText("Selected week " + myProgress + "/40");


                    myProgress++;
                    variable++;


                    if(variable ==40 || variable >40){
                        variable =40;
                        myProgress=40;
                    }
                }
                else {
                    if (variable >= 40) {

                        variable =39;
                    }
                    if (variable < 0) {

                        variable = 0;
                    }
                }


            }
        });


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (variable >= 0 && variable <40) {
                    myProgress--;
                    variable--;

                    if(variable ==-1 || variable <0){
                        variable =0;
                        myProgress=1;
                    }

                    img1.setImageResource(fruitArray.getResourceId(variable, -1));
                    title.setText(mWeekArray[variable]);
                    description.setText(mLengthArray[variable]);


                    pb.setProgress(myProgress);
                    pb.setText("Selected week " + myProgress + "/40");




                }
                else{

                    if(variable >=40){

                        variable =39;
                    }
                    if(variable <0){

                        variable =0;
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
