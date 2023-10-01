package D30;

public class carRunner {
    public static void main(String[] args) {

        BMW auto1 = new BMW();
        System.out.println(auto1.carYear(2023, 2020));
        auto1.yakit();
        auto1.plaka();

        System.out.println("----------");

        Mercedes E200 = new Mercedes();
        E200.yakit();

        System.out.println(E200.getCarMarka());
        System.out.println(E200.getCarModel());
        E200.plaka();
        System.out.println(E200.setKm(10000));

    }
}
