package com.ifading.coinmarket.net;

import com.ifading.coinmarket.bean.FuliResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created  on 20180320//.
 *
 * @author by yangjingsheng
 */

public interface FuliRequestInterface {
    @GET("data/福利/{amount}/{page}")
    Call<FuliResult> getCall(@Path("amount")String amount,@Path("page")String page);
}
