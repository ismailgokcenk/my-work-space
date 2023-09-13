package D15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class passByValue {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(11);
        list.add(12);
        //System.out.println(list);
        degistirList(list);
        System.out.println(list);


    }

    public static void degistirList(List<Integer> list){
        list=new ArrayList<>();
        list.add(40);
        System.out.println(list);
    }

}
