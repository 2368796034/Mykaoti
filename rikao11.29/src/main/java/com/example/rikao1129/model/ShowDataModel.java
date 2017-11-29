package com.example.rikao1129.model;


import com.example.rikao1129.bean.OneDataBean;
import com.example.rikao1129.okhttp.AbstractUiCallBack;
import com.example.rikao1129.okhttp.OkhttpUtils;

/**
 * Created by lenovo on 2017/11/28.
 */

public class ShowDataModel {
    public  void getdata(int page, final IShowModel model){
        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getProducts?pscid=39&page="+page, new AbstractUiCallBack<OneDataBean>() {

            @Override
            public void success(OneDataBean bean) {
                model.success(bean);
            }

            @Override
            public void failure(Exception e) {
                  model.error(e);
            }
        });

    }
}
