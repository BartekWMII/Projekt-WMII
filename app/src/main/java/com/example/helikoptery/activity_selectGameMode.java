package com.example.helikoptery;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_selectGameMode extends AppCompatActivity {

    AnimationDrawable animBluetooth;
    AnimationDrawable animWiFi;
    ImageButton imageButtonBluetooth;
    ImageButton imageButtonWifi;
    final int DELAYED_TIME = 140;
    Context context = this;
    private int gold=100000;
    private int army;
    private TextView textViewGold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_after_menu);
        textViewGold=findViewById(R.id.textViewGold);



    }


    public void onClick(View view)
    {
        TextView showCountTextView=
                (TextView) findViewById(R.id.textViewGold);

        //get the value of the text view
        String countString = showCountTextView.getText().toString();

        //convert value to a number and ++
        Integer gold = Integer.parseInt(countString);
        gold=gold+200;

        //display the new value int the text view
        showCountTextView.setText(gold.toString());;
        // na koncu nie zapomnij dodac do activity main TEXT android:onClick="toastMe"
    }

    public void onClickSql(View view)
    {
        TextView showCountTextView=
                (TextView) findViewById(R.id.textViewGold);

        //get the value of the text view
        String countString = showCountTextView.getText().toString();

        //convert value to a number and ++
        Integer gold = Integer.parseInt(countString);
        gold=gold-10000;

        //display the new value int the text view
        showCountTextView.setText(gold.toString());;
        // na koncu nie zapomnij dodac do activity main TEXT android:onClick="toastMe"
    }



}
