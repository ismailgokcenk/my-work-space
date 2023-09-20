package D21;

public class LinkedList {

    public static void main(String[] args) {


        java.util.LinkedList<String> str = new java.util.LinkedList<>();  //linklist classından bir obje olusturduk. Link lsit yapımızda string tutacagız
        str.add("Mehmet");
        str.add("Ahmet");
        str.add("Mehmet");
        str.add("Onur");
        str.add("Kubre");
        str.add("Tuba");
        str.add("Duygu");
        str.add("Mehmet");
        System.out.println(str);//[Mehmet, Ahmet, Onur, Kubre, Tuba, Duygu]

        str.add(1,"Kamil");
        System.out.println(str);
        str.addFirst("Gökçen");
        System.out.println(str);
        str.addLast("Oznur");
        System.out.println(str);
        str.removeFirst();
        System.out.println(str);
        str.removeLast();
        System.out.println(str);
       // str.removeLast();
        //System.out.println(str);
        str.remove("Mehmet");
        System.out.println(str);
        str.removeLastOccurrence("Mehmet");
        System.out.println(str);
        System.out.println(str.get(2));


    }
}
