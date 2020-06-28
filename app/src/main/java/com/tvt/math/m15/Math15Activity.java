package com.tvt.math.m15;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@Route(path = MathRouterUrl.Math15Act)
public class Math15Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_15_act);

        initListener();
    }

    private void initListener() {
        findViewById(R.id.tvResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Math15 math15 = new Math15();
                int number1 = math15.NumberOf1(10000);
                int number2 = math15.NumberOf1WithLeft(10000);
                System.out.println("number1 = " + number1 + ", number2 = " + number2);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
