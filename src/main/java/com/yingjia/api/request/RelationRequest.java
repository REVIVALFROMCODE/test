package com.yingjia.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RelationRequest {
    @JsonProperty("parent_id")
    private String pid;
    @JsonProperty("username")
    private String name;

    private String title;
    private String label;
    private String gender;
    private String birthday;

    public String getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getLabel() {
        return label;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }
}
