package com.example.android_with_java.ders2.stadart_programlama;

public class KarsilastirmaOperatorleri {
    public static void main(String[] args) {
        int a = 40;
        int b = 50;

        int x = 90;
        int y = 80;

        System.out.println("a == b : " + (a==b));
        System.out.println("a != b : " + (a!=b));
        System.out.println("a >  b : " + (a>b));
        System.out.println("a >= b : " + (a>=b));
        System.out.println("a <  b : " + (a<b));
        System.out.println("a <= b : " + (a<=b));

        System.out.println("a > b || x > y : " + (a > b || x > y));
        System.out.println("a > b && x > y : " + (a > b && x > y));
    }
}
