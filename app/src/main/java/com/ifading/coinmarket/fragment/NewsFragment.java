package com.ifading.coinmarket.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ifading.coinmarket.R;
import com.ifading.coinmarket.adapter.NewsAdapter;
import com.ifading.coinmarket.api.ApiConstant;
import com.ifading.coinmarket.api.ApiUtils;
import com.ifading.coinmarket.bean.NewsResult;
import com.ifading.coinmarket.net.NewsGetRequestInterface;

import java.util.HashMap;
import java.util.Map;

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

        Timber.tag(TAG).d("CoinMarketFragment,onCreateView");
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mRv.setLayoutManager(linearLayoutManager);

    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.NEWS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        NewsGetRequestInterface request = retrofit.create(NewsGetRequestInterface.class);
        String timeStampString = String.valueOf(System.currentTimeMillis());
        String sign = ApiUtils.generateSign(timeStampString);
        Map<String,String> queryMap = new HashMap<>();
        Timber.tag(TAG).d("SIGN:"+sign);

    /*
    http://api.xinwen.cn/news/all?size=15
    &signature=9c45b01bfd1d136a1255d1a9b57ed866
    &timestamp=1521450804596
    &access_key=HTLk0wcf9vjDFjV8

    http://api.xinwen.cn/news/all?size=15&signature=54ab2c9994e7ea10bdd0d58e50ac73b2&timestamp=1521452688672&access_key=HTLk0wcf9vjDFjV8
    */
        queryMap.put("size","15");
        queryMap.put("signature",sign);
        queryMap.put("timestamp",timeStampString);
        queryMap.put("access_key",ApiConstant.ACCESS_KEY);

        Call<NewsResult> call = request.getCall(queryMap);
        call.enqueue(new Callback<NewsResult>() {
            @Override
            public void onResponse(Call<NewsResult> call, Response<NewsResult> response) {
                Log.d(TAG, response.body().toString());
                NewsAdapter homeAdapter = new NewsAdapter(R.layout.item_news, response.body().getData().getNews());
                mRv.setAdapter(homeAdapter);
            }

            @Override
            public void onFailure(Call<NewsResult> call, Throwable t) {
                Log.d(TAG, "连接失败,t:" + t.toString());
            }
        });
    }
}
