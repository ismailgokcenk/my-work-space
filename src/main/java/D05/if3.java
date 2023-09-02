package D05;

import java.util.Scanner;

public class if3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen bir tamsayi giriniz");
        int tamsayi = input.nextInt();

        if (tamsayi % 2 == 0) {
            System.out.println("Cift sayi");
        } else if (tamsayi % 2 != 0) {
            System.out.println("Tek sayi");
        } else {
            System.out.println("ILütfen geçerli bir sayı giriniz");
        }

    }
}
