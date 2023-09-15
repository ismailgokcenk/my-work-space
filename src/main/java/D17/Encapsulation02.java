package D17;

public class Encapsulation02 {

    public static void main(String[] args) {

        //Ali, Can, 25 ozelliklerine sahip bir obje olusturunuzz ve yazdırınız

        Encapsulation01 obj1 = new Encapsulation01("Ali","Can",25);
        System.out.println(obj1.getIsim());
        System.out.println(obj1.getSoyIsim());
        System.out.println(obj1.getYas());
        System.out.println(obj1);

        //objenin yasını 30 olarak guncelleyin

        obj1.setYas(30);
        System.out.println(obj1);

        //parametresiz cons kullanarak 2. bir obje olusturun
        Encapsulation01 obj2 = new Encapsulation01();
        System.out.println(obj2);

        //Ayse, Yilmaz, 40 degerlerini atayın
        obj2.setIsim("Ayse");
        obj2.setSoyIsim("Yilmaz");
        obj2.setYas(40);
        System.out.println(obj2);


        //yas ı -5 olarak guncelleyin
        obj2.setYas(-5);
        System.out.println(obj2);


    }

}
