package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    Noten obj1 = new Noten();
        int[] note = {56,23, 78, 44, 9, 100, 77};
        int[] note2 = {55, 100};
        System.out.print("Nicht ausreichende Noten: ");
        System.out.println(Arrays.toString(obj1.nicht_ausreichend(note)));
        System.out.print("Nicht ausreichende Noten bsp2: ");
        obj1.nicht_ausreichend(note2);   //wenn es keine nicht ausreichende noten gibt
        System.out.print("Durchschnitt: ");
        System.out.println(obj1.durchschnitt(note));
        System.out.print("Abgerundeten Noten: ");
        System.out.println(Arrays.toString(obj1.abgerundetNoten(note)));
        System.out.print("Maximal abgerundeten Note: ");
        System.out.println(obj1.maximalAbgerundet(note));

        Zahlen obj2 = new Zahlen();
        int[] zahlen = {4,8,3,10,17,3};
        int[] zahlen2 = {1,1,1,1,1};
        int[] zahlen3 = {1,2,3,3,1};
        System.out.print("Maximale Zahl: ");
        System.out.println(obj2.maximal(zahlen));
        System.out.print("Minimale Zahl: ");
        System.out.println(obj2.minimal(zahlen));
        System.out.print("Maximale Summe von n-1 Zahlen: ");
        System.out.println(obj2.maxSumme(zahlen));
        System.out.print("Maximale Summe von n-1 Zahlen bsp2: ");
        System.out.println(obj2.maxSumme(zahlen2));   //wenn der min mehrere mal erscheint
        System.out.print("Minimale Summe von n-1 Zahlen: ");
        System.out.println(obj2.minSumme(zahlen));
        System.out.print("Maximale Summe von n-1 Zahlen bsp2: ");
        System.out.println(obj2.minSumme(zahlen3));   //wenn der max mehrere mal erscheint

        GrosseZahlen obj3 = new GrosseZahlen();
        int[] nr1 = {1,3,0,0,0,0,0,0,0};
        int[] nr2 = {8,9,0,0,0,0,5,0,0};
        System.out.print("Summe: ");
        System.out.println(Arrays.toString(obj3.summe(nr1, nr2)));
        int[] nr3 = {8,3,0,0,0,0,0,0,0};
        int[] nr4 = {5,4,0,0,0,0,0,0,0};
        System.out.print("Differenz: ");
        System.out.println(Arrays.toString(obj3.diff(nr3, nr4)));
        int[] nr33 = {8,3,0,0,0,0,0,0,1};
        int[] nr44 = {8,2,0,0,0,0,0,0,5};
        System.out.print("Differenz bsp2: ");
        System.out.println(Arrays.toString(obj3.diff(nr33, nr44)));   //wenn der rez mit 2 ziffern kleiner ist
        int[] nr5 = {2,3,6,0,0,0,0,0,0};
        System.out.print("Multiplikation: ");
        System.out.println(Arrays.toString(obj3.multiplik(nr5, 4)));
        System.out.print("Multiplikation bsp2: ");
        System.out.println(Arrays.toString(obj3.multiplik(nr5, 10)));  //wenn der rez mit 2 ziffer grosser ist
        System.out.print("Division: ");
        System.out.println(Arrays.toString(obj3.div(nr5, 2)));
        System.out.print("Division bsp2: ");
        System.out.println(Arrays.toString(obj3.div(nr5, 12)));       //wenn de rez kurzer ist

        Einkaufen obj4 = new Einkaufen();
        int[] t1 = {40,35,70,15,45};
        System.out.print("Billigste Tastatur: ");
        System.out.println(obj4.billigsteTastatur(t1));
        int[] t2 = {15,20,10,35};
        int[] u2 = {20,15,40,15};
        System.out.print("Teuersten Gegenstand: ");
        System.out.println(obj4.teuerstenGegenstand(t2, u2));
        int[] u3 = {15,45,30};
        System.out.print("Teuerste USB Laufwerk, das Markus kaufen kann ");
        System.out.println(obj4.teuerstUSBMarkus(u3, 30));
        int[] t4 = {40,50,60};
        int[] u4 = {11,12};
        System.out.print("Der maximalen Geldbetrag, der von Markus ausgegeben wird: ");
        System.out.println(obj4.maxGeldbetrag(t4, u4,51));
        int[] t44 = {60};
        int[] u44 = {8,12};
        System.out.print("Der maximalen Geldbetrag, der von Markus ausgegeben wird bsp2: ");
        System.out.println(obj4.maxGeldbetrag(t44, u44,60));
        int[] t444 = {40,60};
        int[] u444 = {8,12};
        System.out.print("Der maximalen Geldbetrag, der von Markus ausgegeben wird bsp3: ");
        System.out.println(obj4.maxGeldbetrag(t444, u444,60));
    }
}