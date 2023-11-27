package com.example.bitirme_projesi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bitirme_projesi.R;
import com.example.bitirme_projesi.databinding.FragmentSepetBinding;
import com.example.bitirme_projesi.ui.adapter.SepetCardAdapter;
import com.example.bitirme_projesi.ui.viewmodel.SepetViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SepetFragment extends Fragment {
    private FragmentSepetBinding binding;
    private SepetViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSepetBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(this).get(SepetViewModel.class);

        binding.sepetRv.setLayoutManager(new LinearLayoutManager(requireContext()));
        viewModel.getSepetListesi().observe(getViewLifecycleOwner(), sepetListesi -> {
            SepetCardAdapter adapter = new SepetCardAdapter(sepetListesi, requireContext(), viewModel);
            binding.sepetRv.setAdapter(adapter);
        });

        return binding.getRoot();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // viewModel = new ViewModelProvider(this).get(SepetViewModel.class); // Bu satırı kaldırın
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.sepettekiUrunleriYukle();
    }
}