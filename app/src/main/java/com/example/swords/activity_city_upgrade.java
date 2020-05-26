package com.example.swords;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class activity_city_upgrade extends AppCompatActivity {

    private TextView textViewSkarb;
    private TextView textViewKosz;
    private TextView textViewKop;
    private TextView textViewIleStal;
    private TextView textViewAwans;
    public static int miastoa;
    public static int miastoimpa;
    public static int miastob;
    public static int miastoimpb;
    public static int miastoc;
    public static int miastoimpc;
    public static int miastod;
    public static int miastoimpd;
    public static int stal=50;
    public static int stalimp;
    private Button button,button2,button3;
    public static int goldKing,goldCity;
    public static int awansLVL;
    public static int armyCity,armyKing;
    public static int KwiatMiasta=0;
    public static int DrzewoMiasta=0;
    public static int kontrol=0;
    public static int licznikQ=0;
    boolean SprCityA=false, SprCityAImp=false, SprCityBImp=false, SprCityB=false, SprCityCImp=false, SprCityC=false, SprArmyImp=false, SprArmy=false, SprGold=false, SprGoldImp=false;
    boolean SprStal=false, SprStalImp=false;
    public static int bezpiecznik,licznik,kontrolka,counterQ,CityA,CityB,CityC;
    public static String UpCityA, UpCityB, UpCityC, UpCityD, UpCityStal;

    Context context = this;

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("daneA", textViewSkarb.getText().toString());
        editor.putString("daneB", textViewKosz.getText().toString());
        editor.putString("daneC", textViewKop.getText().toString());
        editor.putString("daneD", textViewAwans.getText().toString());
        editor.putString("daneS",textViewIleStal.getText().toString());
        editor.putInt("kwiat3", KwiatMiasta);
        KwiatMiasta++;
        Toast.makeText(activity_city_upgrade.this, "DzialaPauza " + UpCityA + " " + UpCityB+" "+" "+ UpCityC+" "+" st: "+UpCityStal+ " " +KwiatMiasta, Toast.LENGTH_LONG).show();
        editor.commit();

    }


    @Override
    protected void onResume () {
        super.onResume();
        // Toast.makeText(activity_afterMenu.this, kwiat, Toast.LENGTH_LONG).show();

        if(KwiatMiasta>0)
        {
            super.onResume();
            SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
            DrzewoMiasta = sharedPref.getInt("kwiat3", 1);
            UpCityA = sharedPref.getString("daneA", ""); // Tekst zapisujemy do zmiennej globalnej i w metodzie OnCreate() przypisujemy do odpowiedniej kontrolki EditText: editText.setText(txt);
            UpCityB = sharedPref.getString("daneB", ""); // Tekst zapisujemy do zmiennej globalnej i w metodzie OnCreate() przypisujemy do odpowiedniej kontrolki EditText: editText.setText(txt);
            UpCityC = sharedPref.getString("daneC", "");
            UpCityD= sharedPref.getString("daneD", "");
            UpCityStal = sharedPref.getString("daneS", "");

            KwiatMiasta = DrzewoMiasta;

            Toast.makeText(activity_city_upgrade.this, "Dziala wznowienie: " + UpCityA + " Kasztany: " + UpCityB + " kopalnie: "+ UpCityC + " Awanse: " + UpCityD + " staL: " +UpCityStal, Toast.LENGTH_LONG).show();

            TextView showCountTextView = (TextView) findViewById(R.id.textViewSkarb);
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewKoszar);
            TextView showCountTextView3 = (TextView) findViewById(R.id.textViewKop);
            TextView showCountTextView4 = (TextView) findViewById(R.id.textViewAwans);
            TextView showCountTextView5 = (TextView) findViewById(R.id.textViewIleStal);
            stalimp=getIntent().getIntExtra("Stal",stal);


            try {
                miastoa = Integer.parseInt(UpCityA);
                miastob = Integer.parseInt(UpCityB);
                miastoc = Integer.parseInt(UpCityC);
                miastod = Integer.parseInt(UpCityD);
                stal = Integer.parseInt(UpCityStal)+stalimp;


            } catch (NumberFormatException e) {
                // e.printStackTrace();
            }

            Toast.makeText(context, "Jeszcze nie wpisałem", Toast.LENGTH_SHORT).show();
            showCountTextView.setText(String.valueOf(miastoa));
            showCountTextView2.setText(String.valueOf(miastob));
            showCountTextView3.setText(String.valueOf(miastoc));
            showCountTextView4.setText(String.valueOf(miastod));
            showCountTextView5.setText(String.valueOf(stal));
            Toast.makeText(context, "Juz wpisałem",Toast.LENGTH_SHORT).show();



            Toast.makeText(context, "Tyle stali: "+stal, Toast.LENGTH_SHORT).show();

            KwiatMiasta++;
        }


        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_city_upgrade);

        KwiatMiasta++;

        textViewSkarb = findViewById(R.id.textViewSkarb);
        textViewKosz = findViewById(R.id.textViewKoszar);
        textViewKop= findViewById(R.id.textViewKop);
        textViewIleStal = findViewById(R.id.textViewIleStal);
        textViewAwans = findViewById(R.id.textViewAwans);

        setContentView(R.layout.activity_city_upgrade);
        bezpiecznik = getIntent().getIntExtra("Kod", licznik);
        kontrolka = getIntent().getIntExtra("kontrola", counterQ);

        button=findViewById(R.id.SecretButton);
        button2=findViewById(R.id.KingBack);
        button3=findViewById(R.id.settingsButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToSecret();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToKing();
            }
        });


        TextView showCountTextView = (TextView) findViewById(R.id.textViewSkarb);
        TextView showCountTextViewKosz=(TextView) findViewById(R.id.textViewKoszar);
        TextView showCountTextViewKop=(TextView) findViewById(R.id.textViewKop);
        TextView showCountTextViewAwans=(TextView) findViewById(R.id.textViewAwans);
        TextView showStal=(TextView) findViewById(R.id.textViewIleStal);

        String countString = showCountTextView.getText().toString();
        String countStringb = showCountTextViewKosz.getText().toString();
        String countStringc = showCountTextViewKop.getText().toString();
        String countStringd = showCountTextViewAwans.getText().toString();
        String countStal =  showStal.getText().toString();

        Integer miastoSa = Integer.parseInt(countString);
        Integer miastoSb = Integer.parseInt(countStringb);
        Integer miastoSc = Integer.parseInt(countStringc);
        Integer miastoSd = Integer.parseInt(countStringd);
        Integer stalinium = Integer.parseInt(countStal);

        stalimp=getIntent().getIntExtra("Stal",stal);
        miastoSa=miastoa;
        miastoSb=miastob;
        miastoSc=miastoc;
        miastoSd=miastod;
        stalinium=stal+stalimp;

        showCountTextView.setText(miastoSa.toString());
        showCountTextViewKosz.setText(miastoSb.toString());
        showCountTextViewKop.setText(miastoSc.toString());
        showCountTextViewAwans.setText(miastoSd.toString());
        showStal.setText(stalinium.toString());

        textViewSkarb=findViewById(R.id.textViewSkarb);
        textViewKosz=findViewById(R.id.textViewKoszar);
        textViewKop=findViewById(R.id.textViewKop);
        textViewAwans=findViewById(R.id.textViewAwans);
        textViewIleStal=findViewById(R.id.textViewIleStal);

        KwiatMiasta++;
        stal=stalimp+stal;
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewIleStal);
            String Bim = Integer.toString(stal);
            showCountTextView2.setText(Bim);

    }



    private void moveToSecret()
    {
        Intent intent = new Intent(this,secret.class);
        startActivity(intent);
    }

    public void moveToSettings(View view)
    {
        Intent intent = new Intent(this,activity_settings.class);
        startActivity(intent);
    }

    public void onBackPressed()
    {
        //Intent intent = new Intent(getApplicationContext(),activity_menu.class);
        // startActivity(intent);
        //activity_afterMenu.super.onBackPressed();
        //super.onBackPressed();
    }

   /* public void moveToKiller(View view)
    {
        Intent intent = new Intent(this,activity_asasyn.class);
        intent.putExtra("Gold7",goldCity);
        startActivity(intent);
    }*/


    private void moveToKing()
    {
     //   licznikQ++;
        Intent intent = new Intent(this,activity_afterMenu.class);//po co tu jest tyle tego ?????
        intent.putExtra("skarb",miastoa);
        intent.putExtra("kosz",miastob);
        intent.putExtra("kop",miastoc);
        intent.putExtra("awan",miastod);
        intent.putExtra("StalZ",SprStal);
        intent.putExtra("Stal", stal);
        startActivity(intent);
    }

    public void miastoClick(View view) {

        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewSkarb);
        TextView showCountTextView2 =
                (TextView) findViewById(R.id.textViewIleStal);

        int sprM=miastoa;
        if ((((sprM+1)*10)+5)>=stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*miastoa)-5;
            miastoa++;
            String miastostringa=Integer.toString(miastoa);
            showCountTextView.setText(miastostringa);
            SprCityA=true;
            String Bim=Integer.toString(stal);
            showCountTextView2.setText(Bim);
        }
    }

    public void GarnUp(View view) {

        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewKoszar);
        TextView showCountTextView2 =
                (TextView) findViewById(R.id.textViewIleStal);

        int sprM=miastob;
        if ((((sprM+1)*10)+5)>=stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*miastob)-5;
            miastob++;
            SprCityB=true;
            String miastostringb=Integer.toString(miastob);
            showCountTextView.setText(miastostringb);
            String Bim=Integer.toString(stal);
            showCountTextView2.setText(Bim);

        }
    }

    public void KopUp(View view) {

        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewKop);
        TextView showCountTextView2 =
                (TextView) findViewById(R.id.textViewIleStal);


        int sprM=miastoc;
        if ((((sprM+1)*10)+5)>=stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*miastoc)-5;
            miastoc++;
            SprCityB=true;
            String miastostringc=Integer.toString(miastoc);
            showCountTextView.setText(miastostringc);
            String Bim=Integer.toString(stal);
            showCountTextView2.setText(Bim);
        }
    }

    public void HelpDesk(View view)
    {

        // new AlertDialog.Builder(this)
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Pomoc");
        alertDialogBuilder.setMessage("Na start otrzymujemy 2 000 000 zlota oraz 5000 zolnierzy\n\n" +
                "Za zakonczenie zadania sukcesem otrzymujemy 250 000 zlota\n\n" +
                "Za przegraną tracimy 150 000 zlota oraz 150 zolnierzy\n\n" +
                "Zolnierzy mozemy werbowac po 100 osób za 100 000 zlota\n\n" +
                "Smoki:\n\n" +
                "Aby walczyc z Czerwonym Smokiem potrzebujemy 3 000 000 zlota oraz 5500 zolnierzy, za wygrana otrzymujemy 500 000 zlota, a za przegrana tracimy 1000 zolnierzy\n\n" +
                "Aby walczyc z Zielonym Smokiem potrzebujemy 5 000 000 zlota oraz 6500 zolnierzy, za wygrana otrzymujemy 1 000 000 zlota, a za przegrana tracimy 1500 zolnierzy\n\n" +
                "Aby walczyz z Rubinowym Smokiem potrzebujemy 8 000 000 zlota oraz 7500 zolnierzy, za wygrana otrzymujemy 2 000 000 zlota, a za przegrana tracimy 2000 zolnierzy\n\n" +
                "Aby walczyc z Platynowym Smokiem potrzebujemy 12 500 000 zlota oraz 8500 zolnierzy, za wygrana otrzymujemy 2 500 000 zlota, a za przegrana tracimy 2500 zolnierzy\n\n" +
                "Aby walczyc z Bialym Smokiem potrzebujmemy 20 000 000 zlota oraz 10 000 zolnierzy, za wygrana otrzymujemy 10 000 000 zlota, oraz kod do tajemniczej komnaty, a za przegraną tracimy 5000 zolnierzy");
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

    public void OnCliAwan(View view) {
        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewAwans);
        TextView showCountTextView2 =
                (TextView) findViewById(R.id.textViewIleStal);

        int sprM=miastod;
        if ((((sprM+1)*10)+5)>=stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*miastod)-5;
            miastod++;
            SprCityB=true;
            String miastostringc=Integer.toString(miastod);
            showCountTextView.setText(miastostringc);
            String Bim=Integer.toString(stal);
            showCountTextView2.setText(Bim);
        }
    }
}
