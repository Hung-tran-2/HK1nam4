package stu.edu.vn.thicuoiki;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import stu.edu.vn.thicuoiki.module.Sach;

public interface ApiService {
    //http://document.fitstu.net/wssach/api.php?action=getds&mssv=dh52007186
    String BASE_URL="http://document.fitstu.net/wssach/";
    Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService API_SERVICE = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .build()
            .create(ApiService.class);
    @GET("api.php?action=getds&mssv=dh52007186")
    Call<List<Sach>> getall();
}
