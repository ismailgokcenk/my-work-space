package D22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lambda01 {


    public static void main(String[] args) {


        List<Integer> sayi = new ArrayList<>(Arrays.asList(-5, -8, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

        ciftElemenlar(sayi);
        System.out.println("\n ****");
        ciftNegatiffMetRef(sayi);



    }

    //SORU1: List elemanlarının çift ve negatf olanlarını,
    // Lambda Expression kullanarak aralarında bosluk olacak sekilde yazdırın

    public static void ciftElemenlar (List<Integer> sayi){
        sayi.stream().filter(t-> t%2==0 && t>0).forEach(Utils::yazdir);

    }

    //SORU2: List elemanlarının çift ve pozitif olanlarını,
    // Method Referances kullanarak aralarında bosluk olacak sekilde yazdırın


    public static void ciftNegatiffMetRef (List<Integer> sayi){
        sayi.stream().filter(Utils::ciftNegatifBul).forEach(Utils::yazdir);
    }

}