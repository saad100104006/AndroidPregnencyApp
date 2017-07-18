package info.androidhive.instantapps.pregnency;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by md.tanvirsaad on 7/17/17.
 */


public class BasicActivity extends AppCompatActivity implements OnDateSelectedListener, OnMonthChangedListener {

    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();


    MaterialCalendarView c;

  //  @BindView(R.id.calendarView)
    MaterialCalendarView widget;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        textView=(TextView)findViewById(R.id.textView);
        widget=(MaterialCalendarView)findViewById(R.id.calendarView);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

       // ButterKnife.bind(this);

        widget.setOnDateChangedListener(this);
        widget.setOnMonthChangedListener(this);

        //Setup initial text
        textView.setText(getSelectedDatesString());
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @Nullable CalendarDay date, boolean selected) {
       // textView.setText(getSelectedDatesString());

        ///
        // create a Dialog component

                final Dialog dialog = new Dialog(this);

                //tell the Dialog to use the dialog.xml as it's layout description

                dialog.setContentView(R.layout.custom_dialog_calendar);
                dialog.setTitle("Android Custom Dialog Box");
                TextView txt = (TextView) dialog.findViewById(R.id.date);

        TextView txt2 = (TextView) dialog.findViewById(R.id.addNote);

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BasicActivity.this,CalendarNoteActivity.class);
                startActivity(intent);
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

        ////
    }

    @Override
    public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
        //noinspection ConstantConditions
        getSupportActionBar().setTitle(FORMATTER.format(date.getDate()));
    }

    private String getSelectedDatesString() {
        CalendarDay date = widget.getSelectedDate();
        if (date == null) {
            return "No Selection";
        }
        return FORMATTER.format(date.getDate());
    }
}
