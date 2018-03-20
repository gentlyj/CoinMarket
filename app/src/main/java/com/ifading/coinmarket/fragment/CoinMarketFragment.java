package com.ifading.coinmarket.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ifading.coinmarket.R;
import com.ifading.coinmarket.adapter.HomeAdapter;
import com.ifading.coinmarket.api.ApiConstant;
import com.ifading.coinmarket.bean.CoinResult;
import com.ifading.coinmarket.net.TickerGetRequestInterface;

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

public class CoinMarketFragment extends Fragment {
    private static final String TAG = "CoinMarketFragment";
    @BindView(R.id.main_rv)
    protected RecyclerView mRv;


    public static CoinMarketFragment newInstance(int index) {
        CoinMarketFragment fragment = new CoinMarketFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coin_market, container, false);
        ButterKnife.bind(this,view);
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        mRv.setLayoutManager(linearLayoutManager);

    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.COIN_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        TickerGetRequestInterface request = retrofit.create(TickerGetRequestInterface.class);
        Call<List<CoinResult>> call = request.getCall();
        call.enqueue(new Callback<List<CoinResult>>() {
            @Override
            public void onResponse(Call<List<CoinResult>> call, Response<List<CoinResult>> response) {
                Log.d(TAG,response.body().toString());
                HomeAdapter homeAdapter = new HomeAdapter(R.layout.home_item_view,response.body());
                mRv.setAdapter(homeAdapter);
            }

            @Override
            public void onFailure(Call<List<CoinResult>> call, Throwable t) {
                Log.d(TAG,"连接失败,t:"+t.toString());
            }
        });
    }
}
