package com.ifading.coinmarket.api;

import com.ifading.coinmarket.utils.MD5Utils;

/**
 * Created  on 20180319//.
 *
 * @author by yangjingsheng
 */

public class ApiUtils {

    public static String generateSign(String timeStamp) {

        return MD5Utils.getMD5String(ApiConstant.SECRET_KEY + timeStamp + ApiConstant.ACCESS_KEY);
    }

}
