package info.androidhive.instantapps.pregnency.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.instantapps.pregnency.Calendar;
import info.androidhive.instantapps.pregnency.CalendarAdapter;
import info.androidhive.instantapps.pregnency.R;
import info.androidhive.instantapps.pregnency.utils.PregnancyDB;
import info.androidhive.instantapps.pregnency.utils.RecyclerTouchListener;


/**
 * Created by md.tanvirsaad on 7/19/17.
 */


public class BabyShopFragment extends Fragment {

    private List<Calendar> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CalendarAdapter mAdapter;
    EditText textView;
    Toolbar toolbar;
    PregnancyDB db;
    //2
    public static BabyShopFragment newInstance() {
        return new BabyShopFragment();
    }

    //3

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_baby_shop, container, false);


        db=new PregnancyDB(getActivity());
        movieList=db.GetAllCalendar();

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mAdapter = new CalendarAdapter( movieList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Calendar movie = movieList.get(position);
                Toast.makeText(getActivity().getApplicationContext(), movie.getCal_date() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



        return  view;
    }
}

