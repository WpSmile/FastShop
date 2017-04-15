package com.example.administrator.fastshop.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.fastshop.R;
import com.example.administrator.fastshop.view.fragment.RechargeRecordFragment;
import com.example.administrator.fastshop.view.fragment.TopUpFragment;

import java.util.ArrayList;

/*
* 充值中心
* */
public class RechargeActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = RechargeActivity.class.getCanonicalName();
    RechargeActivity mContext;
    TextView rechargeTvChongzhiyemian, rechargeTvChongzhijilu;
    ImageView rechargeImageBack;
    FrameLayout rechargeFramlayout;

    ArrayList<Fragment> fragments;
    TopUpFragment topUpFragment;
    RechargeRecordFragment rechargeRecordFragment;

    int currentFragmentIndex = 0;
    int clickButtonIndex;
    TextView[] tvArray = new TextView[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        mContext = this;
        initView();
        setListener();
    }

    private void setListener() {
        rechargeTvChongzhiyemian.setOnClickListener(this);
        rechargeTvChongzhijilu.setOnClickListener(this);
        rechargeImageBack.setOnClickListener(this);
    }

    private void initView() {
        rechargeTvChongzhiyemian = (TextView) findViewById(R.id.recharge_tv_chongzhiyemian);
        rechargeTvChongzhijilu = (TextView) findViewById(R.id.recharge_tv_chongzhijilu);
        rechargeFramlayout = (FrameLayout) findViewById(R.id.recharge_framlayout);
        rechargeImageBack = (ImageView) findViewById(R.id.recharge_image_back);
        setFragment();
    }

    private void setFragment() {
        fragments = new ArrayList<>();
        topUpFragment = new TopUpFragment();
        rechargeRecordFragment = new RechargeRecordFragment();
        fragments.add(topUpFragment);
        fragments.add(rechargeRecordFragment);
        tvArray[0] = rechargeTvChongzhiyemian;
        tvArray[1] = rechargeTvChongzhijilu;


        //默认的显示的fragment
        Fragment showFragment = fragments.get(currentFragmentIndex);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.recharge_framlayout, showFragment)
                .show(showFragment).commit();

        //设置默认的按钮的颜色
        tvArray[currentFragmentIndex].setTextColor(getResources().getColor(R.color.titleColor));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recharge_image_back:
                finish();
                break;
            case R.id.recharge_tv_chongzhiyemian:
                clickButtonIndex = 0;
                break;
            case R.id.recharge_tv_chongzhijilu:
                clickButtonIndex = 1;
                break;
        }

        if (currentFragmentIndex != clickButtonIndex) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            //隐藏当前的fragment
            transaction.hide(fragments.get(currentFragmentIndex));
            // 显示 点击的button对应的gragment
            Fragment showFragment = fragments.get(clickButtonIndex);
            // 没有添加过，
            if (!showFragment.isAdded()) {
                transaction.add(R.id.recharge_framlayout, showFragment);
            }
            transaction.show(showFragment);
            transaction.commit();
            //设置按钮的状态
            setButtonStatus();
            currentFragmentIndex = clickButtonIndex;
        }
    }

    private void setButtonStatus() {
        tvArray[currentFragmentIndex].setSelected(false);
        tvArray[currentFragmentIndex].setTextColor(getResources().getColor(R.color.black));

        tvArray[clickButtonIndex].setSelected(true);
        tvArray[clickButtonIndex].setTextColor(getResources().getColor(R.color.titleColor));
    }
}
