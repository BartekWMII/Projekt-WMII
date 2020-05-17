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
    public static int gold = 1000000;
    public static int  army = 1000;
    public static int gold2=0;
    public static int army2=0;
    private  int goldC=0;
    private  int armyC=0;
    private int stal =50;
    private int miasto=1;
    private TextView textViewGold;
    private TextView textViewArmy;
    private AlertDialog.Builder dialogBuilder;
    private Button button;
    int counter=0;
    int bezpiecznik,licznik;
    int armia,kasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_after_menu);
        textViewGold = findViewById(R.id.textViewGold);

        button=findViewById(R.id.buttonCityUP);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToCityUpgrade();
            }
        });
        gold2=getIntent().getIntExtra("Gold666",gold);///gold przeniesiony z aftermenu activity
        army2=getIntent().getIntExtra("Armia666",army);

        bezpiecznik=getIntent().getIntExtra("Kod",licznik);
        if(bezpiecznik==1)
        {

            TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
            String countString2 = showCountTextView2.getText().toString();
            String countString = showCountTextView.getText().toString();
            Integer goldd = Integer.parseInt(countString);
            Integer armyy = Integer.parseInt(countString2);

            goldd = gold+gold2 ;
            armyy = army+army2 ;
            gold=0;
            army=0;
            gold=goldd;
            army=armyy;
            showCountTextView.setText(goldd.toString());
            showCountTextView2.setText(armyy.toString());
            Toast.makeText(activity_afterMenu.this,"Dziala"+goldd+armyy , Toast.LENGTH_LONG).show();
        }

       // Toast.makeText(activity_afterMenu.this,"Dziala"+gold+army , Toast.LENGTH_LONG).show();


    }
    public void moveToCityUpgrade()
    {

        TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
        TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
        String countString2 = showCountTextView2.getText().toString();
        String countString = showCountTextView.getText().toString();
        Integer goldd = Integer.parseInt(countString);
        Integer armyy = Integer.parseInt(countString2);

        goldd = gold ;
        armyy = army ;
        //gold=0;
       // army=0;
        Toast.makeText(activity_afterMenu.this,"Dzialaaaa"+gold+army , Toast.LENGTH_LONG).show();

        //showCountTextView.setText(goldd.toString());
       // showCountTextView2.setText(armyy.toString());

        Intent intent = new Intent(this,activity_city_upgrade.class);
        intent.putExtra("Gold",gold);
        intent.putExtra("Armia",army);
        startActivity(intent);
    }



    public void onClick(View view) {
        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewArmy);

        //get the value of the text view
        String countString = showCountTextView.getText().toString();

        //convert value to a number and ++
        Integer army = Integer.parseInt(countString);
        army = army - 100;

        //display the new value int the text view
        showCountTextView.setText(army.toString());
        ;
        // na koncu nie zapomnij dodac do activity main TEXT android:onClick="toastMe"
    }

    public void onClickSql(View view) {
        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewGold);

        //get the value of the text view
        String countString = showCountTextView.getText().toString();

        //convert value to a number and ++
        Integer gold = Integer.parseInt(countString);
        gold = gold - 100000;

        //display the new value int the text view
        showCountTextView.setText(gold.toString());
        ;
        // na koncu nie zapomnij dodac do activity main TEXT android:onClick="toastMe"
    }

    public void NextQuest(View view) {
        final Random random = new Random();
        String q = "Nowe Zadanie!";
        String qq = "WALKA ZE SMOKIEM";
        final ArrayList<String> aListQuest = new ArrayList<String>();

        aListQuest.add("Znaleziono ślady nieznanej postaci, podążać za nimi i sprawdzić co to ?");
        aListQuest.add("W pobliskiej jaskni udomowiła się pantera, zagraża naszym ludziom." +
                " Zabic ją ?");
        aListQuest.add("Nasz jasnowidz uważa, że nadchodzi potężna burza, zabezpieczyć nasze plony ?");

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(q);
        final String a = aListQuest.get(random.nextInt(aListQuest.size()));
        alertDialogBuilder.setMessage(a);

        //alertDialogBuilder.setIcon(R.drawable.question);
        // alertDialogBuilder.setMessage("Na pewno ?");
        //alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            int b = random.nextInt(10);

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if (b % 2 == 0) {
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

    //////
    public void BossQuest(View view) {
        final Random random = new Random();
        String qq = "WALKA ZE SMOKIEM";
        final ArrayList<String> BossQuest = new ArrayList<String>();
        BossQuest.add("Chcesz podjąć walke z Czerwonym smokiem ?");
        BossQuest.add("Chcesz podjąć walke z Zielonym smokiem ?");
        BossQuest.add("Chccesz podjąć ostateczną walkę z Białym Smokiem Albinosem ?");
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(qq);
        if(counter==0)
        {
            alertDialogBuilder.setMessage(BossQuest.get(0));
        }

        if(counter==1)
        {
            alertDialogBuilder.setMessage(BossQuest.get(1));
        }

        if(counter==2)
        {
            alertDialogBuilder.setMessage(BossQuest.get(2));
        }

        TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
        String countString = showCountTextView.getText().toString();
        Integer gold = Integer.parseInt(countString);
        showCountTextView.setText(gold.toString());

        if (gold >= 1000000 && counter==0)
        {

            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    TextView showCountTextView =
                            (TextView) findViewById(R.id.textViewGold);
                    String countString = showCountTextView.getText().toString();
                    Integer gold = Integer.parseInt(countString);
                    gold = gold + 200000;
                    showCountTextView.setText(gold.toString());

                    alertDialogBuilder2.setTitle("Zadanie Wykonane");
                    alertDialogBuilder2.setMessage("Pokonałeś Czerwonego Smoka !");
                    alertDialogBuilder2.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                           // Toast.makeText(activity_afterMenu.this, "You clicked over no", Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog alertDialog2 = alertDialogBuilder2.create();
                    alertDialog2.show();

                   // Toast.makeText(activity_afterMenu.this, "Pokonałeś Czerwonego Smoka !!!", Toast.LENGTH_LONG).show();
                    counter++;
                }

            });
            alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        else if(gold >=2000000 && counter==1)
        {
            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    TextView showCountTextView =
                            (TextView) findViewById(R.id.textViewGold);
                    String countString = showCountTextView.getText().toString();
                    Integer gold = Integer.parseInt(countString);
                    gold = gold + 200000;
                    showCountTextView.setText(gold.toString());

                    alertDialogBuilder2.setTitle("Zadanie Wykonane");
                    alertDialogBuilder2.setMessage("Pokonałeś Zielonego Smoka !");
                    alertDialogBuilder2.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            // Toast.makeText(activity_afterMenu.this, "You clicked over no", Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog alertDialog2 = alertDialogBuilder2.create();
                    alertDialog2.show();
                    counter++;
                    //Toast.makeText(activity_afterMenu.this, "Pokonałeś Zielonego Smoka !!!", Toast.LENGTH_LONG).show();
                }

            });
            alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        else if(gold >=3000000 && counter==2)
        {
            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    TextView showCountTextView =
                            (TextView) findViewById(R.id.textViewGold);
                    String countString = showCountTextView.getText().toString();
                    Integer gold = Integer.parseInt(countString);
                    gold = gold + 200000;
                    showCountTextView.setText(gold.toString());

                    alertDialogBuilder2.setTitle("Zadanie Wykonane");
                    alertDialogBuilder2.setMessage("Pokonałeś Białego Smoka !");
                    alertDialogBuilder2.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {

                        }
                    });
                    AlertDialog alertDialog2 = alertDialogBuilder2.create();
                    alertDialog2.show();

                   // Toast.makeText(activity_afterMenu.this, "Pokonałeś Bialego Smoka !!!", Toast.LENGTH_LONG).show();
                }

            });
            alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
        else
            {

            alertDialogBuilder2.setTitle("Uwaga");
            alertDialogBuilder2.setMessage("Nie spełniasz wymagań do walki ze smokiem");

                alertDialogBuilder2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Toast.makeText(activity_afterMenu.this, "You clicked over no", Toast.LENGTH_LONG).show();
                    }
                });
            AlertDialog alertDialog2 = alertDialogBuilder2.create();
            alertDialog2.show();
        }

    }
}









