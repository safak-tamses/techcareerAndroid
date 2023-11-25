package com.example.odev7.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev7.R;
import com.example.odev7.databinding.FragmentTodoKayitBinding;
import com.example.odev7.ui.viewmodel.TodoKayitViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TodoKayitFragment extends Fragment {
    private FragmentTodoKayitBinding binding;
    private TodoKayitViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTodoKayitBinding.inflate(inflater, container, false);

        binding.buttonKaydet.setOnClickListener(v -> {
            String todo_name = binding.editTextKisiAd.getText().toString();
            Log.e("test ",todo_name);
            viewModel.kaydet(todo_name);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(TodoKayitViewModel.class);
    }
}