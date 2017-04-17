package com.example.administrator.fastshop.view.bean;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/17.
 */

public class GoodsBean implements Serializable {
    private String goodsId;
    private String goodsName;
    private String goodsImageUrl;
    private int image;
    private String goodsWinner;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImageUrl() {
        return goodsImageUrl;
    }

    public void setGoodsImageUrl(String goodsImageUrl) {
        this.goodsImageUrl = goodsImageUrl;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getGoodsWinner() {
        return goodsWinner;
    }

    public void setGoodsWinner(String goodsWinner) {
        this.goodsWinner = goodsWinner;
    }

    @Override
    public String toString() {
        return '{' +
                "goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsImageUrl='" + goodsImageUrl + '\'' +
                ", imaage=" + image +
                ", goodsWinner='" + goodsWinner + '\'' +
                '}';
    }
}
