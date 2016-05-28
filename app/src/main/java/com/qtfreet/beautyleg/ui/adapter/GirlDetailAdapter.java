package com.qtfreet.beautyleg.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qtfreet.beautyleg.R;
import com.qtfreet.beautyleg.view.RadioImageView;

import java.util.List;


public class GirlDetailAdapter extends RecyclerView.Adapter<GirlDetailAdapter.GirlsViewHodler> {

    private Context mContext;
    private List<String> imageInfos;

    private OnMeiziClickListener onMeiziClickListener;

    public GirlDetailAdapter(Context mContext, List<String> imageInfos) {
        this.mContext = mContext;
        this.imageInfos = imageInfos;
    }

    @Override
    public GirlsViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.girls_layout_detail, parent, false);
        return new GirlsViewHodler(view);
    }

    @Override
    public void onBindViewHolder(GirlsViewHodler holder, int position) {

        loadImage(holder, imageInfos.get(position));
    }

    private void loadImage(GirlsViewHodler holder, String imageInfo) {

        Glide.with(mContext)
                .load(imageInfo).diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop()
                .into(holder.ivGril);
    }

    @Override
    public int getItemCount() {
        return imageInfos.size();
    }

    class GirlsViewHodler extends RecyclerView.ViewHolder {

        private RadioImageView ivGril;

        public GirlsViewHodler(View itemView) {
            super(itemView);
            ivGril = (RadioImageView) itemView.findViewById(R.id.iv_gril);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMeiziClickListener.onMeiziClick(v, getAdapterPosition());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onMeiziClickListener.onMeiziLongClick(v, getAdapterPosition());
                    return true;
                }
            });
        }
    }

    public void setOnMeiziClickListener(OnMeiziClickListener listener) {
        this.onMeiziClickListener = listener;
    }


}
