package com.example.odev6_sahibinden_clone.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev6_sahibinden_clone.R;
import com.example.odev6_sahibinden_clone.databinding.FragmentDetaysayfaUstMenuBinding;


public class DetaysayfaUstMenuFragment extends Fragment {
    FragmentDetaysayfaUstMenuBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetaysayfaUstMenuBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}