package com.tvt.math.m18;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.adapter.BaseViewPagerAdapter;
import com.tvt.math.adapter.Math18PagerAdapter;
import com.tvt.math.bean.MathTenBean;
import com.tvt.math.router.MathRouterUrl;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

@Route(path = MathRouterUrl.Math18Act)
public class Math18Activity extends AppCompatActivity {

    private final static int Type_Delete_Node = 0;//删除节点
    private final static int Type_Delete_Duplication = 1;//删除重复的节点

    private ViewPager mViewPager = null;
    private Math18PagerAdapter mPagerAdapter = null;
    private List<MathTenBean> dataArray = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_18_act);

        mViewPager = findViewById(R.id.viewPager);
        mPagerAdapter = new Math18PagerAdapter();
        mViewPager.setAdapter(mPagerAdapter);
        initData();
        initListener();
    }

    private void initListener() {
        mPagerAdapter.setCallback(new BaseViewPagerAdapter.BaseItemClick<MathTenBean>() {
            @Override
            public void onItemClick(MathTenBean data, int position) {
                Math18 mathSix = new Math18();
                switch (data.getType()) {
                    case Type_Delete_Node:
                        //mathSix.deleteNode(3);
                        break;
                    case Type_Delete_Duplication:
                        //mathSix.deleteDuplication(3);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void initData() {
        dataArray = new ArrayList<>();
        dataArray.add(new MathTenBean(Type_Delete_Node, 0, 0, R.mipmap.math_18_code_1, getString(R.string.math_18_title_1)));
        dataArray.add(new MathTenBean(Type_Delete_Duplication, 0, 0, R.mipmap.math_18_code_2, getString(R.string.math_18_title_2)));
        mPagerAdapter.setDataArray(dataArray);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
