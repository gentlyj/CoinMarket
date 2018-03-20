package com.ifading.coinmarket.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ifading.coinmarket.R;
import com.ifading.coinmarket.bean.CoinResult;
import com.ifading.coinmarket.bean.NewsResult;

import java.util.List;

/**
 * Created  on 20180317//.
 *
 * @author by yangjingsheng
 */

public class NewsAdapter extends BaseQuickAdapter<NewsResult.Data.News, BaseViewHolder> {


    public NewsAdapter(int layoutResId, @Nullable List<NewsResult.Data.News> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, NewsResult.Data.News item) {
        //helper.setText(R.id.tv_item_news_summary, item.getSummary());
        helper.setText(R.id.tv_item_news_title, item.getTitle());
        helper.setText(R.id.tv_item_news_source, item.getSource());

        helper.setText(R.id.tv_item_news_time, String.valueOf(item.getGmt_publish()));
        if (item.getThumbnail_img() !=null &&item.getThumbnail_img().size()>0) {
            ImageView imageView = helper.getView(R.id.iv_item_news_img);
            Glide.with(mContext)
                    .load(item.getThumbnail_img().get(0))
                    .into(imageView);
        }

    }
}
