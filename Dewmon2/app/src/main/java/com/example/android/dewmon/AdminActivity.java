package com.example.android.dewmon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
    public void StartRG(View view) {

    }


    public void OpenHomepage(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }


    public void OpenSetThreshold(View view) {
        startActivity(new Intent(getApplicationContext(),SetThresholdActivity.class));
    }

    public void OpenAlertpage(View view) {
        startActivity(new Intent(getApplicationContext(),AlertActivity.class));
    }
}