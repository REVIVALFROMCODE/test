package com.yingjia.api.service;

import cn.dev33.satoken.stp.StpUtil;
import com.yingjia.api.config.CustomConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private HttpService h;

    private Map<String,String> map = new HashMap<>();

    @Autowired
    public UserService(HttpService httpService) {
        this.h=httpService;
    }

    public String login(String code) {
        String response = h.login(code);
        StpUtil.login(response);
        String token = StpUtil.getTokenValue();
        return token;
    }
}
