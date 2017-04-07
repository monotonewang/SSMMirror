package com.demo.fukiapi.home.po;

import java.util.List;

/**
 * Created by dell on 2017/4/7.
 */
public class HomeNewCustom {
    private String resultCode;
    private String reseaon;
    private List<HomeNew> homeNewList;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getReseaon() {
        return reseaon;
    }

    public void setReseaon(String reseaon) {
        this.reseaon = reseaon;
    }

    public List<HomeNew> getHomeNewList() {
        return homeNewList;
    }

    public void setHomeNewList(List<HomeNew> homeNewList) {
        this.homeNewList = homeNewList;
    }

    @Override
    public String toString() {
        return "HomeNewCustom{" +
                "resultCode='" + resultCode + '\'' +
                ", reseaon='" + reseaon + '\'' +
                ", homeNewList=" + homeNewList +
                '}';
    }
}
