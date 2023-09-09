package D03;

import java.util.Scanner;

public class D3Prc3 {
    public static void main(String[] args) {

 /*
        Example 1: Asagidaki ciktiyi verecek kodu yaziniz
                    Week: 1
                      Day: 1
                      Day: 2
                      Day: 3
                      .....
                    Week: 2
                      Day: 1
                      Day: 2
                      Day: 3
                      ....    */


        for (int i = 1; i <3 ; i++) {
            System.out.println("week:" +i);

            for (int j = 1; j <4 ; j++) {
                System.out.println("    day:" +j);

            }
        }


         /*
          Asagida gordugunuz sekli console'a yazdiran kodu olusturunuz

                X X X X X
                X X X X X
                X X X X X    */

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen satır(row) sayisini giriniz");

        int row = input.nextInt();

        System.out.println("Lütfen sütun(colum) sayısını giriniz");
        int colum= input.nextInt();







    }
}
