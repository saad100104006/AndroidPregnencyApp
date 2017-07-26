package info.androidhive.instantapps.pregnency.fragments;


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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import info.androidhive.instantapps.pregnency.R;
import info.androidhive.instantapps.pregnency.utils.TextProgressBar;

/**
 * Created by Saad on 7/10/17.
 */


public class PregnantWomenFragment extends Fragment {

    ImageButton next,previous;
    ImageView img1;
    TextView title,description, today, week, month, expected;
    TextProgressBar pb;
    private int[] textureArrayWin = {
            R.drawable.img1,
            R.drawable.ic_woman_white,
            R.drawable.ic_baby_white,
    };

    Calendar calendar2;

    String[] mWeekArray,mLengthArray,mWeightArray,mSizeOfArray;
    TypedArray fruitArray;

    private  int myProgress = 1;
    private int i = 0;

    InterstitialAd mInterstitialAd;

    String TAG = "AUTHENTICATION_FILE_NAME";

    public PregnantWomenFragment newInstance() {
        return new PregnantWomenFragment();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


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
        mWeekArray =   getResources().getStringArray(R.array.note);
        mLengthArray=   getResources().getStringArray(R.array.length);
      //  mWeightArray=   getResources().getStringArray(R.array.weight);
       // mSizeOfArray=   getResources().getStringArray(R.array.sizeof);


        pb = new TextProgressBar(getActivity());
        pb = (TextProgressBar) getActivity().findViewById(R.id.pb);
        next = (ImageButton) getActivity().findViewById(R.id.next);
        previous = (ImageButton) getActivity().findViewById(R.id.previous);
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
                    img1.setImageResource(fruitArray.getResourceId(i, -1));
                    title.setText(mWeekArray[i]);
                    description.setText(mLengthArray[i]);
                    pb.setProgress(myProgress);
                    pb.setText("Selected week " + myProgress + "/40");

                    myProgress--;
                    i--;

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



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //   return inflater.inflate(R.layout.fragment_test, container, false);

        View view = inflater.inflate(R.layout.fragment_women, container, false);
        title = (TextView) view.findViewById(R.id.title);
        description=(TextView) view.findViewById(R.id.description);
        img1 = (ImageView) view.findViewById(R.id.image1);
      //  next = (ImageButton) getActivity().findViewById(R.id.next);
      //  previous = (ImageButton) getActivity().findViewById(R.id.previous);


        today = (TextView) view.findViewById(R.id.today);
        week = (TextView) view.findViewById(R.id.week);
        month = (TextView) view.findViewById(R.id.month);
        expected = (TextView) view.findViewById(R.id.expected);



    /*    pb = new TextProgressBar(getActivity());
        pb = (TextProgressBar) getActivity().findViewById(R.id.pb);
        pb.setScaleY(3.5f);
        Drawable draw = getResources().getDrawable(R.drawable.custom_progressbar);
// set the drawable as progress drawable
        pb.setProgressDrawable(draw);*/


        calendar2 = Calendar.getInstance(TimeZone.getDefault());
        int i = calendar2.get(Calendar.MONTH);
        int j = calendar2.get(Calendar.DAY_OF_MONTH);
        int k = calendar2.get(Calendar.YEAR);

        calendar2.set(k, i, j);


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




       // text.setText("jdhgewuhg");
       // img1.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_baby_white));

      /*  next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("Saad");
                img1.setImageResource(textureArrayWin[0]);
                text.setText("saaaad");

                myProgress++;
                pb.setProgress(myProgress);
                pb.setText("Selected week " + myProgress + "/42");


            }
        });*/


        //   new Thread(myThread).start();

        return view;


    }


}

