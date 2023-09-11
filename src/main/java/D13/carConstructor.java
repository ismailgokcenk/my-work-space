package D13;

public class carConstructor {


    //veriable lar :
    int ilanNo;
    String marka;
    String model;
    int yil ;
    int fiyat;


    public static void main(String[] args) {

        //main method ıcınde car1 adında obje olusturduk ve degerler atadık

        carConstructor car1 = new carConstructor();

        car1.ilanNo=1001;
        car1.marka="Toyota";
        car1.model="Corolla";
        car1.yil=2010;
        car1.fiyat=15000;

        System.out.println(car1.ilanNo + "," + car1.marka + "," + car1.model + "," + car1.yil + "," + car1.fiyat);

        car1.hiz(150);
        car1.yakit("Benzin");


    }


    //methodlar:
    public void hiz (int maxHiz){
        System.out.println("Araba max.  "  + maxHiz +"km yapar");
    }

    public void yakit(String yakitTuru){
        System.out.println("Araba yakit olarak   " + yakitTuru +"  kullanır");
    }







}
