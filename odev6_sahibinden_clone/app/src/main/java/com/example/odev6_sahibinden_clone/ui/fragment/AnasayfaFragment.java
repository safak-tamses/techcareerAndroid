package com.example.odev6_sahibinden_clone.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev6_sahibinden_clone.R;
import com.example.odev6_sahibinden_clone.data.entity.Arabalar;
import com.example.odev6_sahibinden_clone.databinding.FragmentAnasayfaBinding;
import com.example.odev6_sahibinden_clone.ui.adapter.ArabalarAdapter;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AnasayfaFragment extends Fragment {

    private FragmentAnasayfaBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false);
        binding.anasayfaRv.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<Arabalar> arabalarListesi = new ArrayList<>();
        Arabalar araba1 = new Arabalar(
                "honda",120,new Date(),1111,"Honda","SLX","Civic",new Date(),"Dizel","Otomatik","2. el",18000,"eski",180,2600,"Arkadan","Mavi",true,false,"Tr","Sahibindem",false,true
        );
        arabalarListesi.add(araba1);
        ArabalarAdapter arabalarAdapter = new ArabalarAdapter(arabalarListesi,requireContext());
        binding.anasayfaRv.setAdapter(arabalarAdapter);

        return binding.getRoot();

    }


}