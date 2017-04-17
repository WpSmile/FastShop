package com.example.administrator.fastshop.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.fastshop.R;
import com.example.administrator.fastshop.view.adapter.NewShowGoodsAdapter;
import com.example.administrator.fastshop.view.bean.NewShowGoodsBean;
import com.example.administrator.fastshop.view.views.DividerItemDecoration;
import com.example.administrator.fastshop.view.views.SpaceItemDecoretion;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LatestFragment extends Fragment{
    RecyclerView announcedRecyccler;
    ArrayList<NewShowGoodsBean> allGoodsBeanArrayList;
    GridLayoutManager manager;
    NewShowGoodsAdapter mAdapter;

    public LatestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_latest, container, false);
        initView(view);
        return view;
    }
    private void initView(View view) {
        announcedRecyccler = (RecyclerView) view.findViewById(R.id.announced_recyccler);

        allGoodsBeanArrayList = new ArrayList<>();
        NewShowGoodsBean bean = new NewShowGoodsBean();
        bean.setImage(R.drawable.item_image02);
        bean.setGoodsName("爱国者(AIGO)充电宝20000毫安");
        bean.setUsername("微微");
        bean.setCount("176");
        bean.setNum("10000146");
        bean.setTime("2017-04-17 20:54");
        for (int i = 0; i < 10; i++) {
            bean.setAllgoodsId(i + "");
            allGoodsBeanArrayList.add(bean);
        }

        manager = new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false);
        mAdapter = new NewShowGoodsAdapter(getContext(), allGoodsBeanArrayList);
        announcedRecyccler.setLayoutManager(manager);
        announcedRecyccler.setAdapter(mAdapter);
        announcedRecyccler.setHasFixedSize(true);
        announcedRecyccler.addItemDecoration(new SpaceItemDecoretion(8));
        announcedRecyccler.addItemDecoration(new DividerItemDecoration(getContext(),manager.getOrientation()));
    }

}
