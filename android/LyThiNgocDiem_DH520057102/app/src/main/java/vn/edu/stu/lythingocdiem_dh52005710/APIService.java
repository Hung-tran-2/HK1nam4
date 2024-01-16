package vn.edu.stu.lythingocdiem_dh52005710;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vn.edu.stu.lythingocdiem_dh52005710.Model.AddMonHoc;
import vn.edu.stu.lythingocdiem_dh52005710.Model.DeleteMonHoc;
import vn.edu.stu.lythingocdiem_dh52005710.Model.MonHoc;

public interface APIService {
    String BASE_URL = "http://document.fitstu.net/wsmonhoc/";
    Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    APIService API_SERVICE = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .build()
            .create(APIService.class);

    @GET("api.php?action=dsmh&mssv=dh52005710")
    Call<List<MonHoc>> getallMonHoc();

    @GET("api.php?action=themmh&mssv=dh52005710")
    Call<AddMonHoc> ThemMonHoc(
            @Query("ten") String tenmh);
    @GET("api.php?action=xoamh&mssv=dh52005710")
    Call<DeleteMonHoc> XoaMonHoc(
            @Query("ma") int ma);
}
