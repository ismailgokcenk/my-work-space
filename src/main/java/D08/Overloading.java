package D08;

public class Overloading {
    public static void main(String[] args) {


        int sonuc = carpma(3,2);
        System.out.println(sonuc);

        double sonucD=carpma(3,4);
        System.out.println(sonucD);

        Overloading denemeStr = new Overloading();
        denemeStr.selamver("Ahmet");

    }


    public static int carpma(int a , int b){
        return a*b;
    }

    public static double carpma(double x, double y) {
        return x*y;

    }

    public void selamver(String isim){
        System.out.println("Merhaba" + isim );
    }
}

