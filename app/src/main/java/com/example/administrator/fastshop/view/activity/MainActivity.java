package com.example.administrator.fastshop.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.fastshop.R;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener,ViewPager.OnPageChangeListener {

    private final static String TAG = MainActivity.class.getCanonicalName();
    MainActivity mContext;

    ViewPager mainViewpager;
    BadgeItem badgeItem;
    BottomNavigationBar bottomNavigationBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;

        initView();
        setListener();
    }

    private void setListener() {
        bottomNavigationBar.setTabSelectedListener(this);
    }

    private void initView() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.main_bottomnavigaationbar);
        mainViewpager = (ViewPager) findViewById(R.id.main_viewpager);
        addItem();//添加底部菜单的方法
    }

    private void addItem() {
        //购物车上面的小圆圈
        badgeItem = new BadgeItem();
        badgeItem.setHideOnSelect(false)
                .setText("0")
                .setTextColor(Color.WHITE)
                .setBackgroundColor(Color.RED)
                .setBorderWidth(0);

        bottomNavigationBar.clearAll();
        bottomNavigationBar.setBarBackgroundColor(R.color.bottomColor);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .addItem(new BottomNavigationItem(R.mipmap.icon_home, R.string.home_page).setActiveColorResource(R.color.titleColor))
                .addItem(new BottomNavigationItem(R.mipmap.icon_all, R.string.all_goods).setActiveColorResource(R.color.titleColor))
                .addItem(new BottomNavigationItem(R.mipmap.icon_show_lastest, R.string.announced_the_latest).setActiveColorResource(R.color.titleColor))
                .addItem(new BottomNavigationItem(R.mipmap.icon_cart, R.string.cart).setActiveColorResource(R.color.titleColor).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.icon_personal, R.string.personal_center).setActiveColorResource(R.color.titleColor))
                .setFirstSelectedPosition(0)
                .initialise();//初始化

    }

    @Override
    public void onTabSelected(int position) {
        bottomNavigationBar.setAnimationDuration(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
