package OU.OU4;

import java.util.*;

import static java.lang.System.out;

public class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {
    public static void main(String[] args) {
        out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRÄNGAR\n");
        // mata in två naturliga heltal
        Scanner in = new Scanner(System.in);
        out.println("två naturliga heltal:");
        String tal1 = in.next();
        String tal2 = in.next();
        out.println();

        // addera heltalen och visa resultatet
        String summa = addera(tal1, tal2);
        visa(tal1, tal2, summa, '+');

        // subtrahera heltalen och visa resultatet
        String differens = subtrahera(tal1, tal2);
        visa(tal1, tal2, differens, '-');
    }

    // addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
    // summa som en teckensträng.
    public static String addera(String tal1, String tal2) {
        // Skapar variabler
        int langd1 = tal1.length();
        int langd2 = tal2.length();
        int minnessiffra = 0;
        StringBuilder summa = new StringBuilder();

        // Adderar ett tal i taget från termerna.

        // Då både termerna har tal kvar att addera i någon position.
        while (langd1 > 0 && langd2 > 0) {
            int ettTal1 = tal1.charAt(langd1 - 1) - '0';
            int ettTal2 = tal2.charAt(langd2 - 1) - '0';
            //adderar entalen med varandra och +1 till nästa loop.
            if (minnessiffra + ettTal1 + ettTal2 > 9) {
                summa.insert(0, (minnessiffra + ettTal1 + ettTal2 - 10));
                minnessiffra = 1;
            } else {
                summa.insert(0, (minnessiffra + ettTal1 + ettTal2));
                minnessiffra = 0;
            }
            langd1--;
            langd2--;
        }

        // Adderar översta termen då undre termen är klar
        while (langd1 > 0) {
            int ettTal1 = tal1.charAt(langd1 - 1) - '0';
            if (minnessiffra + ettTal1 > 9) {
                summa.insert(0, (minnessiffra + ettTal1 - 10));
                minnessiffra = 1;
            } else {
                summa.insert(0, (minnessiffra + ettTal1));
                minnessiffra = 0;
            }
            langd1--;
        }

        // Adderar understa termen då övre termen är klar
        while (langd2 > 0) {
            int ettTal2 = tal2.charAt(langd2 - 1) - '0';
            if (minnessiffra + ettTal2 > 9) {
                summa.insert(0, (minnessiffra + ettTal2 - 10));
                minnessiffra = 1;
            } else {
                summa.insert(0, (minnessiffra + ettTal2));
                minnessiffra = 0;
            }
            langd2--;
        }

        //Ifall det är en minnessiffra kvar efter additionen
        while (minnessiffra == 1) {
            summa.insert(0, minnessiffra);

            minnessiffra--;
        }

        return summa.toString();
    }

    // subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
    // deras differens som en teckensträng.
    // Det första heltalet är inte mindre än det andra heltalet.
    public static String subtrahera(String tal1, String tal2) {
        // Skapar variabler
        int langd1 = tal1.length();
        int langd2 = tal2.length();
        int minnessiffra = 0;
        StringBuilder summa = new StringBuilder();

        // Subtraherar ett tal i taget från termerna.

        // Då både termerna har tal kvar att subtrahera någon position.
        while (langd1 > 0 && langd2 > 0) {
            int ettTal1 = tal1.charAt(langd1 - 1) - '0';
            int ettTal2 = tal2.charAt(langd2 - 1) - '0';

            // Då subtraktion blir negativt så adderar den 10 till differansen
            // och subtraherar -1 vid nästa gång.
            if (minnessiffra + ettTal1 - ettTal2 < 0) {
                summa.insert(0, (10 + minnessiffra + ettTal1 - ettTal2));
                minnessiffra = -1;
            } else {
                summa.insert(0, (minnessiffra + ettTal1 - ettTal2));
                minnessiffra = 0;
            }
            langd1--;
            langd2--;
        }

        // Skriver ut översta termen då undre termen är klar,
        // samt subtraherar med 1 då minnessiffra finns.
        while (langd1 > 0) {
            int ettTal1 = tal1.charAt(langd1 - 1) - '0';

            if (minnessiffra + ettTal1 < 0) {
                summa.insert(0, (10 + minnessiffra + ettTal1));
                minnessiffra = -1;
            } else {
                summa.insert(0, (minnessiffra + ettTal1));
                minnessiffra = 0;
            }
            langd1--;
        }

        // Subtraherar understa termen då övre termen är klar
        while (langd2 > 0) {
            int ettTal2 = tal2.charAt(langd2 - 1) - '0';

            if (minnessiffra - ettTal2 < 0) {
                summa.insert(0, (10 + minnessiffra - ettTal2));
                minnessiffra = -1;
            } else {
                summa.insert(0, (minnessiffra - ettTal2));
                minnessiffra = 0;
            }
            langd2--;
        }

        // Subtraherar minnessiffra om det finns efter alla tal
        // har blivit subtraherade.
        while (minnessiffra == -1) {
            summa.insert(0, (10 + minnessiffra));

            minnessiffra--;
        }

        return summa.toString();
    }

    // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
    // utförd i samband med hetalen
    public static void visa(String tal1, String tal2, String resultat, char operator) {
        // sätt en lämplig längd på heltalen och resultatet
        int len1 = tal1.length();
        int len2 = tal2.length();
        int len = resultat.length();
        int maxLen = Math.max(Math.max(len1, len2), len);
        tal1 = sattLen(tal1, maxLen - len1);
        tal2 = sattLen(tal2, maxLen - len2);
        resultat = sattLen(resultat, maxLen - len);

        // visa heltalen och resultatet
        out.println("  " + tal1);
        out.println("" + operator + " " + tal2);
        for (int i = 0; i < maxLen + 2; i++)
            out.print("-");
        out.println();
        out.println("  " + resultat + "\n");
    }

    // sattLen lägger till ett angivet antal mellanslag i början av en given sträng
    public static String sattLen(String s, int antal) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < antal; i++)
            sb.insert(0, " ");

        return sb.toString();
    }
}
