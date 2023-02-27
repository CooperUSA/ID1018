package EU.EU4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class NPolylinje implements Polylinje {

    //Noderna tillhör polylinje
    private static class Nod {
        public Punkt horn;
        public Nod nastaNod;

        public Nod(Punkt horn) {
            this.horn = horn;
            nastaNod = null;
        }
    }

    private Nod horn;
    private String farg = "svart";
    private int bredd = 1; // pixlar

    public NPolylinje() {
        this.horn = null;
    }

    public NPolylinje(Punkt[] horn) {
        if (horn.length > 0) {
            Nod nod = new Nod(new Punkt(horn[0]));
            this.horn = nod;
            int pos = 1;
            while (pos < horn.length) {
                nod.nastaNod = new Nod(new Punkt(horn[pos++]));
                nod = nod.nastaNod;
            }
        }
    }
    // ytterligare kod här
    @Override
    public String toString () {
        Nod nod = this.horn;

        StringBuilder resultat = new StringBuilder("{[ ");
        while (nod != null){
            resultat.append("(");
            resultat.append(nod.horn);
            resultat.append(") ");

            nod = nod.nastaNod;
        }
        resultat.append("], ");
        resultat.append(farg);
        resultat.append(", ");
        resultat.append(bredd);
        resultat.append(" }");

        return resultat.toString();
    }

    public Punkt[] getHorn() {
        int noder = 0;
        Nod nod = this.horn;
        // ökar "noder" för att få antalet noder
        while (nod != null){
            noder++;
            nod = nod.nastaNod;
            System.out.println();
        }
        // Skapar en ny array med lika stor index som noder
        Punkt[] punkter = new Punkt[noder];
        nod = this.horn;

        // Ger varje index element efter respektive nod
        for(int i = 0; i < punkter.length; i++){
            punkter[i] = nod.horn;
            nod = nod.nastaNod;
        }

        return punkter;
    }

    public String getFarg() {
        return farg;
    }

    public int getBredd() {
        return bredd;
    }

    public double langd() {
        double langd = 0;
        Nod nod = this.horn;
        // ökar "noder" för att få antalet noder
        while (nod != null && nod.nastaNod != null){
            langd += nod.horn.avstand(nod.nastaNod.horn);
            nod = nod.nastaNod;
        }
        return langd;
    }

    public void setFarg(String farg) {
        this.farg = farg;
    }

    public void setBredd(int bredd) {
        this.bredd = bredd;
    }

    public void laggTill(Punkt horn) {
        Nod nyNod = new Nod(new Punkt(horn));
        Nod nod = this.horn;

        // Om det inte finns några noder.
        if(nod == null){
            this.horn = nyNod;
            return; // returner för att gå genom while-loopen
        }
        // Kollar alla noder stegvist tills den kommer till den som inte
        // har en "nästa nod", och lägger då till den.
        while (nod.nastaNod != null){
            nod = nod.nastaNod;
        }
        nod.nastaNod = nyNod;
    }

    public void laggTillFramfor(Punkt horn, String hornNamn) {
        Nod nyNod = new Nod(new Punkt(horn));
        boolean uteEfter = false;
        Nod nod = this.horn;

        // Om det ska läggas till en nod framför den första så
        // ändrar man this.horn pekaren (startpunkten) till nya punkten
        // och pekar nya punkten till nod (som pekar på gamla startpunkten).
        if(nod.horn.getNamn().equals(hornNamn)){
            this.horn = nyNod;
            nyNod.nastaNod = nod;
            uteEfter = true;
        }

        while (nod.nastaNod != null && !uteEfter){
            // Namnet på nästa nods punkt.
            String nastaNamn = nod.nastaNod.horn.getNamn();

            // Om namnet på nästa nods punkt är det vi söker så pekar
            // noden på näst-nästa noden (skippar därmed nästa nod).
            if(nastaNamn.equals(hornNamn)){
                nyNod.nastaNod = nod.nastaNod;
                nod.nastaNod = nyNod;
                uteEfter = true;
            }
            nod = nod.nastaNod;
        }

        // Om noden inte existerar så skriver den detta meddelande förstS
        if(!uteEfter){
            System.out.println("Noden finns ej.");
        }
    }

    public void taBort(String hornNamn) {
        boolean sammaNamn = false;
        Nod nod = this.horn;

        // Om första noden ska bort. Returnera så den ej
        // går genom resten av koden.
        if(nod.horn.getNamn().equals(hornNamn)){
            this.horn = nod.nastaNod;
            sammaNamn = true;
        }

        // Kollar alla noder efter den första
        while (nod.nastaNod != null && !sammaNamn){
            // Namnet på nästa nods punkt.
            String nastaNamn = nod.nastaNod.horn.getNamn();

            // Om namnet på nästa nods punkt är det vi söker
            // så blir näst-nästa noden istället nästa nod.
            if(nastaNamn.equals(hornNamn)){
                nod.nastaNod = nod.nastaNod.nastaNod;

                // När man tar bort sista noden, iställer för att göra
                // sammaNamn=true så returnar man direkt för att nod.nastaNod inte
                // pekar på något och man vill avsluta metoden direkt.
                return;
            }
            nod = nod.nastaNod;
        }

        // Då den har kollat alla noder och inte hitta namnet
        if(!sammaNamn){
            System.out.println("Denna nod finns ej");
        }
    }

    public Iterator<Punkt> iterator() {
        // Gör om arrayn från getHorn till en lista så att
        // iteratorn kan röra sig genom den.
        List<Punkt> lista = Arrays.asList(this.getHorn());
        return lista.iterator();
    }
}
