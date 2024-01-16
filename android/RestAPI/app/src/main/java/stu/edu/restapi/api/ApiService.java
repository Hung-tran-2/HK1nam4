package stu.edu.restapi.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import stu.edu.restapi.model.Book;
import stu.edu.restapi.opject.Khachhang;

public interface ApiService {
//    Gson gson = new GsonBuilder()
//            .setDateFormat("yyyy-MM-dd HH:mm:ss")
//            .create();
//    //https://71a1-171-240-240-53.ngrok-free.app/bookstore/api/v3/books
//    ApiService api = new Retrofit.Builder().
//            baseUrl("https://71a1-171-240-240-53.ngrok-free.app/bookstore/").
//            addConverterFactory(GsonConverterFactory.create(gson)).
//                build().
//                create(ApiService.class);

//    @GET("api/v3/books")
//    Call<List<Book>> getListKhachH (@Query("data") int khID);
    @GET("/api/v3/books")
    Call<List<Book>> getListOfBooks();
}
