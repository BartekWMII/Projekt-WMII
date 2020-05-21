package com.example.helikoptery;


import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.PowerManager;
import android.support.annotation.AnimatorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
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
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class activity_afterMenu extends AppCompatActivity {

    final int DELAYED_TIME = 140;
    Context context = this;
    public static int gold = 2000000;
    public static int army = 5000;
    public static int goldSekret=0;
    public static int armySekret=0;
    public static int stal =0;
    public static int stalimp=0;
    public static int miastoa=0;
    public static int miastoimpa=0;
    public static int miastob=0;
    public static int miastoimpb=0;
    public static int miastoc=0;
    public static int miastoimpc=0;
    public static String txt,gld;
    boolean SprCityA=false, SprCityAImp=false, SprCityBImp=false, SprCityB=false, SprCityCImp=false, SprCityC=false, SprArmyImp=false, SprArmy=false, SprGold=false, SprGoldImp=false;
    boolean SprStal=false, SprStalImp=false;
    ///Spr -> stała zmienna dla AfterMenu, która ma się zmieniać TYLKO WTEDY GDY Spr*-*Imp ma inną wartość. W zamyśle. Spr!=SprImp dodajemy importowane wartości do obecnie istniejących
    ///a następnie zmieniamy wartości dla Spr na SprImp. SprImp zostaje w swoim stanie, zmienia się w momencie zmiany któregoś z intów.
    ///Każdy int ma 2 dedykowane wartości Boolowskie

    public static int licznikPodatki=1;

    private TextView textViewGold;
    private TextView textViewArmy;
    private AlertDialog.Builder dialogBuilder;
    private Button button;
    int counterDragon=0;
    public static int bezpiecznik,licznik,kontrolka,counterQ,goldCity,armyCity;

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("daneG", textViewGold.getText().toString());
        editor.putString("dane", textViewArmy.getText().toString());

        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        txt = sharedPref.getString("dane", ""); // Tekst zapisujemy do zmiennej globalnej i w metodzie OnCreate() przypisujemy do odpowiedniej kontrolki EditText: editText.setText(txt);
        gld = sharedPref.getString("daneG", ""); // Tekst zapisujemy do zmiennej globalnej i w metodzie OnCreate() przypisujemy do odpowiedniej kontrolki EditText: editText.setText(txt);
        Toast.makeText(activity_afterMenu.this,"Dziala "+gld+" "+txt , Toast.LENGTH_LONG).show();

       TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
        TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
        showCountTextView.setText(gld);
        showCountTextView2.setText(txt);
        army = Integer.parseInt(txt);
        gold=Integer.parseInt(gld);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_after_menu);
        textViewGold = findViewById(R.id.textViewGold);
        textViewArmy = findViewById(R.id.textViewArmy);



        button=findViewById(R.id.buttonCityUP);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToCityUpgrade();
            }
        });


        bezpiecznik=getIntent().getIntExtra("Kod",licznik);
        kontrolka=getIntent().getIntExtra("kontrola", counterQ);



        /*if(bezpiecznik==1)
        {

            goldSekret=getIntent().getIntExtra("Gold666",gold);
            armySekret=getIntent().getIntExtra("Armia666",army);

            miastoimpa=getIntent().getIntExtra("skarb",miastoa);
            miastoimpb=getIntent().getIntExtra("kosz",miastob);
            miastoimpc=getIntent().getIntExtra("kop",miastoc);

            TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
            String countString = showCountTextView.getText().toString();
            Integer goldd = Integer.parseInt(countString);
            Integer armyy = Integer.parseInt(countString2);

            gold=gold+goldSekret;
            army=army+armySekret;

            miastoa=miastoa+miastoimpa;
            miastob=miastob+miastoimpb;
            miastoc=miastoc+miastoimpc;
            goldd = gold;
            armyy = army;
            showCountTextView.setText(goldd.toString());
            showCountTextView2.setText(armyy.toString());
            //Toast.makeText(activity_afterMenu.this,"Dziala"+goldd+armyy , Toast.LENGTH_LONG).show();
            bezpiecznik=0;
        }*/

        SprArmyImp=getIntent().getBooleanExtra("ArmiaZ", SprArmy);
        SprGoldImp=getIntent().getBooleanExtra("GoldZ", SprGold);
        SprCityAImp=getIntent().getBooleanExtra("CityAZ", SprCityA);
        SprCityBImp=getIntent().getBooleanExtra("CityBZ", SprCityB);
        SprCityCImp=getIntent().getBooleanExtra("CityCZ", SprCityC);
        SprStalImp=getIntent().getBooleanExtra("StalZ", SprStal);

        if (SprGold==SprGoldImp)
        {
            goldSekret=getIntent().getIntExtra("gold666",army);
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewGold);
            String countString2 = showCountTextView2.getText().toString();
            Integer armyy = Integer.parseInt(countString2);
        }

        if(SprArmy==SprArmyImp)
        {
            armySekret=getIntent().getIntExtra("Armia666",army);
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
            String countString2 = showCountTextView2.getText().toString();
            Integer goldd = Integer.parseInt(countString2);

        }

        if(SprCityA!=SprCityAImp)
        {
            miastoimpa=getIntent().getIntExtra("skarb",miastoa);
            miastoa=miastoimpa;
        }

        if(SprCityB!=SprCityBImp)
        {
            miastoimpb=getIntent().getIntExtra("kosz",miastob);
            miastob=miastoimpb;
        }

        if(SprCityC!=SprCityCImp)
        {
            miastoimpc=getIntent().getIntExtra("kop",miastoc);
            miastoc=miastoimpc;
        }

        if(SprStal!=SprStalImp)
        {
            stalimp=getIntent().getIntExtra("Stal",stal);
            stal=stalimp;
        }

        /*  if(kontrolka==2)
        {
            gold=getIntent().getIntExtra("goldSekret",goldCity);
            army=getIntent().getIntExtra("Armia2",armyCity);

            TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
            String countString2 = showCountTextView2.getText().toString();
            String countString = showCountTextView.getText().toString();
            Integer goldd = Integer.parseInt(countString);
            Integer armyy = Integer.parseInt(countString2);
            goldd = gold;
            armyy = army;
            showCountTextView.setText(goldd.toString());
            showCountTextView2.setText(armyy.toString());
            //Toast.makeText(activity_afterMenu.this,"Dziala"+goldd+armyy , Toast.LENGTH_LONG).show();
            kontrolka=1;
        }*/

        // Toast.makeText(activity_afterMenu.this,"Dziala"+gold+army , Toast.LENGTH_LONG).show();
    }

    public void onBackPressed()
    {
        //Intent intent = new Intent(getApplicationContext(),activity_menu.class);
       // startActivity(intent);
        //activity_afterMenu.super.onBackPressed();
        //super.onBackPressed();
    }


    public void moveToCityUpgrade()
    {
        Intent intent = new Intent(this,activity_city_upgrade.class);
        intent.putExtra("Gold",gold);
        intent.putExtra("Armia",army);
        intent.putExtra("Stal",stal);
        intent.putExtra("skarb",miastoa);
        intent.putExtra("kosz",miastob);
        intent.putExtra("kop",miastoc);
        startActivity(intent);
    }

    public void onClick(View view) {
        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewArmy);
        TextView showCountTextView2 =
                (TextView) findViewById(R.id.textViewGold);

        //get the value of the text view
        String countString = showCountTextView.getText().toString();
        String countString2 = showCountTextView2.getText().toString();
        //convert value to a number and ++
        Integer armyy = Integer.parseInt(countString);
        Integer goldd=Integer.parseInt(countString2);
        if (armyy>0) {
            army = army + 100;
            gold = gold - 100000;
            armyy=army;
            goldd = gold;
            //display the new value int the text view
            showCountTextView.setText(armyy.toString());
            showCountTextView2.setText(goldd.toString());
        }
        else
        {
            Toast.makeText(context, "Nie masz wojowników!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickSql(View view) {
        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewGold);
        //get the value of the text view
        String countString = showCountTextView.getText().toString();
        //convert value to a number and ++
        Integer goldd = Integer.parseInt(countString);
        goldd = goldd - 100000 + (100*miastoa);
        gold=goldd;
        //display the new value int the text view
        showCountTextView.setText(goldd.toString());
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
        aListQuest.add("Z pobliskiej wioski zniknęła ludność, rozpocząć poszukiwania ?");
        aListQuest.add("W pobliżu pewna grupa rozbójników rabuje mieszkańców, zaatakować ich ?");
        aListQuest.add("W jednej z naszej wiosek panuje wirus, znaleźć jego źródło ?");
        aListQuest.add("Nasza dostawa żywności oraz uzbrojenia nie dotarła do punktu"+
                "docelowego. Wysłać zwiad ?");
        aListQuest.add("Zwiad donosi że w okolicy grasuje ogromny niedźwiedź."+
                "Wysłać zwiad na polowanie ?");
        aListQuest.add("Na królewski rynek wdarło się stado dzików! Zabić je?");
        aListQuest.add("Kryzys w królestwie! Rabusie okradają miejscowych!"+ "Wysłać patrol na rynek?");

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final String a = aListQuest.get(random.nextInt(aListQuest.size()));
        alertDialogBuilder.setMessage(a);
        alertDialogBuilder.setTitle(q);

        //alertDialogBuilder.setIcon(R.drawable.question);
        // alertDialogBuilder.setMessage("Na pewno ?");
        //alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            int b = random.nextInt(100);

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                licznikPodatki++;
                if (b >50) {
                    TextView showCountTextView =
                            (TextView) findViewById(R.id.textViewGold);
                    String countString = showCountTextView.getText().toString();
                    Integer goldd = Integer.parseInt(countString);
                    gold = gold + 250000 + (20)*miastoa;

                    if (b%5==0)
                    {
                        Integer stall = stal;
                        stal=stal+2+(10*miastoc);
                        stall=stal;
                    }

                    goldd=gold;
                    showCountTextView.setText(goldd.toString());
                    Toast.makeText(activity_afterMenu.this, "Misja zakonczona powodzeniem !!!", Toast.LENGTH_LONG).show();


                } else {
                    TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
                    TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
                    String countString2 = showCountTextView2.getText().toString();
                    String countString = showCountTextView.getText().toString();
                    Integer goldd = Integer.parseInt(countString);
                    Integer armyy = Integer.parseInt(countString2);
                    gold = gold - 50000 + (5)*miastoa;
                    army = army - 100 +(1)*miastob;
                    goldd=gold;
                    armyy=army;
                    showCountTextView.setText(goldd.toString());
                    showCountTextView2.setText(armyy.toString());
                    Toast.makeText(activity_afterMenu.this, "Porażka !!!", Toast.LENGTH_LONG).show();
                }
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                //Toast.makeText(activity_afterMenu.this, "You clicked over no", Toast.LENGTH_LONG).show();

            }
        });

        if(licznikPodatki >7)
        {
            TextView showCountTextView =
                    (TextView) findViewById(R.id.textViewGold);
            //get the value of the text view
            String countString = showCountTextView.getText().toString();
            //convert value to a number and ++
            Integer goldd = Integer.parseInt(countString);
            goldd = goldd - 100000 +(1000*miastoa);
            gold=goldd;
            //display the new value int the text view
            showCountTextView.setText(goldd.toString());
             Toast.makeText(activity_afterMenu.this, "Zapłacono podatki !!!", Toast.LENGTH_SHORT).show();
             licznikPodatki=0;

        }
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.frame);
        TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        TextView textView1 = (TextView) alertDialog.findViewById((R.id.alertTitle));
        Typeface face= ResourcesCompat.getFont(this,R.font.magic);
        textView.setTextSize(17);
        textView1.setTextSize(25);

        // TextView textView1 = (TextView) alertDialogBuilder.findViewById(android.R.id.title);
        //  Typeface face1= ResourcesCompat.getFont(this,R.font.magic);
        textView.setTypeface(face);
        textView1.setTypeface(face);


        alertDialog.getWindow().setLayout(820,470);///przed dodaniem na telefon zmienic na 600/400

    }

    //////
    public void BossQuest(View view) {
        final Random random = new Random();
        String qq = "WALKA ZE SMOKIEM";
        final ArrayList<String> BossQuest = new ArrayList<String>();
        BossQuest.add("Chcesz podjac walke z Czerwonym Smokiem ?");
        BossQuest.add("Chcesz podjac walke z Zielonym Smokiem ?");
        BossQuest.add("Chcesz podjac walke z Rubinowym Smokiem ?");
        BossQuest.add("Chcesz podjac walke z Platynowym Smokiem ?");
        BossQuest.add("Chccesz podjac ostateczną walkę z Białym Smokiem Albinosem ?");
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(qq);
        int los= random.nextInt(100);



        if(counterDragon==0)
        {
            alertDialogBuilder.setMessage(BossQuest.get(0));
        }

        if(counterDragon==1)
        {
            alertDialogBuilder.setMessage(BossQuest.get(1));
        }

        if(counterDragon==2)
        {
            alertDialogBuilder.setMessage(BossQuest.get(2));
        }

        if(counterDragon==3)
        {
            alertDialogBuilder.setMessage(BossQuest.get(3));
        }

        if(counterDragon==4)
        {
            alertDialogBuilder.setMessage(BossQuest.get(4));
        }

        TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
        String countString = showCountTextView.getText().toString();
        Integer goldd = Integer.parseInt(countString);
        showCountTextView.setText(goldd.toString());

        if (gold >= 3000000 && army >= 5500 && counterDragon==0)
        {
            if(los >25) {

                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        TextView showCountTextView =
                                (TextView) findViewById(R.id.textViewGold);
                        String countString = showCountTextView.getText().toString();
                        Integer goldd = Integer.parseInt(countString);
                        goldd = goldd + 500000 + (2000 * miastoa);
                        gold = goldd;
                        showCountTextView.setText(goldd.toString());

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

                        alertDialog2.getWindow().setBackgroundDrawableResource(R.drawable.frame);
                        TextView textView = (TextView) alertDialog2.findViewById(android.R.id.message);
                        TextView textView1 = (TextView) alertDialog2.findViewById((R.id.alertTitle));
                        Typeface face = ResourcesCompat.getFont(activity_afterMenu.this, R.font.magic);
                        textView.setTextSize(17);
                        textView1.setTextSize(25);
                        textView.setTypeface(face);
                        textView1.setTypeface(face);
                        alertDialog2.getWindow().setLayout(600, 400);

                        // Toast.makeText(activity_afterMenu.this, "Pokonałeś Czerwonego Smoka !!!", Toast.LENGTH_LONG).show();
                        counterDragon++;
                    }

                });
                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.frame);
                TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
                TextView textView1 = (TextView) alertDialog.findViewById((R.id.alertTitle));
                Typeface face = ResourcesCompat.getFont(this, R.font.magic);
                textView.setTextSize(17);
                TextView textView2 = (TextView) alertDialog.findViewById(android.R.id.button1);
                textView1.setTextSize(25);
                textView.setTypeface(face);
                textView1.setTypeface(face);
                textView2.setTypeface(face);
                alertDialog.getWindow().setLayout(600, 400);
            }
            else
            {

                //convert value to a number and ++
                goldd = goldd - 100000 +(1000*miastoa);
                gold=goldd;
                //display the new value int the text view
                showCountTextView.setText(goldd.toString());
                Toast.makeText(activity_afterMenu.this, "Porażka !!!", Toast.LENGTH_LONG).show();
            }
        }
        else if (gold >= 5000000 && army >= 6500 && counterDragon==1) {
            if (los > 35) {
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        TextView showCountTextView =
                                (TextView) findViewById(R.id.textViewGold);
                        String countString = showCountTextView.getText().toString();
                        Integer goldd = Integer.parseInt(countString);
                        goldd = goldd + 1000000 + (2000 * miastoa);
                        gold = goldd;
                        showCountTextView.setText(goldd.toString());

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

                        alertDialog2.getWindow().setBackgroundDrawableResource(R.drawable.frame);
                        TextView textView = (TextView) alertDialog2.findViewById(android.R.id.message);
                        TextView textView1 = (TextView) alertDialog2.findViewById((R.id.alertTitle));
                        Typeface face = ResourcesCompat.getFont(activity_afterMenu.this, R.font.magic);
                        textView.setTextSize(17);
                        textView1.setTextSize(25);
                        textView.setTypeface(face);
                        textView1.setTypeface(face);
                        alertDialog2.getWindow().setLayout(600, 400);
                        counterDragon++;
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

                alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.frame);
                TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
                TextView textView1 = (TextView) alertDialog.findViewById((R.id.alertTitle));
                Typeface face = ResourcesCompat.getFont(this, R.font.magic);
                textView.setTextSize(17);
                textView1.setTextSize(25);
                textView.setTypeface(face);
                textView1.setTypeface(face);
                alertDialog.getWindow().setLayout(600, 400);
            }
            else
            {
                //convert value to a number and ++
                goldd = goldd - 100000 +(1000*miastoa);
                gold=goldd;
                //display the new value int the text view
                showCountTextView.setText(goldd.toString());
                Toast.makeText(activity_afterMenu.this, "Porażka !!!", Toast.LENGTH_LONG).show();
            }
        }
        else if (gold >= 8000000 && army >= 7500 && counterDragon==2)
        {
            if(los > 45) {
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        TextView showCountTextView =
                                (TextView) findViewById(R.id.textViewGold);
                        String countString = showCountTextView.getText().toString();
                        Integer goldd = Integer.parseInt(countString);
                        goldd = goldd + 2000000 + 2000 * miastoa;
                        gold = goldd;
                        showCountTextView.setText(goldd.toString());

                        alertDialogBuilder2.setTitle("Zadanie Wykonane");
                        alertDialogBuilder2.setMessage("Pokonałeś Rubinowego Smoka !");
                        alertDialogBuilder2.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {

                            }
                        });
                        AlertDialog alertDialog2 = alertDialogBuilder2.create();
                        alertDialog2.show();

                        alertDialog2.getWindow().setBackgroundDrawableResource(R.drawable.frame);
                        TextView textView = (TextView) alertDialog2.findViewById(android.R.id.message);
                        TextView textView1 = (TextView) alertDialog2.findViewById((R.id.alertTitle));
                        Typeface face = ResourcesCompat.getFont(activity_afterMenu.this, R.font.magic);
                        textView.setTextSize(17);
                        textView1.setTextSize(25);
                        textView.setTypeface(face);
                        textView1.setTypeface(face);
                        alertDialog2.getWindow().setLayout(600, 400);
                        counterDragon++;
                    }

                });
                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.frame);
                TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
                TextView textView1 = (TextView) alertDialog.findViewById((R.id.alertTitle));
                Typeface face = ResourcesCompat.getFont(this, R.font.magic);
                textView.setTextSize(17);
                textView1.setTextSize(25);
                textView.setTypeface(face);
                textView1.setTypeface(face);
                alertDialog.getWindow().setLayout(600, 400);
            }
            else
            {
                //convert value to a number and ++
                goldd = goldd - 100000 +(1000*miastoa);
                gold=goldd;
                //display the new value int the text view
                showCountTextView.setText(goldd.toString());
                Toast.makeText(activity_afterMenu.this, "Porażka !!!", Toast.LENGTH_LONG).show();
            }
        }/////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (gold >= 12000000 && army >= 8500 && counterDragon==3)
        {
            if(los > 55) {
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        TextView showCountTextView =
                                (TextView) findViewById(R.id.textViewGold);
                        String countString = showCountTextView.getText().toString();
                        Integer goldd = Integer.parseInt(countString);
                        goldd = goldd + 2500000 + 2000 * miastoa;
                        gold = goldd;
                        showCountTextView.setText(goldd.toString());

                        alertDialogBuilder2.setTitle("Zadanie Wykonane");
                        alertDialogBuilder2.setMessage("Pokonałeś Platynowego Smoka !");
                        alertDialogBuilder2.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {

                            }
                        });
                        AlertDialog alertDialog2 = alertDialogBuilder2.create();
                        alertDialog2.show();

                        alertDialog2.getWindow().setBackgroundDrawableResource(R.drawable.frame);
                        TextView textView = (TextView) alertDialog2.findViewById(android.R.id.message);
                        TextView textView1 = (TextView) alertDialog2.findViewById((R.id.alertTitle));
                        Typeface face = ResourcesCompat.getFont(activity_afterMenu.this, R.font.magic);
                        textView.setTextSize(17);
                        textView1.setTextSize(25);
                        textView.setTypeface(face);
                        textView1.setTypeface(face);
                        alertDialog2.getWindow().setLayout(600, 400);
                        counterDragon++;
                    }

                });
                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.frame);
                TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
                TextView textView1 = (TextView) alertDialog.findViewById((R.id.alertTitle));
                Typeface face = ResourcesCompat.getFont(this, R.font.magic);
                textView.setTextSize(17);
                textView1.setTextSize(25);
                textView.setTypeface(face);
                textView1.setTypeface(face);
                alertDialog.getWindow().setLayout(600, 400);
            }
            else
            {
                //convert value to a number and ++
                goldd = goldd - 100000 +(1000*miastoa);
                gold=goldd;
                //display the new value int the text view
                showCountTextView.setText(goldd.toString());
                Toast.makeText(activity_afterMenu.this, "Porażka !!!", Toast.LENGTH_LONG).show();
            }
        }///////////////////////////////////////////////////////////////
        else if (gold >= 20000000 && army >= 10000 && counterDragon==4)
        {
            if(los > 70) {

                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        TextView showCountTextView =
                                (TextView) findViewById(R.id.textViewGold);
                        String countString = showCountTextView.getText().toString();
                        Integer goldd = Integer.parseInt(countString);
                        goldd = goldd + 10000000 + 2000 * miastoa;
                        gold = goldd;
                        showCountTextView.setText(goldd.toString());

                        alertDialogBuilder2.setTitle("Zadanie Wykonane");
                        alertDialogBuilder2.setMessage("Pokonałeś Bialego Smoka !");
                        alertDialogBuilder2.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {

                            }
                        });
                        AlertDialog alertDialog2 = alertDialogBuilder2.create();
                        alertDialog2.show();

                        alertDialog2.getWindow().setBackgroundDrawableResource(R.drawable.frame);
                        TextView textView = (TextView) alertDialog2.findViewById(android.R.id.message);
                        TextView textView1 = (TextView) alertDialog2.findViewById((R.id.alertTitle));
                        Typeface face = ResourcesCompat.getFont(activity_afterMenu.this, R.font.magic);
                        textView.setTextSize(17);
                        textView1.setTextSize(25);
                        textView.setTypeface(face);
                        textView1.setTypeface(face);
                        alertDialog2.getWindow().setLayout(600, 400);
                        counterDragon++;
                    }

                });
                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.frame);
                TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
                TextView textView1 = (TextView) alertDialog.findViewById((R.id.alertTitle));
                Typeface face = ResourcesCompat.getFont(this, R.font.magic);
                textView.setTextSize(17);
                textView1.setTextSize(25);
                textView.setTypeface(face);
                textView1.setTypeface(face);
                alertDialog.getWindow().setLayout(600, 400);
            }
            else
            {
                //convert value to a number and ++
                goldd = goldd - 100000 +(1000*miastoa);
                gold=goldd;
                //display the new value int the text view
                showCountTextView.setText(goldd.toString());
                Toast.makeText(activity_afterMenu.this, "Porażka !!!", Toast.LENGTH_LONG).show();
            }
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

            alertDialog2.getWindow().setBackgroundDrawableResource(R.drawable.frame);
            TextView textView = (TextView) alertDialog2.findViewById(android.R.id.message);
            TextView textView1 = (TextView) alertDialog2.findViewById((R.id.alertTitle));
            Typeface face= ResourcesCompat.getFont(activity_afterMenu.this,R.font.magic);
            textView.setTextSize(17);
            textView1.setTextSize(25);
            textView.setTypeface(face);
            textView1.setTypeface(face);
            alertDialog2.getWindow().setLayout(600,400);
        }
    }
}








