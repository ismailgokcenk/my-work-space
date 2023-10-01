package D28;

public interface Ac {

    /*
    1)Bir interface i bir classın parenti yapmak ıcın implements keyvordu kullanırız.
    2)Java parentlar class oldugunda multiple parent a  müsade etmez ama biz bazen multiple parenta
    ihtiyac duyarız. İşte bu ihtiyacı gidermek ıcın java ınterface isimli yeni bir yapı oluşturdu
    3)interface lerin icine concrete method konulamaz. cunku concrate methodlarda body vardır.
    Ve body o methodun isi nasıl yapacagını beirtir/ayrıntı verir. İsin nasıl yapıalcagı bir cok detay ıcerir.
    Bu da child classlarda kafa karısıklıgına sebep olur. Halbuki saadece yapılması gereken isi söyleyip
    nasıl yapıalcagını child a bırakırsanız child class ın kafa karısıklıgını engellemiş olursunuz.
    4)Interfacelerdeki tum methodlar otomatık olarak public ve abstract tır. Statik degildir!
    5)Interface ler concrete method ıcremezler. Dolayısıyla interface ıcındeki hiçbirsey ıstege baglı degıldır.
    hersey child classlar ıcın mecburidir. Bu yuzde ınterfaceler e "to-do-list" de denir.
    6)Coklu interface parent ların herbirinin icine aynı isimde methodlar koyabiliriz. (biz run koyduk)
    Mesela run() methodunu koymak gıbı.
    Child class herhangi birini override ettiğinde hepsini override etmiş gibi olur.
    SOnra body ye yazarak uygulamasını yazmıs olur (sout ettiğimiz yer)
    7) interface lerdeki tüm veriable lar otomatik olarak (default olarak) public static ve final dır
    final oldugu için interface icindeki verable i initialize yapmalısınız(deger atamak zorundasınız)
    interface lerde veriable cagırırken interface ismi kullanılarak cagrılır. cunku bu hem static olmanın
    geregidir hem de okunurlugu artırır.
    8) normalde interfacelere concerete method koyulamaz. ama bazen gerekirse özel durumlarda:
        a)default keywordu kullanarak interface ıcıne concrete method koyabiliriz
        b)static keyword ünü kullanarak interfaceıcıne concerete methodu koyabiliriz.
                .static keyword ünü kullanarak olusturdugumuz concrete methodlara ulasmak ıcın objekt
                olusturmaya gerek yoktur. interfacein ismi (Engine) yeterlidir.
                .default keywordunu kullanarak olusturdugumuz concrete methodlara interface in
                child klasından object olusturularak ulasılabilir.
     9)Interfacelerden obje olusturulamaz. aynı abstraclass mantıgı. icinde eksik yapılar var.
     interface lerin constructorları yoktur.


       NOT==> Türlerine gore baglama keywordleri:
            Child              Parent
            class               class       ==>    extends
            interface           interface   ==>    extends
            class               interface   ==>    implements
            interface           class       ==>    OLAMAZ



      interwiev sorusu:

      Abstract class ile interface arasındaki farklar nelerdir?

      1) Abstract classlar hem abstract hemde concrete methodlar icerebilir fakat interfaceler sadece abstract method icerir
         ama interfacelerde istersek default ve static keywordleriri kullanarak concrete method olusturabiliriz.
      2) Abstract classlar multiple interitance i desteklemez ama interfaceler destekler
      3) Abstract classlar icinde herturlu veriable olusturulabilir. ama interfeceler icindeki veriable lar
      public,static ve final olmak zorundadır.
      4) interfacelerde constructer yoktur, ama abstractlarda consructer vardır. her ikisinden de object üretilemez
      5) interface classın childi olamaz. ama abstruct class ,classın child ı olabilir.





     */




    public abstract void cold(); // abstract yszsak da olur yazmasakda.otom. abstract kabul ediyor zaten

    void run();

    public static final int price =2000;  //7 numaralı not
    //public static final burayı yazmasak da aynı. default


    default void eco(){  //8 nolu not.defaultu koyunca hata gidiyor. istisnai durum
        System.out.println("Uses gas less"); //bu default acces mod. degil.
                                             //acces mod. olan default zaten yazmıyorduk.
                                             // buradaki default keyword
                                             // buranın acces. mod ı public
    }

}




