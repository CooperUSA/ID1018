package OU.OU5;
import java.util.*;

public class ValjPolylinje {
    public static final Random    rand = new Random ();
    public static final int    ANTAL_POLYLINJER = 10;

    public static void main (String[] args)
    {
        // skapa ett antal slumpmässiga polylinjer.
        // Just nu 10 slumpmässiga polylinjer.
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
        for (int i = 0; i < ANTAL_POLYLINJER; i++) {
            polylinjer[i] = slumpPolylinje();
        }
        // visa polylinjerna
        // For varje polylinje (p) som finns i array:n polylinjer
        // skriv ut polylinje (p)
        for (Polylinje p : polylinjer) {
            System.out.printf("%.1f", p.langd());
            System.out.println(" " + p);
        }


        // bestäm den kortaste av de polylinjer som är gula
        Polylinje kortGul = null;
        int i = 0;

        // Medans polylinjen som den undersöker inte är gul och
        // då det finns polylinjer kvar att undersöka.
        // (innan den har hittat den första gula polylinjen)
        // Om den undersökte är gul så blir kortGul den polylinjen.
        while(kortGul == null && i < polylinjer.length) {
            if(polylinjer[i].getFarg().equals("Gul")){
                kortGul = polylinjer[i];
            }
            i++;
        }
        // Då kortGul har fått värdet av en gul polylinjen så jämnför
        // den stegvist resterande polylinjers längd med sin egna,
        // men endast om de är gula.
        // Om den är kortare så blir kortGul den polylinjen.
        while(i < polylinjer.length){
            if(polylinjer[i].getFarg().equals("Gul")) {
                if (kortGul.langd() > polylinjer[i].langd()) {
                    kortGul = polylinjer[i];
                }
            }
            i++;
        }
        // visa den valda polylinjen
        System.out.println("\n"+ kortGul);
    }

    // slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor bokstav i
    // det engelska alfabetet, och slumpmässiga koordinater.
    public static Punkt slumpPunkt ()
    {
        String    n = "" + (char) (65 + rand.nextInt (26));
        int    x = rand.nextInt (11);
        int    y = rand.nextInt (11);

        return new Punkt (n, x, y);
    }

    // slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, eller röd
    // eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
    // kan inte ha samma namn.
    public static Polylinje slumpPolylinje ()
    {
        // skapa en tom polylinje, och lägg till hörn till den
        Polylinje    polylinje = new Polylinje ();
        int    antalHorn = 2 + rand.nextInt (7);
        int    antalValdaHorn = 0;
        boolean[]    valdaNamn = new boolean[26];
        // ett och samma namn kan inte förekomma flera gånger
        Punkt    valdPunkt = null;
        char    valtChar = 0;
        while (antalValdaHorn < antalHorn)
        {
            // Gör valdPunkt till en slumpmässig punkt och valtChar till den
            // punktens namn som en char.
            valdPunkt = slumpPunkt();
            valtChar = valdPunkt.getNamn().charAt(0);

            // Då valdaNamn på platsen valtChar är sann, så slumpas punkten igen.
            // Alltså om någon punkt har samma namn som den nya punkten så blir
            // den slumpad igen.
            while(valdaNamn[valtChar - 'A']){
                valdPunkt = slumpPunkt();
                valtChar = valdPunkt.getNamn().charAt(0);
            }

            // Tar unika namnet genom att göra platsen i valdaNamn till true
            valdaNamn[valtChar - 'A'] = true;

            // Lägger till en punkt i polylinjen
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
