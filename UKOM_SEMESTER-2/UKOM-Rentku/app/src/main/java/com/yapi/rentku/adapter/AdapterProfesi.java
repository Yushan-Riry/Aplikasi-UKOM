package com.yapi.rentku.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.yapi.rentku.R;
import com.yapi.rentku.model.AdatM;
import com.yapi.rentku.model.ProfesiM;
import com.yapi.rentku.penyewa.adat.Adat;
import com.yapi.rentku.penyewa.adat.DetailAdat;
import com.yapi.rentku.penyewa.profesi.DetailProfesi;

import java.util.List;

public class AdapterProfesi extends RecyclerView.Adapter<AdapterProfesi.MyViewHolder> {

    List<ProfesiM> profesiMlist;

    public AdapterProfesi(List<ProfesiM> ProfesiMList) { this.profesiMlist = ProfesiMList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profesi, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterProfesi.MyViewHolder holder, int position) {

        //pisah id
        Intent intent = (Adat.ma.getIntent());
        int value = intent.getIntExtra("idKategori", 0);
        if (profesiMlist.get(position).getIdkategori() == value){

            holder.tvNamaToko.setText(profesiMlist.get(position).getNtokop());
            holder.tvJam.setText("Tutup Pukul " + profesiMlist.get(position).getJamp());
            holder.tvAlamat.setText(profesiMlist.get(position).getAlamatp());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mIntent = new Intent(view.getContext(), DetailProfesi.class);
                    mIntent.putExtra("Nmtkp", profesiMlist.get(position).getNtokop());
                    mIntent.putExtra("Jmp", profesiMlist.get(position).getJamp());
                    mIntent.putExtra("Almtp", profesiMlist.get(position).getAlamatp());
                    view.getContext().startActivity(mIntent);
                }
            });

        } else {
            holder.itemView.setVisibility(View.GONE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        }

    }

    @Override
    public int getItemCount() {
        return profesiMlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNamaToko, tvJam, tvAlamat;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvNamaToko = (TextView) itemView.findViewById(R.id.tvNamaBaju);
            tvJam = (TextView) itemView.findViewById(R.id.tvHarga);
            tvAlamat = (TextView) itemView.findViewById(R.id.tvKeterangan);
        }
    }

}
