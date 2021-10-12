package com.company;

public class Zahlen {
    /*
    2.1 das maximal Zahl von ein Array
    Vorb: ein Array von n positive zahlen
    Nachb: ein int, der grosste
    Ausnahmen: wenn der array leer ist
 */
    public int maximal(int[] z){

        if(z.length == 0){           //error, wenn es keine zahlen gibt
            System.err.println("Keine zahlen gegeben");
            return 0;
        }

        int max = 0;
        for(int i=0; i<z.length; i++){       //durchlaufen den Array
            if(z[i]>max){                    //vergleichen jedes element mit dem bisherigen maximum
                max = z[i];
            }
        }
        return max;
    }

    /*
        2.2 das minimal Zahl von ein Array
        Vorb: ein Array von n positive zahlen
        Nachb: ein int, der kleinste
        Ausnahmen: wenn der array leer ist
     */
    public int minimal(int[] z){

        if(z.length == 0){           //error, wenn es keine zahlen gibt
            System.err.println("Keine zahlen gegeben");
            return 0;
        }

        int min = z[0];                    //der ersten elem in das min
        for(int i=1; i<z.length; i++){     //durchlaufen den Array
            if(z[i]<min){                  //vergleichen jedes element mit dem bisherigen minimum
                min=z[i];
            }
        }
        return min;
    }

    /*
        2.3 die maximale Summe von n-1 Zahlen in den Array (ohne der min, einmal)
        Vorb: ein Array von n positive zahlen
        Nachb: ein int
        Ausnahmen: wenn der array leer ist
    */
    public int maxSumme(int[] z){

        if(z.length == 0){           //error, wenn es keine zahlen gibt
            System.err.println("Keine zahlen gegeben");
            return 0;
        }

        int min = minimal(z);
        int summe = 0;
        int n=0;                              //wie viele male hat das min erschienen
        for(int i=0; i<z.length; i++){        //die summe aller nummer, ohne den kleinste
            if(z[i]==min){
                n++;
            }
            if(z[i] != min || n>1){           //wenn der nummer nicht da min ist, oder wenn das min hat schon einmal erschienen
                summe = summe + z[i];
            }
        }
        return summe;
    }

    /*
        2.4 die minimale Summe von n-1 Zahlen in den Array (ohne der max, einmal)
        Vorb: ein Array von n positive zahlen
        Nachb: ein int
        Ausnahmen: wenn der array leer ist
    */
    public int minSumme(int[] z){

        if(z.length == 0){           //error, wenn es keine zahlen gibt
            System.err.println("Keine zahlen gegeben");
            return 0;
        }

        int max = maximal(z);
        int summe=0;
        int n=0;                              //wie viele male hat das max erschienen
        for(int i=0; i<z.length; i++){        //die summe aller nummer, ohne den kleinste
            if(z[i]==max){
                n++;
            }
            if(z[i] != max || n>1){           //wenn der nummer nicht da min ist, oder wenn das min hat schon einmal erschienen
                summe = summe + z[i];
            }
        }
        return summe;
    }
}
