package com.example.navigationcomponentkullanimi;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationcomponentkullanimi.databinding.FragmentAnaSayfaBinding;

public class AnaSayfaFragment extends Fragment {
    private FragmentAnaSayfaBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /* Önemli  */
        binding = FragmentAnaSayfaBinding.inflate(inflater, container, false);

        binding.buttonDetay.setOnClickListener(view -> {
//            binding.textViewAnasayfa.setText("Merhaba");
            Urunler urun = new Urunler(1, "TV");


            AnaSayfaFragmentDirections.DetayGecis gecis = AnaSayfaFragmentDirections.detayGecis(urun);
            gecis.setAd("Ahmet");
            gecis.setYas(23);
            gecis.setBoy(1.74f);
            gecis.setBekar(true);



            /* Navigation classındaki geçişin sağlanmasını tetikleyen yapı burada  */
            Navigation.findNavController(view).navigate(gecis);

        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Yaşam döngüsü", "onCreate");
        //bir kere uygulama yüklenince çalışır
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("Yaşam döngüsü", "onResume");
        //sayfa her görüldüğünde
        // Sayfaya geri dönüldüğünde
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("Yaşam döngüsü", "onPause");
        //Sayfa her görünmez olduğunda çalışır
    }
}