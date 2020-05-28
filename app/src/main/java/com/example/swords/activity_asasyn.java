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

    private int sila;
    private int inteligencja;
    private int wytrzymalosc;
    public static int kwiatRab;
    private int drzewoRab;
    public static int kills=0;
    public static int goldB=0;
    public static int counterM=0;
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
        kwiatRab++;
        editor.putInt("kwiatRab", kwiatRab);

        //Toast.makeText(this, "Chyba dziala", Toast.LENGTH_LONG).show();

        editor.commit();
    }

    @Override
    protected void onResume () {
        super.onResume();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        // Toast.makeText(activity_afterMenu.this, kwiat, Toast.LENGTH_LONG).show();
        // kills=0;
        //gold=0;
        drzewoRab=sharedPref.getInt("kwiatRab",kwiatRab );

        if(drzewoRab>0)
        {
            //   Toast.makeText(this, "Chyba dzialaRRR", Toast.LENGTH_LONG).show();

            super.onResume();
           // SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
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

        textViewStrong = findViewById(R.id.textViewStrong);
        textViewIQ = findViewById(R.id.textViewIQ);
        textViewHP=findViewById(R.id.textViewHP);

        TextView showCountTextView1 = (TextView) findViewById(R.id.textViewStrong);
        TextView showCountTextView2 = (TextView) findViewById(R.id.textViewIQ);
        TextView showCountTextView3 = (TextView) findViewById(R.id.textViewHP);

        String countStringSila = showCountTextView1.getText().toString();
        String countStringIQ = showCountTextView2.getText().toString();
        String countStringHP = showCountTextView3.getText().toString();

        Integer countSila = Integer.parseInt(countStringSila);
        Integer countIQ = Integer.parseInt(countStringIQ);
        Integer countHP = Integer.parseInt(countStringHP);

        wytrzymalosc=countHP;
        inteligencja=countIQ;
        sila=countSila;

        showCountTextView1.setText(countSila.toString());
        showCountTextView2.setText(countIQ.toString());
        showCountTextView3.setText(countHP.toString());

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

    public void HelpDesk(View view)
    {

        // new AlertDialog.Builder(this)
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Lista Zlecen");
        alertDialogBuilder.setMessage("Kazde ulepszenie zabojcy ksoztuje 500 000 zlota\n\n"+
                "Zlecenia wykonuja w kolejnosci ponizej \n\n"+
                "Za kazde wykonanie zlecenia otrzymasz nagrode w postaci duzej liczby zlota\n\n"+
                "Statystyki dopasowujemy do opisu postaci np Gargulec jest niebywale inteligentny "+
                "oraz wytrzymaly, to znak dla nas ze musimy ulepszyc wytrzymalosc oraz sile\n\n"+
                "Za jedno ulepszenie statystyki zabojcy przyjmujemy piec wcisniec ulepszenia, czyli "+
                "Jedno ulepszenie sily to tak naprawde 5 ulepszen\n\n"+
                "Aby wejsc do zabojcy musisz miec minimum 10 mln zlota"+
                "Wydawaj zloto uwaznie, zabojca dziala tylko w nocy, dlatego nie widzisz liczby zlota." +
                "U zabojcy mozesz placic nawet gdy nie masz pieniedzy, lecz pamietaj ze to moze " +
                "pograzyc krolestwo w biedzie i nedzy.\n\n\n"+
                "1 Twoim zleceniem jest zabicie Kejrana. " +
                "Jest to pradawne drzewo, ktore pod wplywem zlych urokow zostalo zmienione " +
                "w drzewiasta osmiornice. Jest niebywale silny i wytrzymaly\n\n" +
                "2 Twoim zleceniem jest zabicie Wielkiego Lodowego Giganta " +
                "Pochodzi on z krainy Freljordu gdzie panuje wieczna zima " +
                "Jest bardzo wytrzymalym przeciwnikiem, uciekanie przed nim to zaden wstyd\n\n" +
                "3 Twoim zleceniem jest zabicie Baby Cmentarnej " +
                "Niebywale grozny stwor, jest to niespokojna dusza ktora nie moze wrocic w zaswiaty " +
                "Jest inteligentna wytrzymala i jak na swoj wiek silna\n\n" +
                "4 Twoim zleceniem jest zabicie Mglaka " +
                "Szybki wytrzymaly i rowniez silny stwor z bagien w poblizu lasu\n\n" +
                "5 Twoim zleceniem jest zabicie Gryfa " +
                "Jest on inteligentny oraz niebywale silny. Posiada wielkie szpony " +
                "i ogromne szkydla, ktorych podmuch jest w stanie zdmuchnac przeciwnika z pola walki\n\n" +
                "6 Twoim zleceniem jest zabicie Zywiolaka Ognia " +
                "Pochodzi on z pradawnej krainy Darkharr gdzie wladze sprawuje Brand." +
                "Zywiolak jest inteligentny i bardzo wytrzymaly czasami bywa tez silny\n\n" +
                "7 Twoim zleceniem jest zabicie Biesa " +
                "Jest to pies z wygladem jelenia niebywale silny i wytrzymaly " +
                "Jest stworem rozumnym, potrafi porozumiewac sie mowa ludzka\n\n " +
                "8 Twoim zleceniem jest zabicie Widlogona " +
                "Nazwano go tak setki lat temu mimo tego ze jego ogon przypomina bardziej miecz " +
                "niz widly... dziwne " +
                "Jest inteligentny i wytrzymaly a jego ogon silny\n\n" +
                "9 Twoim zleceniem jest zabicie Gagulca " +
                "To nie ten z Katdery Notre-Dame " +
                "Niezwykle wytrzymaly i twardy\n\n" +
                "10 Twoim zleceniem jest zabicie Harpii " +
                "Ani to silne, wytrzymale... a napewno nie jest inteligentne\n\n" );
        // alertDialogBuilder.setPositiveButton("OK", null);

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

        alertDialog.getWindow().setLayout(600,850);///przed dodaniem na telefon zmienic na 600/400

    }


    public void onClickStrong(View view) {
        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewStrong);


        //get the value of the text view
        String countString = showCountTextView.getText().toString();

        //convert value to a number and ++
        Integer stronger = Integer.parseInt(countString);
        //  Integer goldd=Integer.parseInt(countString);
       // if (stronger>0) {
            stronger=stronger+10;
            gold = gold - 500000;
            sila=stronger;
            kills++;
            //display the new value int the text view
            showCountTextView.setText(stronger.toString());
       // }
      //  else
       // {
            //Toast.makeText(context, "Nie masz zlota!", Toast.LENGTH_SHORT).show();
       // }
    }

    public void onClickIQ(View view) {
        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewIQ);

        //get the value of the text view
        String countString = showCountTextView.getText().toString();

        //convert value to a number and ++
        Integer inteligencja2 = Integer.parseInt(countString);
        // Integer goldd=Integer.parseInt(countString2);
      //  if (inteligencja2>0) {
            inteligencja2 = inteligencja2 + 10;
            gold = gold - 500000;
            inteligencja=inteligencja2;
            kills++;
            // goldd = gold;
            //display the new value int the text view
            showCountTextView.setText(inteligencja2.toString());

       // }
      //  else
      //  {
            // Toast.makeText(context, "Nie masz zlota!", Toast.LENGTH_SHORT).show();
        //}
    }

    public void onClickHP(View view) {
        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewHP);


        //get the value of the text view
        String countString = showCountTextView.getText().toString();

        //convert value to a number and ++
        Integer HP2 = Integer.parseInt(countString);
        // Integer goldd=Integer.parseInt(countString2);
       // if (HP2>0) {
            HP2 = HP2 + 10;
            gold = gold - 500000;
            wytrzymalosc = HP2;
            kills++;
            //display the new value int the text view
            showCountTextView.setText(HP2.toString());
            //  showCountTextView2.setText(goldd.toString());
       // }
      //  else
      //  {
            // Toast.makeText(context, "Nie masz wojownikow!", Toast.LENGTH_SHORT).show();
    //    }
    }


    public void Quest(View view) {
        String qq = "ZLECENIE";
        final ArrayList<String> BossQuest = new ArrayList<String>();
        BossQuest.add("Chcesz sie podjac walki z Kejranem?");
        BossQuest.add("Chcesz sie podjac walki z Lodowym Gigantem ?");
        BossQuest.add("Chcesz sie podjac walki z Baba cmentarna?");
        BossQuest.add("Chcesz sie podjac walki z Mglakiem?");
        BossQuest.add("Chcesz sie podjac walki z Gryfem ?");
        BossQuest.add("Chcesz sie podjac walki z Zwyiolakiem OGnia ?");
        BossQuest.add("Chcesz sie podjac walki z Biesem ?");
        BossQuest.add("Chcesz sie podjac walki z Mieczo.. znaczy Widlogonem ?");
        BossQuest.add("Chcesz sie podjac walki z Gargulcem ?");
        BossQuest.add("Chcesz sie podjac walki z Harpia ?");
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(qq);


        if(counterM==0)
        {
            alertDialogBuilder.setMessage(BossQuest.get(0));
        }

        if(counterM==1)
        {
            alertDialogBuilder.setMessage(BossQuest.get(1));
        }

        if(counterM==2)
        {
            alertDialogBuilder.setMessage(BossQuest.get(2));
        }

        if(counterM==3)
        {
            alertDialogBuilder.setMessage(BossQuest.get(3));
        }

        if(counterM==4)
        {
            alertDialogBuilder.setMessage(BossQuest.get(4));
        }
        if(counterM==5)
        {
            alertDialogBuilder.setMessage(BossQuest.get(5));
        }
        if(counterM==6)
        {
            alertDialogBuilder.setMessage(BossQuest.get(6));
        }
        if(counterM==7)
        {
            alertDialogBuilder.setMessage(BossQuest.get(7));
        }
        if(counterM==8)
        {
            alertDialogBuilder.setMessage(BossQuest.get(8));
        }
        if(counterM==9)
        {
            alertDialogBuilder.setMessage(BossQuest.get(9));
        }



        if ( wytrzymalosc >= 150 && sila>=150 && counterM==0)
        {
            kills++;

            alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                        /*TextView showCountTextView =
                                (TextView) findViewById(R.id.textViewGold);
                        String countString = showCountTextView.getText().toString();
                        Integer goldd = Integer.parseInt(countString);*/
                    gold = gold + 7000000;
                       /* goldd = gold;
                        showCountTextView.setText(goldd.toString());*/

                    alertDialogBuilder2.setTitle("Zadanie Wykonane");
                    alertDialogBuilder2.setMessage("Pokonales Kejrana!");

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
                    Typeface face = ResourcesCompat.getFont(activity_asasyn.this, R.font.magic);
                    textView.setTextSize(17);
                    textView1.setTextSize(25);
                    textView.setTypeface(face);
                    textView1.setTypeface(face);
                    alertDialog2.getWindow().setLayout(600, 350);

                    // Toast.makeText(activity_afterMenu.this, "Pokonałeś Czerwonego Smoka !!!", Toast.LENGTH_LONG).show();
                    counterM++;
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
            Typeface face = ResourcesCompat.getFont(activity_asasyn.this, R.font.magic);
            textView.setTextSize(17);
            TextView textView2 = (TextView) alertDialog.findViewById(android.R.id.button1);
            textView1.setTextSize(25);
            textView.setTypeface(face);
            textView1.setTypeface(face);
            textView2.setTypeface(face);
            alertDialog.getWindow().setLayout(600, 350);

        }
        else if (wytrzymalosc >= 200 && counterM==1)
        {

            alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                        /*TextView showCountTextView =
                                (TextView) findViewById(R.id.textViewGold);
                        String countString = showCountTextView.getText().toString();
                        Integer goldd = Integer.parseInt(countString);*/
                    gold = gold + 3000000;
                       /*goldd = gold;
                        showCountTextView.setText(goldd.toString());*/

                    alertDialogBuilder2.setTitle("Zadanie Wykonane");
                    alertDialogBuilder2.setMessage("Pokonales Lodowego Giganta !");
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
                    Typeface face = ResourcesCompat.getFont(activity_asasyn.this, R.font.magic);
                    textView.setTextSize(17);
                    textView1.setTextSize(25);
                    textView.setTypeface(face);
                    textView1.setTypeface(face);
                    alertDialog2.getWindow().setLayout(600, 350);
                    counterM++;
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
        else if (wytrzymalosc >= 250 && inteligencja >= 150 && sila >= 200 &&counterM==2)
        {
            alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                       /* TextView showCountTextView =
                                (TextView) findViewById(R.id.textViewGold);
                        String countString = showCountTextView.getText().toString();
                        Integer goldd = Integer.parseInt(countString);*/
                    gold = gold + 10000000;
                       /* goldd = gold;
                        showCountTextView.setText(goldd.toString());*/

                    alertDialogBuilder2.setTitle("Zadanie Wykonane");
                    alertDialogBuilder2.setMessage("Pokonales Babe Cmentarna!");
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
                    Typeface face = ResourcesCompat.getFont(activity_asasyn.this, R.font.magic);
                    textView.setTextSize(17);
                    textView1.setTextSize(25);
                    textView.setTypeface(face);
                    textView1.setTypeface(face);
                    alertDialog2.getWindow().setLayout(600, 350);
                    counterM++;
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

        }/////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (wytrzymalosc >= 300 && sila >= 250 && counterM==3)
        {

            alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                       /* TextView showCountTextView =
                                (TextView) findViewById(R.id.textViewGold);
                        String countString = showCountTextView.getText().toString();
                        Integer goldd = Integer.parseInt(countString);*/
                    gold = gold + 7000000;
                      /*  goldd = gold;
                        showCountTextView.setText(goldd.toString());*/

                    alertDialogBuilder2.setTitle("Zadanie Wykonane");
                    alertDialogBuilder2.setMessage("Pokonales Mglaka!");
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
                    Typeface face = ResourcesCompat.getFont(activity_asasyn.this, R.font.magic);
                    textView.setTextSize(17);
                    textView1.setTextSize(25);
                    textView.setTypeface(face);
                    textView1.setTypeface(face);
                    alertDialog2.getWindow().setLayout(600, 350);
                    counterM++;
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

        }///////////////////////////////////////////////////////////////
        else if (sila >= 300 && inteligencja >= 200 && counterM==4)
        {


            alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                      /*  TextView showCountTextView =
                                (TextView) findViewById(R.id.textViewGold);
                        String countString = showCountTextView.getText().toString();
                        Integer goldd = Integer.parseInt(countString);*/
                    gold = gold + 7000000;
                        /*goldd = gold;
                        showCountTextView.setText(goldd.toString());*/

                    alertDialogBuilder2.setTitle("Zadanie wykonane");
                    alertDialogBuilder2.setMessage("Pokonales Gryfa");
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
                    Typeface face = ResourcesCompat.getFont(activity_asasyn.this, R.font.magic);
                    textView.setTextSize(17);
                    textView1.setTextSize(25);
                    textView.setTypeface(face);
                    textView1.setTypeface(face);
                    alertDialog2.getWindow().setLayout(600, 350);
                    counterM++;
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
            alertDialog.getWindow().setLayout(600, 350);
        }
        else if (wytrzymalosc >= 350 && sila >= 350 && inteligencja >= 250 && counterM==5)
        {

            alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    /*TextView showCountTextView =
                            (TextView) findViewById(R.id.textViewGold);
                    String countString = showCountTextView.getText().toString();
                    Integer goldd = Integer.parseInt(countString);*/
                    gold = gold + 10000000;
                  /*  goldd = gold;
                    showCountTextView.setText(goldd.toString());*/

                    alertDialogBuilder2.setTitle("Zadanie Wykonane");
                    alertDialogBuilder2.setMessage("Pokonales Zywiolaka!");
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
                    Typeface face = ResourcesCompat.getFont(activity_asasyn.this, R.font.magic);
                    textView.setTextSize(17);
                    textView1.setTextSize(25);
                    textView.setTypeface(face);
                    textView1.setTypeface(face);
                    alertDialog2.getWindow().setLayout(600, 350);
                    counterM++;
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
        else if (wytrzymalosc >= 400 && sila >= 400 && counterM==6)
        {

            alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                   /* TextView showCountTextView =
                            (TextView) findViewById(R.id.textViewGold);
                    String countString = showCountTextView.getText().toString();
                    Integer goldd = Integer.parseInt(countString);*/
                    gold = gold + 7000000;
                  /*  goldd = gold;
                    showCountTextView.setText(goldd.toString());*/

                    alertDialogBuilder2.setTitle("Zadanie Wykonane");
                    alertDialogBuilder2.setMessage("Pokonales Biesa!");
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
                    Typeface face = ResourcesCompat.getFont(activity_asasyn.this, R.font.magic);
                    textView.setTextSize(17);
                    textView1.setTextSize(25);
                    textView.setTypeface(face);
                    textView1.setTypeface(face);
                    alertDialog2.getWindow().setLayout(600, 350);
                    counterM++;
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
        else if (inteligencja >= 300 && wytrzymalosc >= 450 && sila >= 450 && counterM==7)
        {

            alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                   /* TextView showCountTextView =
                            (TextView) findViewById(R.id.textViewGold);
                    String countString = showCountTextView.getText().toString();
                    Integer goldd = Integer.parseInt(countString);*/
                    gold = gold + 10000000;
                   /* goldd = gold;
                    showCountTextView.setText(goldd.toString());*/

                    alertDialogBuilder2.setTitle("Zadanie Wykonane");
                    alertDialogBuilder2.setMessage("Pokonales Widlogona");
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
                    Typeface face = ResourcesCompat.getFont(activity_asasyn.this, R.font.magic);
                    textView.setTextSize(17);
                    textView1.setTextSize(25);
                    textView.setTypeface(face);
                    textView1.setTypeface(face);
                    alertDialog2.getWindow().setLayout(600, 350);
                    counterM++;
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
        else if (wytrzymalosc >= 500 && counterM==8)
        {

            alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                   /* TextView showCountTextView =
                            (TextView) findViewById(R.id.textViewGold);
                    String countString = showCountTextView.getText().toString();
                    Integer goldd = Integer.parseInt(countString);*/
                    gold = gold + 3000000;
                    /*goldd = gold;
                    showCountTextView.setText(goldd.toString());*/

                    alertDialogBuilder2.setTitle("Zadanie Wykonane");
                    alertDialogBuilder2.setMessage("Pokonales Gargulca!");
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
                    Typeface face = ResourcesCompat.getFont(activity_asasyn.this, R.font.magic);
                    textView.setTextSize(17);
                    textView1.setTextSize(25);
                    textView.setTypeface(face);
                    textView1.setTypeface(face);
                    alertDialog2.getWindow().setLayout(600, 350);
                    counterM++;
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
        else if (counterM==9)
        {

            alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    /*TextView showCountTextView =
                            (TextView) findViewById(R.id.textViewGold);
                    String countString = showCountTextView.getText().toString();
                    Integer goldd = Integer.parseInt(countString);*/
                    gold = gold + 7777777;
                   /* goldd = gold;
                    showCountTextView.setText(goldd.toString());*/

                    alertDialogBuilder2.setTitle("Zadanie Wykonane");
                    alertDialogBuilder2.setMessage("Pokonales Harpie!");
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
                    Typeface face = ResourcesCompat.getFont(activity_asasyn.this, R.font.magic);
                    textView.setTextSize(17);
                    textView1.setTextSize(25);
                    textView.setTypeface(face);
                    textView1.setTypeface(face);
                    alertDialog2.getWindow().setLayout(600, 350);
                    counterM++;
                    counterM++;
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

        else if(counterM >9)
        {
            Toast.makeText(activity_asasyn.this, "Brak nowych zlecen !!!", Toast.LENGTH_LONG).show();
        }
        else
        {

            alertDialogBuilder2.setTitle("Uwaga");
            alertDialogBuilder2.setMessage("Nie spelniasz wymagan zlecenia");

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
            Typeface face= ResourcesCompat.getFont(activity_asasyn.this,R.font.magic);
            textView.setTextSize(17);
            textView1.setTextSize(25);
            textView.setTypeface(face);
            textView1.setTypeface(face);
            alertDialog2.getWindow().setLayout(600,350);
        }


    }



}
