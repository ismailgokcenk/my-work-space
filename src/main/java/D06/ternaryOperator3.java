package D06;

public class ternaryOperator3 {
    public static void main(String[] args) {


        //Example 2: Iki sayinin isareti ayni ise bu sayilari carpan,
        //isaretleri farkli ise "Farkli isaretli sayilari carpamiyorum"
        // mesaji veren kodu yaziniz.

        int a = 10;
        int b = -20;

        Object result2 = ( a>0 && b>0 || a<0 && b<0   ) ? (a*b) : "Farkli isaretli sayilari carpamiyorum" ;
        System.out.println(result2);


    }

}
