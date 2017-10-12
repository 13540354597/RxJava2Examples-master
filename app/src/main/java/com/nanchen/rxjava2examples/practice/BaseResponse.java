package com.nanchen.rxjava2examples.practice;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by TR 105 on 2017/8/4.
 */

public class BaseResponse<T> {

    @SerializedName("reason")
    public String reason;

    @SerializedName("err")
    public String err;

    @SerializedName("rest")
    public List<T> rest;
}
