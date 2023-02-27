package EU.EU4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VPolylinje implements Polylinje{

    private Punkt[]    horn;
    private String     farg = "svart";
    private int        bredd = 1;

    public VPolylinje ()
    {
        this.horn = new Punkt[0];
    }

    public VPolylinje (Punkt[] horn)
    {
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++)
            this.horn[i] = new Punkt(horn[i]);
    }

    public String toString () {
        StringBuilder resultat = new StringBuilder("{[ ");

        for (int i = 0; i < horn.length; i++){
            resultat.append(horn[i].toString() + " ");
        }
        resultat.append("], ");
        resultat.append(farg);
        resultat.append(", ");
        resultat.append(bredd);
        resultat.append(" }");

        return resultat.toString();
    }

    public Punkt[] getHorn () {
        Punkt[] tempHorn = this.horn.clone();
        return tempHorn;
    }

    public String getFarg () {

        return farg;
    }

    public int getBredd () {

        return bredd;
    }

    public void setFarg (String farg) {
        this.farg = farg;
    }

    public void setBredd (int bredd) {
        this.bredd = bredd;
    }

    public double langd () {
        double langd = 0;
        for(int i = 0; i < horn.length-1; i++){
            langd += horn[i].avstand(horn[i+1]);
        }
        return langd;
    }

    public void laggTill (Punkt horn)
    {
        Punkt[]    h = new Punkt[this.horn.length + 1];
        int    i = 0;
        for (i = 0; i < this.horn.length; i++) {
            h[i] = this.horn[i];
            if(h[i].getNamn().equals(horn.getNamn())){
                throw new IllegalArgumentException("Punkt existerar redan");
            }
        }
        h[i] = new Punkt(horn);

        this.horn = h;
    }

    public void laggTillFramfor (Punkt horn, String hornNamn) {
        Punkt[]    h = new Punkt[this.horn.length + 1];
        boolean flag = false;
        int i = 0;

        for (i = 0; i < this.horn.length; i++){
            if(hornNamn == this.horn[i].getNamn()) {
                h[i] = new Punkt(horn);
                h[i+1] = this.horn[i];
                flag = true;
            }
            else if(flag){
                h[i+1] = this.horn[i];
            }
            else{
                h[i] = this.horn[i];
            }
        }
        if(flag) {
            this.horn = h;
        }
        else{
            System.out.println("Punkten finns ej");
        }
    }

    public void taBort (String hornNamn) {
        Punkt[]    h = new Punkt[this.horn.length - 1];
        boolean flag = false;
        int i = 0;

        for (i = 0; i < h.length; i++){
            if(hornNamn == this.horn[i].getNamn()) {
                h[i] = this.horn[i+1];
                flag = true;
            }
            else if(flag){
                h[i] = this.horn[i+1];
            }
            else{
                h[i] = this.horn[i];
            }
        }
        this.horn = h;

        if(!flag){
            System.out.println("Punkt finns ej.");
        }
    }

    public Iterator<Punkt> iterator() {
        // Gör om arrayn från getHorn till en lista så att
        // iteratorn kan röra sig genom den.
        List<Punkt> lista = Arrays.asList(this.getHorn());
        return lista.iterator();
    }
}
