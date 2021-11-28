package com.yapi.rentku.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.yapi.rentku.R;
import com.yapi.rentku.model.DetailAdatM;
import com.yapi.rentku.penyewa.adat.Adat;
import com.yapi.rentku.penyewa.adat.BajuAdat;
import com.yapi.rentku.penyewa.adat.DetailAdat;

import java.util.List;

public class AdapterDetailAdat extends RecyclerView.Adapter<AdapterDetailAdat.MyViewHolder> {

    List<DetailAdatM> detailAdatMList;

    public AdapterDetailAdat(List<DetailAdatM> detailAdatMList) { this.detailAdatMList = detailAdatMList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detailadat, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterDetailAdat.MyViewHolder holder, int position) {

        //pisah id
        Intent intent = (Adat.ma.getIntent());
        int value = intent.getIntExtra("idKategori", 0);
        if (detailAdatMList.get(position).getIdkategori() == value){

            holder.tvNamaBaju.setText(detailAdatMList.get(position).getNbajuadat());
            holder.tvHarga.setText(detailAdatMList.get(position).getHargabj());
            holder.tvKeterangan.setText(detailAdatMList.get(position).getDeskripsibj());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mIntent = new Intent(view.getContext(), BajuAdat.class);
                    mIntent.putExtra("Nmbj", detailAdatMList.get(position).getNbajuadat());
                    mIntent.putExtra("Knds", detailAdatMList.get(position).getKondisi());
                    mIntent.putExtra("Hrg", detailAdatMList.get(position).getHargabj());
                    mIntent.putExtra("Deskbj", detailAdatMList.get(position).getDeskripsibj());
                    view.getContext().startActivity(mIntent);
                }
            });

        } else {
            holder.itemView.setVisibility(View.GONE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        }

    }

    @Override
    public int getItemCount() { return detailAdatMList.size();
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
