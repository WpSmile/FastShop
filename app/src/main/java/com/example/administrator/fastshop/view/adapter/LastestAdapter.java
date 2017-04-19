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
import com.example.administrator.fastshop.view.bean.GoodsBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/17.
 */

public class LastestAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<GoodsBean> mList;
    private RecyclerView parent;
    private View.OnClickListener onClickListener;

    public LastestAdapter(final Context context, ArrayList<GoodsBean> list) {
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
                String goodsId = (String) v.getTag();
                Intent intent = new Intent();
                intent.putExtra("goodsId", goodsId);
                intent.setClass(context, GoodsDetailsActivity.class);
                context.startActivity(intent);
            }
        };
    }

    public void initData(ArrayList<GoodsBean> goodsBeanArrayList) {
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
        View layout = LayoutInflater.from(context).inflate(R.layout.item_lastest_show_all, parent, false);
        holder = new LastestViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GoodsBean goodsBean = mList.get(position);
        ((LastestViewHolder) holder).itemLastestShowAll.setTag(goodsBean.getGoodsId());
        ((LastestViewHolder) holder).lastestItemTitle.setText(goodsBean.getGoodsName());
        ((LastestViewHolder) holder).lastestItemWinner.setText(goodsBean.getGoodsWinner());
        Glide.with(context).load(goodsBean.getGoodsImageUrl()).into(((LastestViewHolder) holder).lastestItemImage);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class LastestViewHolder extends RecyclerView.ViewHolder {
        LinearLayout itemLastestShowAll;
        ImageView lastestItemImage;
        TextView lastestItemTitle, lastestItemWinner;

        public LastestViewHolder(View itemView) {
            super(itemView);
            itemLastestShowAll = (LinearLayout) itemView.findViewById(R.id.item_lastest_show_all);
            lastestItemImage = (ImageView) itemView.findViewById(R.id.lastest_item_image);
            lastestItemTitle = (TextView) itemView.findViewById(R.id.lastest_item_title);
            lastestItemWinner = (TextView) itemView.findViewById(R.id.lastest_item_winner);

            itemLastestShowAll.setOnClickListener(onClickListener);
        }
    }
}
