package com.example.odev7.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev7.R;
import com.example.odev7.data.entity.ToDo;
import com.example.odev7.databinding.FragmentTodoDetayBinding;
import com.example.odev7.ui.viewmodel.TodoDetayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TodoDetayFragment extends Fragment {
    private FragmentTodoDetayBinding binding;
    private TodoDetayViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTodoDetayBinding.inflate(inflater, container, false);

        TodoDetayFragmentArgs bundle = TodoDetayFragmentArgs.fromBundle(getArguments());
        ToDo gelenTodo = bundle.getTodo();

        binding.editTextKisiAd.setText(gelenTodo.getTodo_name());

        binding.buttonGuncelle.setOnClickListener(v -> {
            String todo_name = binding.editTextKisiAd.getText().toString();

            viewModel.guncelle(gelenTodo.getTodo_id(),todo_name);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(TodoDetayViewModel.class);
    }
}