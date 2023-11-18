package com.example.hiltkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Kargo kargo;
    Internet internet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kargo = new Kargo();
        kargo.gonder();

        internet = new Internet();
        internet.basvuruYap();
    }
}