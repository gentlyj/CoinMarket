package com.ifading.coinmarket.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ifading.coinmarket.R;
import com.ifading.coinmarket.bean.CoinResult;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 * Created  on 20180317//.
 *
 * @author by yangjingsheng
 */

public class HomeAdapter extends BaseQuickAdapter<CoinResult, BaseViewHolder> {
    private NumberFormat nf = new DecimalFormat("$#,###.####");

    public HomeAdapter(int layoutResId, @Nullable List<CoinResult> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CoinResult item) {
        helper.setText(R.id.tv_home_item_name, item.getName());
        helper.setText(R.id.tv_home_item_id, item.getSymbol());
        helper.setText(R.id.tv_home_item_value, nf.format(Double.valueOf(item.getPrice_usd())));

        helper.setTextColor(R.id.tv_home_item_change,
                Float.valueOf(item.getPercent_change_24h()) > 0 ? Color.GREEN : Color.RED);

        helper.setText(R.id.tv_home_item_change, item.getPercent_change_24h() + "%");
        helper.setText(R.id.tv_home_item_cap, "总市值: " + nf.format(Double.valueOf(item.getMarket_cap_usd())));
    }
}
