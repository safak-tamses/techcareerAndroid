package com.example.filmlerapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmlerapp.data.entity.Filmler;
import com.example.filmlerapp.databinding.CardTasarimBinding;
import com.example.filmlerapp.ui.fragment.AnasayfaFragmentDirections;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class FilmlerAdapter extends RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu> {
    private List<Filmler> filmlerListesi;
    private Context mContext;

    public FilmlerAdapter(List<Filmler> filmlerListesi, Context mContext) {
        this.filmlerListesi = filmlerListesi;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Filmler film = filmlerListesi.get(position);
        CardTasarimBinding t = holder.tasarim;
        t.imageViewFilm.setImageResource(mContext.getResources().getIdentifier(film.getResim(), "drawable", mContext.getPackageName()));
        t.textViewFiyat.setText(film.getFiyat() + " ₺");
        t.buttonSepet.setOnClickListener(v -> {
            Snackbar.make(v, film.getAd() + " sepete eklendi", Snackbar.LENGTH_SHORT).show();
        });

        t.cardViewFilm.setOnClickListener(v -> {
            AnasayfaFragmentDirections.DetayGecis gecis = AnasayfaFragmentDirections.detayGecis(film);
            Navigation.findNavController(v).navigate(gecis);
        });

    }

    @Override
    public int getItemCount() {
        return filmlerListesi.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu(CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }
}
