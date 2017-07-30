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

import com.pregnancy.utils.TextProgressBar;
import com.pregnency.R;


/**
 * Created by Saad on 7/16/17.
 */


public class NotesFragment extends Fragment {

    ImageButton previousBtn;
    ImageView img1;
    TextProgressBar pb;
    private  int myProgress = 1;
    private int refactor = 0;
    TypedArray fruitArray;
    TextView weekCalc,lengthCalc,weightCalc,sizeOfCalc;
    String[] mWeekArray,mLengthArray,mWeightArray,mSizeOfArray;
    ImageButton nextButton;
    int flag=1;


    public static NotesFragment newInstance() {
        return new NotesFragment();
    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_note, container, false);

        return view;


    }




    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        img1 = (ImageView) view.findViewById(R.id.image1);
        weekCalc=(TextView)view.findViewById(R.id.pregnancyText2);
        lengthCalc=(TextView)view.findViewById(R.id.length);
        weightCalc=(TextView)view.findViewById(R.id.weight);
        sizeOfCalc=(TextView)view.findViewById(R.id.sizeof);


        fruitArray = getResources().obtainTypedArray(R.array.pregnanncy_fruits);
        mWeekArray =   getResources().getStringArray(R.array.note);
        mLengthArray=   getResources().getStringArray(R.array.length);
        mWeightArray=   getResources().getStringArray(R.array.weight);
        mSizeOfArray=   getResources().getStringArray(R.array.sizeof);

        nextButton =(ImageButton)view.findViewById(R.id.lulu2);


       pb = new TextProgressBar(getActivity());
        pb = (TextProgressBar) view.findViewById(R.id.pb);
        //final ImageButton   nextBtn = (ImageButton) view.findViewById(R.id.next);
        previousBtn = (ImageButton) view.findViewById(R.id.dunu);
       pb.setScaleY(3.5f);
        Drawable draw = getResources().getDrawable(R.drawable.custom_progressbar);
       pb.setProgressDrawable(draw);


        img1.setImageResource(fruitArray.getResourceId(0, -1));
        weekCalc.setText(mWeekArray[refactor]);
        lengthCalc.setText(mLengthArray[refactor]);
        weightCalc.setText(mWeightArray[refactor]);
        sizeOfCalc.setText(mSizeOfArray[refactor]);





        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick_next(view);
            }
        });



        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (refactor >= 0 && refactor <40 ) {

                    myProgress--;
                    refactor--;

                    if(refactor ==-1 || refactor <0){
                        refactor =0;
                        myProgress=1;
                    }



                    img1.setImageResource(fruitArray.getResourceId(refactor, 0));
                    weekCalc.setText(mWeekArray[refactor]);
                    lengthCalc.setText(mLengthArray[refactor]);
                    weightCalc.setText(mWeightArray[refactor]);
                    sizeOfCalc.setText(mSizeOfArray[refactor]);


                    pb.setProgress(myProgress);
                    pb.setText("Selected week " + myProgress + "/40");



                }
                else{

                    if(refactor >=40){

                        refactor =39;
                    }
                    if(refactor <0){

                        refactor =0;
                    }
                }

            }
        });





    }





    public void onClick_next(View v) {



        if (refactor < 40 && refactor >=0) {
            img1.setImageResource(fruitArray.getResourceId(refactor, 0));
            weekCalc.setText(mWeekArray[refactor]);
            lengthCalc.setText(mLengthArray[refactor]);
            weightCalc.setText(mWeightArray[refactor]);
            sizeOfCalc.setText(mSizeOfArray[refactor]);
          pb.setProgress(myProgress);
            pb.setText("Selected week " + myProgress + "/40");


            myProgress++;
            refactor++;


            if(refactor ==40 || refactor >40){
                refactor =40;
                myProgress=40;
            }
        }
        else {
            if (refactor >= 40) {

                refactor =39;
            }
            if (refactor < 0) {

                refactor = 0;
            }
        }

// here we go!
    }


}

