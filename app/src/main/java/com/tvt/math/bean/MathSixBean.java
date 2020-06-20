package com.tvt.math.bean;

public class MathSixBean {
    private int type;
    private int gifViewId;
    private int codeId;
    private String title;

    public MathSixBean(int type, int gifViewId, int codeId, String title) {
        this.type = type;
        this.gifViewId = gifViewId;
        this.codeId = codeId;
        this.title = title;
    }

    public int getType() {
        return this.type;
    }

    public int getGifViewId() {
        return gifViewId;
    }

    public int getCodeId() {
        return codeId;
    }

    public String getTitle() {
        return title;
    }
}
