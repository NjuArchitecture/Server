package cn.edu.nju.controller;

import cn.edu.nju.utility.GoodInfo;

import java.util.List;

/**
 * @author Qiang
 * @since 10/04/2017
 */
public class GoodJson {

    private List<GoodInfo> goodInfoList;

    public GoodJson(List<GoodInfo> goodInfoList) {
        this.goodInfoList = goodInfoList;
    }

    public GoodJson() {
    }

    public List<GoodInfo> getGoodInfoList() {
        return goodInfoList;
    }

    public void setGoodInfoList(List<GoodInfo> goodInfoList) {
        this.goodInfoList = goodInfoList;
    }
}
