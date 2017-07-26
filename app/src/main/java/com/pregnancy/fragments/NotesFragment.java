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

import info.androidhive.instantapps.pregnency.R;
import com.pregnancy.utils.TextProgressBar;

/**
 * Created by Saad on 7/16/17.
 */


public class NotesFragment extends Fragment {

    ImageButton nextBtn, previousBtn;
    ImageView img1;
    TextProgressBar pb;
    private  int myProgress = 1;
    private int i = 0;
    TypedArray fruitArray;
    TextView weekCalc,lengthCalc,weightCalc,sizeOfCalc;
    String[] mWeekArray,mLengthArray,mWeightArray,mSizeOfArray;


    public static NotesFragment newInstance() {
        return new NotesFragment();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        fruitArray = getResources().obtainTypedArray(R.array.pregnanncy_fruits);
        mWeekArray =   getResources().getStringArray(R.array.note);
        mLengthArray=   getResources().getStringArray(R.array.length);
      mWeightArray=   getResources().getStringArray(R.array.weight);
       mSizeOfArray=   getResources().getStringArray(R.array.sizeof);


        pb = new TextProgressBar(getActivity());
        pb = (TextProgressBar) getActivity().findViewById(R.id.pb);
        nextBtn = (ImageButton) getActivity().findViewById(R.id.next);
        previousBtn = (ImageButton) getActivity().findViewById(R.id.previous);
        pb.setScaleY(3.5f);
        Drawable draw = getResources().getDrawable(R.drawable.custom_progressbar);
        pb.setProgressDrawable(draw);


        img1.setImageResource(fruitArray.getResourceId(0, -1));
        weekCalc.setText(mWeekArray[i]);
        lengthCalc.setText(mLengthArray[i]);
       weightCalc.setText(mWeightArray[i]);
        sizeOfCalc.setText(mSizeOfArray[i]);



        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

/*
                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();*/


                if (i < 40 && i>=0) {
                    img1.setImageResource(fruitArray.getResourceId(i, 0));
                    weekCalc.setText(mWeekArray[i]);
                    lengthCalc.setText(mLengthArray[i]);
                    weightCalc.setText(mWeightArray[i]);
                    sizeOfCalc.setText(mSizeOfArray[i]);
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


        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (i >= 0 && i<40) {
                    img1.setImageResource(fruitArray.getResourceId(i, 0));
                    weekCalc.setText(mWeekArray[i]);
                    lengthCalc.setText(mLengthArray[i]);
                    weightCalc.setText(mWeightArray[i]);
                    sizeOfCalc.setText(mSizeOfArray[i]);


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_note, container, false);




        img1 = (ImageView) view.findViewById(R.id.image1);
        weekCalc=(TextView)view.findViewById(R.id.pregnancyText2);
        lengthCalc=(TextView)view.findViewById(R.id.length);
        weightCalc=(TextView)view.findViewById(R.id.weight);
        sizeOfCalc=(TextView)view.findViewById(R.id.sizeof);





        return view;


    }
}

