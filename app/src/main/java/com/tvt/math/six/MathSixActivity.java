package com.tvt.math.six;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;
import com.tvt.math.ui.GifView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

@Route(path = MathRouterUrl.MathSixAct)
public class MathSixActivity extends AppCompatActivity {

    private GifView gifView;
    private AppCompatTextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_six_act);

        gifView = findViewById(R.id.gifView);
        result = findViewById(R.id.tvResult);

        initData();
        initListener();
    }

    private void initListener() {
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MathSix.ListNode listNode = new MathSix.ListNode(0);
                MathSix.ListNode listNode1 = new MathSix.ListNode(1);
                MathSix.ListNode listNode2 = new MathSix.ListNode(2);
                listNode.next = listNode1;
                listNode1.next = listNode2;
                MathSix mathThree = new MathSix();
                mathThree.printListFromTailToHead1(listNode);
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
