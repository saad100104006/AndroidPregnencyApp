package info.androidhive.instantapps.pregnency.fragments;

import android.content.res.TypedArray;
import android.graphics.Canvas;
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

import info.androidhive.instantapps.pregnency.adapter.ShopAdapter;
import info.androidhive.instantapps.pregnency.model.Calendar;
import info.androidhive.instantapps.pregnency.adapter.CalendarAdapter;
import info.androidhive.instantapps.pregnency.R;
import info.androidhive.instantapps.pregnency.model.Shop;
import info.androidhive.instantapps.pregnency.utils.PregnancyDB;
import info.androidhive.instantapps.pregnency.utils.RecyclerTouchListener;


/**
 * Created by md.tanvirsaad on 7/19/17.
 */


public class BabyShopFragment extends Fragment {

    private List<Shop> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ShopAdapter mAdapter;
    EditText textView;
    Toolbar toolbar;
    PregnancyDB db;
    TypedArray fruitArray;
    //2
    public static BabyShopFragment newInstance() {
        return new BabyShopFragment();
    }

    //3

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        fruitArray = getActivity().getResources().obtainTypedArray(R.array.pregnanncy_fruits);


        View view = inflater.inflate(R.layout.fragment_baby_shop, container, false);



        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mAdapter = new ShopAdapter( movieList,getActivity());


        prepareMovieData();


        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL) {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                // Do not draw the divider
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Shop movie = movieList.get(position);
                Toast.makeText(getActivity().getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



        return  view;
    }

    private void prepareMovieData() {
        Shop movie = new Shop("Mad Max: Fury Road", "Action & Adventure");
        movieList.add(movie);

        movie = new Shop("Inside Out", "Animation, Kids & Family");
        movieList.add(movie);

        movie = new Shop("Star Wars: Episode VII - The Force Awakens", "Action");
        movieList.add(movie);

        movie = new Shop("Shaun the Sheep", "Animation");
        movieList.add(movie);

        movie = new Shop("The Martian", "Science Fiction & Fantasy");
        movieList.add(movie);

        movie = new Shop("Mission: Impossible Rogue Nation", "Action");
        movieList.add(movie);

        movie = new Shop("Up", "Animation");
        movieList.add(movie);

        movie = new Shop("Star Trek", "Science Fiction");
        movieList.add(movie);

        movie = new Shop("The LEGO Movie", "Animation");
        movieList.add(movie);


        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}

