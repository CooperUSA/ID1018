package OU.OU2;

public class Triangel {
    // Parametern tar emot 3 sidor av en triangel.
    // Returnerar omkretsen av en triangel.
    static double omkrets(double a, double b, double c){
        return a+b+c;
    }

    // Parametern tar emot 3 sidor av en triangel.
    // Returnerar halva omkretsen (semiperimetern) av en triangel.
    static double sP(double a, double b, double c){
        return omkrets(a,b,c)/2;
    }

    // Parametern tar emot en sida av triangeln och dens höjd.
    // Returnerar arean av en triangel.
    static double area (double a, double h){
        return (a*h)/2;
    }

    // Parametern tar emot 3 sidor av en triangel.
    // Returnerar median av en triangel utifrån sida A.
    static double median (double a, double b, double c){
        return 1.0/2.0 * Math.sqrt(2*(b*b) + 2*(c*c) - (a*a));
    }

    // Parametern tar emot 2 sidor av en triangel och vinkeln mellan de.
    // Returnerar cosinussatsen av en triangel utifrån sida A.
    static double cosinus (double b, double c, double alfa){
        return Math.sqrt((b*b) + (c*c) - 2 * b * c * Math.cos(Math.toRadians(alfa)));
    }

    // Bisektris tar emot två sidor i en triangel och vinkeln (i radianer) mellan dessa sidor.
    // Metoden returnerar längden av den motsvarande bisektrisen - den som delar den givna
    // vinkeln i två lika delar.
    public static double bisektris (double b, double c, double alfa)
    {
        double p = 2 * b * c * Math.cos (alfa / 2);

        return p / (b + c);
    }
    // "b", "c" och "alfa" är formella namn, man anger deras värde.
    // Därmed behöver man ej en fler metoder.

    // Parametern tar emot 3 sidor av en triangel.
    // Returnerar radien på den omskrivna cirkeln för en triangel.
    static double omskrivnaCirkeln(double a, double b, double c){
        double oCirkeln = (a * b * c)/(4 * Math.sqrt( sP(a,b,c) *
                (sP(a,b,c) - a) * (sP(a,b,c) - b) * (sP(a,b,c) - c) ));

        return oCirkeln;
    }

    // Parametern tar emot 3 sidor av en triangel.
    // Returnerar radien på den inskrivna cirkeln för en triangel
    static double inskrivnaCirkeln(double a, double b, double c){
        double iCirkeln =Math.sqrt( ( (sP(a,b,c) - a) * (sP(a,b,c) - b) * (sP(a,b,c) - c) ) / sP(a,b,c) );

        return iCirkeln;
    }
}
