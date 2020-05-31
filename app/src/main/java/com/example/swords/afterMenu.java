package com.example.swords;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class afterMenu extends AppCompatActivity {

    Context context = this;
    public static int goldSekret=0;
    public static int armySekret=0;
    public static int stal =0;
    public static int miastoSkarb=0;
    public static int miastoimpa=0;
    public static int miastoKoszary=0;
    public static int miastoimpb=0;
    public static int miastoKopalnia=0;
    public static int miastoimpc=0;
    public static int miastoAwans=0;
    public static int miastoimpd=0;
    public static int kwiat=0;
    public static int drzewo=0;
    public static String txt,gld;
    boolean SprCityA=false, SprCityAImp=false, SprCityBImp=false, SprCityB=false, SprCityCImp=false, SprCityC=false, SprArmyImp=false, SprArmy=false, SprGold=false, SprGoldImp=false;
    boolean SprStal=false, SprStalImp=false;
    public static int licznikPodatki=1;
    public TextView textViewGold;
    public TextView textViewArmy;
    public static int counterDragon=0;
    public static int bezpiecznik,licznik,zabojca,kills,goldK,pepega,gold,army;

   @Override
    protected void onPause() {
        super.onPause();
       kwiat++;
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("daneG", textViewGold.getText().toString());
        editor.putString("dane", textViewArmy.getText().toString());
        editor.putInt("kwiat2", kwiat);
        editor.commit();
   }

    @Override
    protected void onResume () {
        super.onResume();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        drzewo=sharedPref.getInt("kwiat2", kwiat);

        if(drzewo>0)
        {
            super.onResume();
            txt = sharedPref.getString("dane", "");
            gld = sharedPref.getString("daneG", "");
            kwiat=drzewo;

        TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
        TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);

        try{
            army = Integer.parseInt(txt);
            gold = Integer.parseInt(gld);
        } catch (Exception e) {
           // e.printStackTrace();
        }
            showCountTextView.setText(gld);
            showCountTextView2.setText(txt);
             kwiat++;

            if(bezpiecznik>0)
            {

                goldSekret=getIntent().getIntExtra("Gold666",gold);
                armySekret=getIntent().getIntExtra("Armia666",army);

                TextView showCountTextViewGol = (TextView) findViewById(R.id.textViewGold);
                TextView showCountTextViewArm = (TextView) findViewById(R.id.textViewArmy);

                String countString = showCountTextView.getText().toString();
                String countString2 = showCountTextView2.getText().toString();

                Integer goldd = Integer.parseInt(countString);
                Integer armyy = Integer.parseInt(countString2);

                gold=gold+goldSekret;
                army=army+armySekret;

                goldd = gold;
                armyy = army;

                showCountTextViewGol.setText(goldd.toString());
                showCountTextViewArm.setText(armyy.toString());

                bezpiecznik=0;
            }

            miastoimpa=getIntent().getIntExtra("skarb",miastoSkarb);
            miastoimpb=getIntent().getIntExtra("kosz",miastoKoszary);
            miastoimpc=getIntent().getIntExtra("kop",miastoKopalnia);
            miastoimpd=getIntent().getIntExtra("awan",miastoAwans);

            miastoSkarb=miastoimpa;
            miastoKoszary=miastoimpb;
            miastoKopalnia=miastoimpc;
            miastoAwans=miastoimpd;

            if(zabojca>0)
            {
                goldK=getIntent().getIntExtra("goldKill",gold);
                TextView showCountTextView3 = (TextView) findViewById(R.id.textViewGold);
                String countString = showCountTextView3.getText().toString();
                Integer goldd = Integer.parseInt(countString);
                gold=gold+goldK;
                goldd = gold;
                showCountTextView3.setText(goldd.toString());
                zabojca=0;
            }
            stal=0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        textViewGold = findViewById(R.id.textViewGold);
        textViewArmy = findViewById(R.id.textViewArmy);
        Button button = findViewById(R.id.buttonCityUP);
        setContentView(R.layout.activity_after_menu);

        bezpiecznik = getIntent().getIntExtra("Kod", licznik);
        zabojca=getIntent().getIntExtra("zabojca", kills);
        SprArmyImp = getIntent().getBooleanExtra("ArmiaZ", SprArmy);
        SprGoldImp = getIntent().getBooleanExtra("GoldZ", SprGold);
        SprCityAImp = getIntent().getBooleanExtra("CityAZ", SprCityA);
        SprCityBImp = getIntent().getBooleanExtra("CityBZ", SprCityB);
        SprCityCImp = getIntent().getBooleanExtra("CityCZ", SprCityC);
        SprStalImp = getIntent().getBooleanExtra("StalZ", SprStal);
        miastoimpd=getIntent().getIntExtra("awan",miastoAwans);

        miastoAwans=miastoimpd;

        TextView showCountTextViewGold = (TextView) findViewById(R.id.textViewGold);
        TextView showCountTextViewArmy=(TextView) findViewById(R.id.textViewArmy);

        String countStringGold = showCountTextViewGold.getText().toString();
        String countStringArmy = showCountTextViewArmy.getText().toString();

        Integer countGold = Integer.parseInt(countStringGold);
        Integer countArmy = Integer.parseInt(countStringArmy);

        army=countArmy;
        gold=countGold;
        showCountTextViewGold.setText(countGold.toString());
        showCountTextViewArmy.setText(countArmy.toString());

        textViewGold = findViewById(R.id.textViewGold);
        textViewArmy = findViewById(R.id.textViewArmy);

        if (SprGold == SprGoldImp) {
            goldSekret = getIntent().getIntExtra("gold666", army);
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewGold);
            String countString2 = showCountTextView2.getText().toString();
            Integer armyy = Integer.parseInt(countString2);
        }

        if (SprArmy == SprArmyImp) {
            armySekret = getIntent().getIntExtra("Armia666", army);
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
            String countString2 = showCountTextView2.getText().toString();
            Integer goldd = Integer.parseInt(countString2);
        }

        if (SprCityA != SprCityAImp) {
            miastoimpa = getIntent().getIntExtra("skarb", miastoSkarb);
            miastoSkarb = miastoimpa;
        }

        if (SprCityB != SprCityBImp) {
            miastoimpb = getIntent().getIntExtra("kosz", miastoKoszary);
            miastoKoszary = miastoimpb;
        }

        if (SprCityC != SprCityCImp) {
            miastoimpc = getIntent().getIntExtra("kop", miastoKopalnia);
            miastoKopalnia = miastoimpc;
        }

    }

    public void onBackPressed()
    {
        //zablokowane
    }


    public void moveToCityUpgrade(View view)
    {
        Intent intent = new Intent(this, upgrade.class);
        intent.putExtra("Stal",stal);
        startActivity(intent);
    }

    public void WerbunekClick(View view) {
        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewArmy);
        TextView showCountTextView2 =
                (TextView) findViewById(R.id.textViewGold);

        String countString = showCountTextView.getText().toString();
        String countString2 = showCountTextView2.getText().toString();

        Integer armyy = Integer.parseInt(countString);
        Integer goldd=Integer.parseInt(countString2);

        if (goldd>0) {
            army = army + 100;
            gold = gold - 100000;
            armyy=army;
            goldd = gold;

            showCountTextView.setText(armyy.toString());
            showCountTextView2.setText(goldd.toString());
        }
        else
        {
            Toast.makeText(context, "Nie masz zlota!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickWork(View view) {
        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewGold);
        String countString = showCountTextView.getText().toString();
        Integer goldd = Integer.parseInt(countString);
        goldd = goldd +5000 + 50*miastoAwans;
        gold=goldd;
        showCountTextView.setText(goldd.toString());
    }

    public void moveToKiller(View view)
    {
        if(gold>=10000000) {
            pepega = 0;
            pepega++;
            Intent intent = new Intent(this, asasyn.class);
            intent.putExtra("Gold7", gold);
            intent.putExtra("pepega", pepega);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(context, "Aby wejsc do zabojcy musisz miec minimum 10 mln zlota", Toast.LENGTH_SHORT).show();
        }
    }

    public void NextQuest(View view) {
        final Random random = new Random();
        String q = "Nowe Zadanie!";
        String qq = "WALKA ZE SMOKIEM";
        final ArrayList<String> aListQuest = new ArrayList<String>();

        aListQuest.add("Znaleziono slady nieznanej postaci, podazać za nimi i sprawdzic co to ?");
        aListQuest.add("W pobliskiej jaskni udomowila się pantera, zagraza naszym ludziom." +
                " Zabic ja ?");
        aListQuest.add("Nasz jasnowidz uważa, że nadchodzi potezna burza, zabezpieczyz nasze plony ?");
        aListQuest.add("Z pobliskiej wioski zniknela ludnosc, rozpoczac poszukiwania ?");
        aListQuest.add("W pobliżu pewna grupa rozbojników rabuje mieszkancow, zaatakowac ich ?");
        aListQuest.add("W jednej z naszej wiosek panuje wirus, znalezc jego źrddlo ?");
        aListQuest.add("Nasza dostawa zywnosci oraz uzbrojenia nie dotarla do punktu"+
                "docelowego. Wyslac zwiad ?");
        aListQuest.add("Zwiad donosi że w okolicy grasuje ogromny niedzwiedz."+
                "Wyslać zwiad na polowanie ?");
        aListQuest.add("Na krolewski rynek wdarlo się stado dzikow! Przepedzic je?");
        aListQuest.add("Kryzys w krolestwie! Rabusie okradaja miejscowych!"+ "Wyslac patrol na rynek?");
        aListQuest.add("W okolicy grasuja gobliny. Postawić kres ich wybrykom?");
        aListQuest.add("Podobno straznicy przy bramie sa przekupni i w naszy miescie pojawila sie kontrabanda. Wymienic straznikow?");
        aListQuest.add("Smok zaczal porywac nasze owce, postawic ogrodzenie i straznikow przy pastwiskach?");
        aListQuest.add("W okolicy grasuje podpalacz dachow. Wypuscic wiecej patroli?");
        aListQuest.add("Znany Bard chce dac koncert w naszym Krolestwie. Wpuszczamy go?");
        aListQuest.add("Ludzie zaczynaja sie buntowac, chca mniejszej kontroli dobr wkraczajacych do krolestwa, zmniejszyc obostrzenia?");
        aListQuest.add("Zaczely wysychac okoliczne rzeki, choc caly czas pada. Wyslac negocjatorow do obozu Bobro-ludzi?");
        aListQuest.add("Zwiad wrogich wojsk kręci się przy naszych murach, przepedzić ich ?");
        aListQuest.add("Mala dziewczynka zgubila misia, pomozesz jej go znalezc ?");
        aListQuest.add("Lekarz potrzebuje ziol z lasu, potrzeba mu ochrona przed rabusiami " +
                "Zgadzasz sie by mu pomoc ? ");
        aListQuest.add("W dolinie na zachod od krolestwa znaleziono skamieniale ogry. Tluczemy je dopoki sa skamieniale?");
        aListQuest.add("Do miasta przyjechal tragarz z egzotycznymi zwierzetami. Rozkazac mu aby oddal nam 2 sztuki kazdego ze zwierzat?");
        aListQuest.add("Elfi straznicy drzew chca zebysmy im pomogli chronic ich lasu w trakcie ceremonii ich druidow, "+ "w zamian za zloto. Pomagamy im?");

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final String a = aListQuest.get(random.nextInt(aListQuest.size()));
        alertDialogBuilder.setMessage(a);
        alertDialogBuilder.setTitle(q);

        alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

            int b = random.nextInt(100);

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                licznikPodatki++;
                if (b >40) {
                    TextView showCountTextView =
                            (TextView) findViewById(R.id.textViewGold);
                    String countString = showCountTextView.getText().toString();
                    Integer goldd = Integer.parseInt(countString);
                    gold = gold + 250000 + (20)*miastoSkarb;

                    if (b%5==0)
                    {
                        Integer stall = stal;
                        stal=stal+10+(5*miastoKopalnia);
                        stall=stal;
                        Toast.makeText(afterMenu.this, "Znaleziono trochę stali!!", Toast.LENGTH_SHORT).show();
                    }
                    goldd=gold;
                    showCountTextView.setText(goldd.toString());
                }
                else
                    {
                    TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
                    TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
                    String countString2 = showCountTextView2.getText().toString();
                    String countString = showCountTextView.getText().toString();
                    Integer goldd = Integer.parseInt(countString);
                    Integer armyy = Integer.parseInt(countString2);
                    gold = gold - 50000 + (5)*miastoSkarb;
                    army = army - 100 +(1)*miastoKoszary;
                    goldd=gold;
                    armyy=army;
                    showCountTextView.setText(goldd.toString());
                    showCountTextView2.setText(armyy.toString());
                    Toast.makeText(afterMenu.this, "Porazka !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertDialogBuilder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });

        if(licznikPodatki >7)
        {
            TextView showCountTextView =
                    (TextView) findViewById(R.id.textViewGold);
            String countString = showCountTextView.getText().toString();
            Integer goldd = Integer.parseInt(countString);
            goldd = goldd - 100000 +(1000*miastoSkarb);
            gold=goldd;
            showCountTextView.setText(goldd.toString());
             Toast.makeText(afterMenu.this, "Zaplacono podatki !!!", Toast.LENGTH_SHORT).show();
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
        textView.setTypeface(face);
        textView1.setTypeface(face);

        alertDialog.getWindow().setLayout(600,350);
    }


    public void BossQuest(View view) {
        final Random random = new Random();
        String qq = "WALKA ZE SMOKIEM";
        final ArrayList<String> BossQuest = new ArrayList<String>();
        BossQuest.add("Chcesz podjac walke z Czerwonym Smokiem ?");
        BossQuest.add("Chcesz podjac walke z Zielonym Smokiem ?");
        BossQuest.add("Chcesz podjac walke z Rubinowym Smokiem ?");
        BossQuest.add("Chcesz podjac walke z Platynowym Smokiem ?");
        BossQuest.add("Chccesz podjac ostateczną walkę z Bialym Smokiem Albinosem ?");
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(qq);
        final int los= random.nextInt(100);

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
                alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (los > 25) {

                            TextView showCountTextView =
                                    (TextView) findViewById(R.id.textViewGold);
                            String countString = showCountTextView.getText().toString();
                            Integer goldd = Integer.parseInt(countString);
                            goldd = goldd + 500000 + (2000 * miastoSkarb);
                            gold = goldd;
                            showCountTextView.setText(goldd.toString());

                            alertDialogBuilder2.setTitle("Zadanie Wykonane");
                            alertDialogBuilder2.setMessage("Pokonales Czerwonego Smoka !");
                            alertDialogBuilder2.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                }
                            });
                            AlertDialog alertDialog2 = alertDialogBuilder2.create();
                            alertDialog2.show();

                            alertDialog2.getWindow().setBackgroundDrawableResource(R.drawable.frame);
                            TextView textView = (TextView) alertDialog2.findViewById(android.R.id.message);
                            TextView textView1 = (TextView) alertDialog2.findViewById((R.id.alertTitle));
                            Typeface face = ResourcesCompat.getFont(afterMenu.this, R.font.magic);
                            textView.setTextSize(17);
                            textView1.setTextSize(25);
                            textView.setTypeface(face);
                            textView1.setTypeface(face);
                            alertDialog2.getWindow().setLayout(600, 350);

                            counterDragon++;
                        }
                        else
                            {
                            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
                            String countString2 = showCountTextView2.getText().toString();
                            TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);

                            String countString = showCountTextView.getText().toString();
                            Integer goldd = Integer.parseInt(countString);
                            Integer armyy = Integer.parseInt(countString2);

                            gold = gold - 100000;
                            army = army - 1000;

                            goldd = gold;
                            armyy = army;

                            showCountTextView.setText(goldd.toString());
                            showCountTextView2.setText(armyy.toString());

                            Toast.makeText(afterMenu.this, "Porazka !!!", Toast.LENGTH_LONG).show();
                        }

                    }
                        });
                alertDialogBuilder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
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
                alertDialog.getWindow().setLayout(600, 350);

        }
        else if (gold >= 5000000 && army >= 6500 && counterDragon==1)
        {

                alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (los > 35) {
                            TextView showCountTextView =
                                    (TextView) findViewById(R.id.textViewGold);
                            String countString = showCountTextView.getText().toString();
                            Integer goldd = Integer.parseInt(countString);
                            goldd = goldd + 1000000 + (2000 * miastoSkarb);
                            gold = goldd;
                            showCountTextView.setText(goldd.toString());

                            alertDialogBuilder2.setTitle("Zadanie Wykonane");
                            alertDialogBuilder2.setMessage("Pokonales Zielonego Smoka !");
                            alertDialogBuilder2.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                }
                            });
                            AlertDialog alertDialog2 = alertDialogBuilder2.create();
                            alertDialog2.show();

                            alertDialog2.getWindow().setBackgroundDrawableResource(R.drawable.frame);
                            TextView textView = (TextView) alertDialog2.findViewById(android.R.id.message);
                            TextView textView1 = (TextView) alertDialog2.findViewById((R.id.alertTitle));
                            Typeface face = ResourcesCompat.getFont(afterMenu.this, R.font.magic);
                            textView.setTextSize(17);
                            textView1.setTextSize(25);
                            textView.setTypeface(face);
                            textView1.setTypeface(face);
                            alertDialog2.getWindow().setLayout(600, 350);
                            counterDragon++;
                        } else {
                            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
                            String countString2 = showCountTextView2.getText().toString();
                            Integer armyy = Integer.parseInt(countString2);
                            TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
                            String countString = showCountTextView.getText().toString();
                            Integer goldd = Integer.parseInt(countString);
                            gold = gold - 200000;
                            army = army - 1500;
                            goldd = gold;
                            armyy = army;
                            showCountTextView.setText(goldd.toString());
                            showCountTextView2.setText(armyy.toString());
                            Toast.makeText(afterMenu.this, "Porazka !!!", Toast.LENGTH_LONG).show();
                        }
                    }

                });
                alertDialogBuilder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
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
                alertDialog.getWindow().setLayout(600, 350);
            }

        else if(gold >= 8000000 && army >= 7500 && counterDragon==2)
        {

                alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (los > 45) {
                            TextView showCountTextView =
                                    (TextView) findViewById(R.id.textViewGold);
                            String countString = showCountTextView.getText().toString();
                            Integer goldd = Integer.parseInt(countString);
                            goldd = goldd + 2000000 + 2000 * miastoSkarb;
                            gold = goldd;
                            showCountTextView.setText(goldd.toString());

                            alertDialogBuilder2.setTitle("Zadanie Wykonane");
                            alertDialogBuilder2.setMessage("Pokonales Rubinowego Smoka !");
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
                            Typeface face = ResourcesCompat.getFont(afterMenu.this, R.font.magic);
                            textView.setTextSize(17);
                            textView1.setTextSize(25);
                            textView.setTypeface(face);
                            textView1.setTypeface(face);
                            alertDialog2.getWindow().setLayout(600, 350);
                            counterDragon++;
                        }
                        else {
                            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
                            String countString2 = showCountTextView2.getText().toString();
                            Integer armyy = Integer.parseInt(countString2);
                            TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
                            String countString = showCountTextView.getText().toString();
                            Integer goldd = Integer.parseInt(countString);
                            gold = gold - 300000;
                            army = army - 2000;
                            goldd = gold;
                            armyy = army;
                            showCountTextView.setText(goldd.toString());
                            showCountTextView2.setText(armyy.toString());
                            Toast.makeText(afterMenu.this, "Porazka !!!", Toast.LENGTH_LONG).show();
                        }
                    }

                });
                alertDialogBuilder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
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
                alertDialog.getWindow().setLayout(600, 350);

        }
        else if (gold >= 12000000 && army >= 8500 && counterDragon==3)
        {

                alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (los > 55) {
                            TextView showCountTextView =
                                    (TextView) findViewById(R.id.textViewGold);
                            String countString = showCountTextView.getText().toString();
                            Integer goldd = Integer.parseInt(countString);
                            goldd = goldd + 2500000 + 2000 * miastoSkarb;
                            gold = goldd;
                            showCountTextView.setText(goldd.toString());

                            alertDialogBuilder2.setTitle("Zadanie Wykonane");
                            alertDialogBuilder2.setMessage("Pokonales Platynowego Smoka !");
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
                            Typeface face = ResourcesCompat.getFont(afterMenu.this, R.font.magic);
                            textView.setTextSize(17);
                            textView1.setTextSize(25);
                            textView.setTypeface(face);
                            textView1.setTypeface(face);
                            alertDialog2.getWindow().setLayout(600, 350);
                            counterDragon++;
                        } else {
                            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
                            String countString2 = showCountTextView2.getText().toString();
                            Integer armyy = Integer.parseInt(countString2);
                            TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
                            String countString = showCountTextView.getText().toString();
                            Integer goldd = Integer.parseInt(countString);
                            gold = gold - 400000;
                            army = army - 2500;
                            goldd = gold;
                            armyy = army;
                            showCountTextView.setText(goldd.toString());
                            showCountTextView2.setText(armyy.toString());
                            Toast.makeText(afterMenu.this, "Porazka !!!", Toast.LENGTH_LONG).show();
                        }
                    }

                });
                alertDialogBuilder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
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
                alertDialog.getWindow().setLayout(600, 350);

        }
         else if (gold >= 20000000 && army >= 10000 && counterDragon==4)
        {

                alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (los > 66) {
                            TextView showCountTextView =
                                    (TextView) findViewById(R.id.textViewGold);
                            String countString = showCountTextView.getText().toString();
                            Integer goldd = Integer.parseInt(countString);
                            goldd = goldd + 10000000 + 2000 * miastoSkarb;
                            gold = goldd;
                            showCountTextView.setText(goldd.toString());

                            alertDialogBuilder2.setTitle("Koniec gry");
                            alertDialogBuilder2.setMessage("Pokonales ostatniego smoka. " +
                                    "Wszyscy mieszkancy zaznaja teraz spokoju.");
                            alertDialogBuilder2.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    Intent intent = new Intent(getApplicationContext(), end.class);
                                    startActivity(intent);

                                }
                            });

                            AlertDialog alertDialog2 = alertDialogBuilder2.create();
                            alertDialog2.show();

                            alertDialog2.getWindow().setBackgroundDrawableResource(R.drawable.frame);
                            TextView textView = (TextView) alertDialog2.findViewById(android.R.id.message);
                            TextView textView1 = (TextView) alertDialog2.findViewById((R.id.alertTitle));
                            Typeface face = ResourcesCompat.getFont(afterMenu.this, R.font.magic);
                            textView.setTextSize(17);
                            textView1.setTextSize(25);
                            textView.setTypeface(face);
                            textView1.setTypeface(face);
                            alertDialog2.getWindow().setLayout(600, 350);
                            counterDragon++;
                            counterDragon++;
                        } else {
                            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
                            String countString2 = showCountTextView2.getText().toString();
                            Integer armyy = Integer.parseInt(countString2);
                            TextView showCountTextView = (TextView) findViewById(R.id.textViewGold);
                            String countString = showCountTextView.getText().toString();
                            Integer goldd = Integer.parseInt(countString);
                            gold = gold - 500000;
                            army = army - 5000;
                            goldd = gold;
                            armyy = army;
                            showCountTextView.setText(goldd.toString());
                            showCountTextView2.setText(armyy.toString());
                            Toast.makeText(afterMenu.this, "Porazka !!!", Toast.LENGTH_LONG).show();
                        }
                    }

                });
            alertDialogBuilder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
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
                alertDialog.getWindow().setLayout(600, 350);
        }
         else if(counterDragon >4)
        {
            Toast.makeText(afterMenu.this, "Pokonales juz wszystkie smoki !!!", Toast.LENGTH_LONG).show();
        }
        else
        {
            alertDialogBuilder2.setTitle("Uwaga");
            alertDialogBuilder2.setMessage("Nie spelniasz wymagan do walki ze smokiem");

            alertDialogBuilder2.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                }
            });
            AlertDialog alertDialog2 = alertDialogBuilder2.create();
            alertDialog2.show();

            alertDialog2.getWindow().setBackgroundDrawableResource(R.drawable.frame);
            TextView textView = (TextView) alertDialog2.findViewById(android.R.id.message);
            TextView textView1 = (TextView) alertDialog2.findViewById((R.id.alertTitle));
            Typeface face= ResourcesCompat.getFont(afterMenu.this,R.font.magic);
            textView.setTextSize(17);
            textView1.setTextSize(25);
            textView.setTypeface(face);
            textView1.setTypeface(face);
            alertDialog2.getWindow().setLayout(600,300);
        }
    }
}