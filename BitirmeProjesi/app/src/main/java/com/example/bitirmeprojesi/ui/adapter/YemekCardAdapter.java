package com.example.bitirmeprojesi.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bitirmeprojesi.R;
import com.example.bitirmeprojesi.data.entity.DTO.SepetEkle;
import com.example.bitirmeprojesi.data.entity.VeriTabaniYemek;
import com.example.bitirmeprojesi.data.entity.Yemekler;
import com.example.bitirmeprojesi.databinding.YemekCardTasarimBinding;
import com.example.bitirmeprojesi.ui.fragment.AnasayfaFragmentDirections;
import com.example.bitirmeprojesi.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;

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
        if (!yemeklerListesi.isEmpty()){
            Yemekler yemek = yemeklerListesi.get(position);
            YemekCardTasarimBinding t = holder.tasarim;
            layoutDegistir(t.consId);

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

                Snackbar snackbar = Snackbar.make(t.getRoot(), "Ürün sepete eklendi", Snackbar.LENGTH_SHORT);

                snackbar.show();

            });

            t.imageViewFavoriEkle.setOnClickListener(v -> {
                viewModel.favoriEkle(yemek.getYemek_adi(), yemek.getYemek_resim_adi(), yemek.getYemek_fiyat());
                Snackbar snackbar = Snackbar.make(t.getRoot(), "Ürün favorilerinize eklendi", Snackbar.LENGTH_SHORT);
                snackbar.show();
            });


            t.yemekSatir.setOnClickListener(v -> {
                AnasayfaFragmentDirections.DetayaGecis gecis = AnasayfaFragmentDirections.detayaGecis(yemek);
                Navigation.findNavController(v).navigate(gecis);
            });
        }

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

    private void layoutDegistir(ConstraintLayout constraintLayout) {
        int startColor = Color.parseColor("#ffc98d");
        int endColor = Color.parseColor("#81f4d4");

        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM, new int[]{startColor, endColor});

        gradientDrawable.setCornerRadii(new float[]{30, 30, 30, 30, 30, 30, 30, 30});

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            constraintLayout.setBackground(gradientDrawable);
        } else {
            constraintLayout.setBackgroundDrawable(gradientDrawable);
        }
    }

}