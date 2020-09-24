package com.qq.nps16signup.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable{
    @SerializedName("email")
    private String mEmail;
    @SerializedName("username")
    private String mUsername;
    @SerializedName("password")
    private String mPassword;
    @SerializedName("imageurl")
    private String mImageurl;
    public User(String email, String username, String password, String imageurl) {
        mEmail = email;
        mUsername = username;
        mPassword = password;
        mImageurl= imageurl;

    }

    protected User(Parcel in) {
        mEmail = in.readString();
        mUsername = in.readString();
        mPassword = in.readString();
        mImageurl= in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmImageurl() {
        return mImageurl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mEmail);
        parcel.writeString(mUsername);
        parcel.writeString(mPassword);
    }
}
