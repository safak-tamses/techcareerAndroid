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
import com.example.bitirmeprojesi.databinding.FragmentSepetBinding;
import com.example.bitirmeprojesi.ui.adapter.SepetCardAdapter;
import com.example.bitirmeprojesi.ui.viewmodel.SepetViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SepetFragment extends Fragment {
    private FragmentSepetBinding binding;
    private SepetViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSepetBinding.inflate(inflater, container, false);

        binding.sepetRv.setLayoutManager(new LinearLayoutManager(requireContext()));


        binding.textViewSepetBos.setText("Sepetinizde ürün bulunmuyor.");

        viewModel.sepetListesi.observe(getViewLifecycleOwner(), sepetListesi -> {
            if (sepetListesi != null && sepetListesi.size() > 0){
                binding.textViewSepetBos.setText("");
                SepetCardAdapter adapter = new SepetCardAdapter(sepetListesi, requireContext(), viewModel);
                binding.sepetRv.setAdapter(adapter);
            } else {
                binding.textViewSepetBos.setText("Sepetinizde ürün bulunmuyor.");
                SepetCardAdapter adapter = new SepetCardAdapter(new ArrayList<>(), requireContext(), viewModel);
                binding.sepetRv.setAdapter(adapter);
            }
        });



        binding.imageViewSepetHome.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.sepettenAnaSayfayaGecis);
        });
        binding.imageViewSepetFavori.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.sepettenFavoriyeGecis);
        });


        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SepetViewModel.class);
    }


    @Override
    public void onResume() {
        super.onResume();
        viewModel.sepetiYukle();
    }

}