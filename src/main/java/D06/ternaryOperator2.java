package D06;

import java.util.Scanner;

public class ternaryOperator2 {

    public static void main(String[] args) {

        //Example : Size verilen sayinin 3 basamakli olup olmadigini kontrol eden kodu yaziniz

        Scanner input = new Scanner(System.in);
        System.out.println("Please add a number");
        int num = input.nextInt();
        num = Math.abs(num);
        String result =(num>99 && num<1000 ? ("Üc basamaklı") : ("Üc basamaklı degil"));
        System.out.println(result);


        //Example 2: Iki sayinin isareti ayni ise bu sayilari carpan,
        //isaretleri farkli ise "Farkli isaretli sayilari carpamiyorum"
        // mesaji veren kodu yaziniz.

        int a = 10;
        int b = 20;

        Object result2 = ( a>0 && b>0 || a<0 && b<0   ) ? (a*b) : "Farkli isaretli sayilari carpamiyorum" ;
        System.out.println(result2);




    }

}
