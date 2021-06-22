package com.example.android.dewmon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EnterSpotActivity extends AppCompatActivity {

    Button checkHl_bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_spot);

        final Spinner spinner = findViewById(R.id.spinner);
        checkHl_bt = findViewById(R.id.HumidityCheck_bt);

        List<String> list = new ArrayList<String>();

        list.add("Enter Spot");
        list.add("CC-I");
        list.add("CC-II");
        list.add("CC-III");
        list.add("Lecture Theatre");
        list.add("Auditorium");
        list.add("Library");
        list.add("Boys Hostel");
        list.add("Girls Hostel");
        list.add("Admin Block");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        checkHl_bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                GlobalVariable.SpotName= spinner.getSelectedItem().toString();
                startActivity(new Intent(getApplicationContext(), HumidityStatistics.class));

            }
        });

    }

}