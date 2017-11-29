package com.example.rikao1129.view;


import com.example.rikao1129.bean.OneDataBean;

/**
 * Created by lenovo on 2017/11/28.
 */

public interface IShowDataView {
    public  void success(OneDataBean bean);
    public  void error(Exception e);
}
