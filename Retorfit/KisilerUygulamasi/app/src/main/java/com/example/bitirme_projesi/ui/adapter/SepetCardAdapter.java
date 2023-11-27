package com.example.bitirme_projesi.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bitirme_projesi.data.entity.Sepet;
import com.example.bitirme_projesi.databinding.SepetCardTasarimBinding;
import com.example.bitirme_projesi.ui.viewmodel.SepetViewModel;

import java.util.List;

public class SepetCardAdapter extends RecyclerView.Adapter<SepetCardAdapter.SepetCardTasarimTutucu>{
    private List<Sepet> sepetListesi;
    private Context mContext;
    private SepetViewModel viewModel;

    public SepetCardAdapter(List<Sepet> sepetListesi, Context mContext, SepetViewModel viewModel) {
        this.sepetListesi = sepetListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public SepetCardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SepetCardTasarimBinding binding = SepetCardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new SepetCardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SepetCardTasarimTutucu holder, int position) {
        Sepet sepet = sepetListesi.get(position);
        SepetCardTasarimBinding t = holder.tasarim;
        t.textViewUrunAdi.setText(sepet.getYemek_adi());
        t.textViewUrunFiyati.setText(sepet.getYemek_fiyat());
        t.textViewUrunAdet.setText(sepet.getYemek_siparis_adet());

        String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + sepet.getYemek_resim_adi();
        Glide.with(mContext).load(url).override(300, 300).into(t.imageViewUrunResim);

        int toplamTutar = sepet.getYemek_fiyat() + sepet.getYemek_siparis_adet();
        t.textViewToplamTutar.setText(String.valueOf(toplamTutar));

        t.imageViewSilResmi.setOnClickListener(v -> {
            viewModel.sepettenUrunSil(sepet.getSepet_yemek_id());
        });
    }

    @Override
    public int getItemCount() {
        if (sepetListesi == null) {
            return 0;
        }
        return sepetListesi.size();
    }


    public class SepetCardTasarimTutucu extends RecyclerView.ViewHolder{
        private SepetCardTasarimBinding tasarim;
        public SepetCardTasarimTutucu(SepetCardTasarimBinding tasarim){
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }
}
