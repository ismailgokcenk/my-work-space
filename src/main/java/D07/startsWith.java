package D07;

public class startsWith {
    public static void main(String[] args) {

        String str = "Java güzel";
        System.out.println(str.startsWith("J"));
        System.out.println(str.startsWith("j"));
        System.out.println(str.startsWith("Jav"));
        System.out.println(str.startsWith("v",2));

    }
}
