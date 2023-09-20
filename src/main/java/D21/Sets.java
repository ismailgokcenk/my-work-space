package D21;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public class Sets {

    public static void main(String[] args) {

        HashSet<String> hstr = new HashSet<>(); //hashset sırasız hızlı
        hstr.add("ali");
        hstr.add("veli");
        hstr.add("selami");
        hstr.add("can");
        System.out.println(hstr);


        hstr.add(null);
        System.out.println(hstr);

        LinkedHashSet<String> lstr = new LinkedHashSet<>();  // giriş sırasına gore sıralar
        lstr.add("ali");
        lstr.add("veli");
        lstr.add("selami");
        lstr.add("can");
        System.out.println(lstr);


        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(313);
        lhs.add(19);
        lhs.add(7);
        lhs.add(1);
        lhs.add(19);  //aynısını yazmaz
        System.out.println(lhs);

        TreeSet<Integer> ts = new TreeSet<>(); //natural order a gore sıralr
        ts.add(1);
        ts.add(2);
        ts.add(3);
        ts.add(4);
        ts.add(5);
        System.out.println(ts);

    }


}
