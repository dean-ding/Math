package com.tvt.math.m24;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@Route(path = MathRouterUrl.Math24Act)
public class Math24Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_24_act);

        initListener();
    }

    private void initListener() {
        findViewById(R.id.tvResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Math24 math24 = new Math24();

                Math24.ListNode listNode1 = new Math24.ListNode(1);
                Math24.ListNode listNode2 = new Math24.ListNode(2);
                Math24.ListNode listNode3 = new Math24.ListNode(3);
                Math24.ListNode listNode4 = new Math24.ListNode(4);
                Math24.ListNode listNode5 = new Math24.ListNode(5);
                Math24.ListNode listNode6 = new Math24.ListNode(6);
                Math24.ListNode listNode7 = new Math24.ListNode(7);
                Math24.ListNode listNode8 = new Math24.ListNode(8);
                listNode1.next = listNode2;
                listNode2.next = listNode3;
                listNode3.next = listNode4;
                listNode4.next = listNode5;
                listNode5.next = listNode6;
                listNode6.next = listNode7;
                listNode7.next = listNode8;

                math24.ReverseList1(listNode1);
                math24.ReverseList2(listNode1);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
