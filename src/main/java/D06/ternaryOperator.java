package D06;

public class ternaryOperator {

    public static void main(String[] args) {

        int x=40;

        String sonuc = (x%2==0) ? "cift sayi" : "tek sayi" ;
        System.out.println(sonuc);

        int b = 90;
        System.out.println( (b>500) ? ("inek") : ("koyun") );
        System.out.println( (b<91) ? 9 : 11  );

        int y = 1;
        int z = 1;

        int a = y<10 ? y++ : z++;
        System.out.println(y+"," + z+ "," + a );

    }
}
