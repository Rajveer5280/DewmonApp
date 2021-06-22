package com.example.android.dewmon;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class HumidityStatistics extends AppCompatActivity {

    private TextView current_hl,currentSpot;
    Button current_hl_bt;
    String yourSpot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humidity_statistics);

        current_hl = findViewById(R.id.current_hl_valuetxt);
        currentSpot = findViewById(R.id.current_spot_txt);
        yourSpot = GlobalVariable.SpotName;
        currentSpot.setText(yourSpot);


        current_hl_bt = findViewById(R.id.current_hlstat_bt);

        current_hl_bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Random random = new Random();
                int number = random.nextInt(100) +1;

                current_hl.setText(String.valueOf(number));
                int Hl = Integer.parseInt(current_hl.getText().toString());

                int minHl = GlobalVariable.MinHl;
                int maxHl = GlobalVariable.MaxHl;

                if (Hl < minHl || Hl > maxHl) {
                    Toast.makeText(getApplicationContext(),"Humidity Level is out of safe criteria",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Humidity Level is in safe criteria",Toast.LENGTH_SHORT).show();
                }


            }
        });


        //    current_hl = findViewById(R.id.current_hl_value);

        //   Intent i = getIntent();
        //    hl = i.getIntExtra(HumidityValue,0);

        //    current_hl.setText(hl);

    }


}