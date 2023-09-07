package D09;

import java.util.Scanner;

public class forLoop6 {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen 100 den kucuk bir tamsayı giriniz");
        int sayi = input.nextInt();


            for (int i = 1; i <= sayi; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println(i + "Java Guzeldir");
                } else if (i % 5 == 0) {
                    System.out.println(i + "Guzeldir");
                } else if (i % 3 == 0) {
                    System.out.println(i + "Java");
                }else {
                    System.out.println("geçersiz");
                }

            }

        }

    }

