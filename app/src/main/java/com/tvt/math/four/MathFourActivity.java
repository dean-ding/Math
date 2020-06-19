package com.tvt.math.four;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;
import com.tvt.math.ui.GifView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

@Route(path = MathRouterUrl.MathFourAct)
public class MathFourActivity extends AppCompatActivity {

    private GifView gifView;
    private AppCompatTextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_four_act);

        gifView = findViewById(R.id.gifView);
        result = findViewById(R.id.tvResult);

        initData();
        initListener();
    }

    private void initListener() {
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[][] matrix = {
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}};
                MathFour mathThree = new MathFour(matrix);
                mathThree.Find(16);
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
