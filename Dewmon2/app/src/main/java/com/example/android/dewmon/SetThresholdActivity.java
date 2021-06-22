package com.example.android.dewmon;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SetThresholdActivity extends AppCompatActivity {

    EditText editTextMinHl,editTextMaxHl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_threshold);
        editTextMinHl = findViewById(R.id.minHl_txt);
        editTextMaxHl = findViewById(R.id.maxHl_txt);
    }

    public void SetThresholdValues(View view) {
        GlobalVariable.MinHl = Integer.parseInt(editTextMinHl.getText().toString());
        GlobalVariable.MaxHl = Integer.parseInt(editTextMaxHl.getText().toString());
        Toast.makeText(getApplicationContext(),"Threshold Successfully Setted",Toast.LENGTH_SHORT).show();

    }


}