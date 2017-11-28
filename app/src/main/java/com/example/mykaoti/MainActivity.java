package com.example.mykaoti;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.mycartutils.bean.ChildBean;
import com.bwie.mycartutils.bean.GroupBean;
import com.bwie.mycartutils.utils.CartUtils;
import com.example.mykaoti.adapter.MyAdapter;
import com.example.mykaoti.bean.Bean;
import com.example.mykaoti.bean.NetDataBean;
import com.example.mykaoti.presenter.MyXRVpresenter;
import com.example.mykaoti.view.IXrecyclerview;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity implements IXrecyclerview {

    MyXRVpresenter presenter=new MyXRVpresenter(this,this);
    RecyclerView xrv;
    int num=30;
    int offset=1;
    Handler handler=new Handler();
    private SpringView springView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xrv= (RecyclerView) findViewById(R.id.xrv);

        View view=View.inflate(MainActivity.this,R.layout.head_layout,null);

    }
    @Override
    public void ShowXrv(final Bean bean) {
        LinearLayoutManager manager=new LinearLayoutManager(MainActivity.this);
        xrv.setLayoutManager(manager);
        final MyAdapter adapter=new MyAdapter(MainActivity.this,bean);
        xrv.setAdapter(adapter);


        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,bean.getData().get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        //上拉刷新  以及下拉加载
        springView = (SpringView) findViewById(R.id.springview);

        springView.setHeader(new DefaultHeader(this));
        springView.setFooter(new DefaultFooter(this));


        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                //下啦

                springView.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
// 上啦
                springView.onFinishFreshAndLoad();

            }
        });

    }
}
