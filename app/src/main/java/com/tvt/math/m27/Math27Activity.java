package com.tvt.math.m27;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@Route(path = MathRouterUrl.Math27Act)
public class Math27Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_27_act);

        initListener();
    }

    private void initListener() {
        findViewById(R.id.tvResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Math27.TreeNode root = new Math27.TreeNode(1);
                Math27.TreeNode root1 = new Math27.TreeNode(2);
                Math27.TreeNode root2 = new Math27.TreeNode(3);
                Math27.TreeNode root3 = new Math27.TreeNode(4);
                Math27.TreeNode root4 = new Math27.TreeNode(5);
                Math27.TreeNode root5 = new Math27.TreeNode(6);
                Math27.TreeNode root6 = new Math27.TreeNode(7);
                Math27.TreeNode root7 = new Math27.TreeNode(8);
                Math27.TreeNode root8 = new Math27.TreeNode(9);

                root.left = root1;
                root.right = root2;

                root1.left = root3;
                root1.right = root4;

                root2.left = root5;
                root2.right = root6;

                root3.left = root7;
                root3.right = root8;

                Math27 math27 = new Math27();
                math27.Mirror(root);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
