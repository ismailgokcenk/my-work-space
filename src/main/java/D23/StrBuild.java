package D23;

public class StrBuild {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("...");
        System.out.println(sb);

        StringBuilder sb1 = new StringBuilder(); // boş bir StringBuilder
        System.out.println(sb1);

        StringBuilder sb2 =new StringBuilder("Test"); // belli bir degeri olan Str.Bukild
        System.out.println(sb2);
        StringBuilder sb3 = new StringBuilder(5); // Ilkuzunlugu tahmin edilen bir StrBuild



    }

}
