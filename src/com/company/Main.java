package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    Noten obj1 = new Noten();
        int[] note = {56,23, 78, 44, 9, 100};
        obj1.nicht_ausreichend(note);
        obj1.durschnitt(note);
        obj1.abgerundetNoten(note);
        obj1.maximalAbgerundet(note);

        Zahlen obj2 = new Zahlen();
        int[] zahlen = {4,8,3,10,17};
        obj2.maximal(zahlen);
        obj2.minmal(zahlen);
        obj2.maxSumme(zahlen);
        obj2.minSumme(zahlen);

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
        if(nichAusreichNoten.length ==0){
            System.out.println("Keine nicht ausreichende Noten");
            return null;
        }
        return nichAusreichNoten;
    }

    public int durschnitt(int[] noten){
        int durschnitt, summe = 0;
        boolean found_one = false;

        for(int i=0; i<noten.length; i++){
            found_one = true;
            summe = summe+noten[i];
        }
        if(found_one == false){
            System.out.println("Keine Noten gegeben");
            return 0;
        }
        durschnitt = summe/noten.length;
        //System.out.println(durschnitt);
        return durschnitt;
    }

    int[] abgerundetNoten(int[] noten){
        int[] abgerundetenNoten = new int[noten.length];
        for(int i=0; i<noten.length; i++){
            if(noten[i]>=38){  //wir abrunden, nur wenn die Note groeser gleich 38 ist
                int multiplu5 = noten[i];
                while(multiplu5 % 5 != 0){   //wir finden den nachsten multipel von 5
                    multiplu5++;
                }
                if(multiplu5 - noten[i] < 3){
                    abgerundetenNoten[i] = multiplu5;
                }
                else{
                    abgerundetenNoten[i]=noten[i];
                }
            }
            else{
                abgerundetenNoten[i]=noten[i];
            }
        }
        /*for(int i=0; i<abgerundetenNoten.length; i++)
            System.out.println(abgerundetenNoten[i]);*/
        return abgerundetenNoten;
    }

    int maximalAbgerundet(int[] noten){
        int max = 0;
        int[] abgerundetNoten = abgerundetNoten(noten);
        for(int i=0; i<noten.length; i++){
            if(abgerundetNoten[i] != noten[i]){
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
        int max = 0;
        for(int i=0; i<z.length; i++){
            if(z[i]>max){
                max = z[i];
            }
        }
        //System.out.println(max);
        return max;
    }

    public int minmal(int[] z){
        int min = z[0];
        for(int i=1; i<z.length; i++){
            if(z[i]<min){
                min=z[i];
            }
        }
        //System.out.println(min);
        return min;
    }

    public int maxSumme(int[] z){
        int min = minmal(z);
        int summe = 0;
        for(int i=0; i<z.length; i++){
            if(z[i] != min){
                summe = summe + z[i];
            }
        }
        //System.out.println(summe);
        return summe;
    }

    public int minSumme(int[] z){
        int max = maximal(z);
        int summe = 0;
        for(int i=0; i<z.length; i++){
            if(z[i] != max){
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
        int added = 0, carry=0;
        int[] sum = new int[n1.length];
        int poz1 = n1.length - 1;
        int poz2 = n2.length -1;

        while(poz2>=0){
            added=n1[poz1]+n2[poz2]+carry;
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
                    newSum[i]=1;
                }
                else{
                    newSum[i] = sum[i-1];
                }
            }

            /*for(int i=0; i<newSum.length; i++)
                System.out.println(newSum[i]);*/
            return newSum;

        }

        /*for(int i=0; i<sum.length; i++)
            System.out.println(sum[i]);*/

        return sum;
    }

    public boolean isSmaller(int[] nr1, int[] nr2){
        for(int i=0; i<nr1.length; i++){
            if(nr1[i]<nr2[i]){
                return true;
            }
            else{
                if(nr1[i]>nr2[i]){
                    return false;
                }
            }
        }
        return false;
    }

    public int[] calcDiff(int[] n1, int[] n2){
        int d,carry = 0;
        int[] rez = new int[n1.length];

        for(int i=n1.length-1; i>=0; i--){
            d = n1[i] - n2[i] - carry;
            if(d < 0){
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
            while(rez[poz]==0){  //fur wenn wir mehrere 0 am anfang der nummer haben
                poz++;
            }
            int[] newRez = new int[rez.length - poz];
            for(int i=0; i<newRez.length; i++) {
                newRez[i] = rez[i + poz];
            }
            /*for(int i=0; i<newRez.length; i++)
                System.out.println(newRez[i]);*/
            return newRez;
        }
        /*for(int i=0; i<rez.length; i++)
            System.out.println(rez[i]);*/
        return rez;
    }

    public int[] diff(int[] n1, int[] n2){
        int[] rez = new int[n1.length];
        if(isSmaller(n1,n2)){
            rez = calcDiff(n2,n1);
        }
        else{
            rez = calcDiff(n1,n2);
        }
        return rez;
    }

    public int[] multiplik(int[] n1, int nr){
        int poz = n1.length-1;
        int[] rez = new int[n1.length];
        int m, carry = 0;

        while(poz>=0){
            m = n1[poz] * nr + carry;
            if(m>9){
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
            /*for(int i=0; i<newRez.length; i++)
                System.out.println(newRez[i]);*/

            return newRez;
        }

        /*for(int i=0; i<rez.length; i++)
            System.out.println(rez[i]);*/

        return rez;
    }

    public int[] div(int[] n1, int nr){
        int[] rez = new int[n1.length];

        int poz = 0;
        int pozRez = 0;
        int temp = n1[poz];

        while(temp<nr){
            temp = temp*10+n1[poz+1];    //wir suchen die kleinste stuck der nummer die grosser als nr
            poz++;
        }

        while(poz<=n1.length-1){
            rez[pozRez] = temp/nr;
            pozRez++;
            if(poz+1>n1.length-1){
                break;              //wir brauchen kein temp wenn wir zu ende der nr sind
            }
            temp = (temp%nr)*10 + n1[poz+1];
            poz++;
        }

        /*for(int i=0; i<rez.length; i++)
            System.out.println(rez[i]);*/
        return rez;
    }
}

class Einkaufen{
    int[] tastaturen;
    int[] USBs;
    int budget;

    int billigsteTastatur(int[] tastaturen){
        int min = tastaturen[0];
        for(int i=1; i<tastaturen.length; i++){
            if(tastaturen[i] < min){
                min = tastaturen[i];
            }
        }
        //System.out.println(min);
        return min;
    }

    int teuerstenGegenstand(int[] tastaturen, int[] USBs){
        int max = tastaturen[0];
        for(int i=1; i<tastaturen.length; i++){
            if(tastaturen[i]>max){
                max = tastaturen[i];
            }
        }
        for(int j=0; j<USBs.length; j++){
            if(USBs[j]>max){
                max = USBs[j];
            }
        }
        //System.out.println(max);
        return max;
    }

    int teuerstUSBMarkus(int[] USBs, int budget){
        int max = 0;
        for(int i=0; i< USBs.length; i++){
            if(USBs[i]>max && USBs[i]<budget){
                max=USBs[i];
            }
        }
        //System.out.println(max);
        return max;
    }

    int maxGeldbetrag(int[] tastaturen, int[] USBs, int budget){
        Arrays.sort(tastaturen);
        Arrays.sort(USBs);

        int pozTast = tastaturen.length-1;
        int pozUsb = USBs.length-1;
        int t, u;

        while(pozTast>=0){
            pozUsb = USBs.length-1;
            while(pozUsb>=0){
                t=tastaturen[pozTast];
                u=USBs[pozUsb];
                if(t+u<=budget){
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


        //System.out.println(Arrays.toString(tastaturen));        //pus la restu cu liste

    }

}