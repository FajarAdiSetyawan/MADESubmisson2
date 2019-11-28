package com.fajaradisetyawan.submission2;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovieFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieFragment extends Fragment {

    private RecyclerView rvMovie;
    private ArrayList<Movie> movies = new ArrayList<>();
    private String[] dataTitleMovie;
    private String[] dataGenreMovie;
    private String[] dataRelase;
    private String[] dataRuntime;
    private String[] dataSinopsisMovie;
    private TypedArray dataPhotoMovie;

    private Context context = getContext();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;

    public MovieFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MovieFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MovieFragment newInstance(String param1, String param2) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_movie, container, false);
        rvMovie = (RecyclerView) view.findViewById(R.id.rv_movie);
        CardViewAdapterMovie cardViewAdapterMovie = new CardViewAdapterMovie(getContext(), movies);
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMovie.setAdapter(cardViewAdapterMovie);
        return view;
    }

    public void onViewCreated(@Nullable View view, Bundle savedinstance){
        super.onViewCreated(view,savedinstance);
        movies.addAll(getListcard());

        Showcardlist();

    }

    private ArrayList<Movie> getListcard(){
        dataTitleMovie = getResources().getStringArray(R.array.data_title_movie);
        dataGenreMovie = getResources().getStringArray(R.array.data_genre_movie);
        dataRelase = getResources().getStringArray(R.array.date_release_movie);
        dataRuntime = getResources().getStringArray(R.array.data_runtime_movie);
        dataSinopsisMovie = getResources().getStringArray(R.array.data_synopsis_movie);
        dataPhotoMovie = getResources().obtainTypedArray(R.array.data_photo_movie);

        ArrayList<Movie> movies=new ArrayList<>();
        for (int i = 0; i < dataTitleMovie.length;i++){
            Movie movie = new Movie();
            movie.setPhotoMovie(dataPhotoMovie.getResourceId(i, -1));
            movie.setTitleMovie(dataTitleMovie[i]);
            movie.setSynopsisMovie(dataSinopsisMovie[i]);
            movie.setDatereleaseMovie(dataRelase[i]);
            movie.setRuntimeMovie(dataRuntime[i]);
            movie.setGenreMovie(dataGenreMovie[i]);
            movies.add(movie);
        }
        return movies;
    }

    private void Showcardlist(){

        CardViewAdapterMovie cardViewAdapterMovie = new CardViewAdapterMovie(getContext(), movies);
        rvMovie.setAdapter(cardViewAdapterMovie);
    }


}
