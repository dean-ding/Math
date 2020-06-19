package com.tvt.math.vh;

import android.view.View;

import com.tvt.math.R;
import com.tvt.math.bean.ActivityBean;

import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class MainRouteHolder extends RecyclerView.ViewHolder {

    private AppCompatTextView tvName;

    public MainRouteHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
    }

    public void update(ActivityBean bean, int position) {
        tvName.setText(String.format(Locale.getDefault(), "%d、%s", position + 1, bean.getName()));
    }
}
