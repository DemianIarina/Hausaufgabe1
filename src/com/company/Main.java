package com.company;

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
        int[] nr1 = {9,1,2,3,4,5,6};
        int[] nr2 = {9,3,4,5,6,7};
        obj3.summe(nr1, nr2);
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
        int max_len;

        if(n1.length > n2.length){    //der summe array ist der gleiche grosse wie der grooste array
            //max_len = n1.length;
            return berechnenSum(n1, n2);
        }
        else{
            //max_len = n2.length;
            return berechnenSum(n2, n1);
        }


                                            // wenn er grosser sein muss, dann wir er neu gemacht

        //ne ducem de la capat spre inceput, pana cand se termina nr mai mic, dupa adaugam restu, si sau ce ramane din ala mai amre
    }

    public int[] berechnenSum(int[] firstNr, int[] secondNr){
        int added = 0, carry=0;
        int[] sum = new int[firstNr.length];
        int poz1 = firstNr.length - 1;
        int poz2 = secondNr.length -1;

        while(poz2>=0){
            added=firstNr[poz1]+secondNr[poz2]+carry;
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
        while(poz1>=0){    //wenn die Zahlen nicht gleich lang sind
            added=firstNr[poz1]+carry;
            if(added>9){
                carry = 1;
            }
            else{
                carry = 0;
            }
            sum[poz1] = added % 10;
            poz1--;
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
}