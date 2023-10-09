package D32;

public class LinkedList {

    public static void main(String[] args) {


        java.util.LinkedList<String> str = new java.util.LinkedList<>();

        str.add("Mehmet");
        str.add("Ahmet");
        str.add("Ali");
        str.add("Can");
        str.add("Veli");
        System.out.println(str);

        str.add(0,"Kamil");
        System.out.println(str);

        str.addFirst("Okan");
        System.out.println(str);

        str.addLast("Hakan");
        System.out.println(str);



        str.remove("Kamil");
        System.out.println(str);

        str.remove(0);
        System.out.println(str);



    }




}
