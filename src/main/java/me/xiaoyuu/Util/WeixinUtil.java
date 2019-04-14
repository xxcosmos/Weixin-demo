package me.xiaoyuu.Util;

import com.google.gson.Gson;
import me.xiaoyuu.common.Common;
import me.xiaoyuu.common.EnumMap;
import me.xiaoyuu.pojo.AccessToken;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeixinUtil {

    public static boolean CheckValid(String timestamp, String nonce, String signature) {
        String[] array = new String[3];
        array[0] = EnumMap.token.getValue();
        array[1] = timestamp;
        array[2] = nonce;
        Arrays.sort(array);
        String code = EncodeUtil.shaEncode(array[0] + array[1] + array[2]);
        return code.equals(signature);
    }

    public String getNewAccessToken() throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put(EnumMap.grant_type.getName(), EnumMap.grant_type.getValue());
        map.put(EnumMap.appID.getName(), EnumMap.appID.getValue());
        map.put(EnumMap.appSecret.getName(), EnumMap.appSecret.getValue());
        String url = GetURLUtil.getUrl(Common.getAccessTokenURL, map);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().get().url(url).build();
        Call call = client.newCall(request);
        Response response = call.execute();
        Gson gson = new Gson();
        assert response.body() != null;
        AccessToken accessToken = gson.fromJson(response.body().string(), AccessToken.class);
        EnumMap.access_token.setValue(accessToken.getAccess_token());
        return accessToken.getAccess_token();
    }
}
