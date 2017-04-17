package com.example.administrator.fastshop.view.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/17.
 */

public class AllGoodsBean implements Serializable {
    private String allgoodsId;
    private String imageUrl;
    private String goodsName;
    private String goodsPrice;
    private String joinNum;
    private String shengyuNum;
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAllgoodsId() {
        return allgoodsId;
    }

    public void setAllgoodsId(String allgoodsId) {
        this.allgoodsId = allgoodsId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getJoinNum() {
        return joinNum;
    }

    public void setJoinNum(String joinNum) {
        this.joinNum = joinNum;
    }

    public String getShengyuNum() {
        return shengyuNum;
    }

    public void setShengyuNum(String shengyuNum) {
        this.shengyuNum = shengyuNum;
    }

    @Override
    public String toString() {
        return '{' +
                "allgoodsId='" + allgoodsId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", joinNum='" + joinNum + '\'' +
                ", shengyuNum='" + shengyuNum + '\'' +
                ", image=" + image +
                '}';
    }
}
