package com.tvt.math.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tvt.math.R;
import com.tvt.math.bean.MathSixBean;
import com.tvt.math.ui.CommonTitleView;
import com.tvt.math.ui.GifView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

public class MathSixPagerAdapter extends BaseViewPagerAdapter<MathSixBean> {

    @Override
    View updateView(ViewGroup container, final int position, final MathSixBean item) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.math_six_item_view, container, false);

        GifView gifView = view.findViewById(R.id.gifView);
        AppCompatImageView imageView = view.findViewById(R.id.tvMathCode);
        AppCompatTextView textView = view.findViewById(R.id.tvResult);
        CommonTitleView title = view.findViewById(R.id.tvTitle);

        if (item.getGifViewId() != 0) {
            gifView.setGifResource(item.getGifViewId());
            gifView.setVisibility(View.VISIBLE);
        }
        else {
            gifView.setVisibility(View.GONE);
        }
        imageView.setImageResource(item.getCodeId());
        title.setText(item.getTitle());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onItemClick(item, position);
                }
            }
        });
        gifView.play();
        return view;
    }

    @Override
    void destroy(View view, int position, MathSixBean item) {
        GifView gifView = view.findViewById(R.id.gifView);
        if (gifView.isPlaying()) {
            gifView.pause();
        }
    }
}
