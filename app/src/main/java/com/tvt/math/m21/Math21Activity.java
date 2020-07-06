package com.tvt.math.m21;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@Route(path = MathRouterUrl.Math21Act)
public class Math21Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_21_act);

        initListener();
    }

    private void initListener() {
        findViewById(R.id.tvResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Math21 math21 = new Math21();
                math21.reOrderArray1(new int[]{1, 3, 5, 2, 4});
                math21.reOrderArray2(new int[]{1, 3, 5, 2, 4});
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
