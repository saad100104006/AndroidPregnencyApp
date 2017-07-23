package info.androidhive.instantapps.pregnency;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;


/**
 * Created by md.tanvirsaad on 7/21/17.
 */


public class SetDateActivity extends AppCompatActivity {


    Button setDate;
    Calendar myCalendar;
    EditText lastDate, dueDate;
    DatePickerDialog.OnDateSetListener date;
    Calendar calendar1, calendar2, calendar3;
    TextView greetings;
    long milliseconds1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup_date);

        setDate = (Button) findViewById(R.id.okay);
        lastDate = (EditText) findViewById(R.id.lastDate);
        dueDate = (EditText) findViewById(R.id.dueDate);
        greetings = (TextView) findViewById(R.id.greetings);


        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetDateActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
            }
        });


        lastDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SetDateActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }


        });


        myCalendar = Calendar.getInstance();
        calendar1 = Calendar.getInstance();
        calendar2=Calendar.getInstance();

        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            /*    calendar1.set(Calendar.YEAR, year);
                calendar1.set(Calendar.MONTH, monthOfYear);
                calendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);*/


                calendar2 = Calendar.getInstance(TimeZone.getDefault());
                int i = calendar2.get(Calendar.MONTH);
                int j = calendar2.get(Calendar.DAY_OF_MONTH);
                int k = calendar2.get(Calendar.YEAR);

                calendar2.set(k, i, j);
                myCalendar.set(year, monthOfYear, dayOfMonth);
                //  calendar1.set(year,monthOfYear,dayOfMonth);
                milliseconds1 = myCalendar.getTimeInMillis();
                long milliseconds2 = calendar2.getTimeInMillis();
                //calendar1.clear();
                calendar2.clear();
                long diff = milliseconds2 - milliseconds1;
                int diffWeeks = (int) diff / (7 * 24 * 60 * 60 * 1000);

              //  greetings.setText(getResources().getString(R.string.greetings1)+" "+String.valueOf(diffWeeks)+" "+getResources().getString(R.string.greetings2));

                Log.d("SAAAAD", String.valueOf(diffWeeks));


                updateLabel();
            }

        };


    }

    private void updateLabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        lastDate.setText(sdf.format(myCalendar.getTime()));

       /* SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("DATE",myCalendar.getTime().toString());
        editor.apply();*/

        myCalendar.add(Calendar.DATE, 294);
        SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", this.MODE_WORLD_WRITEABLE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("DATE", myCalendar.getTime().toString());
        editor.putLong("milliseconds1", milliseconds1);
        editor.putString("expected_date",String.valueOf(myCalendar.getTime()));
        editor.apply();


        dueDate.setText(sdf.format(myCalendar.getTime()));
        myCalendar.add(Calendar.DATE, -294);


    }


}





