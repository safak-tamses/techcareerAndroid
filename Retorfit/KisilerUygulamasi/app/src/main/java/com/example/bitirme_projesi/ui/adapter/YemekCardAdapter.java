package com.example.bitirme_projesi.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bitirme_projesi.data.entity.DTO.SepetEkle;
import com.example.bitirme_projesi.data.entity.Yemekler;
import com.example.bitirme_projesi.databinding.YemekCardTasarimBinding;
import com.example.bitirme_projesi.ui.fragment.AnasayfaFragmentDirections;
import com.example.bitirme_projesi.ui.viewmodel.AnasayfaViewModel;

import java.util.List;

public class YemekCardAdapter extends RecyclerView.Adapter<YemekCardAdapter.YemekCardTasarimTutucu> {
    private List<Yemekler> yemeklerListesi;
    private Context mContext;
    private AnasayfaViewModel viewModel;

    public YemekCardAdapter(List<Yemekler> yemeklerListesi, Context mContext, AnasayfaViewModel viewModel) {
        this.yemeklerListesi = yemeklerListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public YemekCardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        YemekCardTasarimBinding binding = YemekCardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new YemekCardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull YemekCardTasarimTutucu holder, int position) {
        Yemekler yemek = yemeklerListesi.get(position);
        YemekCardTasarimBinding t = holder.tasarim;

        t.textViewYemekAdi.setText(yemek.getYemek_adi());
        t.textViewYemekFiyat.setText(yemek.getYemek_fiyat() + " TL");

        String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + yemek.getYemek_resim_adi();
        Glide.with(mContext).load(url).override(300, 300).into(t.imageViewYemekResim);


        t.imageViewSepeteEkle.setOnClickListener(v -> {
            SepetEkle sepetEkle = new SepetEkle(
                    yemek.getYemek_adi(),
                    yemek.getYemek_resim_adi(),
                    yemek.getYemek_fiyat(),
                    1
            );
            viewModel.sepeteUrunEkle(sepetEkle);
        });

        t.yemekSatir.setOnClickListener(v -> {
            AnasayfaFragmentDirections.DetayaGecis gecis = AnasayfaFragmentDirections.detayaGecis(yemek);
            Navigation.findNavController(v).navigate(gecis);
        });
    }

    @Override
    public int getItemCount() {
        return yemeklerListesi.size();
    }

    public class YemekCardTasarimTutucu extends RecyclerView.ViewHolder {
        private YemekCardTasarimBinding tasarim;

        public YemekCardTasarimTutucu(YemekCardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }
}
