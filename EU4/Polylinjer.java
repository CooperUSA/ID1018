package EU.EU4;

import java.util.*;

public class Polylinjer {
    public static final Random    rand = new Random ();
    public static final int    ANTAL_POLYLINJER = 10;
    public static int i = 0; //För att kunna byta mellan V- och NPolylinje

    public static void main (String[] args)
    {
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
        for (int i = 0; i < ANTAL_POLYLINJER; i++) {
            polylinjer[i] = slumpPolylinje();
        }

        // visa de 10 polylinjerna
        for (Polylinje p : polylinjer) {
            System.out.printf("%.1f", p.langd());
            System.out.println(" " + p);
        }

        // bestämen den kortaste av de polylinjer som är gula
        Polylinje kortGul = null;
        int i = 0;
        while(kortGul == null && i < polylinjer.length) {
            if (polylinjer[i].getFarg().equals("Gul")) {
                kortGul = polylinjer[i];
            }
            i++;
        }
        while(i < polylinjer.length){
            if(polylinjer[i].getFarg().equals("Gul")) {
                if (kortGul.langd() > polylinjer[i].langd()) {
                    kortGul = polylinjer[i];
                }
            }
            i++;
        }

        // visa den kortaste gula
        System.out.println("\n"+ kortGul);
    }

    public static Punkt slumpPunkt ()
    {
        String    n = "" + (char) (65 + rand.nextInt (26));
        int    x = rand.nextInt (11);
        int    y = rand.nextInt (11);

        return new Punkt(n, x, y);
    }

    // slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, eller röd
    // eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
    // kan inte ha samma namn.
    public static Polylinje slumpPolylinje ()
    {
        // Refererar till ett objekt så att man kan utnyttja interfacet
        Polylinje polylinje = null;

        // Utnyttjar intefacet/skapar varannan polylinje från
        // noder och varannan från vektorer

        if(i % 2 == 0){
            polylinje = new VPolylinje (); // (1)
        }
        else{
            polylinje = new NPolylinje (); // (2)
        }
        i++;


        //Utnyttjar intefacet/skapar en VPolylinje
        /*
        polylinje = new VPolylinje (); // (1)
         */

        //Utnyttjar intefacet/skapar en NPolylinje
        /*
        polylinje = new NPolylinje (); // (2)
         */

        int    antalHorn = 2 + rand.nextInt (7);
        int    antalValdaHorn = 0;
        boolean[]    valdaNamn = new boolean[26];
        // ett och samma namn kan inte förekomma flera gånger
        Punkt valdPunkt = null;
        char    valtChar = 0;
        //Skapar slumpade punkter med unika namn
        while (antalValdaHorn < antalHorn)
        {
            valdPunkt = slumpPunkt();
            valtChar = valdPunkt.getNamn().charAt(0);

            while(valdaNamn[valtChar - 'A']){
                valdPunkt = slumpPunkt();
                valtChar = valdPunkt.getNamn().charAt(0);
            }

            valdaNamn[valtChar - 'A'] = true;
            polylinje.laggTill(valdPunkt);
            antalValdaHorn++;
        }
        // sätt färg
        // fargen pekar på slumpmässad färg mellan röd, blå eller gul
        String[] farger = {"Röd", "Blå", "Gul"};
        String fargen = farger[rand.nextInt(farger.length)];

        // Setter polylines färg till den slumpade färgen.
        polylinje.setFarg(fargen);

        return polylinje;
    }
}
