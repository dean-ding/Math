package com.tvt.math.bean;

public class MathTenBean {
    private int type;
    private int gifViewId;
    private int imageId;
    private int codeId;
    private String title;

    public MathTenBean(int type, int gifViewId, int imageId, int codeId, String title) {
        this.type = type;
        this.gifViewId = gifViewId;
        this.imageId = imageId;
        this.codeId = codeId;
        this.title = title;
    }

    public int getType() {
        return this.type;
    }

    public int getGifViewId() {
        return gifViewId;
    }

    public int getImageId() {
        return imageId;
    }

    public int getCodeId() {
        return codeId;
    }

    public String getTitle() {
        return title;
    }
}
