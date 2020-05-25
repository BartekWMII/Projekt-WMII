package com.example.swords;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class activity_asasyn extends AppCompatActivity {


    Context context = this;

    private int sila=100;
    private int inteligencja=100;
    private int wytrzymalosc=100;
    public static int kwiatRab;
    private int drzewoRab;
    public static int kills=0;
    public static int goldB=0;
    public static String wytrz, sil, intel;
    public static int gold=0;
    private TextView textViewStrong;
    private TextView textViewIQ;
    private TextView textViewHP;

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("daneS", textViewStrong.getText().toString());
        editor.putString("daneI", textViewIQ.getText().toString());
        editor.putString("daneW", textViewHP.getText().toString());
        editor.putInt("kwiatRab", kwiatRab);
        kwiatRab++;
        //Toast.makeText(this, "Chyba dziala", Toast.LENGTH_LONG).show();

        editor.commit();
    }

    @Override
    protected void onResume () {
        super.onResume();
        // Toast.makeText(activity_afterMenu.this, kwiat, Toast.LENGTH_LONG).show();
       // kills=0;
        //gold=0;
        if(kwiatRab>1)
        {
         //   Toast.makeText(this, "Chyba dzialaRRR", Toast.LENGTH_LONG).show();

            super.onResume();
            SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
            drzewoRab=sharedPref.getInt("kwiatRab",1 );
            sil = sharedPref.getString("daneS", ""); // Tekst zapisujemy do zmiennej globalnej i w metodzie OnCreate() przypisujemy do odpowiedniej kontrolki EditText: editText.setText(txt);
            intel = sharedPref.getString("daneI", ""); // Tekst zapisujemy do zmiennej globalnej i w metodzie OnCreate() przypisujemy do odpowiedniej kontrolki EditText: editText.setText(txt);
            wytrz = sharedPref.getString("daneW", "");
            kwiatRab=drzewoRab;
            TextView showCountTextView = (TextView) findViewById(R.id.textViewStrong);
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewIQ);
            TextView showCountTextView3 = (TextView) findViewById(R.id.textViewHP);
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

            //bezpiecznik = getIntent().getIntExtra("Kod", licznik);
           // kontrolka = getIntent().getIntExtra("kontrola", counterQ);


        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_asasyn);
        kwiatRab++;
        textViewStrong = findViewById(R.id.textViewStrong);
        textViewIQ = findViewById(R.id.textViewIQ);
        textViewHP=findViewById(R.id.textViewHP);
        kills=0;
        gold=0;
    }

    public void onBackPressed() {
        if (kills > 0) {
            // new AlertDialog.Builder(this)

            Intent intent = new Intent(getApplicationContext(), activity_afterMenu.class);
            intent.putExtra("goldKill", gold);
            intent.putExtra("zabojca", kills);
            startActivity(intent);
            activity_asasyn.super.onBackPressed();
             Toast.makeText(this, "Wynosze- kile: "+kills + "Zloto: "+gold, Toast.LENGTH_LONG).show();
           //  kills=0;

        }
        else
           {
            activity_asasyn.super.onBackPressed();
               Toast.makeText(this, "Normalne wyjscie "+gold, Toast.LENGTH_LONG).show();

           }
    }


    public void onClickStrong(View view) {
        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewStrong);


        //get the value of the text view
        String countString = showCountTextView.getText().toString();

        //convert value to a number and ++
        Integer stronger = Integer.parseInt(countString);
      //  Integer goldd=Integer.parseInt(countString);
        if (stronger>0) {
            sila=sila+10;
            gold = gold - 100000;
            stronger=sila;
            kills++;
            //display the new value int the text view
            showCountTextView.setText(stronger.toString());
        }
        else
        {
            //Toast.makeText(context, "Nie masz zlota!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickIQ(View view) {
        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewIQ);

        //get the value of the text view
        String countString = showCountTextView.getText().toString();

        //convert value to a number and ++
        Integer inteligencja2 = Integer.parseInt(countString);
       // Integer goldd=Integer.parseInt(countString2);
        if (inteligencja2>0) {
            inteligencja = inteligencja + 10;
            gold = gold - 100000;
            inteligencja2=inteligencja;
            kills++;
           // goldd = gold;
            //display the new value int the text view
            showCountTextView.setText(inteligencja2.toString());

        }
        else
        {
           // Toast.makeText(context, "Nie masz zlota!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickHP(View view) {
        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewHP);


        //get the value of the text view
        String countString = showCountTextView.getText().toString();

        //convert value to a number and ++
        Integer HP2 = Integer.parseInt(countString);
       // Integer goldd=Integer.parseInt(countString2);
        if (HP2>0) {
            wytrzymalosc = wytrzymalosc + 10;
            gold = gold - 100000;
            HP2 = wytrzymalosc;
            kills++;
            //display the new value int the text view
            showCountTextView.setText(HP2.toString());
          //  showCountTextView2.setText(goldd.toString());
        }
        else
        {
           // Toast.makeText(context, "Nie masz wojownikow!", Toast.LENGTH_SHORT).show();
        }
    }


   /* public void BossQuest(View view) {
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

                alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

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
                        alertDialogBuilder2.setNegativeButton("OK", new DialogInterface.OnClickListener() {
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
                        alertDialog2.getWindow().setLayout(600, 350);

                        // Toast.makeText(activity_afterMenu.this, "Pokonałeś Czerwonego Smoka !!!", Toast.LENGTH_LONG).show();
                        counterDragon++;
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
            else
            {

                TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
                String countString2 = showCountTextView2.getText().toString();
                Integer armyy = Integer.parseInt(countString2);
                gold = gold - 100000;
                army = army - 1000;
                goldd=gold;
                armyy=army;
                showCountTextView.setText(goldd.toString());
                showCountTextView2.setText(armyy.toString());
                Toast.makeText(activity_afterMenu.this, "Porażka !!!", Toast.LENGTH_LONG).show();
            }
        }
        else if (gold >= 5000000 && army >= 6500 && counterDragon==1) {
            if (los > 35) {
                alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

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
                        alertDialogBuilder2.setNegativeButton("OK", new DialogInterface.OnClickListener() {
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
                        alertDialog2.getWindow().setLayout(600, 350);
                        counterDragon++;
                        //Toast.makeText(activity_afterMenu.this, "Pokonałeś Zielonego Smoka !!!", Toast.LENGTH_LONG).show();
                    }

                });
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
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
            else
            {
                TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
                String countString2 = showCountTextView2.getText().toString();
                Integer armyy = Integer.parseInt(countString2);
                gold = gold - 200000;
                army = army - 1500;
                goldd=gold;
                armyy=army;
                showCountTextView.setText(goldd.toString());
                showCountTextView2.setText(armyy.toString());
                Toast.makeText(activity_afterMenu.this, "Porażka !!!", Toast.LENGTH_LONG).show();
            }
        }
        else if (gold >= 8000000 && army >= 7500 && counterDragon==2)
        {
            if(los > 45) {
                alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

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
                        alertDialog2.getWindow().setLayout(600, 350);
                        counterDragon++;
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
            else
            {
                TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
                String countString2 = showCountTextView2.getText().toString();
                Integer armyy = Integer.parseInt(countString2);
                gold = gold - 300000;
                army = army - 2000;
                goldd=gold;
                armyy=army;
                showCountTextView.setText(goldd.toString());
                showCountTextView2.setText(armyy.toString());
                Toast.makeText(activity_afterMenu.this, "Porażka !!!", Toast.LENGTH_LONG).show();
            }
        }/////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (gold >= 12000000 && army >= 8500 && counterDragon==3)
        {
            if(los > 55) {
                alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

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
                        alertDialog2.getWindow().setLayout(600, 350);
                        counterDragon++;
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
            else
            {
                TextView showCountTextView2 = (TextView) findViewById(R.id.textViewArmy);
                String countString2 = showCountTextView2.getText().toString();
                Integer armyy = Integer.parseInt(countString2);
                gold = gold - 400000;
                army = army - 2500;
                goldd=gold;
                armyy=army;
                showCountTextView.setText(goldd.toString());
                showCountTextView2.setText(armyy.toString());
                Toast.makeText(activity_afterMenu.this, "Porazka !!!", Toast.LENGTH_LONG).show();
            }
        }///////////////////////////////////////////////////////////////
        else if (gold >= 20000000 && army >= 10000 && counterDragon==4)
        {
            if(los > 70) {

                alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        TextView showCountTextView =
                                (TextView) findViewById(R.id.textViewGold);
                        String countString = showCountTextView.getText().toString();
                        Integer goldd = Integer.parseInt(countString);
                        goldd = goldd + 10000000 + 2000 * miastoa;
                        gold = goldd;
                        showCountTextView.setText(goldd.toString());

                        alertDialogBuilder2.setTitle("Koniec gry");
                        alertDialogBuilder2.setMessage("Pokonales ostatniego Bialego smoka. " +
                                "Wszyscy mieszkancy zaznaja teraz spokoju. Chcesz kontynuowac " +
                                "przygode" +
                                "czy  zakonczyc ?");
                        alertDialogBuilder2.setNeutralButton("Nie Koncz", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {

                            }
                        });
                        alertDialogBuilder2.setNegativeButton("Zakoncz", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                System.exit(0);
                                czyPause=false;
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
                        alertDialog2.getWindow().setLayout(600, 350);
                        counterDragon++;
                    }

                });
                alertDialogBuilder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                    }
                });
              //  alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                //    @Override
                  //  public void onClick(DialogInterface dialog, int i) {
                 //   }
             //   });

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
                alertDialog.getWindow().setLayout(600, 4000);
            }

        }
        else if(counterDragon >4)
        {
            Toast.makeText(activity_afterMenu.this, "Pokonales juz wszystkie smoki !!!", Toast.LENGTH_LONG).show();
        }
        else
        {

            alertDialogBuilder2.setTitle("Uwaga");
            alertDialogBuilder2.setMessage("Nie spelniasz wymagan do walki ze smokiem");

            alertDialogBuilder2.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    //Toast.makeText(activity_afterMenu.this, "You clicked over no", Toast.LENGTH_LONG).show();
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
            alertDialog2.getWindow().setLayout(600,300);
        }


    }*/



}
