package com.example.administrator.fastshop.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.fastshop.R;
import com.example.administrator.fastshop.view.activity.LoginActivity;
import com.example.administrator.fastshop.view.activity.RechargeActivity;
import com.example.administrator.fastshop.view.activity.RegisteByPhoneActivity;
import com.example.administrator.fastshop.view.activity.SettingActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalCenterFragment extends Fragment implements View.OnClickListener {
    ImageView personalCenterImageAvatar, personalCenterImageSetting;
    TextView personalCenterTvLogin, personalCenterTvRegiste;
    RelativeLayout cloudAndPurchasingRecordsRl, theWinningRecordRl, rechargeRl, shippingAddressRl, qrCodeToDownloadRl, inviteCodeRl;
    Intent intent;

    public PersonalCenterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personal_center, container, false);
        initView(view);
        setListenner();
        return view;
    }

    private void setListenner() {
        personalCenterImageAvatar.setOnClickListener(this);
        personalCenterImageSetting.setOnClickListener(this);
        personalCenterTvLogin.setOnClickListener(this);
        personalCenterTvRegiste.setOnClickListener(this);
        cloudAndPurchasingRecordsRl.setOnClickListener(this);
        theWinningRecordRl.setOnClickListener(this);
        rechargeRl.setOnClickListener(this);
        shippingAddressRl.setOnClickListener(this);
        qrCodeToDownloadRl.setOnClickListener(this);
        inviteCodeRl.setOnClickListener(this);
    }

    private void initView(View view) {
        personalCenterImageAvatar = (ImageView) view.findViewById(R.id.personal_center_image_avatar);
        personalCenterImageSetting = (ImageView) view.findViewById(R.id.personal_center_image_setting);
        personalCenterTvLogin = (TextView) view.findViewById(R.id.personal_center_tv_login);
        personalCenterTvRegiste = (TextView) view.findViewById(R.id.personal_center_tv_registe);
        cloudAndPurchasingRecordsRl = (RelativeLayout) view.findViewById(R.id.cloud_and_purchasing_records_rl);
        theWinningRecordRl = (RelativeLayout) view.findViewById(R.id.the_winning_record_rl);
        rechargeRl = (RelativeLayout) view.findViewById(R.id.recharge_rl);
        shippingAddressRl = (RelativeLayout) view.findViewById(R.id.shipping_address_rl);
        qrCodeToDownloadRl = (RelativeLayout) view.findViewById(R.id.qr_code_to_download_rl);
        inviteCodeRl = (RelativeLayout) view.findViewById(R.id.invite_code_rl);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.personal_center_image_avatar:
                break;
            case R.id.personal_center_image_setting:
                intent = new Intent();
                intent.setClass(getContext(), SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.personal_center_tv_login:
                intent = new Intent();
                intent.setClass(getContext(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.personal_center_tv_registe:
                intent = new Intent();
                intent.setClass(getContext(), RegisteByPhoneActivity.class);
                startActivity(intent);
                break;
            case R.id.cloud_and_purchasing_records_rl:
                break;
            case R.id.the_winning_record_rl:
                break;
            case R.id.recharge_rl:
                intent = new Intent();
                intent.setClass(getContext(), RechargeActivity.class);
                startActivity(intent);
                break;
            case R.id.shipping_address_rl:
                break;
            case R.id.qr_code_to_download_rl:
                break;
            case R.id.invite_code_rl:
                break;
        }
    }
}
