package com.example.helikoptery;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activity_city_upgrade extends AppCompatActivity {

    public int miasto=1;
    private Button button;
    public static int gold,gold6;
    public static int army6,army;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_upgrade);

        button=findViewById(R.id.SecretButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToSecret();
            }
        });
        gold6=getIntent().getIntExtra("Gold",gold);///gold przeniesiony z aftermenu activity
        army6=getIntent().getIntExtra("Armia",army);///armia przeniesiona z aftermenu activity

        TextView showCountTextView = (TextView) findViewById(R.id.textViewGoldCity);
        String countString = showCountTextView.getText().toString();
        Integer gold = Integer.parseInt(countString);
        gold = 0+gold6 ;
        showCountTextView.setText(gold.toString());
    }

    private void moveToSecret()
    {
        Intent intent = new Intent(this,secret.class);
        intent.putExtra("Gold2",gold6);
        intent.putExtra("Armia2",army6);
        startActivity(intent);
    }
    public void miastoClick(View view) {
        miasto=miasto+1;

    }
}