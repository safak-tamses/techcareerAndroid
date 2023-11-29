package com.example.bitirmeprojesi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bitirmeprojesi.R;
import com.example.bitirmeprojesi.databinding.FragmentFavoriBinding;
import com.example.bitirmeprojesi.ui.adapter.FavoriCardAdapter;
import com.example.bitirmeprojesi.ui.viewmodel.FavoriViewModel;
import com.example.bitirmeprojesi.ui.viewmodel.SepetViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FavoriFragment extends Fragment {
    private FragmentFavoriBinding binding;
    private FavoriViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoriBinding.inflate(inflater,container,false);
        binding.favoriRv.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.getFavList().observe(getViewLifecycleOwner(), favList -> {
            Log.d("FavoriFragment", "Favori listesi güncellendi. Toplam öğe sayısı: " + favList.size());
            FavoriCardAdapter adapter = new FavoriCardAdapter(favList, requireContext(), viewModel);
            binding.favoriRv.setAdapter(adapter);
        });

        binding.imageViewFavAnasayfa.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.favoridenAnasayfayaGecis);
        });
        binding.imageViewFavSepet.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.favoridenSepeteGecis);
        });



        return binding.getRoot();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(FavoriViewModel.class);
    }
    @Override
    public void onResume() {
        super.onResume();
        viewModel.favorileriYukle();
    }

}