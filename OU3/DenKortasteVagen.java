package OU.OU3;

public class DenKortasteVagen {
    // Mellanstationer returnerar en vektor med de mellanstationer som finns på den kortaste
    // vägen. Ordningsnummer av den första mellanstationen finns på index 1, och ordningsnummer
    // av den andra mellanstationen på index 2 i vektorn.
    public static int[] mellanstationer(double[] a, double[][] b, double[] c) {
        // Lagrar värdet för avstånden mellan stationerna
        double kortLangd = a[1] + b[1][1] + c[1];

        // Lagrar antal mellanstationer + 1 (inducerar från 1)
        int[] kortStation = new int[3];

        // Inducerar ett värde till stationerna (startar från station 1 i båda zonerna)
        kortStation[1] = 1;
        kortStation[2] = 1;

        // Tar reda på kortaste längden och vilka stationer den går igenom.
        for (int aI = 1; aI < a.length; aI++) {
            for (int bIJ = 1; bIJ < c.length; bIJ++) {
                double stationer = a[aI] + b[aI][bIJ] + c[bIJ];
                if (kortLangd > stationer) {
                    kortLangd = stationer;
                    kortStation[1] = aI;
                    kortStation[2] = bIJ;
                }
            }
        }
        return kortStation;
    }

    // langd returnerar längden av den kortaste vägen.
    public static double langd(double[] a, double[][] b, double[] c) {
        // Hämtar metod
        int[] kortStation = mellanstationer(a, b, c);

        // Adderar avståndet mellan stationerna från kortStation
        int j = kortStation[2];
        int i = kortStation[1];
        double kortLangd = a[i] + b[i][j] + c[j];

        return kortLangd;
    }
}
