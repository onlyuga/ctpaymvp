package com.ifs.ctpay.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ifs.ctpay.R;
import com.ifs.ctpay.view.model.ShortcutModel;

import java.util.List;

import at.markushi.ui.CircleButton;

/**
 * Created by K53SV on 3/22/2017.
 */

public class ShortcutAdapter extends RecyclerView.Adapter<ShortcutAdapter.ShortcutHolder>{
    List<ShortcutModel> models;
    Context context;

    public ShortcutAdapter(Context context, List<ShortcutModel> models){
    this.context = context;
        this.models = models;
    }

    @Override
    public ShortcutHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_shortcut, parent, false);

        return new ShortcutHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ShortcutHolder holder, int position) {
        holder.btn.setImageResource(R.drawable.contacts_50);
        holder.tvTitle.setText("Hello android");
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ShortcutHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        CircleButton btn;

        public ShortcutHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            btn = (CircleButton) itemView.findViewById(R.id.btn_cb);
        }
    }
}
