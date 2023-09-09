package D01;

public class D1Prc01 {
    public static void main(String[] args) {

        //Example 1: Asagida fiyatlari verilen urunlerin toplam fiyatini bulunuz.
        //           String tv = "$456.99";   String laptop = "$875.99"; ==> 456.99 + 875.99 = 1332.98

        String tv = "$456.99";
        String laptop = "$875.99";

        String newTv= tv.replace("$","");
        String newLaptop = laptop.replace("$","");

        Double totalPrice= Double.valueOf(newTv)+Double.valueOf(newLaptop);
        System.out.println(totalPrice);

        //Example2 Verilen ismin ilk isiminin ilk harfini ve soy isminin ilk harfini ekrana yazdiriniz.
        //                   "    ali cAN   " ==> AC

        String name="    ali cAN   ";
        char name2=name.trim().toUpperCase().charAt(0);
        char surname= name.trim().toUpperCase().charAt(4);
        System.out.println(""+name2+surname);



        //Example3 : Bir string'in belirli bir karakterinden baslayarak belirli bir karaktere kadar tum
        // karakterleri dynamic olarak aliniz
        //abc@gmail.com ===> gmail

        String ornek= "abc@gmail.com";
        System.out.println(ornek.substring(4,9)); //dynamic değil, biz dynamic yapmalıyız.

        int startingIndex= ornek.indexOf("@")+1;
        int lastIndex = ornek.indexOf(".");
        String companyName = ornek.substring(startingIndex,lastIndex);
        System.out.println("Company Name : " +   companyName);


        //Example  Bir String'deki tekrarsiz character'leri ekrana yan yana yazdiriniz.
        //           mehmet ==> ht



        //Example  Bir banka kartının son 4 hanesi hariç tüm hanelerini '*' kullanarak görünmez yapın
        //           1234 6789 1234 6789 ==> **** **** **** 6789

        String cardNum = "1234 6789 1234 6789";
        String first9Num = cardNum.substring(0,15).replaceAll("[0-9]" , "*");

        String last4Num = cardNum.substring(15);
        System.out.println(first9Num+last4Num);












    }
}
