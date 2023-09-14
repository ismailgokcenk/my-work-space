package D16;

public class StrBuilder {
    public static void main(String[] args) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("animal");
        StringBuilder sb3 = new StringBuilder(5);



        sb2.append("als");
        System.out.println(sb2);



        System.out.println(sb2.length());
        System.out.println(sb2.capacity());
        System.out.println(sb3.capacity());
        System.out.println(sb1.capacity()); //16
        System.out.println(sb2.charAt(2)); // i
        System.out.println(sb2.delete(1, 3));
        System.out.println(sb2.deleteCharAt(0)); //malals
        System.out.println(sb1.equals(sb2));
        System.out.println(sb2.indexOf("l")); //2
        System.out.println(sb2.insert(3, "java", 1, 4)); //malavaals
        System.out.println(sb2.replace(3, 8, "ALİ"));
        System.out.println(sb2.reverse()); //ters cevirdi
        sb2.setCharAt(3,'X');
        System.out.println(sb2);
        System.out.println(sb2.toString());


    }
}
