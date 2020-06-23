package com.tvt.math.nine;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;
import com.tvt.math.ui.GifView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

@Route(path = MathRouterUrl.MathNineAct)
public class MathNineActivity extends AppCompatActivity {

    private GifView gifView;
    private AppCompatTextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_nine_act);

        gifView = findViewById(R.id.gifView);
        result = findViewById(R.id.tvResult);

        initData();
        initListener();
    }

    private void initListener() {
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MathNine mathNine = new MathNine();
                mathNine.push(1);
                mathNine.push(2);
                mathNine.push(3);
                mathNine.push(4);
                mathNine.push(5);
                mathNine.push(6);
                mathNine.push(7);
                try {
                    mathNine.pop();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
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
