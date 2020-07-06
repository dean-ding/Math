package com.tvt.math.m23;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@Route(path = MathRouterUrl.Math23Act)
public class Math23Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_23_act);

        initListener();
    }

    private void initListener() {
        findViewById(R.id.tvResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Math23 math23 = new Math23();

                Math23.ListNode listNode1 = new Math23.ListNode(1);
                Math23.ListNode listNode2 = new Math23.ListNode(2);
                Math23.ListNode listNode3 = new Math23.ListNode(3);
                Math23.ListNode listNode4 = new Math23.ListNode(4);
                Math23.ListNode listNode5 = new Math23.ListNode(5);
                Math23.ListNode listNode6 = new Math23.ListNode(6);
                Math23.ListNode listNode7 = new Math23.ListNode(7);
                Math23.ListNode listNode8 = new Math23.ListNode(8);
                listNode1.next = listNode2;
                listNode2.next = listNode3;
                listNode3.next = listNode4;
                listNode4.next = listNode5;
                listNode5.next = listNode6;
                listNode6.next = listNode7;
                listNode7.next = listNode8;
                listNode8.next = listNode1;

                math23.EntryNodeOfLoop(listNode1);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
