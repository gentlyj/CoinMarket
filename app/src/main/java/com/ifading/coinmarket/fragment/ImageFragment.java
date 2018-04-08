package com.ifading.coinmarket.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ifading.coinmarket.R;
import com.ifading.coinmarket.activity.FullScreenImageActivity;
import com.ifading.coinmarket.adapter.ImageAdapter;
import com.ifading.coinmarket.api.ApiConstant;
import com.ifading.coinmarket.bean.FuliResult;
import com.ifading.coinmarket.net.FuliRequestInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

public class ImageFragment extends Fragment {
    public static final int PAGE_ITEM_COUNT = 10;
    private static final String TAG = "ImageFragment";
    @BindView(R.id.main_rv)
    protected RecyclerView mRv;
    @BindView(R.id.swipe_ly)
    protected SwipeRefreshLayout mSwipeLayout;
    private Retrofit mRetrofit;
    private FuliRequestInterface mRequest;
    private ImageAdapter mImageAdapter;
    private List<FuliResult.Results> mDatas = new ArrayList<>();
    private String pageString;


    public static ImageFragment newInstance(int index) {
        ImageFragment fragment = new ImageFragment();
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
        initData();
        initEvent();
        Timber.tag(TAG).d("CoinMarketFragment,onCreateView");
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mDatas == null || mDatas.size() == 0) {
            Timber.tag(TAG).d("fetchImageData,onResume调用");
            fetchImageData(true);
        }

    }

    private void fetchImageData(final boolean isRefresh) {
        Random rand = new Random();
        //随机数量和页数
        pageString = String.valueOf(rand.nextInt(100));

        Call<FuliResult> call = mRequest.getCall(String.valueOf(PAGE_ITEM_COUNT), pageString);
        call.enqueue(new Callback<FuliResult>() {
            @Override
            public void onResponse(Call<FuliResult> call, final Response<FuliResult> response) {
                Timber.tag(TAG).d(response.body().toString());
                List<FuliResult.Results> results = response.body().getResults();
                mSwipeLayout.setRefreshing(false);
                if (results == null || results.size() == 0) {
                    mImageAdapter.loadMoreFail();
                    return;
                }
                mImageAdapter.loadMoreComplete();
                setData(isRefresh, results);
            }

            @Override
            public void onFailure(Call<FuliResult> call, Throwable t) {
                Timber.tag(TAG).d("连接失败,t:" + t.toString());
            }
        });
    }

    private void setData(boolean isRefresh, List<FuliResult.Results> data) {
        final int size = data == null ? 0 : data.size();
        if (isRefresh) {
            mDatas = data;
            mImageAdapter.setNewData(data);
        } else {
            if (size > 0) {
                mDatas.addAll(data);
                mImageAdapter.addData(data);
            }
        }
        if (size < PAGE_ITEM_COUNT) {
            //第一页如果不够一页就不显示没有更多数据布局
            mImageAdapter.loadMoreEnd(isRefresh);
            Toast.makeText(this.getContext(), "no more data", Toast.LENGTH_SHORT).show();
        } else {
            mImageAdapter.loadMoreComplete();
        }
    }

    private void initEvent() {
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Timber.tag(TAG).d("fetchImageData,下来刷新调用");
                fetchImageData(true);
            }
        });
        mImageAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMore();
            }
        }, mRv);
    }

    private void loadMore() {
        Timber.tag(TAG).d("fetchImageData,loadMore调用");
        fetchImageData(false);
    }

    private void initView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this.getActivity().getApplicationContext(), 1);
        mRv.setLayoutManager(layoutManager);
        mImageAdapter = new ImageAdapter(R.layout.item_image, mDatas);
        mImageAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Timber.tag(TAG).d("onItemClick,position:" + position);
                Intent intent = new Intent(ImageFragment.this.getContext(), FullScreenImageActivity.class);
                intent.putExtra(FullScreenImageActivity.IMAGE_URL, mDatas.get(position).getUrl());
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);
            }
        });
        mRv.setAdapter(mImageAdapter);
    }

    private void initData() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.IMAGE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mRequest = mRetrofit.create(FuliRequestInterface.class);
        Timber.tag(TAG).d("fetchImageData,initData调用");
        fetchImageData(true);
    }

}
