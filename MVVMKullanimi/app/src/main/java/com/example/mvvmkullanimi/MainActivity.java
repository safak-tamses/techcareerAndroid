package com.example.mvvmkullanimi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.mvvmkullanimi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.sonuc.observe(this,s -> {
            binding.textViewSonuc.setText(s);
        });



        binding.buttonToplama.setOnClickListener(v -> {
            String alinanSayi1 = binding.editTextSayi1.getText().toString();
            String alinanSayi2 = binding.editTextSayi2.getText().toString();


            viewModel.topla(alinanSayi1,alinanSayi2);


        });
        binding.buttonCarpma.setOnClickListener(v -> {
            String alinanSayi1 = binding.editTextSayi1.getText().toString();
            String alinanSayi2 = binding.editTextSayi2.getText().toString();

            viewModel.carpma(alinanSayi1,alinanSayi2);

        });
    }
}