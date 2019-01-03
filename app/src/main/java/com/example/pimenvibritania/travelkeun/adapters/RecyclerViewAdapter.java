package com.example.pimenvibritania.travelkeun.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pimenvibritania.travelkeun.activities.TravelActivity;
import com.example.pimenvibritania.travelkeun.model.Travel;
import com.example.pimenvibritania.travelkeun.R;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Travel> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Travel> mData) {
        this.mContext = mContext;
        this.mData = mData;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.travel_row, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, TravelActivity.class);
                i.putExtra("nama_travel", mData.get(viewHolder.getAdapterPosition()).getnTravel());
                i.putExtra("nama_perusahaan", mData.get(viewHolder.getAdapterPosition()).getnPerusahaan());
                i.putExtra("jumlah_kendaraan", mData.get(viewHolder.getAdapterPosition()).getJumlah());
                i.putExtra("alamat_travel", mData.get(viewHolder.getAdapterPosition()).getAlamat());
                i.putExtra("travel_img", mData.get(viewHolder.getAdapterPosition()).getImg_url());
                i.putExtra("deskripsi_travel", mData.get(viewHolder.getAdapterPosition()).getDesk());

                mContext.startActivity(i);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_perusahaan.setText(mData.get(position).getnPerusahaan());
        holder.tv_travel.setText(mData.get(position).getnTravel());
//        holder.tv_jumlah.setText(mData.get(position).getJumlah());
        holder.tv_alamat.setText(mData.get(position).getAlamat());

        Glide.with(mContext).load(mData.get(position).getImg_url()).apply(option).into(holder.img_thumbnail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_perusahaan;
        TextView tv_travel;
//        TextView tv_jumlah;
        TextView tv_alamat;
        ImageView img_thumbnail;
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_perusahaan = itemView.findViewById(R.id.perusahaan_name);
            tv_travel = itemView.findViewById(R.id.travel_name);
//            tv_jumlah = itemView.findViewById(R.id.jumlah);
            tv_alamat = itemView.findViewById(R.id.alamat);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
