package com.fajaradisetyawan.submission2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewAdapterMovie extends RecyclerView.Adapter<CardViewAdapterMovie.CardViewViewHolder>{

    public static OnItemClickCallback setOnItemClickCallback;
    private ArrayList<Movie> listMovie = new ArrayList<>();
    Context context;

    public CardViewAdapterMovie(Context context){
        this.context=context;
    }

    public CardViewAdapterMovie(Context context, ArrayList<Movie> movies) {
        this.listMovie = movies;
    }

    public ArrayList<Movie> getListMovie(){
        return listMovie;
    }

    private OnItemClickCallback onItemClickCallback;


    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_card_view_movie, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, final int position) {
        Movie movie = listMovie.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movie.getPhotoMovie())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvTitleMovie.setText(movie.getTitleMovie());
        holder.tvRelaseMovie.setText(movie.getDatereleaseMovie());
        holder.tvRuntime.setText(movie.getRuntimeMovie());
        holder.tvGenreMovie.setText(movie.getGenreMovie());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), "" + listMovie.get(holder.getAdapterPosition()).getTitleMovie(), Toast.LENGTH_SHORT).show();
                Intent moveDetail = new Intent(view.getContext(), DetailMovieAct.class);
                moveDetail.putExtra(DetailMovieAct.EXTRA_MOVIE, listMovie.get(position));
                view.getContext().startActivities(new Intent[]{moveDetail});
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return listMovie.size();
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitleMovie, tvRelaseMovie, tvGenreMovie, tvRuntime;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_movie);
            tvTitleMovie = itemView.findViewById(R.id.tv_title_movie);
            tvRelaseMovie = itemView.findViewById(R.id.tv_release_movie);
            tvRuntime = itemView.findViewById(R.id.tv_runtime_movie);
            tvGenreMovie = itemView.findViewById(R.id.tv_genre_movie);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Movie movie);

    }
}

