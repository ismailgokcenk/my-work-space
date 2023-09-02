package Day03;

public class D3Prc01 {
    public static void main(String[] args) {

        //Example 1: Verilen bir String'de ilk 'a' harfinden onceki tum character'leri console'a yazdiriniz
        //           "I love Java" ==> "I love J"   //tekrarlı işlem oldugu şiçin loop kullanıcaz.

        String s = "I love Java";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a')
                break;
            System.out.print(s.charAt(i));
        }

        System.out.println();


        String s1 = "Tramvay";

        for (int j = 0; j < s1.length(); j++) {
            if (s1.charAt(j) == 'a')
                break;
            System.out.print(s1.charAt(j));
        }


        //example 2 :Verilen bir String'de kucuk harfleri console'a yazmayiniz
        //"Pwd12?Ab" ==> P12?A

        String s2= "Pwd12?Ab";







    }
}



