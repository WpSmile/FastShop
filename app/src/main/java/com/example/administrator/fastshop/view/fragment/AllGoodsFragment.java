package com.example.administrator.fastshop.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.fastshop.R;
import com.example.administrator.fastshop.view.adapter.AllGoodsAdapter;
import com.example.administrator.fastshop.view.bean.AllGoodsBean;
import com.example.administrator.fastshop.view.views.DividerItemDecoration;
import com.example.administrator.fastshop.view.views.SpaceItemDecoretion;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllGoodsFragment extends Fragment implements View.OnClickListener {
    ImageView AllGoodsImgAllSortDown, AllGoodsImgValueSortUp, AllGoodsImgValueSortDown;
    RecyclerView AllGoodsRecycler;
    ArrayList<AllGoodsBean> allGoodsBeanArrayList;
    GridLayoutManager gridLayoutManager;
    AllGoodsAdapter mAdapter;

    public AllGoodsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_goods, container, false);

        initView(view);
        setListener();
        return view;
    }

    private void setListener() {
        AllGoodsImgAllSortDown.setOnClickListener(this);
        AllGoodsImgValueSortUp.setOnClickListener(this);
        AllGoodsImgValueSortDown.setOnClickListener(this);
    }

    private void initView(View view) {
        AllGoodsImgAllSortDown = (ImageView) view.findViewById(R.id.All_goods_img_all_sort_down);
        AllGoodsImgValueSortUp = (ImageView) view.findViewById(R.id.All_goods_img_value_sort_up);
        AllGoodsImgValueSortDown = (ImageView) view.findViewById(R.id.All_goods_img_value_sort_down);
        AllGoodsRecycler = (RecyclerView) view.findViewById(R.id.All_goods_recycler);

        allGoodsBeanArrayList = new ArrayList<>();
        AllGoodsBean bean = new AllGoodsBean();
        bean.setImage(R.drawable.item_image01);
        bean.setGoodsName("机械革命");
        bean.setJoinNum("0");
        bean.setShengyuNum("999");

        for (int i = 0; i < 10; i++) {
            bean.setAllgoodsId(i + "");
            bean.setGoodsPrice("￥"+(i+1));

            allGoodsBeanArrayList.add(bean);
        }

        gridLayoutManager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        mAdapter = new AllGoodsAdapter(getContext(), allGoodsBeanArrayList);
        AllGoodsRecycler.setLayoutManager(gridLayoutManager);
        AllGoodsRecycler.setAdapter(mAdapter);
        AllGoodsRecycler.setHasFixedSize(true);
        AllGoodsRecycler.addItemDecoration(new SpaceItemDecoretion(8));
        AllGoodsRecycler.addItemDecoration(new DividerItemDecoration(getContext(),gridLayoutManager.getOrientation()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.All_goods_img_all_sort_down:
                break;
            case R.id.All_goods_img_value_sort_up:
                break;
            case R.id.All_goods_img_value_sort_down:
                break;
        }
    }
}
