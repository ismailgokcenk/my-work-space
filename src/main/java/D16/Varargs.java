package D16;

public class Varargs {
    public static void main(String[] args) {
        add(5,7,-3,-2,9);



    }

    public static void add (int... sayi) {
        int sum =0;
        for (int w: sayi) {
            sum+=w;
        }
        System.out.println("Girilen sayıların toplami  =  " + sum);
    }




}
//1) Bir method parantezinde birden fazla varargs kullanilmaz
//2) Bir method parantezinde birden fazla parametre kullanilacaksa Varargs en sonda olmalidir


//Java farkli sayidaki parametrelerin hepsini kabul eden bir yapi olusturdu.
//Bu yapiya Varargs diyoruz
//Varargs arka planda Array yapisini kullanir