package EU.EU1;

public class minstaHeltal {

    public static void main(String[] args) {
        /*
        int[] element = {   1, 3, 7, 6, 8, 0,
                            9, 10, 14, 2, 7,
                            6, 1, 19, 20, 0     };

        */
        int[] element = {5, 7, 9, 10, 6, 3, 8,
                10, 13, 19, 11, 20, 14,
                4, 5, 15, 2, 5, 4};


        System.out.println(min(element));
        System.out.println(minimum(element));
    }

    // min returnerar det minsta elementet i en sekventiell samling.
    // Om samlingen är tom, kastas ett undantag av typen IllegalArgumentException.
    public static int min(int[] element) throws IllegalArgumentException {
        if (element.length == 0)
            throw new IllegalArgumentException("tom samling");

        // hör ihop med spårutskriften 2:
        // int    antalVarv = 1;

        int[] sekvens = element;
        int antaletPar = sekvens.length / 2;
        int antaletOparadeElement = sekvens.length % 2;
        int antaletTankbaraElement = antaletPar + antaletOparadeElement;
        int[] delsekvens = new int[antaletTankbaraElement];
        int i = 0;
        int j = 0;
        //while (sekvens.length > 1)
        while (antaletPar > 0) {
            // Sätt in delsekvens i loopen för att fixa problemen
            //int[]    delsekvens = new int[antaletTankbaraElement];

            // skilj ur en delsekvens med de tänkbara elementen
            i = 0;
            j = 0;
            while (j < antaletPar) {
                delsekvens[j++] = (sekvens[i] < sekvens[i + 1]) ? sekvens[i] : sekvens[i + 1];
                i += 2;
            }
            if (antaletOparadeElement == 1)
                // delsekvens[j] = sekvens[sekvens.length - 1];
                // delsekvens[j] = sekvens[2 * antaletPar]; (funkar också)
                delsekvens[j] = sekvens[i];

            // utgå nu ifrån delsekvensen
            sekvens = delsekvens;
            antaletPar = antaletTankbaraElement / 2;
            antaletOparadeElement = antaletTankbaraElement % 2;
            antaletTankbaraElement = antaletPar + antaletOparadeElement;

            // spårutskrift 1 – för att följa sekvensen
            System.out.println(java.util.Arrays.toString(sekvens));

            // spårutskrift 2 - för att avsluta loopen i förväg
            // (för att kunna se vad som händer i början)
            // if (antalVarv++ == 10)
            // System.exit (0);
        }

        // sekvens[0] är det enda återstående tänkbara elementet
        // - det är det minsta elementet
        return sekvens[0];
    }

    public static int minimum(int[] element) throws IllegalArgumentException{

        if (element.length == 0)
            throw new IllegalArgumentException("tom samling");

        int[] sekvens = element;
        int minstaElement = element[0];

        for (int i = 1; i < element.length; i++) {
            if (minstaElement > element[i]) {
                minstaElement = element[i];
            }
        }
        return minstaElement;
    }
}
