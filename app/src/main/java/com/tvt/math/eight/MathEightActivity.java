package com.tvt.math.eight;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tvt.math.R;
import com.tvt.math.router.MathRouterUrl;
import com.tvt.math.ui.GifView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

@Route(path = MathRouterUrl.MathEightAct)
public class MathEightActivity extends AppCompatActivity {

    private GifView gifView1, gifView2;
    private AppCompatTextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_eight_act);

        gifView1 = findViewById(R.id.gifView1);
        gifView2 = findViewById(R.id.gifView2);
        result = findViewById(R.id.tvResult);

        initData();
        initListener();
    }

    private void initListener() {
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MathEight.TreeLinkNode a = new MathEight.TreeLinkNode("a");
                MathEight.TreeLinkNode b = new MathEight.TreeLinkNode("b");
                MathEight.TreeLinkNode c = new MathEight.TreeLinkNode("c");
                MathEight.TreeLinkNode d = new MathEight.TreeLinkNode("d");
                MathEight.TreeLinkNode e = new MathEight.TreeLinkNode("e");
                MathEight.TreeLinkNode f = new MathEight.TreeLinkNode("f");
                MathEight.TreeLinkNode g = new MathEight.TreeLinkNode("g");
                MathEight.TreeLinkNode h = new MathEight.TreeLinkNode("h");
                MathEight.TreeLinkNode i = new MathEight.TreeLinkNode("i");

                a.left = b;
                a.right = c;
                a.parent = null;

                b.left = d;
                b.right = c;
                b.parent = a;

                c.left = f;
                c.right = g;
                c.parent = a;

                d.left = null;
                d.right = null;
                d.parent = b;

                e.left = h;
                e.right = i;
                e.parent = b;

                f.left = null;
                f.right = null;
                f.parent = c;

                g.left = null;
                g.right = null;
                g.parent = c;

                h.left = null;
                h.right = null;
                h.parent = e;

                i.left = null;
                i.right = null;
                i.parent = e;

                MathEight mathFive = new MathEight();
                mathFive.GetNext(i);
            }
        });
    }

    private void initData() {
        gifView1.play();
        gifView2.play();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (gifView1.isPlaying()) {
            gifView1.pause();
        }
        if (gifView2.isPlaying()) {
            gifView2.pause();
        }
    }
}
