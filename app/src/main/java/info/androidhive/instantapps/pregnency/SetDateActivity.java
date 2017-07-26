package info.androidhive.instantapps.pregnency;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

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
    Spinner language;
    private static Locale myLocale;;

    //Shared Preferences Variables
    private static final String Locale_Preference = "Locale Preference";
    private static final String Locale_KeyValue = "Saved Locale";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup_date);

        setDate = (Button) findViewById(R.id.okay);
        lastDate = (EditText) findViewById(R.id.lastDate);
        dueDate = (EditText) findViewById(R.id.dueDate);
        greetings = (TextView) findViewById(R.id.greetings);
         language = (Spinner)findViewById(R.id.spinner1);

        sharedPreferences = getSharedPreferences(Locale_Preference, Activity.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        loadLocale();


        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                showAd();

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

        language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos =position ;

                if(position==0) {
                    changeLocale("en");

                    //changeLocale("en");

                    // PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "en").commit();
                    //setLangRecreate("en");
                }
                else if(position==1){

                    changeLocale("fr");
                }

                else if(position==2){

                    changeLocale("ar");
                }
                else if(position==3){

                    changeLocale("ja");
                }



                else{

                    changeLocale("en");
                    // PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "en").commit();
                    //setLangRecreate("en");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });




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
        SharedPreferences preferences = getSharedPreferences("AUTHENTICATION_FILE_NAME", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("DATE", myCalendar.getTime().toString());
        editor.putLong("milliseconds1", milliseconds1);
        editor.putString("expected_date",String.valueOf(sdf.format(myCalendar.getTime())));
        editor.apply();

        dueDate.setText(sdf.format(myCalendar.getTime()));
        myCalendar.add(Calendar.DATE, -294);


    }

    public void saveLocale(String lang) {
        editor.putString(Locale_KeyValue, lang);
        editor.commit();
    }

    //Get locale method in preferences
    public void loadLocale() {
        String language = sharedPreferences.getString(Locale_KeyValue, "");
        changeLocale(language);
    }

    public void changeLocale(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);//Set Selected Locale
        saveLocale(lang);//Save the selected locale
        Locale.setDefault(myLocale);//set new locale as default
        Configuration config = new Configuration();//get Configuration
        config.locale = myLocale;//set config locale as selected locale
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());//Update the config
        //updateTexts();//Update texts according to locale
    }

    public void showAd(){

        mInterstitialAd = new InterstitialAd(this);

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

    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }


}





