package com.example.helikoptery;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NavUtils;
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
   // Intent intent = new Intent(this,activity_afterMenu.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret);
        button = (Button)findViewById(R.id.GodButton);
        mText = (TextView) findViewById(R.id.textViewGold);

        gold=getIntent().getIntExtra("Gold2",gold);///gold przeniesiony z aftermenu activity
        army=getIntent().getIntExtra("Armia2",army);

       // Intent intent = new Intent(this,activity_afterMenu.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEdit= (EditText)findViewById(R.id.passInput);

                if(pattern.equals(mEdit.getText().toString()))
                {


                    gold=gold+1000000;
                    army=army+1000;
                    licznik++;
                    Toast.makeText(secret.this,"Wezwano Boga" , Toast.LENGTH_LONG).show();

                    //get the value of the text view


                    //convert value to a number and ++



                    //display the new value int the text view



                    //display the new value int the text view
                   // showCountTextView.setText(gold.toString());
                }



            }

        });




    }
    public void onBackPressed()
    {

        new AlertDialog.Builder(this)
                .setTitle("Na pewno chcesz wyjść ?")
                .setMessage("Czy to twoja definitywyna odpowiedź ?")
                .setNegativeButton(android.R.string.no,null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(),activity_afterMenu.class);
                        intent.putExtra("Gold666",gold);
                        intent.putExtra("Armia666",army);
                        intent.putExtra("Kod",licznik);
                        Toast.makeText(secret.this,"Dziala SECKRET"+gold+"oraz"+army , Toast.LENGTH_LONG).show();
                        startActivity(intent);
                        secret.super.onBackPressed();



                    }

                }).create().show();
    }


    }

