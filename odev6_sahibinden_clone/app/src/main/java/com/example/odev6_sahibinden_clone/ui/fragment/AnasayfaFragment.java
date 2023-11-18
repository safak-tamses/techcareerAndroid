package com.example.odev6_sahibinden_clone.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev6_sahibinden_clone.R;
import com.example.odev6_sahibinden_clone.data.entity.Arabalar;
import com.example.odev6_sahibinden_clone.databinding.FragmentAnasayfaBinding;
import com.example.odev6_sahibinden_clone.ui.adapter.ArabalarAdapter;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AnasayfaFragment extends Fragment {

    private FragmentAnasayfaBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false);
        binding.anasayfaRv.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<Arabalar> arabalarListesi = new ArrayList<>();
        Arabalar araba1 = new Arabalar(
            "p1"
                ,"GAYE OTOMOTİV// %50 PEŞİNATLA SENETLİ VADELİ"
                ,"İstanbul,Bağcılar"
                ,325000
                ,"Gaye Otomotiv"
                ,"İstanbul, Bağcılar, 100. Yıl Mh."
                ,"17.11.2023"
                ,1120612005
                ,"Fiat"
                ,"Albea"
                ,"1.2 Active"
                ,"2006"
                ,"Benzin"
                ,"Manuel"
                ,"İkinci El"
                ,200000
                ,"Sedan"
                ,80
                ,1242
                ,"Önden Çekiş"
                ,"Gri"
                ,"Evet"
                ,"Hayır"
                ,"Türkiye(TR) Plakalı"
                ,"Galeriden"
                ,"Evet"
                ,"Evet"
        );
        arabalarListesi.add(araba1);
        Arabalar araba2 = new Arabalar(
                "p2"
                ,"2017 ÇIKIŞLI 96 BİNDE HATASIZ CAM TAVAN OTOMATİK FR ÖZEL PLAKA"
                ,"İstanbul,Küçükçekmece"
                ,887750
                ,"Oktay Bulut"
                ,"İstanbul, Küçükçekmece, Cennet Mh."
                ,"18.11.2023"
                ,1136991729
                ,"Seat"
                ,"Leon"
                ,"1.4 EcoTSI FR"
                ,"2017"
                ,"Benzin"
                ,"Otomatik"
                ,"İkinci El"
                ,96000
                ,"Hatchback 5 kapı"
                ,150
                ,1395
                ,"Önden Çekiş"
                ,"Beyaz"
                ,"Evet"
                ,"Hayır"
                ,"Türkiye(TR) Plakalı"
                ,"Sahibinden"
                ,"Evet"
                ,"Evet"
        );
        arabalarListesi.add(araba2);
        Arabalar araba3 = new Arabalar(
                "p3"
                ,"SAHİBİNDEN TEMİZ BAKIMLI DİZEL OTOMATİK LED PAKET MEGANE 4"
                ,"İstanbul,Esenler"
                ,718000
                ,"Hasan Can"
                ,"İstanbul, Esenler, Fevzi Çakmak Mh."
                ,"17.11.2023"
                ,1136175745
                ,"Renault"
                ,"Megane"
                ,"1.5 dCi Touch"
                ,"2016"
                ,"Dizel"
                ,"Otomatik"
                ,"İkinci El"
                ,174800
                ,"Sedan"
                ,110
                ,1461
                ,"Önden Çekiş"
                ,"Beyaz"
                ,"Hayır"
                ,"Hayır"
                ,"Türkiye(TR) Plakalı"
                ,"Sahibinden"
                ,"Evet"
                ,"Hayır"
        );
        arabalarListesi.add(araba3);
        Arabalar araba4 = new Arabalar(
                "p4"
                ,"GOLF 7,5 LANSMAN RENK DOLU DOLU"
                ,"Bursa, Orhangazi"
                ,845000
                ,"TSN MOTORS ORHANGAZİ"
                ,"Bursa, Orhangazi, Camiikebir Mah."
                ,"18.11.2023"
                ,1137015265
                ,"Volswagen"
                ,"Golf"
                ,"1.0 TSI Comfortline"
                ,"2017"
                ,"Benzin"
                ,"Manuel"
                ,"İkinci El"
                ,80000
                ,"Hatchback 5 kapı"
                ,110
                ,999
                ,"Önden Çekiş"
                ,"Lacivert"
                ,"Hayır"
                ,"Hayır"
                ,"Türkiye(TR) Plakalı"
                ,"Galeriden"
                ,"Evet"
                ,"Evet"
        );
        arabalarListesi.add(araba4);
        Arabalar araba5 = new Arabalar(
                "p5"
                ,"ACİL SATILIK FİYAT DÜŞTÜ SAHİBİNDEN Audi A3 Limousine 1.6"
                ,"İzmir, Bornova"
                ,1175000
                ,"Metin Erdoğan"
                ,"İzmir, Bornova, Erzene Mah."
                ,"18.11.2023"
                ,1124821452
                ,"Audi"
                ,"A3"
                ,"A3 Sedan 1.6 TDI Dynamic"
                ,"2017"
                ,"Dizel"
                ,"Otomatik"
                ,"İkinci El"
                ,129000
                ,"Sedan"
                ,110
                ,1598
                ,"Önden Çekiş"
                ,"Beyaz"
                ,"Hayır"
                ,"Hayır"
                ,"Türkiye(TR) Plakalı"
                ,"Sahibinden"
                ,"Evet"
                ,"Hayır"
        );
        arabalarListesi.add(araba5);
        Arabalar araba6 = new Arabalar(
                "p6"
                ,"İMAJ OTODAN KLİMA ABS HİD DİREKSİYON ACCENT 1.5 GLS"
                ,"Kocaeli, İzmit"
                ,387500
                ,"İMAJ OTO"
                ,"Kocaeli, İzmit, Sanayi Mah."
                ,"18.11.2023"
                ,1137017298
                ,"Hyundai"
                ,"Accent"
                ,"1.5 GLS"
                ,"1997"
                ,"Benzin & LPG"
                ,"Otomatik"
                ,"İkinci El"
                ,228000
                ,"Sedan"
                ,85
                ,1495
                ,"Önden Çekiş"
                ,"Mor"
                ,"Hayır"
                ,"Hayır"
                ,"Türkiye(TR) Plakalı"
                ,"Galeriden"
                ,"Evet"
                ,"Evet"
        );
        arabalarListesi.add(araba6);
        Arabalar araba7 = new Arabalar(
                "p7"
                ,"SS'DEN DÜŞÜK KM BAKIMLARI YENİ UYGUN FİYAT'A"
                ,"Gaziantep, Nurdağı"
                ,372000
                ,"SS YAPI&AUTO"
                ,"Gaziantep, Nurdağı, Atatürk mh."
                ,"18.11.2023"
                ,1137016863
                ,"Peugeot"
                ,"307"
                ,"1.6 HDi Premium"
                ,"2006"
                ,"Dizel"
                ,"Manuel"
                ,"İkinci El"
                ,217000
                ,"Hatchback 5 kapı"
                ,110
                ,1560
                ,"Önden Çekiş"
                ,"Gümüş Gri"
                ,"Hayır"
                ,"Evet"
                ,"Türkiye(TR) Plakalı"
                ,"Galeriden"
                ,"Evet"
                ,"Evet"
        );
        arabalarListesi.add(araba7);
        arabalarListesi.add(araba1);
        arabalarListesi.add(araba2);
        arabalarListesi.add(araba3);


        ArabalarAdapter arabalarAdapter = new ArabalarAdapter(arabalarListesi,requireContext());
        binding.anasayfaRv.setAdapter(arabalarAdapter);

        return binding.getRoot();

    }


}