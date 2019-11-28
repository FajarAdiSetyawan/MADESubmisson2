package com.fajaradisetyawan.submission2;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int photoMovie;
    private String titleMovie;
    private String synopsisMovie;
    private String datereleaseMovie;
    private String genreMovie;
    private String runtimeMovie;

    protected Movie(Parcel in) {
        photoMovie = in.readInt();
        titleMovie = in.readString();
        synopsisMovie = in.readString();
        datereleaseMovie = in.readString();
        genreMovie = in.readString();
        runtimeMovie = in.readString();
    }

    public Movie() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photoMovie);
        dest.writeString(titleMovie);
        dest.writeString(synopsisMovie);
        dest.writeString(datereleaseMovie);
        dest.writeString(genreMovie);
        dest.writeString(runtimeMovie);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getPhotoMovie() {
        return photoMovie;
    }

    public void setPhotoMovie(int photoMovie) {
        this.photoMovie = photoMovie;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public String getSynopsisMovie() {
        return synopsisMovie;
    }

    public void setSynopsisMovie(String synopsisMovie) {
        this.synopsisMovie = synopsisMovie;
    }

    public String getDatereleaseMovie() {
        return datereleaseMovie;
    }

    public void setDatereleaseMovie(String datereleaseMovie) {
        this.datereleaseMovie = datereleaseMovie;
    }

    public String getGenreMovie() {
        return genreMovie;
    }

    public void setGenreMovie(String genreMovie) {
        this.genreMovie = genreMovie;
    }

    public String getRuntimeMovie() {
        return runtimeMovie;
    }

    public void setRuntimeMovie(String runtimeMovie) {
        this.runtimeMovie = runtimeMovie;
    }

}
