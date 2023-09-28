package aKaralama;

import java.util.ArrayList;
import java.util.Arrays;

public class Karalama01 {
    public static void main(String[] args) {

        ArrayList<Integer> ages = new ArrayList<>();

        //Arraylistlere eleman nasıl eklenir?
        ages.add(5);
        ages.add(7);
        ages.add(19);
        ages.add(1,313);  //diğer add methodu ile yaptık.
        ages.add(3,777);  //kacıncı ındexe eklemek ısytıyorsak o ındexi yazıyoruz
        ages.add(999);  //en sona ekleyeceksek one ındex sırasını yazmaya gerek yok

        ArrayList<Integer> newAges = new ArrayList<>();
        newAges.add(1);
        newAges.add(2);
        newAges.add(3);

        ages.addAll(newAges); //1,2,3 ü sona ekleme
        //ages.addAll(0,newAges); //1,2,3 u basa ekleme

        System.out.println(ages);  // [5, 313, 7, 777, 19, 999, 1, 2, 3] - çalısıtırma sekli arraylerden farklı
    }
    }





