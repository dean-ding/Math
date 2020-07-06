package com.tvt.math.m22;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.m21.Math21;
import com.tvt.math.router.MathRouterUrl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@Route(path = MathRouterUrl.Math22Act)
public class Math22Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_22_act);

        initListener();
    }

    private void initListener() {
        findViewById(R.id.tvResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Math22 math22 = new Math22();

                Math22.ListNode listNode1 = new Math22.ListNode(1);
                Math22.ListNode listNode2 = new Math22.ListNode(2);
                Math22.ListNode listNode3 = new Math22.ListNode(3);
                Math22.ListNode listNode4 = new Math22.ListNode(4);
                Math22.ListNode listNode5 = new Math22.ListNode(5);
                Math22.ListNode listNode6 = new Math22.ListNode(6);
                Math22.ListNode listNode7 = new Math22.ListNode(7);
                Math22.ListNode listNode8 = new Math22.ListNode(8);
                listNode1.next = listNode2;
                listNode2.next = listNode3;
                listNode3.next = listNode4;
                listNode4.next = listNode5;
                listNode5.next = listNode6;
                listNode6.next = listNode7;
                listNode7.next = listNode8;

                math22.FindKthToTail(listNode1, 5);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
