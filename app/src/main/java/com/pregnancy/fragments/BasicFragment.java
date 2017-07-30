package com.pregnancy.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.pregnancy.CalendarNoteActivity;
import com.pregnency.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Saad on 7/12/17.
 */

public class BasicFragment extends Fragment implements OnDateSelectedListener, OnMonthChangedListener {

    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();


    MaterialCalendarView c;
    MaterialCalendarView widget;

    private AdView mAdView;
    private Button btnFullscreenAd;

    public static BasicFragment newInstance() {
        return new BasicFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_basic, container, false);
        widget=(MaterialCalendarView)view.findViewById(R.id.calendarView);

        mAdView = (AdView)view. findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);


        widget.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
               // .setMinimumDate(CalendarDay.from(2016, 4, 3))
                //.setMaximumDate(CalendarDay.from(2016, 5, 12))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                //.setSaveCurrentPosition(true)
                .commit();

        widget.setOnDateChangedListener(this);
        widget.setOnMonthChangedListener(this);

        return view;
    }


    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @Nullable CalendarDay date, boolean selected) {
        // textView.setText(getSelectedDatesString());


        final Dialog dialog = new Dialog(getContext());

        //tell the Dialog to use the dialog.xml as it's layout description

        dialog.setContentView(R.layout.custom_dialog_calendar);
        dialog.setTitle("Android Custom Dialog Box");
        TextView txt = (TextView) dialog.findViewById(R.id.date);

        TextView txt2 = (TextView) dialog.findViewById(R.id.addNote);

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(),CalendarNoteActivity.class);
                intent.putExtra("note",getSelectedDatesString());
                startActivity(intent);
                dialog.dismiss();
            }
        });


        txt.setText(getSelectedDatesString());
        Button dialogButton = (Button) dialog.findViewById(R.id.close);
        dialogButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.show();

    }

    @Override
    public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {

    }

    private String getSelectedDatesString() {
        CalendarDay date = widget.getSelectedDate();
        if (date == null) {
            return "No Selection";
        }
        return FORMATTER.format(date.getDate());
    }
}