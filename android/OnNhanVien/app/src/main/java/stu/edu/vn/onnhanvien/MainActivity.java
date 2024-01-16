package stu.edu.vn.onnhanvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import stu.edu.vn.onnhanvien.adapter.AdapterNhanVien;
import stu.edu.vn.onnhanvien.model.NhanVien;
import stu.edu.vn.onnhanvien.model.PhongBan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String url = "http://192.168.1.9/server/";
    ListView lv;
    Spinner spin;
    List<NhanVien> dsNV;
    List<PhongBan> dsPB;
    AdapterNhanVien adt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dsNV = new ArrayList<>();
        dsPB = new ArrayList<>();
        addControls();
        getDataNhanVien();
        getDataPhongBan();
    }
    private void addControls(){
        lv = findViewById(R.id.lvNV);
        spin = findViewById(R.id.spinPB);
    }

    public void showNhanVien(){
        adt = new AdapterNhanVien(
                MainActivity.this,
                R.layout.item,
                dsNV
        );
        lv.setAdapter(adt);
        adt.notifyDataSetChanged();
    }

    public void showPhongBan(){
        ArrayAdapter<PhongBan> adapterCT = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_spinner_item,
                dsPB);
        adapterCT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapterCT);
    }
    public void getDataNhanVien(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String urlProduct = url+"getNhanVienChiTiet.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlProduct,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response){
                        try {
                            JSONArray array = new JSONArray(response);
                            for(int i=0; i<array.length(); i++){
                                JSONObject singleObject = array.getJSONObject(i);
                                NhanVien nv = new NhanVien(singleObject.getInt("id"),
                                        singleObject.getString("tennv"),
                                        singleObject.getString("birthday"),
                                        singleObject.getInt("gioitinh"),
                                        singleObject.getString("tenpb"),
                                        singleObject.getString("mota_pb")
                                );
                                dsNV.add(nv);
                            }

                            showNhanVien();
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("url", "error: "+error.getLocalizedMessage());
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        queue.add(stringRequest);
    }
    public void getDataPhongBan(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String urlProduct = url+"getAllPhongBan.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlProduct,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response){
                        try {
                            JSONArray array = new JSONArray(response);
                            for(int i=0; i<array.length(); i++){
                                JSONObject singleObject = array.getJSONObject(i);
                                PhongBan pb = new PhongBan(singleObject.getInt("id_pb"),
                                        singleObject.getString("ten_pb"));
                                dsPB.add(pb);
                            }

                            showPhongBan();
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("url", "error: "+error.getLocalizedMessage());
            }
        });
        queue.add(stringRequest);
    }
}