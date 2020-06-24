package com.tvt.math.m11;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@Route(path = MathRouterUrl.Math11Act)
public class Math11Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_11_act);

        initListener();
    }

    private void initListener() {
        findViewById(R.id.tvResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Math11 math11 = new Math11();
                math11.minNumberInRotateArray(new int[]{3, 4, 5, 1, 2});
                math11.minNumberInRotateArray(new int[]{1, 1, 1, 0, 1});
                math11.minNumberInRotateArray(new int[]{1, 0, 0, 0, 1});
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
