package com.example.widgetkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.widgetkullanimi.databinding.ActivityMainBinding;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private boolean kontrol = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonOku.setOnClickListener(v -> {
            String alinanVeri = binding.editTextGirdi.getText().toString();
            binding.textViewSonuc.setText(alinanVeri);
        });

        binding.buttonResim1.setOnClickListener(v -> {
            binding.imageView.setImageResource(R.drawable.resim1);
        });
        binding.button2Resim2.setOnClickListener(v -> {
            binding.imageView.setImageResource(getResources().getIdentifier("resim2", "drawable", getPackageName()));
        });

        binding.buttonBasla.setOnClickListener(v -> {
            binding.progressBar.setVisibility(View.VISIBLE);
        });

        binding.buttonDur.setOnClickListener(v -> {
            binding.progressBar.setVisibility(View.INVISIBLE);
        });

        binding.switch1.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if (isChecked) {
                Log.e("Sonuç", "Switch : ON");
            } else {
                Log.e("Sonuç", "Switch : OFF");
            }
        }));
        binding.toogleButton.addOnButtonCheckedListener((((group, checkedId, isChecked) -> {
            kontrol = isChecked;
            if (kontrol) {
                Button secilen = findViewById(binding.toogleButton.getCheckedButtonId());
                String buttonYazi = secilen.getText().toString();
                Log.e("Sonuç :", buttonYazi);
            }

        })));

        ArrayList<String> ulkeler = new ArrayList<>();
        ulkeler.add("Türkiye");
        ulkeler.add("İtalya");
        ulkeler.add("Japonya");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ulkeler);
        binding.autoCompleteTextView.setAdapter(arrayAdapter);


        binding.textViewSlider.setText("Slide : " + binding.slider.getProgress());

        binding.slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.textViewSlider.setText("Slider : " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.buttonSaat.setOnClickListener(v -> {
            MaterialTimePicker timePicker = new MaterialTimePicker.Builder()
                    .setTitleText("Saat Seç")
                    .setTimeFormat(TimeFormat.CLOCK_24H)
                    .build();
            timePicker.show(getSupportFragmentManager(), "");

            timePicker.addOnPositiveButtonClickListener(v1 -> {
                binding.editTextTextSaat.setText(timePicker.getHour() + ":" + timePicker.getMinute());
            });
        });
        binding.buttonTarih.setOnClickListener(v -> {
            MaterialDatePicker datePicker = MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Tarih seç")
                    .build();
            datePicker.show(getSupportFragmentManager(), "");

            datePicker.addOnPositiveButtonClickListener(v1 -> {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String tarih = simpleDateFormat.format(v1);
                binding.editTextTarih.setText(tarih);
            });
        });


        binding.buttonGoster.setOnClickListener(v -> {
            Log.e("Sonuç", "Switch durum  : " + binding.switch1.isChecked());
            if (kontrol) {
                Button secilen = findViewById(binding.toogleButton.getCheckedButtonId());
                String buttonYazi = secilen.getText().toString();
                Log.e("Sonuç :", "Toggle Durum : " + buttonYazi);
            }
            String ulke = binding.autoCompleteTextView.getText().toString();
            Log.e("Sonuç", "Ülke : " + ulke);
            Log.e("Sonuç", "Slider : " + binding.slider.getProgress());
        });


    }
}