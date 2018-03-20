package com.ifading.coinmarket.adapter;


import android.support.annotation.Nullable;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ifading.coinmarket.R;
import com.ifading.coinmarket.bean.FuliResult;


import java.util.List;

/**
 * Created  on 20180317//.
 *
 * @author by yangjingsheng
 */

public class ImageAdapter extends BaseQuickAdapter<FuliResult.Results, BaseViewHolder> {


    public ImageAdapter(int layoutResId, @Nullable List<FuliResult.Results> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, FuliResult.Results item) {

        ImageView imageView = helper.getView(R.id.iv_item_news_img);

        Glide.with(mContext)
                .setDefaultRequestOptions(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
                .load(item.getUrl())
                .into(imageView);

    }

}
