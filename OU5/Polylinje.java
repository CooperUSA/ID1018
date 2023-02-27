package OU.OU5;

public class Polylinje
{
    // Antal hörn/punkter
    private Punkt[]    horn;
    private String     farg = "svart";
    private int        bredd = 1;

    // Då man inte skickar in något värde till konstruktorn Polylinje,
    // så skapas denna tomma array.
    public Polylinje ()
    {
        this.horn = new Punkt[0];
    }

    // Punkt[] är punkt array (likt som int[] är int array). Den kallas horn.
    // Det är horn som vi ger värden på utifrån och sedan kopierar det till
    // "private horn".
    // Då har vi definerat array:n i denna class som vi sedan använder i andra
    // metoder.
    public Polylinje (Punkt[] horn)
    {
        // Gör "privat horn" till en lika stor array som Punkt[] horn
        this.horn = new Punkt[horn.length];
        for (int i = 0; i < horn.length; i++)
            this.horn[i] = new Punkt (horn[i]);
        // horn[i] är punkten på plats i.
        // "this.horn[i] = new Punkt (horn[i])" gör
        // en EGEN kopia av punkten som vi angav utifrån till
        // att bli dens privata punkt på plats i

        // Om man skriver this.horn[i] = horn[i] så blir det inte en
        // ny EGEN kopia, istället blir det bara en referens. De är 2 punkter
        // med samma referenser
    }

    public String toString () {
        // Stringbuilder med "if" sats för att det kan
        // finnas oändligt många punkter.
        StringBuilder resultat = new StringBuilder("{ [ ");

        for (int i = 0; i < horn.length; i++){
            resultat.append("(");
            resultat.append(horn[i].toString());
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
        Punkt[] tempHorn = this.horn.clone();
        return tempHorn;
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
        langd += horn[i].avstand(horn[i+1]);
        }
        return langd;
    }

    public void laggTill (Punkt horn)
    {
        Punkt[]    h = new Punkt[this.horn.length + 1];
        int    i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = new Punkt (horn);

        this.horn = h;
    }

    // Måste duplikera array:n och utöka den. Läg in nya punkten framför den punkt
    // som anges.
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
    }

    public class PolylinjeIterator
    {
        private int aktuell = -1;

        public PolylinjeIterator ()
        {
            if (Polylinje.this.horn.length > 0)
                aktuell = 0;
        }

        public boolean finnsHorn ()
        {
            return aktuell != -1;
        }

        public Punkt horn () throws java.util.NoSuchElementException
        {
            if (!this.finnsHorn ())
                throw new java.util.NoSuchElementException (
                        "slut av iterationen");
            Punkt    horn = Polylinje.this.horn[aktuell];

            return horn;
        }

        public void gaFram ()
        {
            if (aktuell >= 0  && aktuell < Polylinje.this.horn.length - 1)
                aktuell++;
            else
                aktuell = -1;
        }
    }
}
