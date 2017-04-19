package com.example.administrator.fastshop.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.fastshop.R;
import com.example.administrator.fastshop.view.activity.GoodsDetailsActivity;
import com.example.administrator.fastshop.view.bean.AllGoodsBean;
import com.example.administrator.fastshop.view.bean.NewShowGoodsBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/17.
 */

public class NewShowGoodsAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<NewShowGoodsBean> mList;
    private RecyclerView parent;
    private View.OnClickListener onClickListener;

    public NewShowGoodsAdapter(final Context context, ArrayList<NewShowGoodsBean> list) {
        this.context = context;
        if (mList != null) {
            this.mList.clear();
            this.mList.addAll(list);
        } else {
            mList = new ArrayList<>();
            mList.addAll(list);
        }
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.item_new_show_ll:
                        String goodsId = (String) v.getTag();
                        Intent intent = new Intent();
                        intent.putExtra("goodsId", goodsId);
                        intent.setClass(context, GoodsDetailsActivity.class);
                        context.startActivity(intent);
                        break;
                }

            }
        };
    }

    public void initData(ArrayList<NewShowGoodsBean> goodsBeanArrayList) {
        if (mList != null) {
            mList.clear();
        }
        mList.addAll(goodsBeanArrayList);
        notifyDataSetChanged();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.parent = (RecyclerView) parent;
        RecyclerView.ViewHolder holder = null;
        View layout = LayoutInflater.from(context).inflate(R.layout.item_new_show, parent, false);
        holder = new NewShowGoodsViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NewShowGoodsBean goodsBean = mList.get(position);
        ((NewShowGoodsViewHolder) holder).itemNewShowLl.setTag(goodsBean.getAllgoodsId());
        ((NewShowGoodsViewHolder) holder).itemNewShowTvName.setText(goodsBean.getGoodsName());
        ((NewShowGoodsViewHolder) holder).itemNewShowTvUsername.setText(goodsBean.getUsername());
        ((NewShowGoodsViewHolder) holder).itemNewShowTvNum.setText(goodsBean.getNum());
        ((NewShowGoodsViewHolder) holder).itemNewShowTvCount.setText(goodsBean.getCount());
        ((NewShowGoodsViewHolder) holder).itemNewShowTvTime.setText(goodsBean.getTime());
        Glide.with(context).load(goodsBean.getImageUrl()).into(((NewShowGoodsViewHolder) holder).itemNewShowImage);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class NewShowGoodsViewHolder extends RecyclerView.ViewHolder {
        LinearLayout itemNewShowLl;
        ImageView itemNewShowImage;
        TextView itemNewShowTvName,itemNewShowTvUsername,itemNewShowTvNum,itemNewShowTvCount,itemNewShowTvTime;

        public NewShowGoodsViewHolder(View itemView) {
            super(itemView);
            itemNewShowLl = (LinearLayout) itemView.findViewById(R.id.item_new_show_ll);
            itemNewShowImage = (ImageView) itemView.findViewById(R.id.item_new_show_image);
            itemNewShowTvName = (TextView) itemView.findViewById(R.id.item_new_show_tv_name);
            itemNewShowTvUsername = (TextView) itemView.findViewById(R.id.item_new_show_tv_username);
            itemNewShowTvNum = (TextView) itemView.findViewById(R.id.item_new_show_tv_num);
            itemNewShowTvCount = (TextView) itemView.findViewById(R.id.item_new_show_tv_count);
            itemNewShowTvTime = (TextView) itemView.findViewById(R.id.item_new_show_tv_time);

            itemNewShowLl.setOnClickListener(onClickListener);
        }
    }
}
