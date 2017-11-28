package com.example.mykaoti.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.mykaoti.R;
import com.example.mykaoti.bean.Bean;
import com.example.mykaoti.bean.NetDataBean;


/**
 * Created by 杨雪峰 on 2017/11/10.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> implements View.OnClickListener{


    Context context;
    Bean bean;
    public MyAdapter(Context context, Bean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    //模拟接口
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    private OnItemClickListener mOnItemClickListener = null;


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item_layout,null);
        MyHolder holder=new MyHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.singlename.setText(bean.getData().get(position).getTitle());
        holder.songname.setText(bean.getData().get(position).getTitle());
        Glide.with(context)
                .load(bean.getData().get(position).getDetailUrl())
                .into(holder.iv);
        holder.itemView.setTag(position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    @Override
    public int getItemCount() {
        return bean.getData()==null?0:bean.getData().size();
    }
    class MyHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView singlename;
        TextView songname;

        public MyHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.xrv_item_iv);
            singlename=itemView.findViewById(R.id.xrv_item_singlename);
            songname=itemView.findViewById(R.id.xrv_item_songname);
        }
    }
}
