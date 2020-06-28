package com.tvt.math.m14;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.adapter.BaseViewPagerAdapter;
import com.tvt.math.adapter.Math14PagerAdapter;
import com.tvt.math.bean.MathTenBean;
import com.tvt.math.router.MathRouterUrl;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

@Route(path = MathRouterUrl.Math14Act)
public class MathT14Activity extends AppCompatActivity {

    private final static int Type_Dynamic = 0;//动态规划
    private final static int Type_Greedy = 1;//贪心算法

    private ViewPager mViewPager = null;
    private Math14PagerAdapter mPagerAdapter = null;
    private List<MathTenBean> dataArray = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_six_act);

        mViewPager = findViewById(R.id.viewPager);
        mPagerAdapter = new Math14PagerAdapter();
        mViewPager.setAdapter(mPagerAdapter);
        initData();
        initListener();
    }

    private void initListener() {
        mPagerAdapter.setCallback(new BaseViewPagerAdapter.BaseItemClick<MathTenBean>() {
            @Override
            public void onItemClick(MathTenBean data, int position) {
                Math14 mathSix = new Math14();
                int length = 0;
                switch (data.getType()) {
                    case Type_Dynamic:
                        length = mathSix.integerBreak2(30);
                        break;
                    case Type_Greedy:
                        length = mathSix.integerBreak1(30);
                        break;
                    default:
                        break;
                }
                System.out.println("length = " + length);
            }
        });
    }

    private void initData() {
        dataArray = new ArrayList<>();
        dataArray.add(new MathTenBean(Type_Dynamic, 0, 0, R.mipmap.math_14_code1, getString(R.string.math_14_title_1)));
        dataArray.add(new MathTenBean(Type_Greedy, 0, 0, R.mipmap.math_14_code2, getString(R.string.math_14_title_2)));
        mPagerAdapter.setDataArray(dataArray);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
