package com.example.helikoptery;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class activity_afterMenu extends AppCompatActivity {


    final int DELAYED_TIME = 140;
    Context context = this;
    private int gold=100000;
    private int army=1000;
    private TextView textViewGold;
    private TextView textViewArmy;
    private AlertDialog.Builder dialogBuilder;

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
                (TextView) findViewById(R.id.textViewArmy);

        //get the value of the text view
        String countString = showCountTextView.getText().toString();

        //convert value to a number and ++
        Integer army = Integer.parseInt(countString);
        army=army+100;

        //display the new value int the text view
        showCountTextView.setText(army.toString());;
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

    public void NextQuest(View view) {
        final Random random = new Random();
        ArrayList<String> aListQuest = new ArrayList<String>();
        aListQuest.add("Znaleziono ślady nieznanej postaci, podążać za nimi i sprawdzić co to ?");
        aListQuest.add("W pobliskiej jaskni udomowiła się panetera, zagraża naszym ludziom." +
                " Zabic ją ?");
        ///tutaj możesz wstawic jakies swoje questy
        aListQuest.add("Nasz jasnowidz uważa, że nadchodzi potężna burza, zabezpieczyć nasze plony ?");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(aListQuest.get(random.nextInt(aListQuest.size())));
        //alertDialogBuilder.setIcon(R.drawable.question);
        // alertDialogBuilder.setMessage("Na pewno ?");
        //alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int a = random.nextInt(10);
                if (a % 2 == 0) {
                    TextView showCountTextView =
                            (TextView) findViewById(R.id.textViewGold);
                    String countString = showCountTextView.getText().toString();
                    Integer gold = Integer.parseInt(countString);
                    gold = gold + 200000;
                    showCountTextView.setText(gold.toString());
                    Toast.makeText(activity_afterMenu.this, "Znaleziono pradawny artefakt !!!", Toast.LENGTH_LONG).show();
                } else {
                    TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
                    TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
                    String countString2 = showCountTextView2.getText().toString();
                    String countString = showCountTextView.getText().toString();
                    Integer gold = Integer.parseInt(countString);
                    Integer army = Integer.parseInt(countString2);
                    gold = gold - 50000;
                    army = army - 100;
                    showCountTextView.setText(gold.toString());
                    showCountTextView2.setText(army.toString());

                    Toast.makeText(activity_afterMenu.this, "Porażka !!!", Toast.LENGTH_LONG).show();
                }
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(activity_afterMenu.this, "You clicked over no", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }



}