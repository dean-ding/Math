package com.tvt.math;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tvt.math.adapter.MainRouterAdapter;
import com.tvt.math.bean.ActivityBean;
import com.tvt.math.router.MathRouterUrl;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private List<ActivityBean> dataArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        RecyclerView mRecyclerView = findViewById(R.id.rvMathData);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainRouterAdapter adapter = new MainRouterAdapter(dataArray);
        mRecyclerView.setAdapter(adapter);
        adapter.setCallback(new MainRouterAdapter.OnItemCallback() {
            @Override
            public void onItemClick(ActivityBean bean) {
                ARouter.getInstance().build(bean.getRouteUrl()).navigation();
            }
        });
    }

    private void initData() {
        dataArray.add(new ActivityBean(getString(R.string.math_three_title), MathRouterUrl.MathThreeAct));
        dataArray.add(new ActivityBean(getString(R.string.math_four_title), MathRouterUrl.MathFourAct));
        dataArray.add(new ActivityBean(getString(R.string.math_five_title), MathRouterUrl.MathFiveAct));
        dataArray.add(new ActivityBean(getString(R.string.math_six_title), MathRouterUrl.MathSixAct));
        dataArray.add(new ActivityBean(getString(R.string.math_seven_title), MathRouterUrl.MathSevenAct));
        dataArray.add(new ActivityBean(getString(R.string.math_eight_title), MathRouterUrl.MathEightAct));
        dataArray.add(new ActivityBean(getString(R.string.math_nine_title), MathRouterUrl.MathNineAct));
        dataArray.add(new ActivityBean(getString(R.string.math_ten_title), MathRouterUrl.MathTenAct));
        dataArray.add(new ActivityBean(getString(R.string.math_11_title), MathRouterUrl.Math11Act));
        dataArray.add(new ActivityBean(getString(R.string.math_12_title), MathRouterUrl.Math12Act));
    }
}
