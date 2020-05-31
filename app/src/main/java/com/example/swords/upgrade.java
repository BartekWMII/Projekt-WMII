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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class upgrade extends AppCompatActivity {

    private TextView textViewSkarb;
    private TextView textViewKosz;
    private TextView textViewKop;
    private TextView textViewIleStal;
    private TextView textViewAwans;
    public static int miastoSkarb,miastoKoszary,miastoKopalnia,miastoAwans,stalimp;
    public static int stal=50;
    private Button button,button2,button3;
    public static int KwiatMiasta=0;
    public static int DrzewoMiasta=0;
    boolean SprCityA=false, SprCityB=false;
    boolean SprStal=false;
    public static int bezpiecznik,licznik,kontrolka,counterQ;
    public static String UpCityA, UpCityB, UpCityC, UpCityD, UpCityStal;
    Context context = this;

    @Override
    protected void onPause() {
        super.onPause();
        KwiatMiasta++;
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("daneA", textViewSkarb.getText().toString());
        editor.putString("daneB", textViewKosz.getText().toString());
        editor.putString("daneC", textViewKop.getText().toString());
        editor.putString("daneD", textViewAwans.getText().toString());
        editor.putString("daneS",textViewIleStal.getText().toString());
        editor.putInt("kwiat3", KwiatMiasta);
        editor.commit();
    }

    @Override
    protected void onResume () {
        super.onResume();

        if(KwiatMiasta>0)
        {
            super.onResume();
            SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
            DrzewoMiasta = sharedPref.getInt("kwiat3", 1);
            UpCityA = sharedPref.getString("daneA", "");
            UpCityB = sharedPref.getString("daneB", "");
            UpCityC = sharedPref.getString("daneC", "");
            UpCityD= sharedPref.getString("daneD", "");
            UpCityStal = sharedPref.getString("daneS", "");

            KwiatMiasta = DrzewoMiasta;

            TextView showCountTextView = (TextView) findViewById(R.id.textViewSkarb);
            TextView showCountTextView2 = (TextView) findViewById(R.id.textViewKoszar);
            TextView showCountTextView3 = (TextView) findViewById(R.id.textViewKop);
            TextView showCountTextView4 = (TextView) findViewById(R.id.textViewAwans);
            TextView showCountTextView5 = (TextView) findViewById(R.id.textViewIleStal);
            stalimp=getIntent().getIntExtra("Stal",stal);

            try {
                miastoSkarb = Integer.parseInt(UpCityA);
                miastoKoszary = Integer.parseInt(UpCityB);
                miastoKopalnia = Integer.parseInt(UpCityC);
                miastoAwans = Integer.parseInt(UpCityD);
                stal = Integer.parseInt(UpCityStal)+stalimp;

            } catch (NumberFormatException e) {
                // e.printStackTrace();
            }

            showCountTextView.setText(String.valueOf(miastoSkarb));
            showCountTextView2.setText(String.valueOf(miastoKoszary));
            showCountTextView3.setText(String.valueOf(miastoKopalnia));
            showCountTextView4.setText(String.valueOf(miastoAwans));
            showCountTextView5.setText(String.valueOf(stal));

            KwiatMiasta++;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_upgrade);

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

        Integer miastoStringSkarb = Integer.parseInt(countString);
        Integer miastoStringKoszary = Integer.parseInt(countStringb);
        Integer miastoStringKopalnia = Integer.parseInt(countStringc);
        Integer miastoStringAwans = Integer.parseInt(countStringd);
        Integer stalinium = Integer.parseInt(countStal);

        stalimp=getIntent().getIntExtra("Stal",stal);
        miastoStringSkarb=miastoSkarb;
        miastoStringKoszary=miastoKoszary;
        miastoStringKopalnia=miastoKopalnia;
        miastoStringAwans=miastoAwans;
        stalinium=stal+stalimp;

        showCountTextView.setText(miastoStringSkarb.toString());
        showCountTextViewKosz.setText(miastoStringKoszary.toString());
        showCountTextViewKop.setText(miastoStringKopalnia.toString());
        showCountTextViewAwans.setText(miastoStringAwans.toString());
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
        Intent intent = new Intent(this, secret.class);
        startActivity(intent);
    }

    public void moveToSettings(View view)
    {
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }

    public void onBackPressed()
    {
        //zablokowane
    }

    private void moveToKing()
    {
        Intent intent = new Intent(this, afterMenu.class);
        intent.putExtra("skarb",miastoSkarb);
        intent.putExtra("kosz",miastoKoszary);
        intent.putExtra("kop",miastoKopalnia);
        intent.putExtra("awan",miastoAwans);
        intent.putExtra("StalZ",SprStal);
        intent.putExtra("Stal", stal);
        startActivity(intent);
    }

    public void miastoClick(View view) {

        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewSkarb);
        TextView showCountTextView2 =
                (TextView) findViewById(R.id.textViewIleStal);

        int sprM=miastoSkarb;
        if ((((sprM+1)*10)+5)>=stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*(sprM+1))-5;
            miastoSkarb++;
            String miastostringSkarb=Integer.toString(miastoSkarb);
            showCountTextView.setText(miastostringSkarb);
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

        int sprM=miastoKoszary;
        if ((((sprM+1)*10)+5)>=stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*(sprM+1))-5;
            miastoKoszary++;
            SprCityB=true;
            String miastostringKoszary=Integer.toString(miastoKoszary);
            showCountTextView.setText(miastostringKoszary);
            String Bim=Integer.toString(stal);
            showCountTextView2.setText(Bim);

        }
    }

    public void KopUp(View view) {

        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewKop);
        TextView showCountTextView2 =
                (TextView) findViewById(R.id.textViewIleStal);

        int sprM=miastoKopalnia;
        if ((((sprM+1)*10)+5)>=stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*(sprM+1))-5;
            miastoKopalnia++;
            SprCityB=true;
            String miastostringKopalnia=Integer.toString(miastoKopalnia);
            showCountTextView.setText(miastostringKopalnia);
            String Bim=Integer.toString(stal);
            showCountTextView2.setText(Bim);
        }
    }

    public void OnCliAwan(View view) {
        TextView showCountTextView =
                (TextView) findViewById(R.id.textViewAwans);
        TextView showCountTextView2 =
                (TextView) findViewById(R.id.textViewIleStal);

        int sprM=miastoAwans;
        if ((((sprM+1)*10)+5)>=stal)
        {
            Toast.makeText(context, "Brakuje stali!", Toast.LENGTH_SHORT).show();
        }
        else{
            stal=stal-(10*(sprM+1))-5;
            miastoAwans++;
            SprCityB=true;
            String miastostringAwans=Integer.toString(miastoAwans);
            showCountTextView.setText(miastostringAwans);
            String Bim=Integer.toString(stal);
            showCountTextView2.setText(Bim);
        }
    }

    public void HelpDesk(View view)
    {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Pomoc");
        alertDialogBuilder.setMessage("Za zakonczenie zadania sukcesem otrzymujemy 250 000 zlota\n\n" +
                "Za przegrane zadanie tracimy 150 000 zlota oraz 150 zolnierzy\n\n" +
                "Co 7 zadan jest pobierany podatek 100 000\n\n"+
                "Zolnierzy mozemy werbowac po 100 osób za 100 000 zlota\n\n" +
                "Pamietaj o tym że smoki rodzą się na nowo jeśli wyjdziesz z gry, natomiast wszystkie inne postępy zostają zachowane\n\n\n" +
                "Smoki:\n\n" +
                "Aby walczyc z Czerwonym Smokiem potrzebujemy 3 000 000 zlota oraz 5500 zolnierzy, za wygrana otrzymujemy 500 000 zlota, a za przegrana tracimy 1000 zolnierzy\n\n" +
                "Aby walczyc z Zielonym Smokiem potrzebujemy 5 000 000 zlota oraz 6500 zolnierzy, za wygrana otrzymujemy 1 000 000 zlota, a za przegrana tracimy 1500 zolnierzy\n\n" +
                "Aby walczyz z Rubinowym Smokiem potrzebujemy 8 000 000 zlota oraz 7500 zolnierzy, za wygrana otrzymujemy 2 000 000 zlota, a za przegrana tracimy 2000 zolnierzy\n\n" +
                "Aby walczyc z Platynowym Smokiem potrzebujemy 12 500 000 zlota oraz 8500 zolnierzy, za wygrana otrzymujemy 2 500 000 zlota, a za przegrana tracimy 2500 zolnierzy\n\n" +
                "Aby walczyc z Bialym Smokiem potrzebujmemy 20 000 000 zlota oraz 10 000 zolnierzy, za wygrana otrzymujemy 10 000 000 zlota, oraz kod do tajemniczej komnaty, a za przegraną tracimy 5000 zolnierzy\n\n\n"+
                "Ulepszenia w miescie: \n\n"+
                "Ulepszenie skarbca = Każde ulepszenie skarbca zwiększa naszą nagrodę za wygraną misję oraz zmniejsza karę za przegraną misje które odnoszą się do złota ora zmniejsza podatki\n\n" +
                "Ulepszenie Koszar = Zmniejsza kare za przegrane misje które odnoszą się do wojska/armii\n\n" +
                "Ulepszenie Kopalni = Zwiększa ilość stali otrzymywanej za mniej prawdopodobne wygranie misji\n\n" +
                "Zdobycie Awansu = Zwiększa ilość złota zarabianego poprzez przycisk pracuj\n\n" +
                "Koszty ulepszen: \n\n" +
                "Koszt Stali=(Poziom Ulepszenia*10)+5\n\n" +
                "Koszt werbunku zolnierzy= -100+1*Poziom Ulepszenia Koszar\n\n" +
                "Koszt awansu = +5000+50*Poziom Ulepszenia Awansu"
        );

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

        alertDialog.getWindow().setLayout(600,850);
    }


}
