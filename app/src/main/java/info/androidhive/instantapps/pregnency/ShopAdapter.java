package info.androidhive.instantapps.pregnency;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by md.tanvirsaad on 7/20/17.
 */



public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> {

    private List<Calendar> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            genre = (TextView) view.findViewById(R.id.date);
            year = (TextView) view.findViewById(R.id.note);
        }
    }


    public ShopAdapter(List<Calendar> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Calendar movie = moviesList.get(position);
        //  holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getCal_date());
        holder.year.setText(movie.getCal_note());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}

