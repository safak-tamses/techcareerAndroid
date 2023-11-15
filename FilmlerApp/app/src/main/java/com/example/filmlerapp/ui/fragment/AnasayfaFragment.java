package com.example.filmlerapp.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.filmlerapp.R;
import com.example.filmlerapp.data.entity.Filmler;
import com.example.filmlerapp.databinding.FragmentAnasayfaBinding;
import com.example.filmlerapp.ui.adapter.FilmlerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnasayfaFragment extends Fragment {
    private FragmentAnasayfaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false);

        binding.filmlerRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        ArrayList<Filmler> filmlerListesi = new ArrayList<>(Arrays.asList(
                new Filmler(1, "Django", "django", 24),
                new Filmler(2, "Interstellar", "interstellar", 32),
                new Filmler(3, "Inception", "inception", 16),
                new Filmler(4, "The Hateful Eight", "thehatefuleight", 28),
                new Filmler(5, "The Pianist", "thepianist", 18),
                new Filmler(6, "Anadoluda", "anadoluda", 10)
        ));

        FilmlerAdapter filmlerAdapter = new FilmlerAdapter(filmlerListesi,requireContext());
        binding.filmlerRv.setAdapter(filmlerAdapter);



        return binding.getRoot();
    }
}