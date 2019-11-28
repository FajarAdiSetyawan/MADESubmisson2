package com.fajaradisetyawan.submission2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Path;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.florent37.shapeofview.ShapeOfView;
import com.github.florent37.shapeofview.manager.ClipPathManager;

public class DetailMovieAct extends AppCompatActivity {

    ImageView imgPhoto;
    TextView tvTitleMovie, tvGenreMovie, tvRelase, tvRuntime, tvSinopsis;
    public static final String EXTRA_MOVIE="extra_movie";
    private Movie movie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        imgPhoto = findViewById(R.id.img_movie);
        tvTitleMovie = findViewById(R.id.txt_titleMovie);
        tvGenreMovie = findViewById(R.id.tv_genre_movie);
        tvRelase = findViewById(R.id.tv_release_movie);
        tvRuntime = findViewById(R.id.tv_runtime_movie);
        tvSinopsis = findViewById(R.id.tv_synopsis_movie);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        assert movie != null;
        String title = movie.getTitleMovie();
        tvTitleMovie.setText(title);
        
        String sinopsis = movie.getSynopsisMovie();
        tvSinopsis.setText(sinopsis);


        String genre = movie.getGenreMovie();
        tvGenreMovie.setText(genre);

        String runtime = movie.getRuntimeMovie();
        tvRuntime.setText(runtime);

        String relase = movie.getDatereleaseMovie();
        tvRelase.setText(relase);

        int imgfoto = movie.getPhotoMovie();
        imgPhoto.setImageResource(imgfoto);
        Glide.with(this)
                .load(movie.getPhotoMovie())
                .into(imgPhoto);


    }
}

