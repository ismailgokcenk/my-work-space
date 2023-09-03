package D06;

import java.util.Scanner;

public class ternaryOperators4 {
    public static void main(String[] args) {



        //interview question
        /*    Example : Verilen yilin "Artik Yil"(Leap Year) olup olmadigini kontrol eden kodu yaziniz.
                       1)Yil 100'e bolunurse 400'e de bolunmelidir. 1600==>Leap    1800==>Leap degil
                       2)Yil 100'e bolunmuyorsa 4'e bolunmelidir. 2004==>Leap    2005==>Leap degil
         */

        Scanner input = new Scanner(System.in);
        System.out.println("Please add a year");
        int year = input.nextInt();


        String result = (year % 100 == 0 && year % 400 == 0 || year % 100 != 0 && year % 4 == 0 ? "Leap" : "NOT Leap");
        System.out.println(result);






    }
}
