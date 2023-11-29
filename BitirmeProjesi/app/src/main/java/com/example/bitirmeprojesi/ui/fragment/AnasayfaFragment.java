package com.example.bitirmeprojesi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.bitirmeprojesi.R;
import com.example.bitirmeprojesi.databinding.FragmentAnasayfaBinding;
import com.example.bitirmeprojesi.ui.adapter.YemekCardAdapter;
import com.example.bitirmeprojesi.ui.viewmodel.AnasayfaViewModel;

import java.util.ArrayList;

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

        binding.imageViewHomeSepet.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.sepeteGecis);
        });
        binding.imageViewHomeFavori.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.anasayfadanFavoriyeGecis);
        });


        viewModel.getAramaSonucu().observe(getViewLifecycleOwner(), aramaListesi -> {
            YemekCardAdapter adapter = new YemekCardAdapter(aramaListesi, requireContext(), viewModel);
            binding.kisilerRv.setAdapter(adapter);
        });
        viewModel.getYemeklerListesi().observe(getViewLifecycleOwner(), yemeklerListesi -> {
            YemekCardAdapter adapter = new YemekCardAdapter(yemeklerListesi, requireContext(), viewModel);
            binding.kisilerRv.setAdapter(adapter);
        });


        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                viewModel.ara(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                viewModel.ara(newText);
                return true;
            }
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


