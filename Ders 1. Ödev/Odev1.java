package com.example.firstlessonscode.ders1.degiskenler;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Odev1 {
    public enum medeniHal {
        EVLI,
        BEKAR
    };
    public enum mekanPuani {
        bir,
        iki,
        uc,
        dort,
        bes
    };
    public enum resimFormati {
        jpg,
        png,
        svg,
        jpeg,
        bmp
    };
    public enum renk {
        sari,
        mavi,
        pembe,
        yesil,
        kirmizi,
        mor,
        siyah,

    };
    public class EkranBoyutu {
        private int genislik;
        private int yukseklik;

        public EkranBoyutu() {
        }

        public EkranBoyutu(int genislik, int yukseklik) {
            this.genislik = genislik;
            this.yukseklik = yukseklik;
        }

        public int getGenislik() {
            return genislik;
        }

        public int getYukseklik() {
            return yukseklik;
        }

        public void setGenislik(int genislik) {
            this.genislik = genislik;
        }

        public void setYukseklik(int yukseklik) {
            this.yukseklik = yukseklik;
        }
    }
    public static void main(String[] args) {
        String ilce = "Pendik";
        System.out.println("İlçe: " + ilce);

        String kita = "Asya";
        System.out.println("Kıta: " + kita);

        long faks = 902165367214367L;
        System.out.println("Faks: " + faks);

        int postaKodu = 34403;
        System.out.println("Posta Kodu: " + postaKodu);

        String instaAdresi = "https://www.instagram.com/_safakt/";
        System.out.println("Instagram Adresi: " + instaAdresi);

        String calistiginBolum = "Software Developer";
        System.out.println("Çalıştığın Bölüm: " + calistiginBolum);

        int urunMiktari = 348;
        System.out.println("Ürün Miktarı: " + urunMiktari);

        String musteriSoyadi = "Tamses";
        System.out.println("Müşteri Soyadı: " + musteriSoyadi);

        Double odemeMiktari = 148.5;
        System.out.println("Ödeme Miktarı: " + odemeMiktari);

        LocalDate dogumTarihi = LocalDate.of(1996, 2, 6);
        System.out.println("Doğum Tarihi: " + dogumTarihi);

        Double borc = 690.54;
        System.out.println("Borç: " + borc);

        medeniHal medeniHal = Odev1.medeniHal.BEKAR;
        System.out.println("Medeni Hal: " + medeniHal);

        String videoYorumu = "Video çok güzel. Başarılarının devamını dilerim.";
        System.out.println("Video Yorumu: " + videoYorumu);

        LocalTime odemeSaati = LocalTime.of(14, 40);
        System.out.println("Ödeme Saati: " + odemeSaati);

        Double eftMiktari = 1454.5;
        System.out.println("EFT Miktarı: " + eftMiktari);

        int satilanMiktar = 143;
        System.out.println("Satılan Miktar: " + satilanMiktar);

        String telefonModeli = "Samsung Galaxy A3";
        System.out.println("Telefon Modeli: " + telefonModeli);

        String dergiAdi = "Kafa";
        System.out.println("Dergi Adı: " + dergiAdi);

        LocalDate basimTarihi = LocalDate.of(1992, 11, 3);
        System.out.println("Basım Tarihi: " + basimTarihi);

        int zamMiktari = 45;
        System.out.println("Zam Miktarı: " + zamMiktari);

        int daireSayisi = 8;
        System.out.println("Daire Sayısı: " + daireSayisi);

        Double enlem = 43.25;
        System.out.println("Enlem: " + enlem);

        Double boylam = 10.8;
        System.out.println("Boylam: " + boylam);

        String yemekAdi = "Karnıyarık";
        System.out.println("Yemek Adı: " + yemekAdi);

        Double urunFiyati = 249.99;
        System.out.println("Ürün Fiyatı: " + urunFiyati);

        String sirket = "techcareer";
        System.out.println("Şirket: " + sirket);

        String videoAdi = "Ders Videosu";
        System.out.println("Video Adı: " + videoAdi);

        Duration muzikSuresi = Duration.ofMinutes(3).plusSeconds(43);
        System.out.println("Müzik Süresi: " + muzikSuresi);

        mekanPuani mekanPuani = Odev1.mekanPuani.dort;
        System.out.println("Mekan Puanı: " + mekanPuani);

        String dosyaAdi = "dosya_deneme";
        System.out.println("Dosya Adı: " + dosyaAdi);

        resimFormati resimFormati = Odev1.resimFormati.bmp;
        System.out.println("Resim Formatı: " + resimFormati);

        renk renk = Odev1.renk.kirmizi;
        System.out.println("Renk: " + renk);

        String renkKodu = "#FF0000";
        System.out.println("Renk Kodu: " + renkKodu);

        String bilgisayarModeli = "Tulpar v13";
        System.out.println("Bilgisayar Modeli: " + bilgisayarModeli);

        Double ekranBoyutu = 13.5;
        System.out.println("Ekran Boyutu: "+ ekranBoyutu + " inc");

        Duration kullanimSuresi = Duration.ofHours(2).plusMinutes(30);
        System.out.println("Kullanım Süresi: " + kullanimSuresi);

        Double basinc = 1.01325;
        System.out.println("Basınç: " + basinc);

        LocalDate etkinlikGunu = LocalDate.of(2023, 12, 31);
        System.out.println("Etkinlik Günü: " + etkinlikGunu);

        LocalDate odemeGunu = LocalDate.of(2023, 12, 21);
        System.out.println("Ödeme Günü: " + odemeGunu);

        LocalDate yolculukCikisTarihi = LocalDate.of(2023, 11, 21);
        System.out.println("Yolculuk Çıkış Tarihi: " + yolculukCikisTarihi);

        String mahalleAdı = "Çamçeşme mahallesi";
        System.out.println("Mahalle Adı: " + mahalleAdı);

        String otobusHatti = "12A";
        System.out.println("Otobüs Hattı: " + otobusHatti);

        int kullanilanDakika = 120;
        System.out.println("Kullanılan Dakika: " + kullanilanDakika);

        Long kargoTakipNo = 14259232L;
        System.out.println("Kargo Takip Numarası: " + kargoTakipNo);

        LocalDateTime kuponSuresi = LocalDateTime.of(2023, 12, 31, 15, 30);
        System.out.println("Kupon Süresi: " + kuponSuresi);

        Long kuponKodu = 43621267823L;
        System.out.println("Kupon Kodu: " + kuponKodu);

        LocalDate faturaTarihi = LocalDate.of(2023, 10, 23);
        System.out.println("Fatura Tarihi: " + faturaTarihi);
    }

}
