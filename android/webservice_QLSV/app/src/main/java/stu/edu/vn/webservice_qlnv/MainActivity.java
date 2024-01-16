package stu.edu.vn.webservice_qlnv;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import stu.edu.vn.webservice_qlnv.adapterNhanVien.adapter;
import stu.edu.vn.webservice_qlnv.modal.SinhVien;

public class MainActivity extends AppCompatActivity {
    final String SERVER = "http://192.168.56.1/ws/api.php";
    ListView lv;
    TextView txtMa, txtTen;
    Button btnLuu;
    ArrayList<SinhVien> ds;
    adapter adapter;
    SinhVien chon = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
        hienthidanhsach();
    }
    public void addControl(){
        txtMa = findViewById(R.id.txtMa);
        txtTen = findViewById(R.id.txtName);
        btnLuu = findViewById(R.id.btnLuu);
        lv = findViewById(R.id.lvDS);
        ds = new ArrayList<>();
        adapter = new adapter(ds,MainActivity.this);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public void resetInput(){
        txtTen.setText("");
        txtMa.setText("");
    }
    public void addEvent(){
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chon == null){
                    int ma =Integer.parseInt(txtMa.getText().toString());
                    String ten=txtTen.getText().toString();
                    SinhVien sv =new SinhVien(ma,ten);
                    them(sv);
                    resetInput();
                }
                else {
                    String ten = txtTen.getText().toString();
                    chon.setTen(ten);
                    update(chon);
                    chon = null;
                    resetInput();
                    txtMa.setEnabled(true);
                }
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>=0 && i< ds.size()) {
                    chon = ds.get(i);
                    txtMa.setText(chon.getMa() + "");
                    txtTen.setText(chon.getTen());
                    txtMa.setEnabled(false);
                }
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                SinhVien pos = ds.get(i);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo!!");
                builder.setMessage("Bạn có chắc chắn muốn xóa "+ pos.getTen() + " ?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Delete(pos);
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });
    }
    private void them(SinhVien sv){
        RequestQueue rq =Volley.newRequestQueue(MainActivity.this);
        Response.Listener<String>response = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    ds.clear();
                    JSONObject jsonObject = new JSONObject(response);
                    String message = jsonObject.getString("message");
                    if (message.equals("true")) {
                        Toast.makeText(MainActivity.this, "Thêm thành công!", Toast.LENGTH_LONG).show();
                        hienthidanhsach();
                    } else {
                        Toast.makeText(MainActivity.this, "Thêm thất bại!", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception ex) {

                }
            }
        };
        Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Thêm thất bại!", Toast.LENGTH_LONG).show();
            }
        };
        Uri.Builder builder = Uri.parse(SERVER).buildUpon();
        builder.appendQueryParameter("action", "insert");
        builder.appendQueryParameter("masv", sv.getMa()+"");
        builder.appendQueryParameter("tensv", sv.getTen());
        String url = builder.build().toString();
        StringRequest request = new StringRequest(
                Request.Method.GET, url, response,error
        );
        request.setRetryPolicy(new DefaultRetryPolicy(
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));
        rq.add(request);
    }
    private void update(SinhVien sv){
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        Response.Listener<String> reponseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    ds.clear();
                    JSONObject jsonObject = new JSONObject(response);
                    String message =jsonObject.getString("message");
                    if(message.equals("true")){
                        Toast.makeText(MainActivity.this,"Sửa thành công!", Toast.LENGTH_LONG).show();
                        hienthidanhsach();
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Sửa thất bại!", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception ex) {

                }
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
        Uri.Builder builder = Uri.parse(SERVER).buildUpon();
        builder.appendQueryParameter("action", "update");
        builder.appendQueryParameter("masv", sv.getMa()+"");
        builder.appendQueryParameter("tensv", sv.getTen());
        String url = builder.build().toString();
        StringRequest request = new StringRequest(
                Request.Method.GET, url, reponseListener, errorListener
        );
        request.setRetryPolicy(new DefaultRetryPolicy(
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));
        requestQueue.add(request);
    }
    private void Delete(SinhVien sv){
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        Response.Listener<String> reponseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    ds.clear();
                    JSONObject jsonObject = new JSONObject(response);
                    String message =jsonObject.getString("message");
                    if(message.equals("true")){
                        Toast.makeText(MainActivity.this,"Xóa thành công", Toast.LENGTH_LONG).show();
                        hienthidanhsach();
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Xóa thất bại", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception ex) {

                }
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
        Uri.Builder builder = Uri.parse(SERVER).buildUpon();
        builder.appendQueryParameter("action", "delete");
        builder.appendQueryParameter("masv", sv.getMa()+"");
        String url = builder.build().toString();
        StringRequest request = new StringRequest(
                Request.Method.GET, url, reponseListener, errorListener
        );
        request.setRetryPolicy(new DefaultRetryPolicy(
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));
        requestQueue.add(request);
    }
    private void hienthidanhsach() {
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        Response.Listener<String> reponseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    ds.clear();
                    JSONArray jsonArray = new JSONArray(response);
                    int len = jsonArray.length();
                    for (int i = 0; i < len; i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        int ma = jsonObject.getInt("masv");
                        String ten = jsonObject.getString("tensv");
                        ds.add(new SinhVien(ma, ten));
                    }
                    adapter.notifyDataSetChanged();
                } catch (Exception ex) {

                }
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        };
        Uri.Builder builder = Uri.parse(SERVER).buildUpon();
        builder.appendQueryParameter("action", "getall");
        String url = builder.build().toString();
        StringRequest request = new StringRequest(
                Request.Method.GET, url, reponseListener, errorListener
        );
        request.setRetryPolicy(new DefaultRetryPolicy(
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));
        requestQueue.add(request);
    }
}