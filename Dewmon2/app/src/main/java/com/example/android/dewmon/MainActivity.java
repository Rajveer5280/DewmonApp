package com.example.android.dewmon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;
public class MainActivity extends AppCompatActivity {

    TextView textViewAboutUs,textViewHValue;
    Button buttonAvgHl,buttonEnterSpot;
    ImageView imageViewlogout;

    String alertMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewAboutUs  = (TextView) findViewById(R.id.aboutUs_txt);
        textViewHValue = findViewById(R.id.avghumidityValue);
        imageViewlogout = findViewById(R.id.logout_img);


        buttonAvgHl = findViewById(R.id.btgenerate_avghl);
        buttonEnterSpot = findViewById(R.id.btEnter_spot);

        textViewAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
            }
        });

        imageViewlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        });

        buttonEnterSpot.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent  = new Intent(getApplicationContext(), EnterSpotActivity.class);
                startActivity(intent);

            }
        });

        buttonAvgHl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Random random = new Random();
                int number = random.nextInt(100) + 1;

                textViewHValue.setText(String.valueOf(number));
                int HlValue = Integer.parseInt(textViewHValue.getText().toString());
                int minHl = GlobalVariable.MinHl;
                int maxHl = GlobalVariable.MaxHl;

                if (HlValue < minHl || HlValue > maxHl) {
                    sendEmail();
                }
            }
        });

    }
    private void sendEmail() {
        alertMessage=GlobalVariable.AlertMessage;

        String mEmail = "dewmon007@gmail.com";

        String mSubject = "Alert Message From DewMon";
        String mMessage = alertMessage;

        JavaMailApi javaMailAPI = new JavaMailApi(this, mEmail, mSubject, mMessage);
        javaMailAPI.execute();
    }
}