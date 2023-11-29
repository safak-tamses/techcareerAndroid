package com.example.bitirmeprojesi.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.bitirmeprojesi.R;
import com.example.bitirmeprojesi.data.entity.DTO.SepetEkle;
import com.example.bitirmeprojesi.data.entity.Yemekler;
import com.example.bitirmeprojesi.databinding.FragmentDetaysayfaBinding;
import com.example.bitirmeprojesi.ui.viewmodel.DetayViewModel;
import com.google.android.material.snackbar.Snackbar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetaysayfaFragment extends Fragment {
    private FragmentDetaysayfaBinding binding;
    private DetayViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetaysayfaBinding.inflate(inflater,container,false);
        viewModel = new ViewModelProvider(this).get(DetayViewModel.class);

        DetaysayfaFragmentArgs bundle = DetaysayfaFragmentArgs.fromBundle(getArguments());
        Yemekler gelenUrun = bundle.getYemek();

        String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + gelenUrun.getYemek_resim_adi();
        Glide.with(this).load(url).override(300, 300).into(binding.imageViewUrununResmi);

        binding.textViewUrunIsmi.setText(gelenUrun.getYemek_adi());
        binding.textViewUrunTutar.setText(String.valueOf(gelenUrun.getYemek_fiyat() + " ₺"));
        binding.textViewAdet.setText("1");
        binding.textViewToplam.setText("Toplam: "+gelenUrun.getYemek_fiyat() + " ₺");

        binding.imageViewrti.setOnClickListener(v -> {
            String adetMetni = binding.textViewAdet.getText().toString();
            int tutar = gelenUrun.getYemek_fiyat();
            int adet = Integer.parseInt(adetMetni) + 1;
            binding.textViewAdet.setText(String.valueOf(adet));
            binding.textViewToplam.setText("Toplam: " + (adet * tutar) + " ₺") ;
        });

        binding.imageViewEksi.setOnClickListener(v -> {
            String adetMetni = binding.textViewAdet.getText().toString();
            int tutar = gelenUrun.getYemek_fiyat();
            int adet = Integer.parseInt(adetMetni);
            if (adet > 1) {
                adet--;
                binding.textViewAdet.setText(String.valueOf(adet));
                binding.textViewToplam.setText("Toplam: " + (adet * tutar) + " ₺");
            }
        });

        binding.buttonSepeteUrunuEkle.setOnClickListener(v -> {
            String adetMetni = binding.textViewAdet.getText().toString();
            int adet = Integer.parseInt(adetMetni);

                SepetEkle sepetEkle = new SepetEkle(
                        gelenUrun.getYemek_adi(),
                        gelenUrun.getYemek_resim_adi(),
                        gelenUrun.getYemek_fiyat(),
                        adet
                );
                viewModel.sepeteUrunEkle(sepetEkle);
            Snackbar.make(binding.getRoot(), "Ürün sepete eklendi", Snackbar.LENGTH_SHORT).show();
        });



        return binding.getRoot();
    }
}