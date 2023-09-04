package D07;

import java.util.Scanner;

public class containsFrage {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen bir e mail adresi giriniz");
        String str1 = input.nextLine();

        Boolean str2 =  str1.contains("@gmail.com");
        System.out.println(str2);

        if (str2==true){
            System.out.println("e-mail adresiniz kaydedildi");
        } else if (str2==false) {
            System.out.println("lütfen gmail adresi giriniz");
        }else
            System.out.println("lütfen geçerli karakter giriniz");


    }
}
