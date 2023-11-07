package com.example.odev4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev4.databinding.FragmentSayfaABinding;


public class SayfaAFragment extends Fragment {
    private FragmentSayfaABinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSayfaABinding.inflate(inflater, container, false);

        binding.buttonGecisB.setOnClickListener(v -> {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.sayfaBFragment);
        });
        return binding.getRoot();
    }
}