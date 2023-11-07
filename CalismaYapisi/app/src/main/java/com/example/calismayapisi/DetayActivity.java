package com.example.calismayapisi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.calismayapisi.databinding.ActivityDetayBinding;

public class DetayActivity extends AppCompatActivity {
    private ActivityDetayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String gelenAd = getIntent().getStringExtra("ad");
        Integer gelenYas = getIntent().getIntExtra("yas", 0);
        Double gelenBoy = getIntent().getDoubleExtra("boy", 0.0);
        Boolean gelenBekar = getIntent().getBooleanExtra("bekar", false);

        binding.textViewDetay.setText("Gelen isim = " + gelenAd + " gelen yaş = " + gelenYas + " gelen boy = " + gelenBoy + " gelen bekar = " + gelenBekar);
    }
}