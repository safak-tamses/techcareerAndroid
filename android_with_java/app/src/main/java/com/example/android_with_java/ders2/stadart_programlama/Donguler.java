package com.example.android_with_java.ders2.stadart_programlama;

public class Donguler {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Dongu : " + (i + 1));
        }
        for (int j = 10; j < 20; j += 5) {
            System.out.println("Dongu : " + j);
        }
        for (int y = 20; y > 9; y -= 5) {
            System.out.println("Dongu : " + y);
        }
        int sayac = 1;
        while (sayac < 4) {
            System.out.println("Dongu : " + sayac);
            sayac++;
        }
        for (int i = 1; i < 6; i++) {
            if (i == 3) {
                break;
            }
            System.out.println("Dongu : " + i);
        }
        for (int i = 1; i < 6; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println("Dongu : " + i);
        }
    }
}
