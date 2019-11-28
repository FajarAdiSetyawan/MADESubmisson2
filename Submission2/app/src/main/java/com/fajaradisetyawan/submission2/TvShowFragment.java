package com.fajaradisetyawan.submission2;

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
 * Use the {@link TvShowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TvShowFragment extends Fragment {
    private RecyclerView rvTvShow;
    private ArrayList<TvShow> tvShows = new ArrayList<>();
    private String[] dataTitleTvShow;
    private String[] dataGenreTvShow;
    private String[] dataShowtime;
    private String[] dataBroadcast;
    private String[] dataSinopsisTvShow;
    private TypedArray dataPhotoTvShow;
    private TypedArray dataPhotoBroad;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;

    public TvShowFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TvShowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TvShowFragment newInstance(String param1, String param2) {
        TvShowFragment fragment = new TvShowFragment();
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
        view = inflater.inflate(R.layout.fragment_tv_show, container, false);
        rvTvShow = (RecyclerView) view.findViewById(R.id.rv_tvShow);
        CardViewAdapterTvShow cardViewAdapterTvShow = new CardViewAdapterTvShow(getContext(), tvShows);
        rvTvShow.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTvShow.setAdapter(cardViewAdapterTvShow);
        return view;
    }

    public void onViewCreated(@Nullable View view, Bundle savedinstance){
        super.onViewCreated(view,savedinstance);
        tvShows.addAll(getListcard());

        Showcardlist();

    }

    private ArrayList<TvShow> getListcard(){
        dataTitleTvShow = getResources().getStringArray(R.array.data_title_tvShow);
        dataGenreTvShow = getResources().getStringArray(R.array.data_genre_tvShow);
        dataShowtime = getResources().getStringArray(R.array.data_showtimes);
        dataBroadcast = getResources().getStringArray(R.array.data_broadcaster_network_tvShow);
        dataSinopsisTvShow = getResources().getStringArray(R.array.data_synopsis_tvShow);
        dataPhotoTvShow = getResources().obtainTypedArray(R.array.data_photo_tvShow);
        dataPhotoBroad = getResources().obtainTypedArray(R.array.data_photo_broadcast);

        ArrayList<TvShow> tvShows=new ArrayList<>();
        for (int i = 0; i < dataTitleTvShow.length;i++){
            TvShow tvShow = new TvShow();
            tvShow.setPhotoTvShow(dataPhotoTvShow.getResourceId(i, -2));
            tvShow.setPhotoBroadcast(dataPhotoBroad.getResourceId(i, -1));
            tvShow.setTitleTvShow(dataTitleTvShow[i]);
            tvShow.setSynopsisTvShow(dataSinopsisTvShow[i]);
            tvShow.setShowtimesTvShow(dataShowtime[i]);
            tvShow.setBroadcastTvShow(dataBroadcast[i]);
            tvShow.setGenreTvShow(dataGenreTvShow[i]);
            tvShows.add(tvShow);
        }
        return tvShows;
    }

    private void Showcardlist(){

        CardViewAdapterTvShow cardViewAdapterTvShow = new CardViewAdapterTvShow(getContext(), tvShows);
        rvTvShow.setAdapter(cardViewAdapterTvShow);
    }
}
