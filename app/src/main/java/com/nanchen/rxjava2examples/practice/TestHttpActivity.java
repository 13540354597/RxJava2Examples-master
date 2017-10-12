package com.nanchen.rxjava2examples.practice;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.nanchen.rxjava2examples.R;
import com.nanchen.rxjava2examples.practice.bean.Result;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by TR 105 on 2017/8/5.
 */

public class TestHttpActivity extends Activity {
    private Button btn_http;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_http_activity);
        btn_http = (Button) findViewById(R.id.btn_http);
        btn_http.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                http();
            }
        });
    }


    private void http() {
        new HttpClient()
                .getRectService()
                .getManagerData(1, 10, 1024)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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

//        new HttpClient()
//                .getRectService()
//                .getManagerData2(1, 10, 1024).enqueue(new Callback<BaseResponse<Result>>() {
//            @Override
//            public void onResponse(Call<BaseResponse<Result>> call, Response<BaseResponse<Result>> response) {
//                Log.e("================", response.toString());
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse<Result>> call, Throwable t) {
//                Log.e("================", t.getMessage());
//            }
//        });


//                new HttpClient()
//                .getRectService()
//                .getManagerData(1, 10, 1024)
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Observer<BaseResponse<Result>>() {
//                            @Override
//                            public void onSubscribe(Disposable d) {
//
//                            }
//
//                            @Override
//                            public void onNext(BaseResponse<Result> baseResponse) {
//                                Log.e("================", baseResponse.toString());
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//
//                            }
//
//                            @Override
//                            public void onComplete() {
//
//                            }
//                        });

    }
}
