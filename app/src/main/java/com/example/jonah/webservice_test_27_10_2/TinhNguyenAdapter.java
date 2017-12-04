package com.example.jonah.webservice_test_27_10_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jonah on 11/2/2017.
 */

public class TinhNguyenAdapter extends BaseAdapter {
    Context context;
    private int layout;
    private List<TinhNguyen> listTinhNguyen;

    public TinhNguyenAdapter(Context context, int layout, List<TinhNguyen> listTinhNguyen) {
        this.context = context;
        this.layout = layout;
        this.listTinhNguyen = listTinhNguyen;
    }

    @Override
    public int getCount() {
        return listTinhNguyen.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txttentruong,txtmahoatdong,txttenhoatdong,txtngaybatdau,txtngayketthuc,txtdiadiem,txtnoidung;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(layout,null);
            holder.txtmahoatdong=(TextView)convertView.findViewById(R.id.tvmahoatdong);
            holder.txttenhoatdong=(TextView)convertView.findViewById(R.id.tvtenhoatdong);
            holder.txttentruong=(TextView)convertView.findViewById(R.id.tvtentruong);
            holder.txtngaybatdau=(TextView)convertView.findViewById(R.id.tvngaybatdau);
            holder.txtngayketthuc=(TextView)convertView.findViewById(R.id.tvngayketthuc);
            holder.txtdiadiem=(TextView)convertView.findViewById(R.id.tvdiadiem);
            holder.txtnoidung=(TextView)convertView.findViewById(R.id.tvnoidung);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder) convertView.getTag();
        }
        final TinhNguyen tinhNguyen=listTinhNguyen.get(position);
        holder.txtmahoatdong.setText("Mã hoạt động: "+tinhNguyen.getMahoatdong());
        holder.txttenhoatdong.setText(tinhNguyen.getTenhoatdong());
        holder.txttentruong.setText("Tên trường: "+tinhNguyen.getTentruong());
        holder.txtngaybatdau.setText("Ngày bắt đầu: "+tinhNguyen.getNgaybatdau());
        holder.txtngayketthuc.setText("Ngày kết thúc: "+tinhNguyen.getNgayketthuc());
        holder.txtdiadiem.setText("Điạ điểm: "+tinhNguyen.getDiadiem());
        holder.txtnoidung.setText("Nội dung: "+tinhNguyen.getNoidung());
        return convertView;
    }
}
