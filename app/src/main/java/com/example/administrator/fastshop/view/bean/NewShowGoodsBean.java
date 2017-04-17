package com.example.administrator.fastshop.view.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/17.
 */

public class NewShowGoodsBean implements Serializable {
    private String allgoodsId;
    private String imageUrl;
    private String goodsName;
    private String username;
    private String num;
    private String count;
    private String time;
    private int image;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return '{' +
                "allgoodsId='" + allgoodsId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", username='" + username + '\'' +
                ", num='" + num + '\'' +
                ", count='" + count + '\'' +
                ", time='" + time + '\'' +
                ", image=" + image +
                '}';
    }
}
