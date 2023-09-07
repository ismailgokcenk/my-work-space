package D09;

import java.util.Scanner;

public class forLoop4 {
    public static void main(String[] args) {


        //FOR LOOP SORU 4)

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen 100 den küçük bir tamsayı giriniz");
        Integer sayi = input.nextInt();

        for (int i = 1; i < 100; i++) {
            if (  i% 3 == 0 && sayi<100 && i<sayi) {
                System.out.print(i+",");
            } else  {
                System.out.println("Lütfen 100 den kucuk bir sayı giriniz");

            }



            }

            }


        }

