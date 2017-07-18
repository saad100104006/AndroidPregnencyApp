package info.androidhive.instantapps.pregnency;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

/**
 * Created by Saad on 7/18/17.
 */



/**
 * Created by md.tanvirsaad on 7/17/17.
 */


public class CalendarNoteActivity extends AppCompatActivity {

    MaterialCalendarView c;

    //  @BindView(R.id.calendarView)
    MaterialCalendarView widget;
    EditText textView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_note);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_checked);
      //  toolbar.setTitle(itemType);
      setSupportActionBar(toolbar);

        textView=(EditText) findViewById(R.id.note);

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(CalendarNoteActivity.this, "Back clicked!",     Toast.LENGTH_SHORT).show();
            }
        });



    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}

