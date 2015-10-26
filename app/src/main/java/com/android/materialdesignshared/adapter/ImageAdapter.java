package com.android.materialdesignshared.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.materialdesignshared.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 图片展示
 *
 * @Description: ImageAdapter
 * @Author: PentiumRabbit
 * @Update: PentiumRabbit(2015-10-26 17:46)
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private static final String TAG = ImageAdapter.class.getSimpleName();
    private int[] pics;

    public ImageAdapter(AdapterView.OnItemClickListener listener) {
        this.listener = listener;
    }

    private AdapterView.OnItemClickListener listener;


    public void update(int[] pics) {
        this.pics = pics;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_image, parent,
                false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvName.setText(String.valueOf(pics[position]));
        holder.ivPic.setImageResource(pics[position]);
        holder.ivPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(null,v,position,0);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (pics == null) {
            return 0;
        }
        return pics.length;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.iv_pic)
        ImageView ivPic;
        @InjectView(R.id.tv_name)
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);

        }
    }


}
