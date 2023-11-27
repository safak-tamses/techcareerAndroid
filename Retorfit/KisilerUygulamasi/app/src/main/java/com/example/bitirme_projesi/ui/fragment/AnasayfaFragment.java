package com.example.bitirme_projesi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.bitirme_projesi.R;
import com.example.bitirme_projesi.databinding.FragmentAnasayfaBinding;
import com.example.bitirme_projesi.ui.adapter.YemekCardAdapter;
import com.example.bitirme_projesi.ui.viewmodel.AnasayfaViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding binding;
    private AnasayfaViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false);

//        binding.kisilerRv.setLayoutManager(new LinearLayoutManager(requireContext()));

        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false);
        binding.kisilerRv.setLayoutManager(layoutManager);

        binding.imageViewSepeteGit.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.sepeteGecis);
        });


        viewModel.getYemeklerListesi().observe(getViewLifecycleOwner(),yemeklerListesi -> {
            YemekCardAdapter adapter = new YemekCardAdapter(yemeklerListesi,requireContext(),viewModel);
            binding.kisilerRv.setAdapter(adapter);
        });


        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AnasayfaViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.yemekleriYukle();
    }
}