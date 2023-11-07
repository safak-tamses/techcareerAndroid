package com.example.navigationcomponentkullanimi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationcomponentkullanimi.databinding.FragmentBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.Snackbar;


public class BottomSheetFragment extends BottomSheetDialogFragment {
    private FragmentBottomSheetBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false);
        binding.textViewKopyala.setOnClickListener(v -> {
            Snackbar.make(v,"Paylasıldı",Snackbar.LENGTH_SHORT).show();
        });
        binding.textViewPaylas.setOnClickListener( v -> {
            Snackbar.make(v,"Kopyalandı",Snackbar.LENGTH_SHORT).show();
        });
        return binding.getRoot();
    }
}