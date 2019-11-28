package com.fajaradisetyawan.submission2;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {

    private int photoTvShow;
    private int photoBroadcast;
    private String titleTvShow;
    private String synopsisTvShow;
    private String broadcastTvShow;
    private String genreTvShow;
    private String showtimesTvShow;

    protected TvShow(Parcel in) {
        photoTvShow = in.readInt();
        photoBroadcast = in.readInt();
        titleTvShow = in.readString();
        synopsisTvShow = in.readString();
        broadcastTvShow = in.readString();
        genreTvShow = in.readString();
        showtimesTvShow = in.readString();
    }

    public TvShow() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photoTvShow);
        dest.writeInt(photoBroadcast);
        dest.writeString(titleTvShow);
        dest.writeString(synopsisTvShow);
        dest.writeString(broadcastTvShow);
        dest.writeString(genreTvShow);
        dest.writeString(showtimesTvShow);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    public int getPhotoTvShow() {
        return photoTvShow;
    }

    public void setPhotoTvShow(int photoTvShow) {
        this.photoTvShow = photoTvShow;
    }

    public String getTitleTvShow() {
        return titleTvShow;
    }

    public void setTitleTvShow(String titleTvShow) {
        this.titleTvShow = titleTvShow;
    }

    public String getSynopsisTvShow() {
        return synopsisTvShow;
    }

    public void setSynopsisTvShow(String synopsisTvShow) {
        this.synopsisTvShow = synopsisTvShow;
    }

    public String getBroadcastTvShow() {
        return broadcastTvShow;
    }

    public void setBroadcastTvShow(String broadcastTvShow) {
        this.broadcastTvShow = broadcastTvShow;
    }

    public String getGenreTvShow() {
        return genreTvShow;
    }

    public void setGenreTvShow(String genreTvShow) {
        this.genreTvShow = genreTvShow;
    }

    public String getShowtimesTvShow() {
        return showtimesTvShow;
    }

    public void setShowtimesTvShow(String showtimesTvShow) {
        this.showtimesTvShow = showtimesTvShow;
    }

    public int getPhotoBroadcast() {
        return photoBroadcast;
    }

    public void setPhotoBroadcast(int photoBroadcast) {
        this.photoBroadcast = photoBroadcast;
    }
}
