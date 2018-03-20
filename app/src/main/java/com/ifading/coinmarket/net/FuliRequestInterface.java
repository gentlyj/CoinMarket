package com.ifading.coinmarket.net;

import com.ifading.coinmarket.bean.FuliResult;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created  on 20180320//.
 *
 * @author by yangjingsheng
 */

public interface FuliRequestInterface {
    @GET("data/福利/100/2")
    Call<FuliResult> getCall();
}
