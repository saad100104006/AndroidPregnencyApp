package info.androidhive.instantapps.pregnency.fragments;


import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;

import info.androidhive.instantapps.pregnency.R;
import info.androidhive.instantapps.pregnency.utils.TextProgressBar;

/**
 * Created by Saad on 7/10/17.
 */


public class PregnantWomenFragment extends Fragment {

    ImageButton imgBtn;
    ImageView img1;
    TextView text, today, week, month, expected;
    TextProgressBar pb;
    private int[] textureArrayWin = {
            R.drawable.img1,
            R.drawable.ic_woman_white,
            R.drawable.ic_baby_white,
    };
    int myProgress = 0;
    Calendar calendar2;

    String TAG = "AUTHENTICATION_FILE_NAME";

    public PregnantWomenFragment newInstance() {
        return new PregnantWomenFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //   return inflater.inflate(R.layout.fragment_test, container, false);

        View view = inflater.inflate(R.layout.fragment_women, container, false);
        text = (TextView) view.findViewById(R.id.text1);
        today = (TextView) view.findViewById(R.id.today);
        week = (TextView) view.findViewById(R.id.week);
        month = (TextView) view.findViewById(R.id.month);
        expected = (TextView) view.findViewById(R.id.expected);

        img1 = (ImageView) view.findViewById(R.id.image1);
        imgBtn = (ImageButton) getActivity().findViewById(R.id.next);
        pb = new TextProgressBar(getActivity());
        pb = (TextProgressBar) getActivity().findViewById(R.id.pb);
        pb.setScaleY(3.5f);
        Drawable draw = getResources().getDrawable(R.drawable.custom_progressbar);
// set the drawable as progress drawable
        pb.setProgressDrawable(draw);


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


        long diff = milliseconds2 - milliseconds1;
        int diffWeeks = (int) diff / (7 * 24 * 60 * 60 * 1000);
        int days = (int) (diff / (1000 * 60 * 60 * 24));
        int weeks = (int) days / 7;
        int mon = (int) weeks / 4;

        today.setText("Today is your " + days + " th " + "day");
        week.setText("You are in your " + weeks + " " + "weeks");
        month.setText("You are in your " + mon + " " + "months");
        expected.setText("Expected Delivery Date " + expected_date + " ");




        text.setText("jdhgewuhg");
        img1.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_baby_white));

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("Saad");
                img1.setImageResource(textureArrayWin[0]);
                text.setText("saaaad");

                myProgress++;
                pb.setProgress(myProgress);
                pb.setText("week " + myProgress + "/42");


            }
        });


        //   new Thread(myThread).start();

        return view;


    }


}

