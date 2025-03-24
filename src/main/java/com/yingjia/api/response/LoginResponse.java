package com.yingjia.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {
    @JsonProperty("X-Litemall-Token")
    private String token;
    public LoginResponse(String token) {this.token = token;}
    public String getToken() {return token;}
    public void setToken(String token) {this.token = token;}

}
