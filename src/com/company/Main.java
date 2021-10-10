package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    Noten obj1 = new Noten();
        int[] note = {56,23, 78, 44, 9, 100};
        int[] note2 = {55, 100};
        obj1.nicht_ausreichend(note);
        //obj1.nicht_ausreichend(note2);
        obj1.durschnitt(note);
        obj1.abgerundetNoten(note);
        obj1.maximalAbgerundet(note);

        Zahlen obj2 = new Zahlen();
        int[] zahlen = {4,8,3,10,17};
        int[] zahlen2 = {1,1,1,1,1};
        int[] zahlen3 = {1,2,3,3,1};
        obj2.maximal(zahlen);
        obj2.minimal(zahlen);
        obj2.maxSumme(zahlen);
        //obj2.maxSumme(zahlen2);
        obj2.minSumme(zahlen);
        //obj2.minSumme(zahlen3);

        GrosseZahlen obj3 = new GrosseZahlen();
        int[] nr1 = {1,3,0,0,0,0,0,0,0};
        int[] nr2 = {8,7,0,0,0,0,0,0,0};
        obj3.summe(nr1, nr2);
        int[] nr3 = {8,3,0,0,0,0,0,0,1};
        int[] nr4 = {8,2,0,0,0,0,0,0,5};
        obj3.diff(nr3, nr4);
        int[] nr5 = {2,3,6,0,0,0,0,0};
        obj3.multiplik(nr5, 2);
        obj3.div(nr5, 2);

        Einkaufen obj4 = new Einkaufen();
        int[] t1 = {40,35,70,15,45};
        obj4.billigsteTastatur(t1);
        int[] t2 = {15,20,10,35};
        int[] u2 = {20,15,40,15};
        obj4.teuerstenGegenstand(t2, u2);
        int[] u3 = {15,45,20};
        obj4.teuerstUSBMarkus(u3, 30);
        int[] t4 = {40,50,60};
        int[] u4 = {8,12};
        obj4.maxGeldbetrag(t4, u4,60);
        int[] t44 = {60};
        int[] u44 = {8,12};
        obj4.maxGeldbetrag(t44, u44,60);
        int[] t444 = {40,60};
        int[] u444 = {8,12};
        obj4.maxGeldbetrag(t444, u444,60);
    }
}

class Noten{
    private int[] noten;

    /*public Noten(int[] noten){
        this.noten = noten;
    }*/

    public int[] nicht_ausreichend(int[] noten){

        if(noten.length == 0){           //error wenn es keine noten gibt
            System.err.println("Keine noten gegeben");
            return null;
        }

        int nichAusreichNoten[] = new int[0];
        int pos = 0, len = 0;
        for (int i=0; i<noten.length; i++)
            if(noten[i]<40) {
                int newarr[] = new int[len + 1];   //wir machen ein neuen Array, mit den geeignete lange
                for (int j = 0; j < len; j++)
                    newarr[j] = nichAusreichNoten[j];
                len++;
                nichAusreichNoten = newarr;

                nichAusreichNoten[pos] = noten[i];   //einfugen die nicht ausreichende note in den array
                pos++;
            }

        /*for(int i=0; i<nichAusreichNoten.length; i++)
            System.out.println(nichAusreichNoten[i]);*/

        if(nichAusreichNoten.length ==0){        //error wenn es keine solche noten gibt
            System.out.println("Keine nicht ausreichende Noten");
            return null;
        }
        return nichAusreichNoten;
    }

    public int durschnitt(int[] noten){

        if(noten.length == 0){           //error wenn es keine noten gibt
            System.err.println("Keine noten gegeben");
            return 0;
        }

        int durschnitt, summe = 0;

        for(int i=0; i<noten.length; i++){   //wir machen die summe aller noten
            summe = summe+noten[i];
        }

        durschnitt = summe/noten.length;
        //System.out.println(durschnitt);
        return durschnitt;
    }

    int[] abgerundetNoten(int[] noten){

        if(noten.length == 0){           //error wenn es keine noten gibt
            System.err.println("Keine noten gegeben");
            return null;
        }

        int[] abgerundetenNoten = new int[noten.length];
        for(int i=0; i<noten.length; i++){
            if(noten[i]>=38){                        //wir abrunden, nur wenn die Note groesser gleich 38 ist
                int multiplu5 = noten[i];
                while(multiplu5 % 5 != 0){           //wir finden den nachsten multipel von 5
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

        //System.out.println(Arrays.toString(abgerundetenNoten));

        return abgerundetenNoten;
    }

    int maximalAbgerundet(int[] noten){

        if(noten.length == 0){           //error wenn es keine noten gibt
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

        //System.out.println(max);

        return max;
    }
}

class Zahlen{
    private int[] z;

    public int maximal(int[] z){

        if(z.length == 0){           //error wenn es keine zahlen gibt
            System.err.println("Keine zahlen gegeben");
            return 0;
        }

        int max = 0;
        for(int i=0; i<z.length; i++){       //durchlaufen den Array
            if(z[i]>max){                    //vergleichen jedes element mit dem bisherigen maximum
                max = z[i];
            }
        }

        //System.out.println(max);

        return max;
    }

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

        //System.out.println(min);

        return min;
    }

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

        //System.out.println(summe);

        return summe;
    }

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

       //System.out.println(summe);

        return summe;
    }
}

class GrosseZahlen{
    private int[] n;

    public int[] summe(int[] n1, int[] n2){

        if(n1.length == 0 || n2.length == 0 || n1.length!=n2.length){           //error, wenn es keine Zahlen gegeben sind,wenn sie nicht gleich lang sind
            System.err.println("Die gegebene Zahlen sind nicht gut");
            return null;
        }

        int added = 0, carry=0;
        int[] sum = new int[n1.length];
        int poz1 = n1.length - 1;                  //beginnen am Ende der beiden arrays
        int poz2 = n2.length -1;

        while(poz2>=0){
            added=n1[poz1]+n2[poz2]+carry;           //addieren ziffern die aus denselben position sind + das carry von den letzten addieren
            if(added>9){
                carry = 1;
            }
            else{
                carry = 0;
            }
            sum[poz1] = added % 10;
            poz1--;
            poz2--;
        }

        if(carry == 1){                             //wenn wir noch carry haben, dann mussen wir ein grosseres Array machen
            int[] newSum = new int[sum.length +1];
            for(int i=0; i<newSum.length; i++){
                if(i==0){
                    newSum[i]=1;                    //wegen der carry
                }
                else{
                    newSum[i] = sum[i-1];           //kopieren den rest des Arrays
                }
            }

            //System.out.println(Arrays.toString(newSum));

            return newSum;

        }

        //System.out.println(Arrays.toString(sum));

        return sum;
    }

    //die zahlen gaben die gleiche lange
    public boolean isSmaller(int[] nr1, int[] nr2){
        for(int i=0; i<nr1.length; i++){
            if(nr1[i]<nr2[i]){            //wenn ein der ziffern auf denselben position kleiner ist
                return true;
            }
            else{
                if(nr1[i]>nr2[i]){
                    return false;
                }
            }
        }
        return false;     //wenn die zahlen = sind
    }

    public int[] calcDiff(int[] n1, int[] n2){
        int d,carry = 0;
        int[] rez = new int[n1.length];

        for(int i=n1.length-1; i>=0; i--){     //von ende der beiden zahlen
            d = n1[i] - n2[i] - carry;
            if(d < 0){        //wenn die diff zu klein ist, dann leihen wir ein 1 von den nachsten ziffern
                d = d+10;
                carry=1;
            }
            else {
                carry = 0;
            }
            rez[i] = d;
        }

        if(rez[0]==0){
            int poz = 0;
            while(rez[poz]==0){         //fur wenn wir mehrere 0 am anfang der nummer haben
                poz++;
            }
            int[] newRez = new int[rez.length - poz];
            for(int i=0; i<newRez.length; i++) {
                newRez[i] = rez[i + poz];
            }
            return newRez;
        }
        return rez;
    }

    public int[] diff(int[] n1, int[] n2){

        if(n1.length == 0 || n2.length == 0 || n1.length!=n2.length){           //error, wenn es keine Zahlen gegeben sind,wenn sie nicht gleich lang sind
            System.err.println("Die gegebene Zahlen sind nicht gut");
            return null;
        }

        int[] rez;
        if(isSmaller(n1,n2)){        //immer der kleinere aus der grosste nummer abziehen
            rez = calcDiff(n2,n1);
        }
        else{
            rez = calcDiff(n1,n2);
        }

        //System.out.println(Arrays.toString(rez));

        return rez;
    }

    public int[] multiplik(int[] n1, int nr){

        if(n1.length == 0){           //error, wenn es keine Zahlen gegeben sind,wenn sie nicht gleich lang sind
            System.err.println("Die gegeben Zahl ist nicht gut");
            return null;
        }

        int poz = n1.length-1;
        int[] rez = new int[n1.length];
        int m, carry = 0;

        while(poz>=0){
            m = n1[poz] * nr + carry;      //jede ziffer wird multipliziert
            if(m>9){                       //wenn es zu gross ist
                carry = m/10;
                m=m%10;
            }
            else
                carry=0;

            rez[poz] = m;
            poz--;
        }

        if(carry!=0){                               //wir brauchen ein grosseres nummer
            int[] newRez = new int[n1.length +1];
            for(int i=0; i<newRez.length; i++){
                if(i==0){
                    newRez[i]=carry;   //carry kann maximal 8 sein
                }
                else{
                    newRez[i] = rez[i-1];
                }
            }
            //System.out.println(Arrays.toString(newRez));

            return newRez;
        }

        //System.out.println(Arrays.toString(rez));

        return rez;
    }

    public int[] div(int[] n1, int nr){

        if(n1.length == 0){           //error, wenn es keine Zahlen gegeben sind,wenn sie nicht gleich lang sind
            System.err.println("Die gegeben Zahl ist nicht gut");
            return null;
        }

        int[] rez = new int[n1.length];

        int poz = 0;
        int pozRez = 0;
        int temp = n1[poz];

        while(temp<nr){
            temp = temp*10+n1[poz+1];    //wir suchen die kleinste stuck der nummer die grosser als nr(der mit der wir div)
            poz++;
        }

        while(poz<=n1.length-1){
            rez[pozRez] = temp/nr;
            pozRez++;
            if(poz+1>n1.length-1){
                break;                   //wir brauchen kein temp wenn wir zu ende der nr sind
            }
            temp = (temp%nr)*10 + n1[poz+1];
            poz++;
        }

        //System.out.println(Arrays.toString(rez));

        return rez;
    }
}

class Einkaufen{
    int[] tastaturen;
    int[] USBs;
    int budget;

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

        //System.out.println(min);

        return min;
    }

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

        //System.out.println(max);

        return max;
    }

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

        //System.out.println(max);

        return max;
    }

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

                    //System.out.println(t+u);

                    return t+u;
                }
                else{
                    pozUsb--;
                }
            }
            pozTast--;
        }

        //System.out.println("-1");

        return -1;

    }

}