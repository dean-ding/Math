package com.tvt.math.six;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.adapter.BaseViewPagerAdapter;
import com.tvt.math.adapter.MathSixPagerAdapter;
import com.tvt.math.bean.MathSixBean;
import com.tvt.math.router.MathRouterUrl;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

@Route(path = MathRouterUrl.MathSixAct)
public class MathSixActivity extends AppCompatActivity {

    private final static int Type_Recursion = 0;//递归
    private final static int Type_Head = 1;//头插法
    private final static int Type_Stack = 2;//利用栈的先进后出

    private ViewPager mViewPager = null;
    private MathSixPagerAdapter mPagerAdapter = null;
    private List<MathSixBean> dataArray = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_six_act);

        mViewPager = findViewById(R.id.viewPager);
        mPagerAdapter = new MathSixPagerAdapter();
        mViewPager.setAdapter(mPagerAdapter);
        initData();
        initListener();
    }

    private void initListener() {
        mPagerAdapter.setCallback(new BaseViewPagerAdapter.BaseItemClick<MathSixBean>() {
            @Override
            public void onItemClick(MathSixBean data, int position) {
                MathSix.ListNode listNode = new MathSix.ListNode(0);
                MathSix.ListNode listNode1 = new MathSix.ListNode(1);
                MathSix.ListNode listNode2 = new MathSix.ListNode(2);
                listNode.next = listNode1;
                listNode1.next = listNode2;

                MathSix mathSix = new MathSix();
                switch (data.getType()) {
                    case Type_Recursion:
                        mathSix.printListFromTailToHeadUserRecursion(listNode);
                        break;
                    case Type_Head:
                        mathSix.printListFromTailToHeadUserHead(listNode);
                        break;
                    case Type_Stack:
                        mathSix.printListFromTailToHeadUseStack(listNode);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void initData() {
        dataArray = new ArrayList<>();
        dataArray.add(new MathSixBean(Type_Recursion, 0, R.mipmap.math_six_recursion_code, getString(R.string.math_six_title_1)));
        dataArray.add(new MathSixBean(Type_Head, R.mipmap.math_six_head, R.mipmap.math_six_head_code, getString(R.string.math_six_title_2)));
        dataArray.add(new MathSixBean(Type_Stack, R.mipmap.math_six_stack, R.mipmap.math_six_stack_code, getString(R.string.math_six_title_3)));
        mPagerAdapter.setDataArray(dataArray);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
