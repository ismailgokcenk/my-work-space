package D02;

import java.util.Scanner;

public class D2Prc01 {
    public static void main(String[] args) {

         /*  Örnek : Bir parolanın aşağıdaki koşullara sahip olup olmadığını kontrol edin
           i) Parola Boş olmamalıdır, en az bir karakter icermelidir.
           ii) Karakterler Sadece (space) boşluk karakterlerden ibaret olmamalı, space harici karakterlerde bulunmalidir
           iii) Başında ve sonunda boşluk olmamalıdır.
        */


        String parola = "  ";

        //i) Parola Boş olmamalıdır, en az bir karakter icermelidir:

        boolean first = parola.isEmpty();
        System.out.println(first);


        //ii) Karakterler Sadece (space) boşluk karakterlerden ibaret olmamalı, space harici karakterlerde bulunmalidir:

        boolean second = parola.isBlank();
        System.out.println(second);



        //iii) Başında ve sonunda boşluk olmamalıdır.







        System.out.println();
        //Example 1: i)Verilen bir sayinin pozitif çift , negatif cift  veya notr oldugunu kontrol eden kodu yaziniz
        //           ii) Verilen sayı negatif ise "lütfen geçerli bir sayı giriniz" uyarısı yazdırınız

        Scanner input= new Scanner(System.in);
        System.out.println("Lütfen bir sayı giriniz");
        int num = input.nextInt();

        if (num>0 && num%2==0) {
            System.out.println("Pozitif cift sayi");
        } else if (num==0) {
            System.out.println("Notr");
        } else if (num<0 && num%2==0) {
            System.out.println("Negatif cift sayi");
        } else {
            System.out.println("Lütfen geçerli bir sayı giriniz");
        }

    }
}
