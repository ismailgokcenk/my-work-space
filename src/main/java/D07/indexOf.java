package D07;

import D06.Switch;

import java.util.Scanner;

public class indexOf {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen bir cğmle giriniz");
        String str1 = input.nextLine();
        System.out.println("Lütfen kontrol etmek istediğiniz harfi giriniz");
        String str2 = input.nextLine();

        int result = str1.indexOf(str2);
        System.out.println(result);

        if (result<0 ){
            System.out.println("karakteri içermemektedir");
        } else {
            System.out.println("karekter İÇERMEKTEDİR");
        }


    }
}
