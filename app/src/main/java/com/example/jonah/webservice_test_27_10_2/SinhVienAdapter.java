package com.example.jonah.webservice_test_27_10_2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Jonah on 10/27/2017.
 */

public class SinhVienAdapter extends BaseAdapter {
    MainActivity context;
    private int layout;
    private List<SinhVien> listSinhVien;

    public SinhVienAdapter(MainActivity context, int layout, List<SinhVien> listSinhVien) {
        this.context = context;
        this.layout = layout;
        this.listSinhVien = listSinhVien;
    }

    @Override
    public int getCount() {
        return listSinhVien.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private  class ViewHolder{
        TextView txtHoten,txtNamsinh,txtDiachi;
        Button btnEdit,btnDelete;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(layout,null);
            holder.txtHoten=(TextView)convertView.findViewById(R.id.textViewhoten);
            holder.txtNamsinh=(TextView)convertView.findViewById(R.id.textViewnamsinh);
            holder.txtDiachi=(TextView)convertView.findViewById(R.id.textViewdiachi);
            holder.btnEdit=(Button)convertView.findViewById(R.id.btnEdit);
            holder.btnDelete=(Button)convertView.findViewById(R.id.btnDelete1);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder) convertView.getTag();
        }
        final SinhVien sinhVien=listSinhVien.get(position);
        holder.txtHoten.setText("Họ tên: "+sinhVien.getHoten());
        holder.txtNamsinh.setText("Năm sinh: "+sinhVien.getNamsinh());
        holder.txtDiachi.setText("Địa chỉ: "+sinhVien.getDiaChi());

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,CapNhatSinhVien.class);
                intent.putExtra("dataSinhVien",sinhVien);
                context.startActivity(intent);
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog(sinhVien.getHoten(),sinhVien.getId());

            }
        });
        convertView.setMinimumHeight(100);
        return convertView;
    }
    private void ShowDialog(String ten, final int id){
        AlertDialog.Builder dialogXoa=new AlertDialog.Builder(context);
        dialogXoa.setMessage("Bạn có muốn xóa sinh viên "+ten+" không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.XoaHocSinh(id);
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogXoa.show();
    }
}
