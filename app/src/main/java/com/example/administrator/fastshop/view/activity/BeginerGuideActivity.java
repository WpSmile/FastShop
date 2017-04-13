package com.example.administrator.fastshop.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.fastshop.R;

public class BeginerGuideActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = BeginerGuideActivity.class.getCanonicalName();
    ImageView beginerGuideImageBack;
    BeginerGuideActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginer_guide);
        mContext = this;
        initView();
        setListener();
    }

    private void setListener() {
        beginerGuideImageBack.setOnClickListener(mContext);
    }

    private void initView() {
        beginerGuideImageBack = (ImageView) findViewById(R.id.beginer_guide_image_back);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.beginer_guide_image_back:
                finish();
                break;
        }
    }
}
