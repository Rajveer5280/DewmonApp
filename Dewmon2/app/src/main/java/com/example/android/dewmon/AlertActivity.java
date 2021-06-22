package com.example.android.dewmon;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AlertActivity extends AppCompatActivity {
    EditText editTextAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        editTextAlert = findViewById(R.id.alertMsg_txt);
    }

    public void SetAlertMessage(View view) {
        GlobalVariable.AlertMessage = editTextAlert.getText().toString();
        Toast.makeText(getApplicationContext(),"Alert Message Successfully Setted",Toast.LENGTH_SHORT).show();
    }
}