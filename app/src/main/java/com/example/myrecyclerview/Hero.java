package com.example.myrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class Hero implements Parcelable {
    private String Name;
    private String Detail;
    private int Photo;

    public Hero() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Name);
        parcel.writeString(Detail);
        parcel.writeInt(Photo);
    }

    protected Hero(Parcel in) {
        Name = in.readString();
        Detail = in.readString();
        Photo = in.readInt();
    }

    public static final Creator<Hero> CREATOR = new Creator<Hero>() {
        @Override
        public Hero createFromParcel(Parcel in) {
            return new Hero(in);
        }

        @Override
        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };
}
