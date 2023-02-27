package OU.OU1;
import java.util.*; // Scanner, Locale

class Temperaturer
{
    public static void main (String[] args)
    {
        System.out.println ("TEMPERATURER\n");

        // inmatningsverktyg
        Scanner in = new Scanner (System.in);
        in.useLocale (Locale.US);
        // mata in uppgifter om antalet veckor och antalet mätningar
        System.out.print ("antalet veckor: ");
        int antalVeckor = in.nextInt();
        System.out.print ("antalet mätningar per vecka: ");
        int antalMatningarPerVecka = in.nextInt();
        // plats att lagra temperaturer
        double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];
        // mata in temperaturerna
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            System.out.println ("temperaturer - vecka " + vecka + ":");
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                t[vecka][matning] = in.nextDouble ();
        }
        System.out.println ();
        // visa temperaturerna
        System.out.println ("Temperaturerna:");
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                System.out.print (t[vecka][matning] + " ");
            System.out.println ();
        }
        System.out.println ();
        // den minsta, den största och medeltemperaturen – veckovis
        double[] minT = new double[antalVeckor + 1];
        double[] maxT = new double[antalVeckor + 1];
        double[] sumT = new double[antalVeckor + 1];
        double[] medelT = new double[antalVeckor + 1];

        // visa den minsta, den största och medeltemperaturen för varje vecka
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            minT[vecka] = t[vecka][1];
            maxT[vecka] = t[vecka][1];
            sumT[vecka] = t[vecka][1];

            for (int matning = 2; matning <= antalMatningarPerVecka; matning++)
            {
                if (minT[vecka] > t[vecka][matning])
                {
                    minT[vecka] = t[vecka][matning];
                }

                if (maxT[vecka] < t[vecka][matning])
                {
                    maxT[vecka] = t[vecka][matning];
                }

                sumT[vecka] += t[vecka][matning];
            }

            medelT[vecka] = sumT[vecka]/antalMatningarPerVecka;

            System.out.println("\nVecka: " + vecka);
            System.out.printf("\nMinimum temperaturen: " + "%.1f", minT[vecka]);
            System.out.printf("\nMaximum temperaturen: " + "%.1f", maxT[vecka]);
            System.out.printf("\nMedeltemperaturen: " +"%.1f", medelT[vecka]);
            System.out.println("\n");
        }

        // den minsta, den största och medeltemperaturen - hela mätperioden
        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double sumTemp = sumT[1];
        double medelTemp = 0;

        // visa den minsta, den största och medeltemperaturen i hela mätperioden
        for (int vecka = 2; vecka <= antalVeckor; vecka++)
        {
            if (minTemp > minT[vecka])
            {
                minTemp = minT[vecka];
            }

            if (maxTemp < maxT[vecka])
            {
                maxTemp = maxT[vecka];
            }

            sumTemp += sumT[vecka];
        }

        medelTemp = sumTemp/(antalMatningarPerVecka * antalVeckor);

        System.out.println("\n" + "Hela mätperioden: ");
        System.out.printf("\nLägsta temperaturen: " + "%.1f", minTemp);
        System.out.printf("\nHögsta temperaturen: " + "%.1f", maxTemp);
        System.out.printf("\nMedeltemperaturen: " + "%.1f", medelTemp);

        // kolla medeltemp veckovis, (-3+0+4)/3=1/3=0.33326                 (fel svar)(troligen pga 0/3)
        // kolla medeltemp veckovis, (-6+2+4)/3 = 0/3 = -2.2204....E-16     (fel svar)
    }
}
