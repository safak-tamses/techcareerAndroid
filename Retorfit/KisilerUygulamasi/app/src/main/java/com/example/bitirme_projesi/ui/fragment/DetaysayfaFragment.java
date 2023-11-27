package com.example.bitirme_projesi.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.bitirme_projesi.R;
import com.example.bitirme_projesi.data.entity.Yemekler;
import com.example.bitirme_projesi.databinding.FragmentDetaysayfaBinding;
import com.example.bitirme_projesi.ui.viewmodel.DetayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetaysayfaFragment extends Fragment {
    private FragmentDetaysayfaBinding binding;
    private DetayViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetaysayfaBinding.inflate(inflater,container,false);

        DetaysayfaFragmentArgs bundle = DetaysayfaFragmentArgs.fromBundle(getArguments());
        Yemekler gelenUrun = bundle.getYemek();

        String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + gelenUrun.getYemek_resim_adi();
        Glide.with(this).load(url).override(300, 300).into(binding.imageViewUrununResmi);

        binding.textViewUrunIsmi.setText(gelenUrun.getYemek_adi());
        binding.textViewUrunTutar.setText(String.valueOf(gelenUrun.getYemek_fiyat()));

        binding.imageViewArti.setOnClickListener(v -> {
            String adetMetni = binding.textViewAdet.getText().toString();
            int tutar = gelenUrun.getYemek_fiyat();
            int adet = Integer.parseInt(adetMetni) + 1;
            binding.textViewAdet.setText(String.valueOf(adet));
            binding.textViewToplam.setText(String.valueOf(adet * tutar));
        });

        binding.imageViewEksi.setOnClickListener(v -> {
            String adetMetni = binding.textViewAdet.getText().toString();
            int tutar = gelenUrun.getYemek_fiyat();
            int adet = Integer.parseInt(adetMetni);
            if (adet > 0){
                binding.textViewAdet.setText(String.valueOf(adet - 1));
                binding.textViewToplam.setText(String.valueOf(adet * tutar));
            }
        });



        return binding.getRoot();
    }
}