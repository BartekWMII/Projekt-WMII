package com.example.helikoptery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activity_city_upgrade extends AppCompatActivity {

    public int miasto=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_upgrade);
    }

    public void miastoClick(View view) {
        miasto=miasto+1;
        
    }
}
