package D10;

import java.util.Arrays;

public class arrays1 {
    public static void main(String[] args) {


        String names[] = new String[4];

        System.out.println(Arrays.toString(names));

        names[0]="Ali";
        names[1]="Veli";
        names[2]="Ayse";
        names[3]="Fatma";
        System.out.println(Arrays.toString(names));


        System.out.println(names[2].charAt(3));
        System.out.println(names[3].length());
        System.out.println(names[1].length()-1);
        names[0]="Kamil Can";
        System.out.println("names[0] = " + names[0]);
        int size = names[0].length();
        System.out.println(size);


    }
}
