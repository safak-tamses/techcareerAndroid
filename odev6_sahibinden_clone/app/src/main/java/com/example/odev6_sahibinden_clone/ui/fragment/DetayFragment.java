package com.example.odev6_sahibinden_clone.ui.fragment;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev6_sahibinden_clone.R;
import com.example.odev6_sahibinden_clone.data.entity.Arabalar;
import com.example.odev6_sahibinden_clone.databinding.FragmentDetayBinding;

public class DetayFragment extends Fragment {
    private FragmentDetayBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetayBinding.inflate(inflater, container, false);

        DetayFragmentArgs bundle = DetayFragmentArgs.fromBundle(getArguments());
        Arabalar gelenAraba = bundle.getAraba();
        binding.textViewDetayAciklama.setText(gelenAraba.getAciklama());

        binding.imageViewDetaySonuc.setImageResource(getResources().getIdentifier(gelenAraba.getResim(), "drawable", getActivity().getPackageName()));
        binding.textViewYayinlayan.setText(gelenAraba.getYayinlayan());
        binding.textViewModelAciklama.setText(
                "Vasıta > Otomobil > " + gelenAraba.getMarka() + " > " + gelenAraba.getSeri() + " > " + gelenAraba.getModel()
        );
        binding.textViewAdres.setText(gelenAraba.getYerDetay());
//        binding.buttonAciklama.setBackgroundColor(Color.parseColor("#FFA500"));



        String fiyatString = String.valueOf(gelenAraba.getFiyat());

        StringBuilder formattedFiyat = new StringBuilder();
        int uzunluk = fiyatString.length();

        for (int i = 0; i < uzunluk; i++) {
            formattedFiyat.append(fiyatString.charAt(i));
            int kalan = uzunluk - i - 1;
            if (kalan > 0 && kalan % 3 == 0) {
                formattedFiyat.append(".");
            }
        }
        binding.textViewDetayFiyat.setText(formattedFiyat + " TL");

        binding.textViewIlanTarihi.setText(gelenAraba.getIlanTarihi());

        binding.textViewIlanNo.setText(String.valueOf(gelenAraba.getIlanNo()));

        binding.textViewMarka.setText(gelenAraba.getMarka());

        binding.textViewSeri.setText(String.valueOf(gelenAraba.getSeri()));

        binding.textViewModel.setText(gelenAraba.getModel());

        binding.textViewYil.setText(gelenAraba.getYil());

        return binding.getRoot();
    }
}