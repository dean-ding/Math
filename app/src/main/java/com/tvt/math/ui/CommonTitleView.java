/*
 * Copyright (c) 2016 The MaMaHelp_small_withReceiver_7.0 Project,
 *
 * 深圳市新网智创科技有限公司. All Rights Reserved.
 */

package com.tvt.math.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.tvt.math.R;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * 通用title
 */
public class CommonTitleView extends FrameLayout implements View.OnClickListener {
    private AppCompatTextView tvTitle;
    private ConstraintLayout clTitleLayout;
    private Context mContext;

    private String titleText;//title标题

    public CommonTitleView(Context context) {
        this(context, null);
    }

    public CommonTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        readAttr(attrs);
        initView();
    }

    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.common_title_layout, this);
        clTitleLayout = findViewById(R.id.cl_title_parent);
        tvTitle = findViewById(R.id.tv_center_title);
        tvTitle.setText(titleText);
        tvTitle.setOnClickListener(this);
    }

    public void setText(String titleText) {
        tvTitle.setText(titleText);
    }

    @Override
    public void onClick(View v) {
    }

    public View getRootView() {
        return clTitleLayout;
    }

    /***设置title以跑马灯形式跑动*/
    public void setTitleMarquee() {
        tvTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);//设置跑马灯显示效果
        tvTitle.setHorizontallyScrolling(true);//设置水平滚动效果
        tvTitle.setMarqueeRepeatLimit(-1);//设置滚动次数，-1为无限滚动，1为滚动1次
        tvTitle.setSelected(true);
    }

    private void readAttr(AttributeSet attrs) {
        TypedArray ta = mContext.obtainStyledAttributes(attrs,
                R.styleable.CommonTitleView);
        if (null != ta) {
            titleText = ta.getString(R.styleable.CommonTitleView_text);
        }
        ta.recycle();
    }

}
