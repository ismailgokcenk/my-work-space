package D10;

import java.util.Arrays;

public class arrays6 {

    public static void main(String[] args) {


        String str = "Java, ogrenmek guzeldir";
        String arr1[] = str.split(",");
        System.out.println(Arrays.toString(arr1));

       String arr2[] = str.split(" ");
        System.out.println(Arrays.toString(arr2));

        String arr3 [] = str.split("");
        System.out.println(Arrays.toString(arr3));




    }

}
