package com.example.helikoptery;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class activity_city_upgrade extends AppCompatActivity {

    private TextView textViewSkarb;
    private TextView textViewKosz;
    private TextView textViewKop;
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
    public static int KwiatMiasta=0;
    public static int DrzewoMiasta=0;
    public static int kontrol=0;
    public static int licznikQ=0;
    boolean SprCityA=false, SprCityAImp=false, SprCityBImp=false, SprCityB=false, SprCityCImp=false, SprCityC=false, SprArmyImp=false, SprArmy=false, SprGold=false, SprGoldImp=false;
    boolean SprStal=false, SprStalImp=false;
    public static int bezpiecznik,licznik,kontrolka,counterQ,CityA,CityB,CityC;
    public static String UpCityA, UpCityB, UpCityC;

    Context context = this;

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("daneA", textViewSkarb.getText().toString());
        editor.putString("daneB", textViewKosz.getText().toString());
        editor.putString("daneC", textViewKop.getText().toString());
        editor.putInt("kwiat3", KwiatMiasta);
        KwiatMiasta++;
        Toast.makeText(activity_city_upgrade.this, "DzialaP " + UpCityA + " " + UpCityB+" "+" "+ UpCityC+" "+KwiatMiasta, Toast.LENGTH_LONG).show();
        editor.commit();
    }


    @Override
    protected void onResume () {
        super.onResume();
        // Toast.makeText(activity_afterMenu.this, kwiat, Toast.LENGTH_LONG).show();

        if(KwiatMiasta>0)
        {
            super.onResume();
            SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
            DrzewoMiasta = sharedPref.getInt("kwiat3", 1);
            UpCityA = sharedPref.getString("daneA", ""); // Tekst zapisujemy do zmiennej globalnej i w metodzie OnCreate() przypisujemy do odpowiedniej kontrolki EditText: editText.setText(txt);
            UpCityB = sharedPref.getString("daneB", ""); // Tekst zapisujemy do zmiennej globalnej i w metodzie OnCreate() przypisujemy do odpowiedniej kontrolki EditText: editText.setText(txt);
            UpCityC = sharedPref.getString("daneC", "");
            KwiatMiasta = DrzewoMiasta;
            Toast.makeText(activity_city_upgrade.this, "Dziala " + UpCityA + " " + UpCityB + " " + " " + UpCityC + " " + DrzewoMiasta, Toast.LENGTH_LONG).show();
            TextView showCountTextView = (TextView) findViewById(R.id.textViewSkarb);
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewKoszar);
            TextView showCountTextView3 = (TextView) findViewById(R.id.textViewKop);
            showCountTextView.setText(String.valueOf(miastoa));
            showCountTextView2.setText(String.valueOf(miastob));
            showCountTextView3.setText(String.valueOf(miastoc));
            try{
                miastoa = Integer.parseInt(UpCityA);
                miastob = Integer.parseInt(UpCityB);
                miastoc = Integer.parseInt(UpCityC);
            } catch (NumberFormatException e) {
               // e.printStackTrace();
            }

            KwiatMiasta++;
        }


        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_upgrade);

        KwiatMiasta++;
        //textViewSkarb = findViewById(R.id.textViewSkarb);
       //textViewKosz = findViewById(R.id.textViewKoszar);
        //textViewKop= findViewById(R.id.textViewKop);

        setContentView(R.layout.activity_city_upgrade);
        bezpiecznik = getIntent().getIntExtra("Kod", licznik);
        kontrolka = getIntent().getIntExtra("kontrola", counterQ);

        button=findViewById(R.id.SecretButton);
        button2=findViewById(R.id.KingBack);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToSecret();
            }
        });

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
        TextView showStal=(TextView) findViewById(R.id.textViewIleStal);
        String countString = showCountTextView.getText().toString();
        String countStringb = showCountTextViewKosz.getText().toString();
        String countStringc = showCountTextViewKop.getText().toString();
        String countStal =  showStal.getText().toString();
        Integer miastoSa = Integer.parseInt(countString);
        Integer miastoSb = Integer.parseInt(countStringb);
        Integer miastoSc = Integer.parseInt(countStringc);
        Integer stalinium = Integer.parseInt(countStal);
        stalimp=getIntent().getIntExtra("Stal",stal);
        miastoimpa=getIntent().getIntExtra("skarb",miastoa);
        miastoimpb=getIntent().getIntExtra("kosz",miastob);
        miastoimpc=getIntent().getIntExtra("kop",miastoc);
        goldCity=getIntent().getIntExtra("Gold",goldKing);///gold przeniesiony z aftermenu activity
        armyCity=getIntent().getIntExtra("Armia",armyKing);///armia przeniesiona z aftermenu activity
        miastoSa=miastoa;
        miastoSb=miastob;
        miastoSc=miastoc;
        stalinium=stal;
        showCountTextView.setText(miastoSa.toString());
        showCountTextViewKosz.setText(miastoSb.toString());
        showCountTextViewKop.setText(miastoSc.toString());
        showStal.setText(stalinium.toString());
        textViewSkarb=findViewById(R.id.textViewSkarb);
        textViewKosz=findViewById(R.id.textViewKoszar);
        textViewKop=findViewById(R.id.textViewKop);
        KwiatMiasta++;

        if(stal!=stalimp) {
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewIleStal);
            stal = stalimp;
            String Bim = Integer.toString(stal);
            showCountTextView2.setText(Bim);
        }
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
        TextView showCountTextView2 =
                (TextView) findViewById(R.id.textViewIleStal);

        miastoa=miastoa;
        if (SprStalImp!=SprStal)
        {
            stal = stal + stalimp;
            String Bim=Integer.toString(stal);
            showCountTextView2.setText(Bim);
        }
        int sprM=miastoa;
        if ((sprM+1)*10>stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*miastoa)-5;
            miastoa++;
            String miastostringa=Integer.toString(miastoa);
            showCountTextView.setText(miastostringa);
            SprCityA=true;
            String Bim=Integer.toString(stal);
            showCountTextView2.setText(Bim);
        }
    }

    public void GarnUp(View view) {

        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewKoszar);
        TextView showCountTextView2 =
                (TextView) findViewById(R.id.textViewIleStal);

        miastob=miastob;
        if (SprStalImp!=SprStal)
        {
            stal = stal + stalimp;
            String Bim=Integer.toString(stal);
            showCountTextView2.setText(Bim);
        }
        int sprM=miastob;
        if ((sprM+1)*10>stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*miastob)-5;
            miastob++;
            SprCityB=true;
            String miastostringb=Integer.toString(miastob);
            showCountTextView.setText(miastostringb);
            String Bim=Integer.toString(stal);
            showCountTextView2.setText(Bim);

        }
    }

    public void KopUp(View view) {

        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewKop);
        TextView showCountTextView2 =
                (TextView) findViewById(R.id.textViewIleStal);

        miastoc=miastoc;
        if (SprStalImp!=SprStal)
        {
            stal = stal + stalimp;
            String Bim=Integer.toString(stal);
            showCountTextView2.setText(Bim);
        }
        int sprM=miastoc;
        if ((sprM+1)*10>stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*miastoc)-5;
            miastoc++;
            SprCityB=true;
            String miastostringc=Integer.toString(miastoc);
            showCountTextView.setText(miastostringc);
            String Bim=Integer.toString(stal);
            showCountTextView2.setText(Bim);
        }
    }
}