package D12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayList01 {
    public static void main(String[] args) {


        List<String> hayvan = new ArrayList<>();
        System.out.println(hayvan);

        hayvan.add("kedi");
        System.out.println(hayvan);

        hayvan.add("kopek");
        System.out.println(hayvan);

        hayvan.add("aslan");
        hayvan.add("kartal");
        System.out.println(hayvan);

        hayvan.add("sinek");
        hayvan.add(0,"balık");
        System.out.println(hayvan);

        System.out.println(hayvan.size()); //6
        System.out.println(hayvan.isEmpty()); //false. bos olmadıgı ıcın false verdi

        hayvan.remove(0);
        System.out.println(hayvan); //index 0 daki balık silindi

        System.out.println(hayvan.remove(2)); //aslan
        System.out.println(hayvan); //[kedi, kopek, kartal, sinek]

        hayvan.remove("sinek"); //sinegi sildik
        System.out.println(hayvan);

        hayvan.set(2,"tavsan"); //2.index i tavsan yaptık
        System.out.println(hayvan); // [kedi, kopek, tavsan]


    }


}
