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

    public static int miasto;
    public static int miastoimp;
    public static int stal;
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
        stalimp=getIntent().getIntExtra("Stal",stal);
        miastoimp=getIntent().getIntExtra("Miasto",miasto);
        gold6=getIntent().getIntExtra("Gold",gold);///gold przeniesiony z aftermenu activity
        army6=getIntent().getIntExtra("Armia",army);///armia przeniesiona z aftermenu activity


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
      //  intent.putExtra("Gold2",gold6);
      //  intent.putExtra("Armia2",army6);
      //  intent.putExtra
        startActivity(intent);
    }

    public void miastoClick(View view) {

        int sprM=miastoimp;
        if ((sprM+1)*10>stalimp)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*miasto);
            miasto=miasto+1;
        }
    }
}