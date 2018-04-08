package com.ifading.coinmarket.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ifading.coinmarket.R;
import com.ifading.coinmarket.bean.NewsData;

import java.util.List;

/**
 * Created  on 20180317//.
 *
 * @author by yangjingsheng
 */

public class NewsAdapter extends BaseMultiItemQuickAdapter<NewsData.Data, BaseViewHolder> {


    public NewsAdapter(Context context, @Nullable List<NewsData.Data> data) {
        super(data);
        addItemType(NewsData.Data.TYPE_WITH_SUMMARY, R.layout.item_news_with_summary);
        addItemType(NewsData.Data.TYPE_WITHOUT_SUMMARY, R.layout.item_news);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsData.Data item) {
        helper.setText(R.id.tv_item_news_title, item.getTitle());
        switch (helper.getItemViewType()) {
            case NewsData.Data.TYPE_WITH_SUMMARY:
                helper.setText(R.id.tv_item_news_summary, item.getSummary());
                helper.addOnClickListener(R.id.btn_item_news_read);
                break;
            case NewsData.Data.TYPE_WITHOUT_SUMMARY:

                break;

            default:

                break;
        }

    }
}
