package com.example.myapplication.API;

import com.example.myapplication.model.HangHoa;
import com.example.myapplication.model.LoginResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiSevice {
    String Url =  "http://192.168.2.28/de1/";
    Gson GSON= new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiSevice API_SEVICE = new Retrofit.Builder().baseUrl(Url).addConverterFactory(GsonConverterFactory.create(GSON)).build().create(ApiSevice.class);
    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> login(
            @Field("username") String username,
            @Field("password") String password);
    @GET("gethanghoa.php")
    Call<List<HangHoa>> getHangHoaList(@Query("loaihanghoa") String loaihanghoa);

}
