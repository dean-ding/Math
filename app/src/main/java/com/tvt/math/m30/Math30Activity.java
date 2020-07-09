package com.tvt.math.m30;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@Route(path = MathRouterUrl.Math30Act)
public class Math30Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_30_act);

        initListener();
    }

    private void initListener() {
        findViewById(R.id.tvResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Math30 math30 = new Math30();
                math30.push(3);
                math30.push(4);
                math30.push(5);
                math30.push(6);
                math30.push(1);
                math30.push(2);
                math30.push(3);
                math30.min();
                math30.min();
                math30.min();
                math30.min();
                math30.min();
                math30.min();
                math30.min();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
