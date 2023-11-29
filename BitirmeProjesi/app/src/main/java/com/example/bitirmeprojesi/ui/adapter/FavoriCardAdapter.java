package com.example.bitirmeprojesi.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bitirmeprojesi.data.entity.VeriTabaniYemek;
import com.example.bitirmeprojesi.data.entity.Yemekler;
import com.example.bitirmeprojesi.databinding.FavoriCardTasarimBinding;
import com.example.bitirmeprojesi.ui.viewmodel.FavoriViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class FavoriCardAdapter extends RecyclerView.Adapter<FavoriCardAdapter.FavoriCardTasarimTutucu> {
    private List<VeriTabaniYemek> yemekListesi;
    private Context mContext;
    private FavoriViewModel viewModel;

    public FavoriCardAdapter(List<VeriTabaniYemek> yemekListesi, Context mContext, FavoriViewModel viewModel) {
        this.yemekListesi = yemekListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public FavoriCardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FavoriCardTasarimBinding binding = FavoriCardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false);
        return new FavoriCardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriCardTasarimTutucu holder, int position) {
        VeriTabaniYemek fav = yemekListesi.get(position);
        FavoriCardTasarimBinding t = holder.tasarim;
        Log.e("Fav", fav.getYemek_adi() + " 31");

        if (yemekListesi != null) {
            layoutDegistir(t.consId);

            String url = "http://kasimadalan.pe.hu/yemekler/resimler/" + fav.getYemek_resim_adi();
            Glide.with(mContext).load(url).override(300, 300).into(t.imageViewFavoriUrunIsmi);

            t.textViewFavoriUrunAdi.setText(fav.getYemek_adi());
            t.textViewFavoriUrunFiyati.setText(fav.getYemek_fiyat() + " ₺");
            t.imageViewFavSil.setOnClickListener(v -> {
                Snackbar.make(v, fav.getYemek_adi() +" adlı ürün favorilerinizden silinsin mi?",Snackbar.LENGTH_SHORT)
                        .setAction("EVET",v1 -> {
                            viewModel.silFavori(fav.getYemek_id());
                            viewModel.favorileriYukle();
                        })
                        .show();
            });
        }
    }

    @Override
    public int getItemCount() {
        if (yemekListesi == null) {
            return 0;
        }
        return yemekListesi.size();
    }


    public class FavoriCardTasarimTutucu extends RecyclerView.ViewHolder {
        private FavoriCardTasarimBinding tasarim;

        public FavoriCardTasarimTutucu(FavoriCardTasarimBinding tasarim) {
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
    }}
