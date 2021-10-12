package com.company;

public class GrosseZahlen {
    /*
        3.1 die Summe zwei grosse zahlen, addiert eine ziffer nach ein andere, mit carry
        Vorb: 2 Array von ziffern, gleicher lange
        Nachb: ein Array von ziffern, kann eine grosser lange als der vorherigen haben
        Ausnahmen: wenn die arrays leer sind, wenn sie nicht denselben lange haben
    */
    public int[] summe(int[] n1, int[] n2){

        if(n1.length == 0 || n2.length == 0 || n1.length!=n2.length){           //error, wenn es keine Zahlen gegeben sind, wenn sie nicht gleich lang sind
            System.err.println("Die gegebene Zahlen sind nicht gut");
            return null;
        }

        int added, carry=0;
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
            return newSum;

        }
        return sum;
    }

    //prüfen welchen zahlen grosser ist, ziffer nach ziffer
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
        return false;     //wenn die zahlen gleich sind
    }

    public int[] calcDiff(int[] n1, int[] n2){
        int d,carry = 0;
        int[] rez = new int[n1.length];

        for(int i=n1.length-1; i>=0; i--){     //von Ende der beiden zahlen
            d = n1[i] - n2[i] - carry;
            if(d < 0){        //wenn die diff zu klein ist, dann leihen wir ein 1 von den nächsten ziffern
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
            while(rez[poz]==0){         //fur, wenn wir mehrere 0 am anfang der nummer haben
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

    /*
        3.2 die Differenz zwei grosse zahlen, subtrahiert eine ziffer nach ein andere, mit carry - der kleinere aus der grossere
        Vorb: 2 Array von ziffern, gleicher lange
        Nachb: ein Array von ziffern, kann eine kleinere lange als der vorherigen haben
        Ausnahmen: wenn die arrays leer sind, wenn sie nicht denselben lange haben
    */
    public int[] diff(int[] n1, int[] n2){

        if(n1.length == 0 || n2.length == 0 || n1.length!=n2.length){           //error, wenn es keine Zahlen gegeben sind, wenn sie nicht gleich lang sind
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
        return rez;
    }

    /*
        3.3 die Multiplikation ein grosse zahl, mit einer Ziffer, eine ziffer nach ein andere, mit carry
        Vorb: 1 Array von ziffern und 1 ziffer
        Nachb: ein Array von ziffern, kann eine grossere lange als der vorherigen haben
        Ausnahmen: wenn der array leer ist
    */
    public int[] multiplik(int[] n1, int nr){

        if(n1.length == 0){           //error, wenn es keine Zahlen gegeben sind, wenn sie nicht gleich lang sind
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
            return newRez;
        }
        return rez;
    }

    /*
        3.4 die Division ein grosse zahl, mit einer Ziffer, eine ziffer nach ein andere, mit carry
        Vorb: 1 Array von ziffern und 1 ziffer
        Nachb: ein Array von ziffern, kann eine kleinere lange als der vorherigen haben
        Ausnahmen: wenn der array leer ist
    */
    public int[] div(int[] n1, int nr){

        if(n1.length == 0){           //error, wenn es keine Zahlen gegeben sind, wenn sie nicht gleich lang sind
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
                break;                   //wir brauchen kein temp, wenn wir zu Ende der nr sind
            }
            temp = (temp%nr)*10 + n1[poz+1];
            poz++;
        }
        if(pozRez<n1.length){           //wenn der dividirte zahl kurzer ist als der originales nr
            int[] newRez = new int[n1.length - (n1.length - pozRez)];
            for(int i=0; i<newRez.length; i++){
                newRez[i] = rez[i];          //wir kopieren von anfang an
            }
            return newRez;
        }

        //System.out.println(Arrays.toString(rez));

        return rez;
    }
}
