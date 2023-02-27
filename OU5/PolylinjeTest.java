package OU.OU5;

import java.io.PrintWriter;
import java.util.Arrays;

public class PolylinjeTest {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        // testa en konstruktor och en transformator
        Punkt[] p = new Punkt[4];
        p[0] = new Punkt("A", 1, 1);
        p[1] = new Punkt("B", 1, 2);
        p[2] = new Punkt("C", 3, 3);
        p[3] = new Punkt("D", 5, 4);
        Polylinje pol = new Polylinje(p);
        out.println(pol);

        // testa inspektorer
        Punkt[] punkt = pol.getHorn();
        String f = pol.getFarg();
        int b = pol.getBredd();
        out.println(Arrays.toString(punkt) + " " + f + " " + b);

        // testa mutatorer
        pol.setFarg("Lila");
        pol.setBredd(3);
        out.println(pol);
        out.println("Lägg till punkt:");
        pol.laggTill(new Punkt("E", 6, 6));
        out.println(pol);
        out.println("Lägg en punkt framför någon:");
        pol.laggTillFramfor(new Punkt("G", 3, 6), "y");
        out.println(pol);
        out.println("Ta bort en punkt:");
        pol.taBort("B");
        out.println(pol);

        // testa en kombinator
        double d = pol.langd();
        out.println(d);

        // Testa iterator
        Polylinje.PolylinjeIterator iterator = pol.new PolylinjeIterator();

        while(iterator.finnsHorn()){
            System.out.println(iterator.horn());
            iterator.gaFram();
        }
    }
}
