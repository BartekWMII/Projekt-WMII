package com.example.swords;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class zabojcalayou extends AppCompatActivity {
    Context context = this;

    private boolean czyPause;
    private int sila=50;
    private int inteligencja=50;
    private int wytrzymalosc=100;
    private int kwiatRab;
    private int drzewoRab;
    public static String wytrz, sil, intel;
    private TextView textViewSil;
    private TextView textViewInte;
    private TextView textViewWytrz;

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("daneS", textViewSil.getText().toString());
        editor.putString("daneI", textViewInte.getText().toString());
        editor.putString("daneW", textViewWytrz.getText().toString());
        editor.putInt("kwiatRab", kwiatRab);
        kwiatRab++;
        Toast.makeText(zabojcalayou.this, "DzialaP " +   " " + " "+kwiatRab, Toast.LENGTH_LONG).show();
        editor.commit();
    }


    @Override
    protected void onResume () {
        super.onResume();
        // Toast.makeText(activity_afterMenu.this, kwiat, Toast.LENGTH_LONG).show();

        if(kwiatRab>1)
        {
            super.onResume();
            SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
            drzewoRab=sharedPref.getInt("kwiatRab",1 );
            sil = sharedPref.getString("daneS", ""); // Tekst zapisujemy do zmiennej globalnej i w metodzie OnCreate() przypisujemy do odpowiedniej kontrolki EditText: editText.setText(txt);
            intel = sharedPref.getString("daneI", ""); // Tekst zapisujemy do zmiennej globalnej i w metodzie OnCreate() przypisujemy do odpowiedniej kontrolki EditText: editText.setText(txt);
            wytrz = sharedPref.getString("daneW", "");
            kwiatRab=drzewoRab;
            Toast.makeText(zabojcalayou.this, "Dziala " + sil + " " + intel+" "+wytrz, Toast.LENGTH_LONG).show();
            TextView showCountTextView = (TextView) findViewById(R.id.textViewSila);
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewInte);
            TextView showCountTextView3 = (TextView) findViewById(R.id.textViewWytrz);
            showCountTextView.setText(sil);
            showCountTextView2.setText(intel);
            showCountTextView3.setText(wytrz);
            try{
                sila = Integer.parseInt(sil);
                inteligencja = Integer.parseInt(intel);
                wytrzymalosc = Integer.parseInt(wytrz);
            } catch (Exception e) {
                // e.printStackTrace();
            }

            kwiatRab++;

            /*bezpiecznik = getIntent().getIntExtra("Kod", licznik);
            kontrolka = getIntent().getIntExtra("kontrola", counterQ);
            */

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.layout);
        czyPause = false;
    }
}
