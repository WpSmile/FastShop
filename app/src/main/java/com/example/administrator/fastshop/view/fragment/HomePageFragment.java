package com.example.administrator.fastshop.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.fastshop.R;
import com.example.administrator.fastshop.view.activity.BeginerGuideActivity;
import com.example.administrator.fastshop.view.activity.MainActivity;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment implements XBanner.XBannerAdapter, View.OnClickListener {
    private XBanner xBanner;
    private ArrayList<String> imageUrl;
    RelativeLayout homeRlAllGoods, homeRlLastestRecom, homeRlBeginer, homeRlRecharge;

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
        setLiester();
        return view;


    }

    private void setLiester() {
        homeRlAllGoods.setOnClickListener(this);
        homeRlLastestRecom.setOnClickListener(this);
        homeRlBeginer.setOnClickListener(this);
        homeRlRecharge.setOnClickListener(this);
    }

    private void initView(View view) {
        xBanner = (XBanner) view.findViewById(R.id.home_banner);

        imageUrl.add("http://images.17173.com/2012/web/2012/08/21/zxw0821ar05s.jpg");
        imageUrl.add("http://att.bbs.duowan.com/forum/201307/27/2027417vv8evcvey2ulllp.jpg");
        imageUrl.add("http://www.people.com.cn/mediafile/pic/20170208/84/2225815746960402432.jpg");
        imageUrl.add("http://i03.pictn.sogoucdn.com/e7b322dcf9795405");

        xBanner.setData(imageUrl, null);


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


        homeRlAllGoods = (RelativeLayout) view.findViewById(R.id.home_rl_all_goods);
        homeRlLastestRecom = (RelativeLayout) view.findViewById(R.id.home_rl_lastest_recom);
        homeRlBeginer = (RelativeLayout) view.findViewById(R.id.home_rl_beginer);
        homeRlRecharge = (RelativeLayout) view.findViewById(R.id.home_rl_recharge);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_rl_all_goods:

                break;
            case R.id.home_rl_lastest_recom:
                break;
            case R.id.home_rl_beginer:
                Intent intent = new Intent();
                intent.setClass(getActivity(), BeginerGuideActivity.class);
                startActivity(intent);
                break;
            case R.id.home_rl_recharge:
                break;

        }
    }
}
