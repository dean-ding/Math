package com.tvt.math.m25;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@Route(path = MathRouterUrl.Math25Act)
public class Math25Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_25_act);

        initListener();
    }

    private void initListener() {
        findViewById(R.id.tvResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Math25 math25 = new Math25();

                Math25.ListNode listNode1 = new Math25.ListNode(1);
                Math25.ListNode listNode2 = new Math25.ListNode(2);
                Math25.ListNode listNode3 = new Math25.ListNode(3);
                Math25.ListNode listNode4 = new Math25.ListNode(4);
                Math25.ListNode listNode5 = new Math25.ListNode(5);
                Math25.ListNode listNode6 = new Math25.ListNode(6);
                Math25.ListNode listNode7 = new Math25.ListNode(7);
                Math25.ListNode listNode8 = new Math25.ListNode(8);
                listNode1.next = listNode3;
                listNode5.next = listNode7;
                listNode3.next = listNode5;

                listNode2.next = listNode4;
                listNode4.next = listNode6;
                listNode6.next = listNode8;
                math25.Merge1(listNode1, listNode2);

                listNode1.next = listNode3;
                listNode3.next = listNode5;
                listNode5.next = listNode7;
                listNode7.next = null;

                listNode2.next = listNode4;
                listNode4.next = listNode6;
                listNode6.next = listNode8;
                listNode8.next = null;
                math25.Merge2(listNode1, listNode2);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
