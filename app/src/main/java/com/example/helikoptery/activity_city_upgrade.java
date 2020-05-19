package com.example.helikoptery;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activity_city_upgrade extends AppCompatActivity {

    public static int miastoa;
    public static int miastoimpa;
    public static int miastob;
    public static int miastoimpb;
    public static int miastoc;
    public static int miastoimpc;
    public static int stal=50;
    public static int stalimp;
    private Button button,button2,button3;
    public static int gold,gold6;
    public static int army6,army;
    public static int kontrol=0;
    public static int licznikQ=0;

    Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_upgrade);

        button=findViewById(R.id.SecretButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToSecret();
            }
        });
        button2=findViewById(R.id.KingBack);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToKing();
            }
        });

        button3=findViewById(R.id.SettingsButton);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToSettings();
            }
        });

        TextView showCountTextView = (TextView) findViewById(R.id.textViewSkarb);
        String countString = showCountTextView.getText().toString();
        Integer miastoSa = Integer.parseInt(countString);
        stalimp=getIntent().getIntExtra("Stal",stal);
        miastoimpa=getIntent().getIntExtra("skarb",miastoa);
        miastoimpb=getIntent().getIntExtra("kosz",miastob);
        miastoimpc=getIntent().getIntExtra("kop",miastoc);
        gold6=getIntent().getIntExtra("Gold",gold);///gold przeniesiony z aftermenu activity
        army6=getIntent().getIntExtra("Armia",army);///armia przeniesiona z aftermenu activity
        miastoSa=miastoa;
        showCountTextView.setText(miastoSa.toString());


    }


    private void moveToSecret()
    {
        Intent intent = new Intent(this,secret.class);
        intent.putExtra("Gold2",gold6);
        intent.putExtra("Armia2",army6);
        startActivity(intent);
    }

    private void moveToSettings()
    {
        Intent intent = new Intent(this,activity_settings.class);
        startActivity(intent);
    }

    public void onBackPressed()
    {
        //Intent intent = new Intent(getApplicationContext(),activity_menu.class);
        // startActivity(intent);
        //activity_afterMenu.super.onBackPressed();
        //super.onBackPressed();
    }

    private void moveToKing()
    {
     //   licznikQ++;
        Intent intent = new Intent(this,activity_afterMenu.class);
        intent.putExtra("skarb",miastoa);
        intent.putExtra("kosz",miastob);
      //  intent.putExtra("kop",miastoc);
        startActivity(intent);
    }

    public void miastoClick(View view) {

        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewSkarb);

        miastoa=miastoa+miastoimpa;
        stal=stal+stalimp;
        int sprM=miastoa;
        if ((sprM+1)*10>stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*miastoa)-5;
            miastoa=miastoa+1;
            String miastostringa=Integer.toString(miastoa);
            showCountTextView.setText(miastostringa);
        }
    }

    public void GarnUp(View view) {


        miastob=miastob+miastoimpb;
        stal=stal+stalimp;
        int sprM=miastob;
        if ((sprM+1)*10>stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*miastob)-5;
            miastob=miastob+1;
            String miastostringb=Integer.toString(miastob);

        }
    }

    public void KopUp(View view) {
        miastoc=miastoc+miastoimpc;
        stal=stal+stalimp;
        int sprM=miastoc;
        if ((sprM+1)*10>stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*miastoc)-5;
            miastoc=miastoc+1;
            String miastostringc=Integer.toString(miastoc);
        }
    }
}