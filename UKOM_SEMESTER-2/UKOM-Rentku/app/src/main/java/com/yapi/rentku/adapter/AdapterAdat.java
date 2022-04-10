package com.yapi.rentku.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.yapi.rentku.R;
import com.yapi.rentku.model.AdatM;
import com.yapi.rentku.model.DetailAdatM;
import com.yapi.rentku.penyewa.adat.Adat;
import com.yapi.rentku.penyewa.adat.BajuAdat;
import com.yapi.rentku.penyewa.adat.DetailAdat;

import java.util.List;

public class AdapterAdat extends RecyclerView.Adapter<AdapterAdat.MyViewHolder> {

    List<AdatM> adatMList;

    public AdapterAdat(List<AdatM> AdatMList) {
        this.adatMList = AdatMList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adat, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterAdat.MyViewHolder holder, int position) {

        //pisah id
        Intent intent = (Adat.ma.getIntent());
        int value = 127;
        if (adatMList.get(position).getIdkategori() == value){

            holder.tvNamaToko.setText(adatMList.get(position).getNtoko());
            holder.tvJam.setText("Tutup Pukul  " + adatMList.get(position).getJam());
            holder.tvAlamat.setText(adatMList.get(position).getAlamat());
            holder.tvNamaBaju.setText(adatMList.get(position).getNbajuadat());
//            holder.tvNamaBaju.setText(adatMList.get(position).getNbajuadat());
//            holder.tvHarga.setText(adatMList.get(position).getHargabj());
//            holder.tvKeterangan.setText(adatMList.get(position).getDeskripsibj());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mIntent = new Intent(view.getContext(), BajuAdat.class);
                    mIntent.putExtra("ntoko", adatMList.get(position).getNtoko());
                    mIntent.putExtra("nbaju", adatMList.get(position).getNbajuadat());
                    mIntent.putExtra("jam", adatMList.get(position).getJam());
                    mIntent.putExtra("alamat", adatMList.get(position).getAlamat());

                    //yang next ada gambar
                    mIntent.putExtra("Gambar", adatMList.get(position).getFotobj());
                    mIntent.putExtra("namatoko", adatMList.get(position).getNtoko());
                    mIntent.putExtra("harga", adatMList.get(position).getHargabj());
                    mIntent.putExtra("namabaju", adatMList.get(position).getNbajuadat());
                    mIntent.putExtra("kondisi", adatMList.get(position).getKondisi());
                    mIntent.putExtra("ket", adatMList.get(position).getDeskripsibjp());


                    //tambahdetailbaju
                    //mIntent.putExtra("nbajuadat", adatMList.get(position).getNbajuadat());
                    //mIntent.putExtra("kondisi", adatMList.get(position).getKondisi());
                    //mIntent.putExtra("hargabj", adatMList.get(position).getHargabj());
                    //mIntent.putExtra("deskripsibj", adatMList.get(position).getDeskripsibj());

                    view.getContext().startActivity(mIntent);
                }
            });
        } else {//jangan di nyalakan riry gak buat misah kategori yak ? eh boleh" okee
              holder.itemView.setVisibility(View.GONE);
              holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            }
    }

    @Override
    public int getItemCount() {
        return adatMList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNamaToko, tvJam, tvAlamat, tvNamaBaju, tvHarga, tvKeterangan;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvNamaToko = (TextView) itemView.findViewById(R.id.tvNamaBaju);
            tvNamaBaju = (TextView) itemView.findViewById(R.id.tvKeterangan2);
            tvJam = (TextView) itemView.findViewById(R.id.tvHarga);
            tvAlamat = (TextView) itemView.findViewById(R.id.tvKeterangan);
        }
    }
}
