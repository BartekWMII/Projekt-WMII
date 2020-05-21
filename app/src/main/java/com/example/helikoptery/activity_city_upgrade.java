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
    public static int goldKing,goldCity;
    public static int armyCity,armyKing;
    public static int kontrol=0;
    public static int licznikQ=0;
    boolean SprCityA=false, SprCityAImp=false, SprCityBImp=false, SprCityB=false, SprCityCImp=false, SprCityC=false, SprArmyImp=false, SprArmy=false, SprGold=false, SprGoldImp=false;
    boolean SprStal=false, SprStalImp=false;

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
        TextView showCountTextViewKosz=(TextView) findViewById(R.id.textViewKoszar);
        TextView showCountTextViewKop=(TextView) findViewById(R.id.textViewKop);
        String countString = showCountTextView.getText().toString();
        String countStringb = showCountTextView.getText().toString();
        String countStringc = showCountTextView.getText().toString();
        Integer miastoSa = Integer.parseInt(countString);
        Integer miastoSb = Integer.parseInt(countStringb);
        Integer miastoSc = Integer.parseInt(countStringc);
        stalimp=getIntent().getIntExtra("Stal",stal);
        miastoimpa=getIntent().getIntExtra("skarb",miastoa);
        miastoimpb=getIntent().getIntExtra("kosz",miastob);
        miastoimpc=getIntent().getIntExtra("kop",miastoc);
        goldCity=getIntent().getIntExtra("Gold",goldKing);///gold przeniesiony z aftermenu activity
        armyCity=getIntent().getIntExtra("Armia",armyKing);///armia przeniesiona z aftermenu activity
        miastoSa=miastoa;
        miastoSb=miastob;
        miastoSc=miastoc;
        showCountTextView.setText(miastoSa.toString());
        showCountTextViewKosz.setText(miastoSb.toString());
        showCountTextViewKop.setText(miastoSc.toString());

    }


    private void moveToSecret()
    {
        Intent intent = new Intent(this,secret.class);
        intent.putExtra("Gold2",goldCity);
        intent.putExtra("Armia2",armyCity);
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
        intent.putExtra("armia",armyCity);
        intent.putExtra("gold",goldCity);
        intent.putExtra("CityAZ", SprCityA);
        intent.putExtra("CityBZ", SprCityB);
        intent.putExtra("CityCZ",SprCityC);
        intent.putExtra("kop",miastoc);
        intent.putExtra("ArmyZ",SprArmy);
        intent.putExtra("GoldZ",SprGold);
        intent.putExtra("StalZ",SprStal);
        startActivity(intent);
    }

    public void miastoClick(View view) {

        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewSkarb);

        miastoa=miastoa+miastoimpa;
        if (SprStalImp!=SprStal)
        {
            stal = stal + stalimp;
        }
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
            SprCityA=true;
        }
    }

    public void GarnUp(View view) {

        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewKoszar);

        miastob=miastob+miastoimpb;
        if (SprStalImp!=SprStal)
        {
            stal = stal + stalimp;
        }
        int sprM=miastob;
        if ((sprM+1)*10>stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*miastob)-5;
            miastob=miastob+1;
            SprCityB=true;
            String miastostringb=Integer.toString(miastob);
            showCountTextView.setText(miastostringb);

        }
    }

    public void KopUp(View view) {

        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewKop);

        miastoc=miastoc+miastoimpc;
        if (SprStalImp!=SprStal)
        {
            stal = stal + stalimp;
        }
        int sprM=miastoc;
        if ((sprM+1)*10>stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*miastoc)-5;
            miastoc=miastoc+1;
            SprCityB=true;
            String miastostringc=Integer.toString(miastoc);
            showCountTextView.setText(miastostringc);
        }
    }
}