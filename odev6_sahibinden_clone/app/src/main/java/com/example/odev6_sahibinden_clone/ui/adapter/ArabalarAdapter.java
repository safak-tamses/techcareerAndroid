package com.example.odev6_sahibinden_clone.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odev6_sahibinden_clone.data.entity.Arabalar;
import com.example.odev6_sahibinden_clone.databinding.CardTasarimBinding;
import com.example.odev6_sahibinden_clone.ui.fragment.AnasayfaFragmentDirections;

import java.util.List;

public class ArabalarAdapter extends RecyclerView.Adapter<ArabalarAdapter.CardTasarimTutucu>{
    private List<Arabalar> arabalarListesi;
    private Context mContext;

    public ArabalarAdapter(List<Arabalar> arabalarListesi, Context mContext) {
        this.arabalarListesi = arabalarListesi;
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
        Arabalar araba = arabalarListesi.get(position);
        CardTasarimBinding t = holder.tasarim;
        t.imageViewResim.setImageResource(mContext.getResources().getIdentifier(araba.getResim(),"drawable",mContext.getPackageName()));

        String fiyatString = String.valueOf(araba.getFiyat());

        StringBuilder formattedFiyat = new StringBuilder();
        int uzunluk = fiyatString.length();

        for (int i = 0; i < uzunluk; i++) {
            formattedFiyat.append(fiyatString.charAt(i));
            int kalan = uzunluk - i - 1;
            if (kalan > 0 && kalan % 3 == 0) {
                formattedFiyat.append(".");
            }
        }

        t.textViewFiyat.setText(formattedFiyat + " TL");
        t.textViewAciklama.setText(araba.getAciklama());
        t.textViewKonum.setText(araba.getYer());
        t.cardViewAraba.setOnClickListener(v -> {
            AnasayfaFragmentDirections.DetayGecis gecis = AnasayfaFragmentDirections.detayGecis(araba);
            Navigation.findNavController(v).navigate(gecis);
        });
    }

    @Override
    public int getItemCount() {
        return arabalarListesi.size();
    }


    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu(CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }
}
