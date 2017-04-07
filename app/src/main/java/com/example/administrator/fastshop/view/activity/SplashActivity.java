package com.example.administrator.fastshop.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.administrator.fastshop.R;

public class SplashActivity extends AppCompatActivity {

    private final static String TAG = SplashActivity.class.getCanonicalName();
    SplashActivity mContext;
    private final long splashTime = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//用于设置引导页背景充满全屏
        mContext = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        boolean b = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //耗时操作
                long costTime = System.currentTimeMillis();
                if (splashTime - costTime > 0) {
                    try {
                        Thread.sleep(splashTime - costTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Intent intent = new Intent();
                intent.setClass(mContext, MainActivity.class);
                startActivity(intent);
            }
        }, splashTime);


    }

}
