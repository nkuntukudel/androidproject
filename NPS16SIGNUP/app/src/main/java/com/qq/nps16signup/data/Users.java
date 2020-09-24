package com.qq.nps16signup.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Users {
    @SerializedName("newss")
    private ArrayList<User> user;

    public ArrayList<User> getUser() {
        return user;
    }

    public void setUser(ArrayList<User> list) {
        user = list;
    }
}
