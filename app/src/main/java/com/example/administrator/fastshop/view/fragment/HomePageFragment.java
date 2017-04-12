package com.example.administrator.fastshop.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.fastshop.R;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment implements XBanner.XBannerAdapter {
    private XBanner xBanner;
    private ArrayList<String> imageUrl;

    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        imageUrl = new ArrayList<>();
        initView(view);
        return view;


    }

    private void initView(View view) {
        xBanner = (XBanner) view.findViewById(R.id.home_banner);

        imageUrl.add("http://img3.duitang.com/uploads/item/201505/11/20150511185920_SPXUY.png");
        imageUrl.add("http://pic0.mofang.com/2016/0711/20160711113048896.jpg");
        imageUrl.add("http://wanzao2.b0.upaiyun.com/system/pictures/27100499/original/1438870036_499x294.jpeg");
        imageUrl.add("http://i03.pictn.sogoucdn.com/d5f0af489fb7abda");

        xBanner.setData(imageUrl,null);


        /*轮播图片的点击事件*/
        xBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, int position) {
                Toast.makeText(getActivity(), "点击了第" + (position + 1) + "张图片", Toast.LENGTH_SHORT).show();
            }
        });
        xBanner.setmAdapter(this);

        // 设置XBanner的页面切换特效
        xBanner.setPageTransformer(Transformer.Default);
// 设置XBanner页面切换的时间，即动画时长
        xBanner.setPageChangeDuration(800);
    }




    @Override
    public void onResume() {
        super.onResume();
        xBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        xBanner.stopAutoPlay();
    }
    /*可根据自己项目需要使用相应的图片加载工具进行加载图片，此处使用 Glide，进行加载，可配置占位图等*/
    @Override
    public void loadBanner(XBanner banner, Object model, View view, int position) {
        //Glide为网络加载图片的框架
        Glide.with(this).load(imageUrl.get(position)).into((ImageView) view);
    }
}
