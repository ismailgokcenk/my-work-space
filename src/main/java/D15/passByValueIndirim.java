package D15;

public class passByValueIndirim {
    public static void main(String[] args) {

     int fiyat = 100;
        System.out.println("%10 indirimli fiyat  :  "  +indirim10(fiyat));
        System.out.println("%20 indirimli fiyat  :  "  +indirim20(fiyat));
        System.out.println("%25 indirimli fiyat  :  "  +indirim25(fiyat));


    }
    public static int indirim10(int fiyat){
        fiyat *= 0.90;
        return fiyat;

    }
    public static int indirim20(int fiyat){
        fiyat *=0.80;
        return fiyat;
    }
    public static int indirim25(int fiyat){
        fiyat *=0.75;
        return fiyat;
    }


}
