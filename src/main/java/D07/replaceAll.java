package D07;

public class replaceAll {
    public static void main(String[] args) {


        String str = "Java'da rakamlar 1234567890";
        System.out.println(str.replaceAll("a","*"));
        System.out.println(str.replaceAll("\\s", "*"));
        System.out.println(str.replaceAll("\\S","*"));
        System.out.println(str.replaceAll("\\w","*"));
        System.out.println(str.replaceAll("\\W","*"));
        System.out.println(str.replaceAll("\\d","*"));
        System.out.println(str.replaceAll("\\D","*"));

    }
}
