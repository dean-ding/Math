package com.tvt.math.three;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;
import com.tvt.math.ui.GifView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

@Route(path = MathRouterUrl.MathThreeAct)
public class MathThreeActivity extends AppCompatActivity {

    private GifView gifView;
    private AppCompatEditText editText;
    private AppCompatTextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_three_act);

        gifView = findViewById(R.id.gifView);
        editText = findViewById(R.id.etCode);
        result = findViewById(R.id.tvResult);

        initData();
        initListener();
    }

    private void initListener() {
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText() == null || editText.getText().toString().equals("")) {
                    return;
                }
                String[] split = editText.getText().toString().split(":");
                if (split.length == 0) {
                    return;
                }
                int[] math = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    math[i] = Integer.parseInt(split[i]);
                }
                MathThree mathThree = new MathThree(math);
                mathThree.count();
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
