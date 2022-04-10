package com.yapi.rentku.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.yapi.rentku.R;
import com.yapi.rentku.model.DetailProfesiM;
import com.yapi.rentku.penyewa.profesi.BajuProfesi;

import java.util.List;

public class AdapterDetailProfesi extends RecyclerView.Adapter<AdapterDetailProfesi.MyViewHolder> {

    List<DetailProfesiM> detailProfesiMList;

    public AdapterDetailProfesi(List<DetailProfesiM> detailProfesiMList) { this.detailProfesiMList = detailProfesiMList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detailprofesi, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterDetailProfesi.MyViewHolder holder, int position) {
        holder.tvNamaBaju.setText(detailProfesiMList.get(position).getNbajuprofesi());
        holder.tvHarga.setText(detailProfesiMList.get(position).getKondisip());
        holder.tvHarga.setText(detailProfesiMList.get(position).getHargabjp());
        holder.tvKeterangan.setText(detailProfesiMList.get(position).getDeskripsibjp());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), BajuProfesi.class);
                mIntent.putExtra("Nmbjp", detailProfesiMList.get(position).getNbajuprofesi());
                mIntent.putExtra("Kndsp", detailProfesiMList.get(position).getKondisip());
                mIntent.putExtra("Hrgp", detailProfesiMList.get(position).getHargabjp());
                mIntent.putExtra("Deskbjp", detailProfesiMList.get(position).getDeskripsibjp());
                view.getContext().startActivity(mIntent);
            }
        });

    }

    @Override
    public int getItemCount() { return detailProfesiMList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNamaBaju, tvHarga, tvKeterangan;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvNamaBaju = (TextView) itemView.findViewById(R.id.tvNamaBaju);
            tvHarga = (TextView) itemView.findViewById(R.id.tvHarga);
            tvKeterangan = (TextView) itemView.findViewById(R.id.tvKeterangan);
        }
    }

}
