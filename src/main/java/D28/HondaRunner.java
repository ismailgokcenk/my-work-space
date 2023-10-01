package D28;

public class HondaRunner {
    public static void main(String[] args) {

        Civic civic = new Civic();
        civic.cold();

        Accord accord= new Accord();
        accord.cold();

        System.out.println(Ac.price);

        //Ac.price=313; price final oldugu ıcın bu kod hata verir. Yenı deger atamayız.

        System.out.println(Engine.price);
        System.out.println(Security.price);

        //8 numaralı not:
        civic.eco();
        Engine.stop();
    }
}
