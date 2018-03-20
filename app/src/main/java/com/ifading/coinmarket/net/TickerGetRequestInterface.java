package com.ifading.coinmarket.net;

import com.ifading.coinmarket.bean.CoinResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created  on 20180317//.
 *
 * @author by yangjingsheng
 */

public interface TickerGetRequestInterface {
    //https://api.coinmarketcap.com/v1/ticker/

    @GET("v1/ticker/")
    Call<List<CoinResult>> getCall();
}
