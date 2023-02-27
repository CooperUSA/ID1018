package EU.EU4;

import java.util.Arrays;
import java.util.Iterator;

public class PolylinjeTest {
    public static void main(String[] args){
        Polylinje polylinje = null;


        Punkt[] p = new Punkt[4];
        p[0] = new Punkt("A", 1, 1);
        p[1] = new Punkt("B", 1, 2);
        p[2] = new Punkt("C", 3, 3);
        p[3] = new Punkt("D", 5, 4);
        //polylinje = new VPolylinje (p); // (1)
        polylinje = new NPolylinje (p); // (2)
        System.out.println(polylinje);

        // testa inspektorer
        System.out.println("\nInspektorer:");
        Punkt[] punkt = polylinje.getHorn();
        String f = polylinje.getFarg();
        int b = polylinje.getBredd();
        System.out.println(Arrays.toString(punkt) + " " + f + " " + b);

        // testa mutatorer
        System.out.println("\nMutatorer:");
        polylinje.setFarg("Lila");
        polylinje.setBredd(3);
        System.out.println(polylinje);

        System.out.println("\nLägg till punkt:");
        polylinje.laggTill(new Punkt("F", 6, 6));
        System.out.println(polylinje);

        System.out.println("\nLägg en punkt framför någon:");
        polylinje.laggTillFramfor(new Punkt("G", 3, 6), "B");
        System.out.println(polylinje);

        System.out.println("\nTa bort en punkt:");
        polylinje.taBort("E");
        System.out.println(polylinje);

        // testa en kombinator
        System.out.println("\nLängd på polylinjen:");
        double d = polylinje.langd();
        System.out.println(d);

        // Testa iterator
        System.out.println("\nIteratorn:");
        Iterator<Punkt> iterator = polylinje.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

