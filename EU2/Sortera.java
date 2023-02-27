package EU.EU2;

import java.util.Arrays;

public class Sortera {

    public static void main(String[] args){
        int[] lista = {7, 6, 9, 5};

        System.out.println(Arrays.toString(lista));
        System.out.println(Arrays.toString(minstaVardet(lista)));
    }

    public static int[] minstaVardet (int[] varden){

        int temp;
        int i = 0;

        while (i < varden.length)
        {
            int j = i + 1;
            while (j < varden.length)
            {
                if (varden[j] < varden[i])
                {
                    temp = varden[i];
                    varden[i] = varden[j];
                    varden[j] = temp;

                    System.out.println(Arrays.toString(varden));
                }
                j++;
            }
            i++;
        }
        return varden;
    }
}
