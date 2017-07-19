package info.androidhive.instantapps.pregnency;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by md.tanvirsaad on 7/19/17.
 */




/**
 * Created by md.tanvirsaad on 7/17/17.
 */


public class CalendarFragemntActivity extends AppCompatActivity {


    private List<Calendar> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CalendarAdapter mAdapter;
    EditText textView;
    Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_week_info,
            R.drawable.ic_woman_white,
            R.drawable.ic_baby_white
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_fragment_activity);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
       // toolbar.setNavigationIcon(R.drawable.ic_checked);
        //  toolbar.setTitle(itemType);
        setSupportActionBar(toolbar);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();




        //prepareMovieData();




    }

    private void setupViewPager(ViewPager viewPager) {
       ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new BasicFragment(), "ONE");
        adapter.addFragment(new TwoFragment(), "TWO");
     //   adapter.addFragment(new NotesFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //return mFragmentTitleList.get(position);

            return null;
        }
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[2]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);

    }





}



