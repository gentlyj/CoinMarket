package com.ifading.coinmarket.net;

import com.ifading.coinmarket.bean.NewsData;
import com.ifading.coinmarket.bean.ReadHubRoot;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created  on 20180330//.
 *
 * @author by yangjingsheng
 */
public interface ReadHubRequestInterface {
    @GET("news")
    Call<NewsData> getCall();
}
