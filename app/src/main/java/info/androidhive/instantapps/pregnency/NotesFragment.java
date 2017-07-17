package info.androidhive.instantapps.pregnency;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Saad on 7/16/17.
 */


public class NotesFragment extends Fragment {

    ImageButton nextBtn, previousBtn;
    ImageView img1;
    TextProgressBar pb;
    int myProgress = 0;
    int i = 0;
    TypedArray fruitArray;
    TextView weekCalc,lengthCalc,weightCalc,sizeOfCalc;
    String[] mWeekArray,mLengthArray,mWeightArray,mSizeOfArray;


    public static NotesFragment newInstance() {
        return new NotesFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_one, container, false);
        fruitArray = getResources().obtainTypedArray(R.array.pregnanncy_fruits);

        mWeekArray =   getResources().getStringArray(R.array.note);
        mLengthArray=   getResources().getStringArray(R.array.length);
        mWeightArray=   getResources().getStringArray(R.array.weight);
        mSizeOfArray=   getResources().getStringArray(R.array.sizeof);

        img1 = (ImageView) view.findViewById(R.id.image1);
        nextBtn = (ImageButton) getActivity().findViewById(R.id.next);
        previousBtn = (ImageButton) getActivity().findViewById(R.id.previous);

        weekCalc=(TextView)view.findViewById(R.id.pregnancyText2);
        lengthCalc=(TextView)view.findViewById(R.id.length);
        weightCalc=(TextView)view.findViewById(R.id.weight);
        sizeOfCalc=(TextView)view.findViewById(R.id.sizeof);


        pb = new TextProgressBar(getActivity());
        pb = (TextProgressBar) getActivity().findViewById(R.id.pb);
        pb.setScaleY(3.5f);
        Drawable draw = getResources().getDrawable(R.drawable.custom_progressbar);
        pb.setProgressDrawable(draw);


        img1.setImageResource(fruitArray.getResourceId(0, -1));
        weekCalc.setText(mWeekArray[i]);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i <= 41) {
                    img1.setImageResource(fruitArray.getResourceId(i, -1));
                    weekCalc.setText(mWeekArray[i]);
                    lengthCalc.setText(mLengthArray[i]);
                    weightCalc.setText(mWeightArray[i]);
                    sizeOfCalc.setText(mSizeOfArray[i]);

                    myProgress++;
                    i++;
                    pb.setProgress(myProgress);
                    pb.setText("Selected week " + myProgress + "/42");
                    if(i==42){
                        i=41;
                    }
                }


            }
        });


        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (i >= 0) {
                    img1.setImageResource(fruitArray.getResourceId(i, -1));
                    weekCalc.setText(mWeekArray[i]);
                    lengthCalc.setText(mLengthArray[i]);
                    weightCalc.setText(mWeightArray[i]);
                    sizeOfCalc.setText(mSizeOfArray[i]);
                    myProgress--;
                    i--;
                    pb.setProgress(myProgress);
                    pb.setText("Selected week " + myProgress + "/42");

                    if(i==-1){
                        i=0;
                    }
                }

            }
        });

        return view;


        //   new Thread(myThread).start();

    }
}

