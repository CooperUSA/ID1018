package EU.EU4;

public class Punkt {
    private String name;
    private int x;
    private int y;

    // Konstruktor som skapar punkt med värdena vi instanserar
    // (skapar punkten)
    public Punkt(String name, int x, int y){
        this.name   = name;
        this.x      = x;
        this.y      = y;
    }
    // Konstruktor som skapar en punkt utifrån p1,
    // som i tur utgår från konstruktorn som hämtar de privata variablerna
    public Punkt(Punkt p1){
        name = p1.name;
        x    = p1.x;
        y    = p1.y;
    }

    // Returnerar namnet
    public String getNamn(){
        return name;
    }
    // Returnerar x-värdet
    public int getX(){
        return x;
    }
    // Returnerar x-värdet
    public int getY(){
        return y;
    }

    // Avstånd från punkt 1 till godtycklig punkt
    public double avstand(Punkt p2){
        double langd = Math.sqrt((p2.x - x)*(p2.x - x) + (p2.y - y)*(p2.y - y));
        return langd;
    }

    public boolean equals(Punkt p2){
        boolean samma = false;

        if(x == p2.x && y == p2.y){
            samma = true;
        }
        return samma;
    }

    // Ska inte returnera något värde då den bestämmer om värdet som
    // vi redan satt in.
    public void setX(int newX){
        x = newX;
    }
    // Ska inte returnera något värde då den bestämmer om värdet som
    // vi redan satt in.
    public void setY(int newY){
        y = newY;
    }

    // Skriver över toString så att det blir ett mer lämpligt svar,
    // då Punkt är en custom variable och vi vill kunna skriva ut den som
    // en string.
    public String toString(){
        return "( " + name + " " + x + " " + y + " )";
    }
}

