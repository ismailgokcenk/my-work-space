package D21;

import java.util.LinkedList;
import java.util.Scanner;

public class LinListExample {

    public static void main(String[] args) {

        LinkedList<String> str = new LinkedList<>();
        str.add("Ali");
        str.add("Veli");
        str.add("Can");
        str.add("Selami");

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen bir isim giriniz");
        String isim = input.nextLine();


        if (str.remove(isim)){
            System.out.println("Bu isim LinkedListte vardı ve silindi");
            System.out.println(str);
        }else {
            System.out.println("Bu isim LinkedListte yok ve bu yüzden silinemedi");
            System.out.println(str);
        }

    }
}
