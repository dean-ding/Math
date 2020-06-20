package com.tvt.math.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

/**
 * Created: 1895 on 2020/6/19 17:45
 */
public abstract class BaseViewPagerAdapter<T> extends PagerAdapter {

    private List<T> dataArray = new ArrayList<>();
    public BaseItemClick<T> callback;

    public BaseViewPagerAdapter() {
    }

    @Override
    public int getCount() {
        return dataArray.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        T item = getItem(position);
        View view = updateView(container, position, item);
        container.addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        T item = getItem(position);
        destroy((View) object, position, item);
        container.removeView((View) object);
    }

    private T getItem(int position) {
        if (position < 0 || position >= getCount()) {
            return null;
        }
        return dataArray.get(position);
    }

    abstract View updateView(ViewGroup container, int position, T item);

    abstract void destroy(View view, int position, T item);

    public void setDataArray(List<T> dataArray) {
        if (dataArray == null) {
            return;
        }
        this.dataArray.clear();
        this.dataArray.addAll(dataArray);
        notifyDataSetChanged();
    }

    public void setCallback(BaseItemClick<T> callback) {
        this.callback = callback;
    }

    public interface BaseItemClick<T> {
        void onItemClick(T data, int position);
    }
}
