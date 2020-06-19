package com.tvt.math.five;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;
import com.tvt.math.ui.GifView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

@Route(path = MathRouterUrl.MathFiveAct)
public class MathFiveActivity extends AppCompatActivity {

    private GifView gifView;
    private AppCompatTextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_five_act);

        gifView = findViewById(R.id.gifView);
        result = findViewById(R.id.tvResult);

        initData();
        initListener();
    }

    private void initListener() {
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer space = new StringBuffer("we are happy");
                MathFive mathFive = new MathFive();
                mathFive.replaceSpace(space);
            }
        });
    }

    private void initData() {
        gifView.play();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (gifView.isPlaying()) {
            gifView.pause();
        }
    }
}
