package com.example.jonah.webservice_test_27_10_2;

import android.content.Intent;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String url="http://192.168.1.98/WebService/getData.php";
    String urlXoa="http://192.168.1.98/WebService/delete.php";
    ListView lwSinhVien;
    ArrayList<SinhVien> arraySinhVien;
    SinhVienAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lwSinhVien=(ListView)findViewById(R.id.listViewSinhVien);
        arraySinhVien=new ArrayList<>();
        adapter=new SinhVienAdapter(this,R.layout.item_sinh_vien,arraySinhVien);
        lwSinhVien.setAdapter(adapter);
        GetData(url);
    }
    private void GetData(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                arraySinhVien.clear();
                for(int i=0;i<response.length();i++)
                {
                    try {
                        JSONObject object=response.getJSONObject(i);
                        arraySinhVien.add(new SinhVien(object.getInt("Id"),
                                object.getString("Hoten"),
                                object.getInt("Namsinh"),
                                object.getString("Diachi")));
                    } catch (JSONException e) {
                        Toast.makeText(MainActivity.this,"Lỗi ở đây",Toast.LENGTH_LONG).show();
                        e.printStackTrace();

                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_student,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menuAddScreen)
        {
            startActivity(new Intent(MainActivity.this,buttonAddActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
    public void XoaHocSinh(final int idSV){
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, urlXoa,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(MainActivity.this,"Xóa thành công!",Toast.LENGTH_SHORT).show();
                            GetData(url);
                        }
                        else {
                            Toast.makeText(MainActivity.this,"Lỗi khi xóa!",Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
                    }
                }
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>param=new HashMap<>();
                param.put("idSV",String.valueOf(idSV));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }
}
