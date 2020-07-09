package com.tvt.math.m28;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@Route(path = MathRouterUrl.Math28Act)
public class Math28Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_28_act);

        initListener();
    }

    private void initListener() {
        findViewById(R.id.tvResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Math28.TreeNode root1 = new Math28.TreeNode(1);
                Math28.TreeNode root2 = new Math28.TreeNode(2);
                Math28.TreeNode root3 = new Math28.TreeNode(3);
                Math28.TreeNode root4 = new Math28.TreeNode(4);
                Math28.TreeNode root5 = new Math28.TreeNode(5);
                Math28.TreeNode root6 = new Math28.TreeNode(6);
                Math28.TreeNode root7 = new Math28.TreeNode(7);

                root1.left = root2;
                root1.right = root3;

                root2.left = root4;
                root2.right = root5;

                root3.left = root6;
                root3.right = root7;

                Math28.TreeNode child1 = new Math28.TreeNode(1);
                Math28.TreeNode child2 = new Math28.TreeNode(2);
                Math28.TreeNode child3 = new Math28.TreeNode(3);
                Math28.TreeNode child4 = new Math28.TreeNode(4);
                Math28.TreeNode child5 = new Math28.TreeNode(5);
                Math28.TreeNode child6 = new Math28.TreeNode(6);
                Math28.TreeNode child7 = new Math28.TreeNode(7);

                child1.left = child3;
                child1.right = child2;

                child3.left = child7;
                child3.right = child6;

                child2.left = child5;
                child2.right = child4;

                Math28 math28 = new Math28();
                math28.isSymmetrical(root1, child1);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
