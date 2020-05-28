package com.example.swords;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class secret extends AppCompatActivity {

    Button button;
    EditText mEdit;
    TextView mText;
    String pattern = "DR WOJCZYK";
    public static int gold;
    public static int army;
    public static int licznik=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret);
        button = (Button)findViewById(R.id.GodButton);
        mText = (TextView) findViewById(R.id.textViewGold);
        licznik=0;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEdit= (EditText)findViewById(R.id.passInput);

                if(pattern.equals(mEdit.getText().toString()))
                {
                    gold=10000000;
                    army=5000;
                    licznik++;
                    Toast.makeText(secret.this,"Wezwano Boga...." , Toast.LENGTH_SHORT).show();
                    Toast.makeText(secret.this,"Bog obdarzyl cie zlotem oraz armią" , Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
    public void onBackPressed()
    {
        if(licznik==1) {
           // new AlertDialog.Builder(this)
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Czy to twoja definitywna odpowiedź");
            alertDialogBuilder.setTitle("Czy na pewno chcesz wyjść");
            alertDialogBuilder.setNegativeButton("No", null);
                    alertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), activity_afterMenu.class);
                            intent.putExtra("Gold666", gold);
                            intent.putExtra("Armia666", army);
                            intent.putExtra("Kod", licznik);
                            startActivity(intent);
                            secret.super.onBackPressed();
                        }

                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

            alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.frame);
            TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
            TextView textView1 = (TextView) alertDialog.findViewById((R.id.alertTitle));
            Typeface face= ResourcesCompat.getFont(this,R.font.magic);
            textView.setTextSize(17);
            textView1.setTextSize(25);
            textView.setTypeface(face);
            textView1.setTypeface(face);

            alertDialog.getWindow().setLayout(600,350);///przed dodaniem na telefon zmienic na 600/400

        }
        else
        {
            secret.super.onBackPressed();
        }

    }


}

