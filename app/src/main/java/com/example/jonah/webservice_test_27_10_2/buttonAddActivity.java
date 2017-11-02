package com.example.jonah.webservice_test_27_10_2;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class buttonAddActivity extends AppCompatActivity {


    EditText nhapten,nhapnamsinh,nhapdiachi;
    Button btnOk, btnHuy;
    String stringUrl="http://192.168.1.98/WebService/insert.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_add);

        nhapten=(EditText)findViewById(R.id.edtNhapTen);
        nhapdiachi=(EditText)findViewById(R.id.edtNhapDiaChi);
        nhapnamsinh=(EditText)findViewById(R.id.edtNhapNamSinh);
        btnOk=(Button)findViewById(R.id.btnOk);
        btnHuy=(Button)findViewById(R.id.btnHuy);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Hoten=nhapten.getText().toString().trim();
                String Namsinh=nhapnamsinh.getText().toString().trim();
                String Diachi=nhapdiachi.getText().toString().trim();
                if(Hoten.isEmpty()||Namsinh.isEmpty()||Diachi.isEmpty())
                {
                    Toast.makeText(buttonAddActivity.this,"Nhập đầy đủ thông tin",Toast.LENGTH_LONG).show();
                }else {
                    ThemSinhVien(stringUrl);
                    startActivity(new Intent(buttonAddActivity.this, MainActivity.class));
                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private  void ThemSinhVien(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("Success"))
                        {
                            Toast.makeText(buttonAddActivity.this,"Thêm thành công",Toast.LENGTH_LONG).show();
                        }else
                        {
                            Toast.makeText(buttonAddActivity.this,"Lỗi thêm",Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        {
                            Toast.makeText(buttonAddActivity.this,"Lỗi Response",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("hotenSV",nhapten.getText().toString().trim());
                params.put("namsinhSV",nhapnamsinh.getText().toString().trim());
                params.put("diachiSV",nhapdiachi.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
