package com.example.kisileruygulamasi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisileruygulamasi.R;
import com.example.kisileruygulamasi.databinding.FragmentKisiKayitBinding;
import com.example.kisileruygulamasi.ui.viewModel.KisiKayitViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KisiKayitFragment extends Fragment {

    private FragmentKisiKayitBinding binding;
    private KisiKayitViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentKisiKayitBinding.inflate(inflater,container,false);

        binding.buttonKaydet.setOnClickListener(v -> {
            String kisi_ad = binding.editTextKisiAd.getText().toString();
            String kisi_tel = binding.editTextKisiTel.getText().toString();

            viewModel.kaydet(kisi_ad,kisi_tel);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KisiKayitViewModel.class);
    }


}