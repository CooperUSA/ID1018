package OU.OU2;
import java.util.*;

public class EnTriangelOchDessCirklar {

    public static void main (String[] args){
        System.out.println ("TRIANGEL\n");

        Scanner in = new Scanner (System.in);
        in.useLocale (Locale.US);

        System.out.println("Ange sida A:");
        double aSida = in.nextDouble();
        System.out.println("Ange sida B:");
        double bSida = in.nextDouble();
        System.out.println("Ange sida C:");
        double cSida = in.nextDouble();
        System.out.println("Ange vinkeln (i grader) på hörnet främre om sida A:");
        double alfa = in.nextDouble();
        System.out.println("Ange höjden utifrån A:");
        double hojd = in.nextDouble();


        System.out.println("Omkretsen är: " + Triangel.omkrets(aSida,bSida, cSida) + " l.e");
        System.out.println("Semiperimetern är: " + Triangel.sP(aSida,bSida, cSida) + " l.e");
        System.out.println("Arean är: " + Triangel.area(aSida,hojd) + " a.e");
        System.out.println("Medianen från sida A är: " + Triangel.median(aSida, bSida, cSida) + " l.e");
        System.out.println("Cosinussatsen för sida A är: " + Triangel.cosinus(bSida, cSida, alfa) + " l.e");
        System.out.println("Bisektrisen för vinkeln mellan B och C är: " +
                Triangel.bisektris(bSida, cSida, alfa) + " l.e");
        System.out.println("Radien på den omskrivna cirkeln är: " + Triangel.omskrivnaCirkeln(aSida,bSida, cSida)
                + " l.e");
        System.out.println("Radien på den inskrivna cirkeln är: " + Triangel.inskrivnaCirkeln(aSida,bSida,cSida)
                + " l.e");
    }
}
