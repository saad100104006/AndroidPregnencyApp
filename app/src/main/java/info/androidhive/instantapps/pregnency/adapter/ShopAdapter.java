package info.androidhive.instantapps.pregnency.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import info.androidhive.instantapps.pregnency.R;
import info.androidhive.instantapps.pregnency.model.Calendar;
import info.androidhive.instantapps.pregnency.model.Shop;

/**
 * Created by md.tanvirsaad on 7/20/17.
 */



public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> {

    private List<Shop> moviesList;
    TypedArray fruitArray;
    Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;
        public ImageView image;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.description);
            image= (ImageView) view.findViewById(R.id.image);
        }
    }


    public ShopAdapter(List<Shop> moviesList,Context c) {
        this.moviesList = moviesList;
        this.context=c;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shop, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        fruitArray = context.getResources().obtainTypedArray(R.array.pregnanncy);

        Shop movie = moviesList.get(position);
        //  holder.title.setText(movie.getTitle());
        holder.title.setText(movie.getTitle());
        holder.description.setText(movie.getDescription());
        holder.image.setImageResource(fruitArray.getResourceId(position, -1));


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}

