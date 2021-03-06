package com.example.administrator.fastshop.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.fastshop.R;
import com.example.administrator.fastshop.view.activity.BeginerGuideActivity;
import com.example.administrator.fastshop.view.activity.MainActivity;
import com.example.administrator.fastshop.view.activity.RechargeActivity;
import com.example.administrator.fastshop.view.adapter.LastestAdapter;
import com.example.administrator.fastshop.view.bean.GoodsBean;
import com.example.administrator.fastshop.view.views.DividerItemDecoration;
import com.example.administrator.fastshop.view.views.SpaceItemDecoretion;
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
    LinearLayout homeLlLastestShowAll, homeLlGuessYouLike, homeLlShowAtOnce;
    RecyclerView homeLastestRecycler,homeGuessYouLikeRecycler,homeShowAtOnceRecycler;
    ArrayList<GoodsBean> lastestList,guessYouLikeList,showAtOnceList;
    LinearLayoutManager linearLayoutManager;
    LastestAdapter lastestAdapter;
    //GuessYouLikeAdapter guessYouLikeAdapter;
    //ShowAtOnceAdapter showAtOnceAdapter;

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
        homeLlLastestShowAll.setOnClickListener(this);
        homeLlGuessYouLike.setOnClickListener(this);
        homeLlShowAtOnce.setOnClickListener(this);
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
        homeLlLastestShowAll = (LinearLayout) view.findViewById(R.id.home_ll_lastest_show_all);
        homeLlGuessYouLike = (LinearLayout) view.findViewById(R.id.home_ll_guess_you_like);
        homeLlShowAtOnce = (LinearLayout) view.findViewById(R.id.home_ll_show_at_once);
        homeLastestRecycler = (RecyclerView) view.findViewById(R.id.home_lastest_recycler);
        homeGuessYouLikeRecycler = (RecyclerView) view.findViewById(R.id.home_guess_you_like_recycler);
        homeShowAtOnceRecycler = (RecyclerView) view.findViewById(R.id.home_show_at_once_recycler);

        initLastestView();
    }


    private void initLastestView() {
        lastestList = new ArrayList<>();
        GoodsBean bean = new GoodsBean();
        for (int i = 0;i<10;i++){
            bean.setGoodsId(i+"");
            bean.setImage(R.drawable.item_image);
            bean.setGoodsName("飞浦达(PHIPUDS)三刀剃须");
            bean.setGoodsWinner("中奖者:张三");
            lastestList.add(bean);
        }


        linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        lastestAdapter = new LastestAdapter(getContext(),lastestList);
        homeLastestRecycler.setLayoutManager(linearLayoutManager);
        homeLastestRecycler.setAdapter(lastestAdapter);
        homeLastestRecycler.setHasFixedSize(true);
        homeLastestRecycler.addItemDecoration(new DividerItemDecoration(getContext(),linearLayoutManager.getOrientation()));

        linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        lastestAdapter = new LastestAdapter(getContext(),lastestList);
        homeGuessYouLikeRecycler.setLayoutManager(linearLayoutManager);
        homeGuessYouLikeRecycler.setAdapter(lastestAdapter);
        homeGuessYouLikeRecycler.setHasFixedSize(true);
        homeGuessYouLikeRecycler.addItemDecoration(new DividerItemDecoration(getContext(),linearLayoutManager.getOrientation()));

        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,LinearLayoutManager.VERTICAL,false);
        linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        lastestAdapter = new LastestAdapter(getContext(),lastestList);
        homeShowAtOnceRecycler.setLayoutManager(linearLayoutManager);
        homeShowAtOnceRecycler.setAdapter(lastestAdapter);
        homeShowAtOnceRecycler.setHasFixedSize(true);
        homeShowAtOnceRecycler.addItemDecoration(new DividerItemDecoration(getContext(),linearLayoutManager.getOrientation()));
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
                Intent intent1 = new Intent();
                intent1.setClass(getActivity(), RechargeActivity.class);
                startActivity(intent1);
                break;
            case R.id.home_ll_lastest_show_all:
                break;
            case R.id.home_ll_guess_you_like:
                break;
            case R.id.home_ll_show_at_once:
                break;
        }
    }
}
