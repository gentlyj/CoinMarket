package com.ifading.coinmarket.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.github.chrisbanes.photoview.PhotoView;
import com.ifading.coinmarket.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created  on 20180321//.
 *
 * @author by yangjingsheng
 */

public class FullScreenImageActivity extends AppCompatActivity {
    public static final String IMAGE_URL = "FULLSCREENIMAGEACTIVITY_IMAGE_URL";
    @BindView(R.id.pv_full_screen_activity)
    protected PhotoView mPv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("FullScreenImageActivity,onCreate");
         /*set it to be no title*/
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

       /*set it to be full screen*/
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_full_screen_image);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String url = intent.getStringExtra(IMAGE_URL);
        Timber.d("FullScreenImageActivity,url:" + url);
        Glide.with(this)
                .load(url)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        Timber.tag(getClass().getName()).d("图片大小,w:" + resource.getIntrinsicWidth() + " h:" + resource.getIntrinsicWidth());
                        mPv.setImageDrawable(resource);
                    }
                });
        mPv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPv.getScale() <= 1) {
                    fadeFinish();
                }
            }
        });

        /*mPv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Timber.tag(getClass().getName()).d("dispatchTouchEvent,mPv.onTouch():+motionEvent:"+motionEvent.getPointerCount());

                return false;
            }
        });*/

    }

    private void fadeFinish() {
        finish();
        overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);
    }


//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Timber.tag(getClass().getName()).d("dispatchTouchEvent,mPv.getScale():" + mPv.getScale() + " ev.getPointerCount():" + ev.getPointerCount());
//        if (mPv.getScale() <= 1 && ev.getPointerCount() == 1) {
//            //mPv.setClickable(false);
//            Timber.tag(getClass().getName()).d("进来了");
//            return super.dispatchTouchEvent(ev);
//        }
//        return super.dispatchTouchEvent(ev);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Timber.tag(getClass().getName()).d("onTouchEvent");
        /*if (mPv.getScale() <= 1) {
            mPv.setClickable(false);
            return true;
        } else {
            mPv.setClickable(true);
            return super.onTouchEvent(event);
        }*/
        return super.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        fadeFinish();
    }
}
