package com.ifading.coinmarket.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.ifading.coinmarket.R;
import com.ifading.coinmarket.fragment.CoinMarketFragment;
import com.ifading.coinmarket.fragment.ImageFragment;
import com.ifading.coinmarket.fragment.NewsFragment;
import com.ifading.coinmarket.adapter.MainViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.main_tbl)
    protected TabLayout mTabLayout;
    @BindView(R.id.main_vp)
    protected ViewPager mViewPager;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;

    private String[] mTitles = {"Coin", "News", "Imgs"};
    private int[] mUnselectImgs = {R.drawable.coin_unselect, R.drawable.news_unselect, R.drawable.image_unselect};
    private int[] mSelectImgs = {R.drawable.coin_select, R.drawable.news_select, R.drawable.image_select};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        initEvent();
    }

    private void initEvent() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Timber.tag(TAG).d("onTabSelected");

                /*for (int i = 0; i < viewPagerAdapter.getCount(); i++) {
                    //获得到对应位置的Tab
                    TabLayout.Tab itemTab = mTabLayout.getTabAt(i);
                    if (itemTab != null) {
                        //设置自定义的标题
                        itemTab.setCustomView(R.layout.item_tab);
                        TextView textView = (TextView) itemTab.getCustomView().findViewById(R.id.tv_tab_name);
                        textView.setText(mTitles[i]);
                        ImageView imageView= (ImageView) itemTab.getCustomView().findViewById(R.id.iv_tab_ico);
                        imageView.setImageResource(mUnselectImgs[i]);
                    }
                }*/
                TextView tv = (TextView) tab.getCustomView().findViewById(R.id.tv_tab_name);
                tv.setTextColor(Color.GREEN);
                ImageView iv = (ImageView) tab.getCustomView().findViewById(R.id.iv_tab_ico);

                iv.setImageResource(mSelectImgs[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Timber.tag(TAG).d("onTabUnselected");
                TextView tv = (TextView) tab.getCustomView().findViewById(R.id.tv_tab_name);
                tv.setTextColor(Color.WHITE);
                ImageView iv = (ImageView) tab.getCustomView().findViewById(R.id.iv_tab_ico);

                iv.setImageResource(mUnselectImgs[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initView() {
        //给TabLayout设置关联ViewPager，如果设置了ViewPager，那么ViewPagerAdapter中的getPageTitle()方法返回的就是Tab上的标题
        mTabLayout.setupWithViewPager(mViewPager);

        MainViewPager viewPagerAdapter = new MainViewPager(getSupportFragmentManager());
        CoinMarketFragment mCoinFragment = CoinMarketFragment.newInstance(0);
        NewsFragment mNewsFragment = NewsFragment.newInstance(1);
        ImageFragment imageFragment = ImageFragment.newInstance(2);
        viewPagerAdapter.addFragment(mCoinFragment, "Coin");
        viewPagerAdapter.addFragment(mNewsFragment, "News");
        viewPagerAdapter.addFragment(imageFragment, "Imgs");

        mViewPager.setAdapter(viewPagerAdapter);
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);
        one.setIcon(R.drawable.coin_unselect);
        two.setIcon(R.drawable.news_unselect);
        three.setIcon(R.drawable.image_unselect);
        for (int i = 0; i < viewPagerAdapter.getCount(); i++) {
            //获得到对应位置的Tab
            TabLayout.Tab itemTab = mTabLayout.getTabAt(i);
            if (itemTab != null) {
                //设置自定义的标题
                itemTab.setCustomView(R.layout.item_tab);
                TextView textView = (TextView) itemTab.getCustomView().findViewById(R.id.tv_tab_name);
                textView.setTextColor(i == 0 ? Color.GREEN : Color.WHITE);
                textView.setText(mTitles[i]);
                ImageView imageView = (ImageView) itemTab.getCustomView().findViewById(R.id.iv_tab_ico);
                imageView.setImageResource(i == 0 ? mSelectImgs[0] : mUnselectImgs[i]);
            }
        }
        //mTabLayout.getTabAt(0).getCustomView().setSelected(true);
        //mViewPager.setCurrentItem(0);
    }


}
