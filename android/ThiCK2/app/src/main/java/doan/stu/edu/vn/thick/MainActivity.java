package doan.stu.edu.vn.thick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private static final String API_BASE_URL = "http://document.fitstu.net/2022/ws1.php";
    private EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        final EditText etUsername = findViewById(R.id.etUsername);
        final EditText etPassword = findViewById(R.id.etPass);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                xuLyDangNhap(username,password);
            }
        });

    }
    private void xuLyDangNhap (final String username,final String password) {
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new StringRequest(
                Request.Method.GET,
                API_BASE_URL + "?action=login&user=" + username + "&pass=" + password,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "RETURN" );
                            if (success) {
                                Toast.makeText( MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_LONG ).show();
                                Intent intent = new Intent( MainActivity.this, CurrencyRateActivity.class);
                                startActivity( intent );
                            } else {
                                Toast.makeText( MainActivity.this, "Dang nhap that bai", Toast.LENGTH_LONG ).show();
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText( MainActivity.this,"Loi ket noi",Toast.LENGTH_LONG).show();
                    }
                }
        );
        requestQueue.add(request);
    }
}