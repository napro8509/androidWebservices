package com.example.jonah.webservice_test_27_10_2;
import android.content.Intent;
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

public class CapNhatSinhVien extends AppCompatActivity {

    SinhVien sinhVien1;
    EditText edtName,edtYear,edtAddress;
    Button btnUpdate,btnCancel;
    int id=0;
    final String url="http://192.168.1.98/WebService/update.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sinh_vien);

        Intent intent1=getIntent();
        sinhVien1= (SinhVien) intent1.getSerializableExtra("dataSinhVien");
        Toast.makeText(this, (sinhVien1.getId())+"",Toast.LENGTH_LONG).show();
        AnhXa();
        SetText();
    }
    private void AnhXa(){
        edtName=(EditText)findViewById(R.id.edtHoten);
        edtYear=(EditText)findViewById(R.id.edtNamsinh);
        edtAddress=(EditText)findViewById(R.id.edtDiachi);
        btnUpdate=(Button) findViewById(R.id.btnCapNhat);
        btnCancel=(Button)findViewById(R.id.btnHuy);
    }
    private void SetText(){
        edtName.setText(sinhVien1.getHoten());
        edtYear.setText(sinhVien1.getNamsinh()+"");
        edtAddress.setText(sinhVien1.getDiaChi());
        id=sinhVien1.getId();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CapNhat();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void CapNhat(){
        final RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(CapNhatSinhVien.this,"Cập nhật thành công",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(CapNhatSinhVien.this,MainActivity.class));
                        }
                        else {
                            Toast.makeText(CapNhatSinhVien.this,"Lỗi cập nhật!",Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(CapNhatSinhVien.this,error.toString(),Toast.LENGTH_SHORT).show();
                    }
                }
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("idSV",String.valueOf(id));
                params.put("hotenSV",edtName.getText().toString().trim());
                params.put("namsinhSV",edtYear.getText().toString().trim());
                params.put("diachiSV",edtAddress.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
