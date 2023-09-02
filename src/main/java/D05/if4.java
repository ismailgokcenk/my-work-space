package D05;

import java.util.Scanner;

public class if4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen cinsiyet belirtiniz");
        String cinsiyet= input.next();

        System.out.println("Lütfen yaş belirtiniz");
        int yas = input.nextInt();


        if (yas<0 || yas>120){
            System.out.println("Lütfen geçerli bir yaş girinz");
        } else if (cinsiyet.equalsIgnoreCase("Kadın")&& yas<60) {
            System.out.println("Calismali");
        } else if (cinsiyet.equalsIgnoreCase("Kadın")&& yas>=60) {
            System.out.println("Emekli olabilir");
        } else if (cinsiyet.equalsIgnoreCase("Erkek")&& yas<65) {
            System.out.println("Calısmalı");
        } else if (cinsiyet.equalsIgnoreCase("Erkek")&& yas>=65) {
            System.out.println("Emekli olabilir");
        }else {
            System.out.println("Lütfen geçerli bir bilgi giriniz");
        }
    }
}
