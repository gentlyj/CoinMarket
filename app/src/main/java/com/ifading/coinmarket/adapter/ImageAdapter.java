package com.ifading.coinmarket.adapter;


import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ifading.coinmarket.R;
import com.ifading.coinmarket.bean.FuliResult;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import timber.log.Timber;

/**
 * Created  on 20180317//.
 *
 * @author by yangjingsheng
 */

public class ImageAdapter extends BaseQuickAdapter<FuliResult.Results, BaseViewHolder> {


    private HashMap<Integer, BitmapInfo> infos = new HashMap();

    public ImageAdapter(int layoutResId, @Nullable List<FuliResult.Results> data) {
        super(layoutResId, data);

    }

    public void clearItemHeightCache(){
        infos.clear();
    }


    @Override
    protected void convert(final BaseViewHolder helper, FuliResult.Results item) {
        Timber.tag(getClass().getName()).d("convert:count:"+getItemCount()+" position:"+helper.getItemId()
                +" getLayoutPosition:"+helper.getLayoutPosition()
                +" getOldPosition:"+helper.getOldPosition()
                +" getAdapterPosition:"+helper.getAdapterPosition());
        final ImageView imageView = helper.getView(R.id.iv_item_news_img);
        //helper.addOnLongClickListener(R.id.iv_item_news_img);

        if (infos.containsKey(helper.getAdapterPosition())) {
            ViewGroup.LayoutParams params = imageView.getLayoutParams();
            BitmapInfo info = infos.get(helper.getAdapterPosition());
            params.height = imageView.getWidth() * info.height / info.width;
        }

        Glide.with(mContext)
                .setDefaultRequestOptions(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
                .load(item.getUrl())
                .transition(new DrawableTransitionOptions().dontTransition())
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@Nullable Drawable resource, @Nullable Transition transition) {
                        //根据图片的大小来缓存一下 imageview 的大小,避免快速滑动时,没有 imageview 高度导致滑动不正常
                        if (!infos.containsKey(helper.getAdapterPosition())) {
                            infos.put(helper.getAdapterPosition(), new BitmapInfo(resource.getIntrinsicWidth(), resource.getIntrinsicHeight()));
                            //计算 修改ImageView的高

                            ViewGroup.LayoutParams params = imageView.getLayoutParams();
                            BitmapInfo info = infos.get(helper.getAdapterPosition());
                            params.height = imageView.getWidth() * info.height / info.width;
                            Timber.tag(getClass().getName()).d("图片的 w:" + info.width + " h:" + info.height + " imageView宽:" + imageView.getWidth()
                                    + " 计算后的宽度:" + params.height);

                        }
                        imageView.setImageDrawable(resource);
                    }
                });

//        Glide.with(mContext)
//                .setDefaultRequestOptions(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
//                .load(item.getUrl())
//                .into(imageView);


    }

    public static class BitmapInfo {
        public int width;
        public int height;

        public BitmapInfo(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

}
