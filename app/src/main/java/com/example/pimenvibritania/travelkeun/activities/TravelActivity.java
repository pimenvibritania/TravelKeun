package com.example.pimenvibritania.travelkeun.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pimenvibritania.travelkeun.R;

public class TravelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        getSupportActionBar().hide();

        String nTravel =  getIntent().getExtras().getString("nama_travel");
        String nPerusahaan = getIntent().getExtras().getString("nama_perusahaan");
        int jumlah = getIntent().getExtras().getInt("jumlah_kendaraan");
        String alamat = getIntent().getExtras().getString("alamat_travel");
        String img_url = getIntent().getExtras().getString("travel_img");
        String deskripsi = getIntent().getExtras().getString("deskripsi_travel");


        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_nTravel = findViewById(R.id.aa_travel_name);
        TextView tv_nPerisahaan = findViewById(R.id.aa_perusahaan_name);
        TextView tv_alamat = findViewById(R.id.aa_alamat);
        TextView tv_deskripsi = findViewById(R.id.aa_desk);
        ImageView img = findViewById(R.id.aa_thumbnail);


        tv_nTravel.setText(nTravel);
        tv_nPerisahaan.setText(nPerusahaan);
        tv_alamat.setText(alamat);
        tv_deskripsi.setText(deskripsi);

        collapsingToolbarLayout.setTitle(nTravel);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        Glide.with(this).load(img_url).apply(requestOptions).into(img);
    }
}
