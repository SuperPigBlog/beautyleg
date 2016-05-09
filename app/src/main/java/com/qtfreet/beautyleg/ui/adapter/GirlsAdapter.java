package com.qtfreet.beautyleg.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qtfreet.beautyleg.R;
import com.qtfreet.beautyleg.data.bean.imageBean;
import com.qtfreet.beautyleg.view.RadioImageView;

import java.util.List;


public class GirlsAdapter extends RecyclerView.Adapter<GirlsAdapter.GirlsViewHodler> {

    private Context mContext;
    private List<imageBean> imageInfos;

    private OnMeiziClickListener onMeiziClickListener;

    public GirlsAdapter(Context mContext, List<imageBean> imageInfos) {
        this.mContext = mContext;
        this.imageInfos = imageInfos;

    }

    @Override
    public GirlsViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.girls_layout, parent, false);

        return new GirlsViewHodler(view);
    }

    @Override
    public void onBindViewHolder(GirlsViewHodler holder, int position) {

        loadImage(holder, imageInfos.get(position));
    }

    private void loadImage(GirlsViewHodler holder, imageBean imageInfo) {

        Glide.with(mContext)
                .load(imageInfo.getUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop()
                .into(holder.ivGril);

        if (imageInfo.getType()==1){
          holder.des.setText("视频：" +imageInfo.getDes());
        }
        else {
            holder.des.setText("套图：" +imageInfo.getDes());
        }
    }

    @Override
    public int getItemCount() {
        return imageInfos.size();
    }

    class GirlsViewHodler extends RecyclerView.ViewHolder {

        private RadioImageView ivGril;
        private TextView des;


        public GirlsViewHodler(View itemView) {
            super(itemView);
            ivGril = (RadioImageView) itemView.findViewById(R.id.iv_gril);
            des = (TextView) itemView.findViewById(R.id.des);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onMeiziClickListener.onMeiziClick(v, getAdapterPosition());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                   onMeiziClickListener.onMeiziLongClick(v,getAdapterPosition());
                    return true;
                }
            });
        }
    }

    public void setOnMeiziClickListener(OnMeiziClickListener listener) {
        this.onMeiziClickListener = listener;
    }

}
