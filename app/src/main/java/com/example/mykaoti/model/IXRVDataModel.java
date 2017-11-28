package com.example.mykaoti.model;


import okhttp3.Callback;

/**
 * Created by 杨雪峰 on 2017/11/10.
 */

public interface IXRVDataModel {

    public void getnetmusicdata(String num, String offset, Callback callback);

}
