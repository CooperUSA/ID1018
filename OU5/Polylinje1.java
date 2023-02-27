package OU.OU5;

public class Polylinje1 {
    // Antal hörn/punkter
    private Punkt[]    horn;
    private String     farg = "svart";
    private int        bredd = 1;

    // Då man inte skickar in något värde till konstruktorn Polylinje,
    // så skapas denna tomma array.
    public Polylinje1 ()
    {
        this.horn = new Punkt[0];
    }

    // Definerar inte en ny punkt som är en kopia.
    public Polylinje1 (Punkt[] horn)
    {
        this.horn = horn;

    }

    public String toString () {
        // Stringbuilder med "if" sats för att det kan
        // finnas oändligt många punkter.
        StringBuilder resultat = new StringBuilder("{ [ ");

        for (int i = 0; i < horn.length; i++){
            resultat.append("(");
            resultat.append(horn[i].getNamn());
            resultat.append(" ");
            resultat.append(horn[i].getX());
            resultat.append(" ");
            resultat.append(horn[i].getY());
            resultat.append(") ");
        }
        resultat.append("], ");
        resultat.append(farg);
        resultat.append(", ");
        resultat.append(bredd);
        resultat.append(" }");

        return resultat.toString();
    }

    // Returnerar en kopia av objektet "Private Punkt[]" så att man får
    // en publik kopia som kan redigeras utan att påverka originella objektet.
    public Punkt[] getHorn () {

        return this.horn;
    }

    // Returnerar färgen
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

    // Indexerar från 1 och kollar nästa punkt minus denna punkt.
    // Då sista längden finns mellan nästsista och sista punkten.
    // (Vid 3 punkter, kollar avstånd (i=1) p2-p1, (i=2) p3-p2.)
    public double langd () {
        double langd = 0;
        for(int i = 0; i < horn.length-1; i++){
            langd = horn[i].avstand(horn[i+1]);
        }
        return langd;
    }

    // Skapar inte en ny punkt som är en kopia, korrigerar istället den originella
    public void laggTill (Punkt horn)
    {
        Punkt[]    h = new Punkt[this.horn.length + 1];
        int    i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = horn;

        this.horn = h;
    }

    // Skapar inte en ny punkt som är en kopia, korrigerar den originella
    public void laggTillFramfor (Punkt horn, String hornNamn) {
        Punkt[]    h = new Punkt[this.horn.length + 1];
        boolean flag = false;
        int i = 0;

        for (i = 0; i < this.horn.length; i++){
            if(hornNamn == this.horn[i].getNamn()) {
                h[i] = horn;
                flag = true;
            }
            if(flag){
                h[i] = this.horn[i - 1];
            }
            else{
                h[i] = this.horn[i];
            }
        }
        this.horn = h;
    }

    public void taBort (String hornNamn) {
        Punkt[]    h = new Punkt[this.horn.length - 1];
        boolean flag = false;
        int i = 0;

        for (i = 0; i < this.horn.length; i++){
            if(hornNamn == this.horn[i].getNamn()) {
                h[i] = this.horn[i+1];
                flag = true;
            }
            if(flag){
                h[i] = this.horn[i+1];
            }
            else{
                h[i] = this.horn[i];
            }
        }
        this.horn = h;
    }
}
