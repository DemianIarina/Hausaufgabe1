package com.company;

public class Noten {
    /*
        1.1 ein Array von Noten die nicht ausreichend sind(<40)
        Vorb: ein Array von int zwischen 0 und 100
        Nachb: ein Array von int, kleiner als 40, oder null
        Ausnahmen: wenn der array leer ist
     */
    public int[] nicht_ausreichend(int[] noten){

        if(noten.length == 0){           //error, wenn es keine noten gibt
            System.err.println("Keine noten gegeben");
            return null;
        }

        int nichAusreichNoten[] = new int[0];
        int pos = 0, len = 0;
        for (int i=0; i<noten.length; i++)
            if(noten[i]<40) {
                int newarr[] = new int[len + 1];   //wir machen einen neuen Array, mit den geeignete lange
                for (int j = 0; j < len; j++)
                    newarr[j] = nichAusreichNoten[j];
                len++;
                nichAusreichNoten = newarr;

                nichAusreichNoten[pos] = noten[i];   //einfugen die nicht ausreichende note in den array
                pos++;
            }

        if(nichAusreichNoten.length ==0){        //error, wenn es keine solche noten gibt
            System.out.println("Keine nicht ausreichende Noten");
            return null;
        }
        return nichAusreichNoten;
    }

    /*
        1.2 der durchschnittliche wert von ein Array
        Vorb: ein Array von int zwischen 0 und 100
        Nachb: ein int
        Ausnahmen: wenn der array leer ist
    */
    public int durchschnitt(int[] noten){

        if(noten.length == 0){           //error, wenn es keine noten gibt
            System.err.println("Keine noten gegeben");
            return 0;
        }

        int durchschnitt, summe = 0;
        for(int i=0; i<noten.length; i++){   //wir machen die summe aller noten
            summe = summe+noten[i];
        }

        durchschnitt = summe/noten.length;
        return durchschnitt;
    }

    /*
        1.3 ein Array von abgerundeten Noten, nach den regel
        Vorb: ein Array von int zwischen 0 und 100
        Nachb: ein Array von int
        Ausnahmen: wenn der array leer ist
    */
    int[] abgerundetNoten(int[] noten){

        if(noten.length == 0){           //error, wenn es keine noten gibt
            System.err.println("Keine noten gegeben");
            return null;
        }

        int[] abgerundetenNoten = new int[noten.length];
        for(int i=0; i<noten.length; i++){
            if(noten[i]>=38){                        //wir abrunden, nur wenn die Note grosser gleich 38 ist
                int multiplu5 = noten[i];
                while(multiplu5 % 5 != 0){           //wir finden den nächsten multipel von 5
                    multiplu5++;
                }
                if(multiplu5 - noten[i] < 3){        //wenn die Differenz weniger als 3 ist, dann wird abgerundet
                    abgerundetenNoten[i] = multiplu5;
                }
                else{
                    abgerundetenNoten[i]=noten[i];
                }
            }
            else{                                   //wenn wir nicht abrunden mussen
                abgerundetenNoten[i]=noten[i];
            }
        }
        return abgerundetenNoten;
    }

    /*
        1.4 die maximale wert die im ursprünglichen Array nicht gab
        Vorb: ein Array von int zwischen 0 und 100
        Nachb: ein int
        Ausnahmen: wenn der array leer ist
     */
    int maximalAbgerundet(int[] noten){

        if(noten.length == 0){           //error, wenn es keine noten gibt
            System.err.println("Keine noten gegeben");
            return 0;
        }

        int max = 0;
        int[] abgerundetNoten = abgerundetNoten(noten);         //wir abrunden alle noten
        for(int i=0; i<noten.length; i++){
            if(abgerundetNoten[i] != noten[i]){                 //nur die noten die abgerundet wurden
                if(abgerundetNoten[i]>max){
                    max = abgerundetNoten[i];
                }
            }
        }
        return max;
    }
}
