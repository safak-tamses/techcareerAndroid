package com.example.odev4;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev4.databinding.FragmentSayfaYBinding;
import com.google.android.material.snackbar.Snackbar;

public class SayfaYFragment extends Fragment {
    private FragmentSayfaYBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSayfaYBinding.inflate(inflater, container, false);

        OnBackPressedCallback geriTusu = new OnBackPressedCallback(true) {//true : geri dönüş aktif değil
            public void handleOnBackPressed() {
                Snackbar.make(binding.textView6, "Geri dönmek istiyor musunuz?", Snackbar.LENGTH_SHORT)
                        .setAction("EVET", v -> {
                            setEnabled(false);

                            Navigation.findNavController(requireView()).navigate(R.id.sayfaYGecisAnasayfa);
                        }).show();
            }

        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),geriTusu);
        return binding.getRoot();
    }



}
