package com.example.bitirmeprojesi.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bitirmeprojesi.data.entity.DTO.GcSepet;
import com.example.bitirmeprojesi.data.entity.Sepet;
import com.example.bitirmeprojesi.databinding.SepetCardTasarimBinding;
import com.example.bitirmeprojesi.ui.viewmodel.SepetViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SepetCardAdapter extends RecyclerView.Adapter<SepetCardAdapter.SepetCardTasarimTutucu>{
    private List<GcSepet> sepetListesi;
    private Context mContext;
    private SepetViewModel viewModel;

    public SepetCardAdapter(List<GcSepet> sepetListesi, Context mContext, SepetViewModel viewModel) {
        this.sepetListesi = sepetListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public SepetCardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("SepetCardAdapter", "onCreateViewHolder called");
        SepetCardTasarimBinding binding = SepetCardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new SepetCardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SepetCardTasarimTutucu holder, int position) {
        GcSepet sepet = sepetListesi.get(position);
        SepetCardTasarimBinding t = holder.tasarim;

        if (viewModel.getSepetListesi().getValue() != null){
            layoutDegistir(t.consId);

            t.textViewUrunAdi.setText("Yemek Adı: "+sepet.getYemek_adi());
            t.textViewUrunFiyati.setText("Fiyat: "+sepet.getYemek_fiyat() + " ₺");
            t.textViewUrunAdet.setText("Adet: "+sepet.getYemek_siparis_adet());

            String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + sepet.getYemek_resim_adi();
            Glide.with(mContext).load(url).override(300, 300).into(t.imageViewUrunResim);

            String fiyat = sepet.getYemek_fiyat().toString();
            int fiyatT = Integer.parseInt(fiyat);
            String adet = sepet.getYemek_siparis_adet().toString();
            int adetT = Integer.parseInt(adet);
            String id = sepet.getSepet_yemek_id().toString();
            int idT = Integer.parseInt(id);

            int toplamTutar = fiyatT * adetT;
            t.textViewToplamTutar.setText("Toplam tutar: " + toplamTutar + " ₺");


            t.imageViewSilResmi.setOnClickListener(v -> {
                viewModel.sepetiSil(idT);
                viewModel.sepetiYukle();
            });
        }


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
    private List<GcSepet> birlestir(List<GcSepet> gcSepetList){
        Map<String,GcSepet>birlestirilmisMap = new HashMap<>();
        for (GcSepet gcSepet : gcSepetList){
            String sepetYemekId = gcSepet.getSepet_yemek_id();
            if(birlestirilmisMap.containsKey(sepetYemekId)){
                GcSepet birlestirilmis = birlestirilmisMap.get(sepetYemekId);
                birlestirilmis.setYemek_siparis_adet(String.valueOf(Integer.parseInt(birlestirilmis.getYemek_siparis_adet()) +Integer.parseInt(gcSepet.getYemek_siparis_adet())));
            } else {
                birlestirilmisMap.put(sepetYemekId,gcSepet);
            }
        }
        return new ArrayList<>(birlestirilmisMap.values());
    }

    private void layoutDegistir(ConstraintLayout constraintLayout) {

        int startColor = Color.parseColor("#FFE4C6");
        int endColor = Color.parseColor("#A96112");

        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM, new int[]{startColor,endColor});

        gradientDrawable.setCornerRadii(new float[]{30, 30, 30, 30, 30, 30, 30, 30});

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            constraintLayout.setBackground(gradientDrawable);
        } else {
            constraintLayout.setBackgroundDrawable(gradientDrawable);
        }

        // Log mesajı ekle
        Log.d("SepetCardAdapter", "layoutDegistir fonksiyonu çağrıldı.");
    }

}
