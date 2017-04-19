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
import com.example.administrator.fastshop.view.bean.GoodsBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/17.
 */

public class AllGoodsAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<AllGoodsBean> mList;
    private RecyclerView parent;
    private View.OnClickListener onClickListener;

    public AllGoodsAdapter(final Context context, ArrayList<AllGoodsBean> list) {
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
                    case R.id.item_all_goods_ll:
                        String goodsId = (String) v.getTag();
                        Intent intent = new Intent();
                        intent.putExtra("goodsId", goodsId);
                        intent.setClass(context, GoodsDetailsActivity.class);
                        context.startActivity(intent);
                        break;
                    case R.id.item_all_goods_tv_cart:
                        break;
                    case R.id.item_all_goods_tv_buy_now:
                        break;
                }

            }
        };
    }

    public void initData(ArrayList<AllGoodsBean> goodsBeanArrayList) {
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
        View layout = LayoutInflater.from(context).inflate(R.layout.item_all_goods, parent, false);
        holder = new ALLGoodsViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AllGoodsBean goodsBean = mList.get(position);
        ((ALLGoodsViewHolder) holder).itemAllGoodsLl.setTag(goodsBean.getAllgoodsId());
        ((ALLGoodsViewHolder) holder).itemAllGoodsTvName.setText(goodsBean.getGoodsName());
        ((ALLGoodsViewHolder) holder).itemAllGoodsTvPrice.setText(goodsBean.getGoodsPrice());
        ((ALLGoodsViewHolder) holder).itemAllGoodsTvJoin.setText(goodsBean.getJoinNum());
        ((ALLGoodsViewHolder) holder).itemAllGoodsTvShengyu.setText(goodsBean.getShengyuNum());
        Glide.with(context).load(goodsBean.getImageUrl()).into(((ALLGoodsViewHolder) holder).itemAllGoodsTvImage);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class ALLGoodsViewHolder extends RecyclerView.ViewHolder {
        LinearLayout itemAllGoodsLl;
        ImageView itemAllGoodsTvImage;
        TextView itemAllGoodsTvName, itemAllGoodsTvPrice,itemAllGoodsTvJoin,itemAllGoodsTvShengyu,itemAllGoodsTvCart,itemAllGoodsTvBuyNow;

        public ALLGoodsViewHolder(View itemView) {
            super(itemView);
            itemAllGoodsLl = (LinearLayout) itemView.findViewById(R.id.item_all_goods_ll);
            itemAllGoodsTvImage = (ImageView) itemView.findViewById(R.id.item_all_goods_tv_image);
            itemAllGoodsTvName = (TextView) itemView.findViewById(R.id.item_all_goods_tv_name);
            itemAllGoodsTvPrice = (TextView) itemView.findViewById(R.id.item_all_goods_tv_price);
            itemAllGoodsTvJoin = (TextView) itemView.findViewById(R.id.item_all_goods_tv_join);
            itemAllGoodsTvShengyu = (TextView) itemView.findViewById(R.id.item_all_goods_tv_shengyu);
            itemAllGoodsTvCart = (TextView) itemView.findViewById(R.id.item_all_goods_tv_cart);
            itemAllGoodsTvBuyNow = (TextView) itemView.findViewById(R.id.item_all_goods_tv_buy_now);

            itemAllGoodsLl.setOnClickListener(onClickListener);
            itemAllGoodsTvCart.setOnClickListener(onClickListener);
            itemAllGoodsTvBuyNow.setOnClickListener(onClickListener);
        }
    }
}
