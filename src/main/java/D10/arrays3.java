package D10;

import java.util.Arrays;

public class arrays3 {
    public static void main(String[] args) {

        int arrint[]={5,8,6,13,4};
        Arrays.sort(arrint);
        System.out.println(Arrays.toString(arrint));

        String arrayStr[] = {"a","z","s","g"};
        System.out.println(Arrays.toString(arrayStr));
        Arrays.sort(arrayStr);
        System.out.println(Arrays.toString(arrayStr));

        int i = 1;
        do{
            System.out.print(i + ',');
            i++;
        }while (i <= 5);
        


        }

    }

