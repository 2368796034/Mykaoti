package com.example.mykaoti.model;




import com.example.mykaoti.okhttp.OkHttp3Utils;

import okhttp3.Callback;


/**
 * Created by 杨雪峰 on 2017/11/10.
 */

public class MyXRVDataModel implements IXRVDataModel {
    @Override
    public void getnetmusicdata(String num, String offset, Callback callback) {

       // OkHttp3Utils.doGet("http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size="+num+"&offset="+offset,callback);

        OkHttp3Utils.doGet("http://120.27.23.105/product/getProducts?pscid=39&page=1",callback);

    }
}
