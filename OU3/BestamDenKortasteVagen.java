package OU.OU3;
import java.util.*;

public class BestamDenKortasteVagen {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        in.useLocale (Locale.US);

        System.out.println("Ange antal stationer i zon 2");
        int antalU = in.nextInt();
        System.out.println("Ange antal stationer i zon 3");
        int antalV = in.nextInt();
        //Plats att lagra antal stationer mellan zoner.
        double[] i     = new double[antalU + 1];
        double[][] ij  = new double[antalU + 1][antalV + 1];
        double[] j     = new double[antalV + 1];

        System.out.println("\nAnge längden mellan stationer i km");

        //Mata in avstånd mellan stationer.
        //Avståndet mellan X och stationerna i Zon 2.
        for(int aI = 1; aI <= antalU; aI++ ){
            System.out.println("\nLängden mellan station X och U" + aI + ":");
            i[aI] = in.nextDouble();
        }
        System.out.println();

        //Avståndet mellan stationer i Zon 2 och 3.
        for(int aI = 1; aI <= antalU; aI++ ){
            for(int bIJ = 1; bIJ <= antalV; bIJ++){
                System.out.println("\nLängden mellan station U" + aI + " och V" + bIJ + ":");
                ij[aI][bIJ] = in.nextDouble();
            }
            System.out.println();
        }

        //Avståndet mellan stationerna i Zon 3 och Y.
        for(int cJ = 1; cJ <= antalV; cJ++) {
            System.out.println("\nLängden från station V" + cJ + " till Y:");
            j[cJ] = in.nextDouble();
        }

        //Skriver ut värden som kallas från metoder i annan klass
        System.out.println("Den kortaste totala vägen är: " + DenKortasteVagen.langd(i, ij, j) + " km,");
        System.out.print("via stationer U" + DenKortasteVagen.mellanstationer(i, ij, j)[1] + " och V");
        System.out.println(DenKortasteVagen.mellanstationer(i, ij, j)[2]);


    }
}
