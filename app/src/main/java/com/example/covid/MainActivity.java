package com.example.covid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout updatecovid,notify,contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updatecovid = findViewById(R.id.covidupdate);
        notify = findViewById(R.id.notifiy);
        contact = findViewById(R.id.contact);

        updatecovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                indiaupdated();
            }
        });

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notification();
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contact1();
            }
        });

    }

    private void contact1(){
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);
    }

    private void notification(){
        Intent intent = new Intent(this, Notification.class);
        startActivity(intent);
    }

    private void indiaupdated() {
        Intent intent = new Intent(this, indiaupdate.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.menu_about){
            Toast.makeText(MainActivity.this,"About Menu is Click",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}