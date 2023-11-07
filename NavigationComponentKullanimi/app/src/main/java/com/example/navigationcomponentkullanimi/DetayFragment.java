package com.example.navigationcomponentkullanimi;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationcomponentkullanimi.databinding.FragmentDetayBinding;
import com.google.android.material.snackbar.Snackbar;


public class DetayFragment extends Fragment {
    private FragmentDetayBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetayBinding.inflate(inflater, container, false);

        DetayFragmentArgs bundle = DetayFragmentArgs.fromBundle(getArguments());
        Urunler gelenUrun = bundle.getUrun();
        String gelenAd = bundle.getAd();
        int gelenYas = bundle.getYas();
        float gelenBoy = bundle.getBoy();
        boolean gelenBekar = bundle.getBekar();

        binding.textViewDetay.setText(gelenAd + " - " + gelenYas + " - " + gelenBoy + " - " + gelenBekar + " - " + gelenUrun.getId() + " - " + gelenUrun.getAd());

        OnBackPressedCallback geriTusu = new OnBackPressedCallback(true) {//true : geri dönüş aktif değil
            @Override
            public void handleOnBackPressed() {
                Snackbar.make(binding.textViewDetay,"Geri dönmek istiyor musunuz?",Snackbar.LENGTH_SHORT)
                        .setAction("EVET", v-> {
                            setEnabled(false);
                            requireActivity().getOnBackPressedDispatcher().onBackPressed();
                        }).show();

            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),geriTusu);
        return binding.getRoot();
    }
}