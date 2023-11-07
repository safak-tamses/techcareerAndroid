package com.example.odev4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev4.databinding.FragmentAnaSayfaBinding;


public class AnaSayfaFragment extends Fragment {
    private FragmentAnaSayfaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnaSayfaBinding.inflate(inflater, container, false);

        binding.buttonGecisA.setOnClickListener(v -> {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.sayfaAFragment);
        });
        binding.buttonGecisX.setOnClickListener(v -> {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.sayfaXFragment);
        });
        return binding.getRoot();
    }
}