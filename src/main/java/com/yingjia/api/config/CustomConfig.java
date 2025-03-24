package com.yingjia.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomConfig {
    @Value("${yingjia.appid}")
    private static String appid;
    @Value("${yingjia.appsecret}")
    private static String appsecret;
    public static String getAppsecret() {
        return appsecret;
    }

    public static String getAppid() {
        return appid;
    }
}