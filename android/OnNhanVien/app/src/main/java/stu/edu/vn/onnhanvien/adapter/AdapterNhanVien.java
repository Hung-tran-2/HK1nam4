package stu.edu.vn.onnhanvien.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import stu.edu.vn.onnhanvien.R;
import stu.edu.vn.onnhanvien.model.NhanVien;
import stu.edu.vn.onnhanvien.model.PhongBan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AdapterNhanVien extends ArrayAdapter<NhanVien> {
    Activity context;
    int resource;
    List<NhanVien> objects;
    ArrayList<PhongBan> dsPhongBan;
    String url = "http://192.168.1.9/server/";
    public AdapterNhanVien(Activity context, int resource, List<NhanVien> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item = inflater.inflate(this.resource, null);

        TextView name = item.findViewById(R.id.name);
        TextView birthday = item.findViewById(R.id.birthday);
        TextView gioitinh = item.findViewById(R.id.sex);
        TextView txtPhongBan = item.findViewById(R.id.department);
        TextView txtMota = item.findViewById(R.id.mota);
        Button btnXoa = item.findViewById(R.id.btnXoa);
        NhanVien nv = objects.get(position);

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue((Activity)getContext());
                String urlProduct = url+"deleteNhanVienById.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, urlProduct,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response){
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    int success = jsonObject.getInt("success");
                                    String mess = jsonObject.getString("message");
                                    if(success ==1)
                                    {
                                        remove(nv);
                                        notifyDataSetChanged();
                                    }
                                    Toast.makeText(context, mess, Toast.LENGTH_SHORT).show();

                                }catch (JSONException e){
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("url", "error: "+error.getLocalizedMessage());
                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("id_nv", nv.id+"");
                        return params;
                    }
                };
                stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                        DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

                queue.add(stringRequest);
            }
        });

        name.setText(nv.getTennv());
        birthday.setText(nv.getBirthday());
        gioitinh.setText(nv.getGioitinh() == 1 ? "1" : "0");
        txtPhongBan.setText(nv.getTenpb());
        txtMota.setText(nv.getMota_pb());
        return item;




    }
}
