package com.fajaradisetyawan.submission2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailTvShowAct extends AppCompatActivity {
    ImageView imgPhoto, imgBroad;
    TextView tvTitleTvShow, tvBroadcast, tvGenreTvShow, tvShowtime, tvSinopsis;
    public static final String EXTRA_TVSHOW = "extra_tvshow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        imgPhoto = findViewById(R.id.img_tvShow);
        imgBroad = findViewById(R.id.img_broadcast);
        tvTitleTvShow = findViewById(R.id.tv_title_tvShow);
        tvShowtime = findViewById(R.id.tv_showtimes);
        tvBroadcast = findViewById(R.id.tv_broadcaster_network);
        tvGenreTvShow = findViewById(R.id.tv_genre_tvShow);
        tvSinopsis = findViewById(R.id.tv_synopsis_tvShow);


        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TVSHOW);
        assert tvShow != null;
        String title = tvShow.getTitleTvShow();
        tvTitleTvShow.setText(title);

        String sinopsis = tvShow.getSynopsisTvShow();
        tvSinopsis.setText(sinopsis);

        String genre = tvShow.getGenreTvShow();
        tvGenreTvShow.setText(genre);

        String showtime = tvShow.getShowtimesTvShow();
        tvShowtime.setText(showtime);

        String broadcast = tvShow.getBroadcastTvShow();
        tvBroadcast.setText(broadcast);

        int imgfoto = tvShow.getPhotoTvShow();
        imgPhoto.setImageResource(imgfoto);
        Glide.with(this)
                .load(tvShow.getPhotoTvShow())
                .into(imgPhoto);

        int imgBroadcast = tvShow.getPhotoBroadcast();
        imgBroad.setImageResource(imgBroadcast);
        Glide.with(this)
                .load(tvShow.getPhotoBroadcast())
                .into(imgBroad);


    }
}
