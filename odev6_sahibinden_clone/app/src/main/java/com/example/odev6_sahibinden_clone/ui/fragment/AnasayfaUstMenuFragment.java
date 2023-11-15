package com.example.odev6_sahibinden_clone.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev6_sahibinden_clone.R;
import com.example.odev6_sahibinden_clone.databinding.FragmentAnasayfaUstMenuBinding;


public class AnasayfaUstMenuFragment extends Fragment {
    private FragmentAnasayfaUstMenuBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnasayfaUstMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}