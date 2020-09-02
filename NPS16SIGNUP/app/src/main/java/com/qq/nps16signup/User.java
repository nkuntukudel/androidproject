package com.qq.nps16signup;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

class User implements Parcelable{
    private String mEmail;
    private String mUsername;
    private String mPassword;
    public User(String email, String username, String password) {
        mEmail = email;
        mUsername = username;
        mPassword = password;

    }

    protected User(Parcel in) {
        mEmail = in.readString();
        mUsername = in.readString();
        mPassword = in.readString();
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
