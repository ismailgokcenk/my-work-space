package D16;

import java.util.ArrayList;
import java.util.List;

public class MutableImmıtableClass1 {
    public static void main(String[] args) {

        String str ="Mehmet";
        str.toUpperCase();
        System.out.println(str);


        List<String> list = new ArrayList<>();
        list.add("Mehmet");
        list.add("Ahmet");
        System.out.println(list);



    }
}
