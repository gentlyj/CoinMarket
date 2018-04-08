package com.ifading.coinmarket.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ifading.coinmarket.R;
import com.ifading.coinmarket.activity.NewsDetailActivity;
import com.ifading.coinmarket.adapter.NewsAdapter;
import com.ifading.coinmarket.api.ApiConstant;
import com.ifading.coinmarket.bean.NewsData;
import com.ifading.coinmarket.net.ReadHubRequestInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created  on 20180319//.
 *
 * @author by yangjingsheng
 */

public class NewsFragment extends Fragment {
    private static final String TAG = "CoinMarketFragment";
    @BindView(R.id.main_rv)
    protected RecyclerView mRv;
    @BindView(R.id.swipe_ly)
    protected SwipeRefreshLayout mSwipeLayout;
    private ReadHubRequestInterface request;

    private List<NewsData.Data> mDatas = new ArrayList<>();
    private NewsAdapter homeAdapter;

    public static NewsFragment newInstance(int index) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coin_market, container, false);
        ButterKnife.bind(this, view);
        initView();
        initEvent();
        Timber.tag(TAG).d("CoinMarketFragment,onCreateView");
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.READHUB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        request = retrofit.create(ReadHubRequestInterface.class);
        fetchNewsData();

    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mRv.setLayoutManager(linearLayoutManager);
        homeAdapter = new NewsAdapter(this.getContext(), mDatas);
        mRv.setAdapter(homeAdapter);
    }

    private void initEvent() {
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchNewsData();
            }
        });

        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                NewsData.Data data = mDatas.get(position);
                if (data.getItemType() == NewsData.Data.TYPE_WITHOUT_SUMMARY) {
                    data.setItemType(NewsData.Data.TYPE_WITH_SUMMARY);
                } else if (data.getItemType() == NewsData.Data.TYPE_WITH_SUMMARY) {
                    data.setItemType(NewsData.Data.TYPE_WITHOUT_SUMMARY);
                }
                homeAdapter.notifyItemChanged(position);
            }
        });

        homeAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Timber.tag(TAG).d("view:" + view.getId() + " btnid:" + R.id.btn_item_news_read);
                Log.d(TAG, "onItemChildClick: ");
                if (view.getId() == R.id.btn_item_news_read) {
                    NewsData.Data data = mDatas.get(position);
                    Intent intent = new Intent(NewsFragment.this.getContext(), NewsDetailActivity.class);

                    intent.putExtra(NewsDetailActivity.NEWS_URL, data.getUrl());
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);
                }
            }
        });
    }

    private void fetchNewsData() {
        Call<NewsData> call = request.getCall();
        call.enqueue(new Callback<NewsData>() {
            @Override
            public void onResponse(Call<NewsData> call, Response<NewsData> response) {
                if (response.body() == null) {
                    return;
                }
                Log.d(TAG, response.body().toString());
                mSwipeLayout.setRefreshing(false);
                List<NewsData.Data> data = response.body().getData();
                mDatas = data;
                homeAdapter.setNewData(mDatas);
            }

            @Override
            public void onFailure(Call<NewsData> call, Throwable t) {
                Log.d(TAG, "连接失败,t:" + t.toString());
                mSwipeLayout.setRefreshing(false);
            }
        });
    }
}
