package com.example.rikao1129.presenter;


import com.example.rikao1129.bean.OneDataBean;
import com.example.rikao1129.model.IShowModel;
import com.example.rikao1129.model.ShowDataModel;
import com.example.rikao1129.view.IShowDataView;

/**
 * Created by lenovo on 2017/11/28.
 */

public class ShowPrecenter {
      ShowDataModel model;
    IShowDataView view;
    public ShowPrecenter(IShowDataView view){
        this.view=view;
        model=new ShowDataModel();
    }
    public  void  getdata(int page){
          model.getdata(page, new IShowModel() {
              @Override
              public void success(OneDataBean bean) {
                     view.success(bean);
              }

              @Override
              public void error(Exception e) {
                 view.error(e);
              }
          });
    }

    }

