package com.ifading.coinmarket.net;

import com.ifading.coinmarket.bean.NewsResult;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created  on 20180319//.
 *
 * @author by yangjingsheng
 */

public interface NewsGetRequestInterface {

    /*
    http://api.xinwen.cn/news/all?size=15
    &signature=9c45b01bfd1d136a1255d1a9b57ed866
    &timestamp=1521450804596
    &access_key=HTLk0wcf9vjDFjV8
    */

    @GET("news/all?")
    Call<NewsResult> getCall( @QueryMap Map<String, String> param);

}
