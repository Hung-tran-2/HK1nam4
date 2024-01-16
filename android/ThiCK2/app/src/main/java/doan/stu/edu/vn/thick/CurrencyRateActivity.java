package doan.stu.edu.vn.thick;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CurrencyRateActivity extends AppCompatActivity {
    private static final String SERVER_URL = "http://document.fitstu.net/2022/ws1.php";
    private EditText etType;
    private ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_rate);
        etType = findViewById(R.id.etType);
        Button btnGetRate = findViewById(R.id.btnGetRate);
        listView = findViewById(R.id.listView);

        btnGetRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = etType.getText().toString();
                // Gọi service để lấy tỉ giá tiền tệ
                xuliLayTiGia(type);
            }
        });
    }

    private void xuliLayTiGia(final String type) {
        RequestQueue requestQueue = Volley.newRequestQueue(CurrencyRateActivity.this);
        StringRequest request = new StringRequest(
                Request.Method.GET,
                SERVER_URL + "?action=getrate&type=" + type,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            JSONArray jsonArray = jsonObject.getJSONArray( "RETURN" );

                            if (jsonArray.length() > 0) {
                                List<String> rateList = new ArrayList<>();
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject rateObject = jsonArray.getJSONObject( i );
                                    String code = rateObject.getString( "code" );
                                    String rate = rateObject.getString( "rate" );
                                    rateList.add( "code:" + code + "\n" + "rate: " + rate );
                                }
                                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                        CurrencyRateActivity.this,
                                        android.R.layout.simple_list_item_1,
                                        rateList
                                );
                                listView.setAdapter( adapter );
                                Toast.makeText( CurrencyRateActivity.this, "Ket qua :"
                                        + jsonArray.toString(), Toast.LENGTH_LONG ).show();
                            } else {
                                Toast.makeText(
                                        CurrencyRateActivity.this,
                                        "Khong co du lieu ti le gia",
                                        Toast.LENGTH_LONG
                                ).show();
                                listView.setAdapter( null );
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException( e );
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(
                                CurrencyRateActivity.this,
                                "Lỗi khi kết nối đến server",
                                Toast.LENGTH_LONG
                        ).show();
                        listView.setAdapter(null);
                    }
                }
        );
        requestQueue.add(request);
    }

}
