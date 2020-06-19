package com.tvt.math.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tvt.math.R;
import com.tvt.math.bean.ActivityBean;
import com.tvt.math.vh.MainRouteHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainRouterAdapter extends RecyclerView.Adapter<MainRouteHolder> {

    private List<ActivityBean> dataArray = null;
    private OnItemCallback callback;

    public MainRouterAdapter(@NonNull List<ActivityBean> dataArray) {
        this.dataArray = new ArrayList<>();
        this.dataArray.addAll(dataArray);
    }

    @NonNull
    @Override
    public MainRouteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainRouteHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_route_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainRouteHolder holder, int position) {
        final ActivityBean bean = getItem(position);
        if (bean != null) {
            holder.update(bean, position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback != null) {
                        callback.onItemClick(bean);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataArray.size();
    }

    private ActivityBean getItem(int position) {
        if (position < 0 || position >= getItemCount()) {
            return null;
        }
        return dataArray.get(position);
    }

    public void setCallback(OnItemCallback callback) {
        this.callback = callback;
    }

    public interface OnItemCallback {
        void onItemClick(ActivityBean bean);
    }
}
