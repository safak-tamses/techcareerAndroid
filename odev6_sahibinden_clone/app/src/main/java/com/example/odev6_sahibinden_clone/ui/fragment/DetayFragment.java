package com.example.odev6_sahibinden_clone.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev6_sahibinden_clone.R;
import com.example.odev6_sahibinden_clone.data.entity.Arabalar;
import com.example.odev6_sahibinden_clone.databinding.FragmentDetayBinding;

public class DetayFragment extends Fragment {
    private FragmentDetayBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetayBinding.inflate(inflater, container, false);

//        DetayFragmentArgs bundle = DetayFragmentArgs.fromBundle(getArguments());
//        Arabalar gelenAraba = bundle.getAraba();
        return binding.getRoot();
    }
}