package com.company;

import java.util.Arrays;

public class Einkaufen {
    /*
       4.1 finden der kleinste zahl, in eine liste von tastatur preise
       Vorb: 1 Array von int zahlen
       Nachb: ein int
       Ausnahmen: wenn der array leer ist
   */
    int billigsteTastatur(int[] tastaturen){

        if(tastaturen.length == 0){           //error, wenn es keine preise gibt
            System.err.println("Keine preise gegeben");
            return 0;
        }

        int min = tastaturen[0];
        for(int i=1; i<tastaturen.length; i++){        //durchlaufen den ganzen Array
            if(tastaturen[i] < min){                   //wenn der aktuelles preis kleiner als min ist
                min = tastaturen[i];
            }
        }
        return min;
    }

    /*
        4.2 finden die grosste zahl in 2 liste - von tastatur preise und USBs preise
        Vorb: 2 Array von int zahlen
        Nachb: ein int
        Ausnahmen: wenn ein der beiden arrays leer ist
    */
    int teuerstenGegenstand(int[] tastaturen, int[] USBs){

        if(tastaturen.length == 0 || USBs.length ==0){           //error, wenn es keine preise gibt
            System.err.println("Keine preise gegeben");
            return 0;
        }

        int max = tastaturen[0];
        for(int i=1; i<tastaturen.length; i++){          //finden den max preis aus tastaturen
            if(tastaturen[i]>max){
                max = tastaturen[i];
            }
        }
        for(int j=0; j<USBs.length; j++){                //suchen, ob ein USB teurer aks den max tastatur ist
            if(USBs[j]>max){
                max = USBs[j];
            }
        }
        return max;
    }

    /*
        4.3 finden die grosste zahl in eine liste von tastatur preise, aber der kleiner als den gegebenen zahl ist
        Vorb: 1 Array von int zahlen, ein int
        Nachb: ein int
        Ausnahmen: wenn der array leer ist
    */
    int teuerstUSBMarkus(int[] USBs, int budget){

        if(USBs.length == 0){           //error, wenn es keine preise gibt
            System.err.println("Keine preise gegeben");
            return 0;
        }

        int max = 0;
        for(int i=0; i< USBs.length; i++){       //durchlaufen den Array
            if(USBs[i]>max && USBs[i]<=budget){   //suchen nach max preis in USB, aber der kleiner gleich als der budget
                max=USBs[i];
            }
        }
        return max;
    }

    /*
        4.4 finden die teuerste combination von tastatur un USB, der kleiner gleich das gegebenen zahl - das Budget ist
        Vorb: 2 Arrays von int zahlen, ein int
        Nachb: ein int
        Ausnahmen: wenn der array leer ist
    */
    int maxGeldbetrag(int[] tastaturen, int[] USBs, int budget){

        if(tastaturen.length == 0 || USBs.length ==0){           //error, wenn es keine preise gibt
            System.err.println("Keine preise gegeben");
            return 0;
        }

        Arrays.sort(tastaturen);         //beide arrays aufsteigend geordnet
        Arrays.sort(USBs);

        int pozTast = tastaturen.length-1;
        int pozUsb;
        int t, u;

        while(pozTast>=0){              //von der teuersten anfangend
            pozUsb = USBs.length-1;
            while(pozUsb>=0){
                t=tastaturen[pozTast];
                u=USBs[pozUsb];
                if(t+u<=budget){           //wenn die aktuelle preise, kleiner gleich der budget sind
                    return t+u;
                }
                else{
                    pozUsb--;
                }
            }
            pozTast--;
        }
        return -1;

    }
}
