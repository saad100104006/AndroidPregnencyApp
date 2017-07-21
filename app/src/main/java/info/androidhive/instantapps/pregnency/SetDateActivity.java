package info.androidhive.instantapps.pregnency;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.instantapps.pregnency.adapter.CalendarAdapter;
import info.androidhive.instantapps.pregnency.fragments.BabyShopFragment;
import info.androidhive.instantapps.pregnency.model.Calendar;

/**
 * Created by md.tanvirsaad on 7/21/17.
 */



public class SetDateActivity extends AppCompatActivity {


   Button setDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup_date);

        setDate=(Button)findViewById(R.id.okay);


        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SetDateActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
            }
        });


    }

}





