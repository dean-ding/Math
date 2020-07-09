package com.tvt.math.m26;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@Route(path = MathRouterUrl.Math26Act)
public class Math26Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_26_act);

        initListener();
    }

    private void initListener() {
        findViewById(R.id.tvResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Math26.TreeNode root = new Math26.TreeNode(1);
                Math26.TreeNode root1 = new Math26.TreeNode(2);
                Math26.TreeNode root2 = new Math26.TreeNode(3);
                Math26.TreeNode root3 = new Math26.TreeNode(4);
                Math26.TreeNode root4 = new Math26.TreeNode(5);
                Math26.TreeNode root5 = new Math26.TreeNode(6);
                Math26.TreeNode root6 = new Math26.TreeNode(7);
                Math26.TreeNode root7 = new Math26.TreeNode(8);
                Math26.TreeNode root8 = new Math26.TreeNode(9);

                root.left = root1;
                root.right = root2;

                root1.left = root3;
                root1.right = root4;

                root2.left = root5;
                root2.right = root6;

                root3.left = root7;
                root3.right = root8;

                Math26.TreeNode child = new Math26.TreeNode(2);
                Math26.TreeNode child1 = new Math26.TreeNode(5);
                Math26.TreeNode child2 = new Math26.TreeNode(6);

                child.left = child1;
                child.right = child2;

                Math26 math26 = new Math26();
                math26.HasSubtree(root, child2);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
