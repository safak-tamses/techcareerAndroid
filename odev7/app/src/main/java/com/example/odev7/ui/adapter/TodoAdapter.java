package com.example.odev7.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odev7.data.entity.ToDo;
import com.example.odev7.databinding.CardTasarimBinding;
import com.example.odev7.ui.fragment.AnasayfaFragmentDirections;
import com.example.odev7.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.CardTasarimTutucu> {
    private List<ToDo> todoListesi;
    private Context mContext;
    private AnasayfaViewModel viewModel;

    public TodoAdapter(List<ToDo> todoListesi, Context mContext, AnasayfaViewModel viewModel) {
        this.todoListesi = todoListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBinding tasarim;
        public CardTasarimTutucu(CardTasarimBinding tasarim){
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }
    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding =
                CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false);
        return new CardTasarimTutucu(binding);
    }
    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        ToDo todo = todoListesi.get(position);
        CardTasarimBinding t = holder.tasarim;

        t.textViewKisiAd.setText(todo.getTodo_name());

        t.imageViewSil.setOnClickListener(v -> {
            Snackbar.make(v,todo.getTodo_name()+" silinsin mi?",Snackbar.LENGTH_SHORT)
                    .setAction("EVET",v1 -> {
                        viewModel.sil(todo.getTodo_id());
                    })
                    .show();
        });

        t.cardViewSatir.setOnClickListener(v -> {
            AnasayfaFragmentDirections.TodoDetayGecis gecis = AnasayfaFragmentDirections.todoDetayGecis(todo);
            Navigation.findNavController(v).navigate(gecis);
        });
    }

    @Override
    public int getItemCount() {
        return todoListesi.size();
    }
}
