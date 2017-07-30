package com.pregnancy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.pregnancy.utils.PregnancyDB;
import com.pregnency.R;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

/**
 * Created by Saad on 7/18/17.
 */



public class CalendarNoteActivity extends AppCompatActivity {

    MaterialCalendarView c;

    //  @BindView(R.id.calendarView)
    MaterialCalendarView widget;
    EditText textView;
    Toolbar toolbar;
    PregnancyDB db;
    String note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_notes);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
       // If your extra data is represented as strings, then you can use intent.getStringExtra(String name) method. In your case:

         note = intent.getStringExtra("note");



        db = new PregnancyDB(this);
        textView = (EditText) findViewById(R.id.note);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.note_menu, menu);//Menu Resource, Menu
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.check){
            db.insertCalendar(note, textView.getText().toString());
            Toast.makeText(CalendarNoteActivity.this, "Note Added!", Toast.LENGTH_SHORT).show();
            finish();
            overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
        }
       else{
            finish();
            overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
        }
        return super.onOptionsItemSelected(item);
    }


}

