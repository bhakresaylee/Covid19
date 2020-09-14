package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.text.NumberFormat;

public class Notification extends AppCompatActivity {
    TextView date, notification, links;
    String str_notification,str_link,str_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Init();

        FetchData();

    }

    private void FetchData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String apiUrl = "https://api.rootnet.in/covid19-in/notifications";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                apiUrl,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray notifications = null;
                        try {
                        notifications = response.getJSONArray("notifications");
                        JSONObject update = notifications.getJSONObject(0);

                        str_notification = update.getString("title").substring(0,6);
                        str_link = update.getString("link").substring(0,6);

                            Handler delayToshowProgess = new Handler();
                            delayToshowProgess.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    notification.setText(str_notification);
                                    links.setText(str_link);
                                }
                            },1000);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }

    private void Init(){

        date = findViewById(R.id.dates);
        notification = findViewById(R.id.notification);
        links = findViewById(R.id.links);
    }
}