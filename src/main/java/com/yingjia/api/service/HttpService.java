package com.yingjia.api.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yingjia.api.config.CustomConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class HttpService {
    private final CloseableHttpClient httpClient;
    private String appid;
    private String secret;

    @Autowired
    public HttpService(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
        appid = CustomConfig.getAppid();
        secret = CustomConfig.getAppsecret();
    }

    public String login(String code) {
        //GET https://api.weixin.qq.com/sns/jscode2session
        //String appid, secret, js_code, grand_type  = "authorization_code"
        try {
            URI uri = new URIBuilder()
                    .setScheme("https")
                    .setHost("api.weixin.qq.com/sns/jscode2session")
                    .setParameter("appid", appid)
                    .setParameter("secret", secret)
                    .setParameter("js_code", code)
                    .setParameter("grant_type", "authorization_code").
                    build();
            HttpGet httpGet = new HttpGet(uri);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (URISyntaxException e) {
            e.getReason();
        } catch (IOException e) {
            e.getCause();
        }
        return null;
    }

    public String errorLogin() {
        return errorCode(500);
    }

    public String errorCode(int code) {
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        if (code == 500) {
            jsonObject.addProperty("errcode", "code");
            jsonObject.addProperty("errmsg", "An error occurred while fetching openid.");
            return gson.toJson(jsonObject);
        }
        return "Unhandled error";
    }
}
