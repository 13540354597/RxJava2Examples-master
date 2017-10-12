package com.nanchen.rxjava2examples.practice;



import com.nanchen.rxjava2examples.practice.bean.Result;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


/**
 * Created by TR 105 on 2017/8/4.
 */

public interface HttpService {

    @GET("/getposts")
    Observable<BaseResponse<Result>> getManagerData(@Query("page") int page, @Query("number") int number, @Query("userID") int userID);
    @GET("/getposts")
    Call<BaseResponse<Result>> getManagerData2(@Query("page") int page, @Query("number") int number, @Query("userID") int userID);
//    @Multipart
//    @POST("/uploadimage")
//    Call<ResponseBody> uploadSimpleFile(@Part("Picture") RequestBody imgs);

    @Multipart
    @POST("/uploadimage")
    Call<ResponseBody> uploadSimpleFile(@Part("Picture") RequestBody imgs);


    @Multipart
    @POST("/uploadimage")
    Observable<BaseResponse<Result>> uploadSimpleFile2(@Part("Picture") RequestBody imgs);

}
