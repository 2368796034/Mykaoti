package com.example.mykaoti.presenter;

import android.content.Context;
import android.util.Log;


import com.example.mykaoti.bean.Bean;
import com.example.mykaoti.bean.NetDataBean;
import com.example.mykaoti.model.MyXRVDataModel;

import com.example.mykaoti.view.IXrecyclerview;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by 杨雪峰 on 2017/11/10.
 */

public class MyXRVpresenter {


    IXrecyclerview view;
    Context context;
    MyXRVDataModel model;

    public MyXRVpresenter(IXrecyclerview view, Context context) {
        this.view = view;
        this.context = context;
        model=new MyXRVDataModel();
    }





}
