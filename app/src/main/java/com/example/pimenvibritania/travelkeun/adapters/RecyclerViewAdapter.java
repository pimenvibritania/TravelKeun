package com.example.pimenvibritania.travelkeun.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
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
        return new MyViewHolder(view);
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

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_perusahaan = itemView.findViewById(R.id.perusahaan_name);
            tv_travel = itemView.findViewById(R.id.travel_name);
//            tv_jumlah = itemView.findViewById(R.id.jumlah);
            tv_alamat = itemView.findViewById(R.id.alamat);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
