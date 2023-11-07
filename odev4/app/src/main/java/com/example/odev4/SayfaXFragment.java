package com.example.odev4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev4.databinding.FragmentSayfaXBinding;


public class SayfaXFragment extends Fragment {
    private FragmentSayfaXBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSayfaXBinding.inflate(inflater, container, false);
        binding.buttonXGecisY.setOnClickListener(v -> {
            NavHostFragment.findNavController(this)
                    .navigate(R.id.sayfaYFragment);
        });

        return binding.getRoot();
    }
}