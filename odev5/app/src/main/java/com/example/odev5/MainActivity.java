package com.example.odev5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.odev5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private boolean kontrol = false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button1.setOnClickListener(v -> {
            binding.editTextSonuc.setText(binding.editTextSonuc.getText().toString() + 1);
        });
        binding.button2.setOnClickListener(v -> {
            binding.editTextSonuc.setText(binding.editTextSonuc.getText().toString() + 2);
        });
        binding.button3.setOnClickListener(v -> {
            binding.editTextSonuc.setText(binding.editTextSonuc.getText().toString() + 3);
        });
        binding.button4.setOnClickListener(v -> {
            binding.editTextSonuc.setText(binding.editTextSonuc.getText().toString() + 4);
        });
        binding.button5.setOnClickListener(v -> {
            binding.editTextSonuc.setText(binding.editTextSonuc.getText().toString() + 5);
        });
        binding.button6.setOnClickListener(v -> {
            binding.editTextSonuc.setText(binding.editTextSonuc.getText().toString() + 6);
        });
        binding.button7.setOnClickListener(v -> {
            binding.editTextSonuc.setText(binding.editTextSonuc.getText().toString() + 7);
        });
        binding.button8.setOnClickListener(v -> {
            binding.editTextSonuc.setText(binding.editTextSonuc.getText().toString() + 8);
        });
        binding.button9.setOnClickListener(v -> {
            binding.editTextSonuc.setText(binding.editTextSonuc.getText().toString() + 9);
        });
        binding.buttonTopla.setOnClickListener(v -> {
            if (binding.editTextSonuc.getText().toString().equals("")) {

            } else {
                binding.editTextSonuc.setText(binding.editTextSonuc.getText().toString() + "+");
            }
        });
        binding.buttonSil.setOnClickListener(v -> {
            if (binding.editTextSonuc.getText().toString().equals("")) {

            } else {
                binding.editTextSonuc.setText(binding.editTextSonuc.getText().toString().substring(0, binding.editTextSonuc.getText().toString().length() - 1));
            }
        });
        binding.buttonSifirla.setOnClickListener(v -> {
            if (binding.editTextSonuc.getText().toString().equals("")) {

            } else {
                binding.editTextSonuc.setText("");
            }
        });
        binding.buttonSonuc.setOnClickListener(v -> {
            if (binding.editTextSonuc.getText().toString().equals("")) {

            } else {
                String mevcutString = binding.editTextSonuc.getText().toString();
                char sonHarf = mevcutString.charAt(mevcutString.length() - 1);
                if (sonHarf == '+') {

                } else {

                    String[] sayilar = mevcutString.split("\\+");
                    int toplam = 0;
                    for (String sayi : sayilar) {
                        int sayiInt = Integer.parseInt(sayi);
                        toplam += sayiInt;
                    }
                    binding.editTextSonuc.setText(String.valueOf(toplam));
                }
            }
        });
    }
}