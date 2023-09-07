package D09;

import java.util.Scanner;

public class forLoop5 {
    public static void main(String[] args) {


        //FOR LOOP SORU 5

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen 100 den kucuk bir tamsayı giriniz");
        int sayi= input.nextInt();

        for (int i = 1; i <101 ; i++) {
            if (i%3==0 && i%5==0 && i<101 ){
                System.out.print(i+",");
            }
            }

        }


    }

