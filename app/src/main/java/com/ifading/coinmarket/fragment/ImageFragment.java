package com.ifading.coinmarket.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ifading.coinmarket.R;
import com.ifading.coinmarket.adapter.ImageAdapter;
import com.ifading.coinmarket.api.ApiConstant;
import com.ifading.coinmarket.bean.FuliResult;
import com.ifading.coinmarket.net.FuliRequestInterface;

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
    private static final String TAG = "ImageFragment";
    @BindView(R.id.main_rv)
    protected RecyclerView mRv;


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

        Timber.tag(TAG).d("CoinMarketFragment,onCreateView");
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this.getActivity().getApplicationContext(),1);
        mRv.setLayoutManager(layoutManager);
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.IMAGE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        FuliRequestInterface request = retrofit.create(FuliRequestInterface.class);

        Call<FuliResult> call = request.getCall();
        call.enqueue(new Callback<FuliResult>() {
            @Override
            public void onResponse(Call<FuliResult> call, Response<FuliResult> response) {
                Timber.tag(TAG).d(response.body().toString());
                ImageAdapter homeAdapter = new ImageAdapter(R.layout.item_image, response.body().getResults());
                mRv.setAdapter(homeAdapter);
            }

            @Override
            public void onFailure(Call<FuliResult> call, Throwable t) {
                Timber.tag(TAG).d("连接失败,t:" + t.toString());
            }
        });
    }
}
