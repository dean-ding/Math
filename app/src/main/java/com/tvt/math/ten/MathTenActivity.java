package com.tvt.math.ten;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.adapter.BaseViewPagerAdapter;
import com.tvt.math.adapter.MathTenPagerAdapter;
import com.tvt.math.bean.MathTenBean;
import com.tvt.math.router.MathRouterUrl;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

@Route(path = MathRouterUrl.MathTenAct)
public class MathTenActivity extends AppCompatActivity {

    private final static int Type_Fibonacci = 0;//斐波那契数列
    private final static int Type_Cover = 1;//矩形覆盖
    private final static int Type_Jump = 2;//跳台阶
    private final static int Type_JumpII = 3;//变态跳台阶

    private ViewPager mViewPager = null;
    private MathTenPagerAdapter mPagerAdapter = null;
    private List<MathTenBean> dataArray = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_six_act);

        mViewPager = findViewById(R.id.viewPager);
        mPagerAdapter = new MathTenPagerAdapter();
        mViewPager.setAdapter(mPagerAdapter);
        initData();
        initListener();
    }

    private void initListener() {
        mPagerAdapter.setCallback(new BaseViewPagerAdapter.BaseItemClick<MathTenBean>() {
            @Override
            public void onItemClick(MathTenBean data, int position) {
                MathTen mathSix = new MathTen();
                switch (data.getType()) {
                    case Type_Fibonacci:
                        mathSix.Fibonacci(3);
                        break;
                    case Type_Cover:
                        mathSix.RectCover(3);
                        break;
                    case Type_Jump:
                        mathSix.JumpFloor(3);
                        break;
                    case Type_JumpII:
                        mathSix.JumpFloorIII(3);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void initData() {
        dataArray = new ArrayList<>();
        dataArray.add(new MathTenBean(Type_Fibonacci, 0, R.mipmap.math_ten_1, R.mipmap.math_ten_code_1, getString(R.string.math_ten_title_1)));
        dataArray.add(new MathTenBean(Type_Cover, R.mipmap.math_ten_2, 0, R.mipmap.math_ten_code_2, getString(R.string.math_ten_title_2)));
        dataArray.add(new MathTenBean(Type_Jump, 0, R.mipmap.math_ten_3, R.mipmap.math_ten_code_3, getString(R.string.math_ten_title_3)));
        dataArray.add(new MathTenBean(Type_JumpII, 0, R.mipmap.math_ten_4, R.mipmap.math_ten_code_4, getString(R.string.math_ten_title_4)));
        mPagerAdapter.setDataArray(dataArray);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
