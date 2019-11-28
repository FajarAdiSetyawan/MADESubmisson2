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

public class CardViewAdapterTvShow extends RecyclerView.Adapter<CardViewAdapterTvShow.CardViewViewHolder> {

    public static CardViewAdapterTvShow.OnItemClickCallback setOnItemClickCallback;
    private ArrayList<TvShow> listTvShow = new ArrayList<>();
    Context context;

    public CardViewAdapterTvShow(Context context){
        this.context=context;
    }

    public CardViewAdapterTvShow(Context context, ArrayList<TvShow> tvShows) {
        this.listTvShow = tvShows;
    }

    public ArrayList<TvShow> getListTvShow(){
        return listTvShow;
    }

    private CardViewAdapterTvShow.OnItemClickCallback onItemClickCallback;


    public void setOnItemClickCallback(CardViewAdapterTvShow.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_card_view_tv_show, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewAdapterTvShow.CardViewViewHolder holder, final int position) {
        TvShow tvShow = listTvShow.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvShow.getPhotoTvShow())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvTitleTvShow.setText(tvShow.getTitleTvShow());
        holder.tvShowtime.setText(tvShow.getShowtimesTvShow());
        holder.tvGenreTvShow.setText(tvShow.getGenreTvShow());
        holder.tvBroadcast.setText(tvShow.getBroadcastTvShow());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), "" + listTvShow.get(holder.getAdapterPosition()).getTitleTvShow(), Toast.LENGTH_SHORT).show();
                Intent moveDetail = new Intent(view.getContext(), DetailTvShowAct.class);
                moveDetail.putExtra(DetailTvShowAct.EXTRA_TVSHOW, listTvShow.get(position));
                view.getContext().startActivities(new Intent[]{moveDetail});
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTvShow.size();
    }

    @Override
    public long getItemId(int position) {
        return listTvShow.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitleTvShow, tvBroadcast, tvGenreTvShow, tvShowtime;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_tvShow);
            tvTitleTvShow = itemView.findViewById(R.id.tv_title_tvShow);
            tvShowtime = itemView.findViewById(R.id.tv_showtimes);
            tvBroadcast = itemView.findViewById(R.id.tv_broadcaster_network);
            tvGenreTvShow = itemView.findViewById(R.id.tv_genre_tvShow);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(TvShow tvShow);

    }
}
