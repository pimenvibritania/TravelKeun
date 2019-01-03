package com.example.pimenvibritania.travelkeun.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.pimenvibritania.travelkeun.R;
import com.example.pimenvibritania.travelkeun.adapters.RecyclerViewAdapter;
import com.example.pimenvibritania.travelkeun.model.Travel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://api-travel.herokuapp.com/api-travel";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Travel> lstTravel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstTravel = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleviewid);
        jsonrequest();
    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++){
                    try {
                        jsonObject = response.getJSONObject(i);
                        Travel travel = new Travel();
                        travel.setnPerusahaan(jsonObject.getString("n_perusahaan"));
                        travel.setnTravel(jsonObject.getString("n_travel"));
                        travel.setJumlah(jsonObject.getInt("jumlah" ));
                        travel.setAlamat(jsonObject.getString("alamat"));
                        travel.setImg_url(jsonObject.getString("n_img"));
                        lstTravel.add(travel);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(lstTravel);
             }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<Travel> lstTravel) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, lstTravel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);
    }
}
