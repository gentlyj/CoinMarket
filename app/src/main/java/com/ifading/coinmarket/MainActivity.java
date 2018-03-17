package com.ifading.coinmarket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ifading.coinmarket.adapter.HomeAdapter;
import com.ifading.coinmarket.bean.CoinResult;
import com.ifading.coinmarket.net.TickerGetRequest_Interface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.main_rv)
    protected RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        mRv.setLayoutManager(linearLayoutManager);

    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        TickerGetRequest_Interface request = retrofit.create(TickerGetRequest_Interface.class);
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
