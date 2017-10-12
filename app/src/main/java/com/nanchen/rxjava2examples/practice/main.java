package com.nanchen.rxjava2examples.practice;

import android.util.Log;

import com.nanchen.rxjava2examples.practice.bean.Result;

import java.io.File;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by TR 105 on 2017/8/4.
 */

public class main {
    public static void main(String[] args) {
//        HttpClient httpClient = new HttpClient();
//        httpClient.getRectService().getManagerData(1, 10, 1024).enqueue(new Callback<BaseResponse<Result>>() {
//            @Override
//            public void onResponse(Call<BaseResponse<Result>> call, Response<BaseResponse<Result>> response) {
//
//
//                List<Result> list = response.body().rest;
//
//                for (Result result : list) {
//                    System.out.print(result.getImagesUrls());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse<Result>> call, Throwable t) {
//
//            }
//        });

        new HttpClient()
                .getRectService()
                .getManagerData(1, 10, 1024)
                .subscribe(new Consumer<BaseResponse<Result>>() {
                    @Override
                    public void accept(BaseResponse<Result> baseResponse) throws Exception {


                        Log.e("================", baseResponse.rest.toString());


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        Log.e("================", throwable.getMessage());


                    }
                });


    }


}
