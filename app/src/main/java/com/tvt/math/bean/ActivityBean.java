package com.tvt.math.bean;

/**
 * 首页跳转到各个子界面的类型
 */
public class ActivityBean {

    private String name = "";
    private String routeUrl = "";

    public ActivityBean(String name, String routeUrl) {
        this.name = name;
        this.routeUrl = routeUrl;
    }

    public String getName() {
        return name;
    }

    public String getRouteUrl() {
        return routeUrl;
    }
}
