package D07;

import java.util.Scanner;

public class contains {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen bir cümle giriniz");
        String str = input.nextLine();

        System.out.println("Lütfen kontrol etmek istediğiniz harfi girin");
        String str2 = input.nextLine();

        Boolean result = str.contains(str2);
        System.out.println(result);

        if (result== true ){
            System.out.println("kelime VAR");
        } else if (result == false) {
            System.out.println("kelime YOK");
        }else
            System.out.println("Lütfen geçerli bir karakter girinz");



    }
}
