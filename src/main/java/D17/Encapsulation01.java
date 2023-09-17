package D17;

public class Encapsulation01 {

  /*
    bir class olusturun
    private access mod sahip variablelar olusturun: isim, soyisim, yas seklinde
    parametreli ve parametresiz constructor olusturun
    bu variablelara ait getter setter methodlarını olusturun
    toString methodunu olusturun
     */


    private String isim;
    private String soyIsim;
    private int yas;

    public Encapsulation01(String isim , String soyIsim , int yas){
        this.isim=isim;
        this.soyIsim=soyIsim;
        this.yas=yas;

    }

    public Encapsulation01(){
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyIsim() {
        return soyIsim;
    }

    public void setSoyIsim(String soyIsim) {
        this.soyIsim = soyIsim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }


    @Override
    public String toString() {
        return "Encapsulation01{" +
                "isim='" + isim + '\'' +
                ", soyIsim='" + soyIsim + '\'' +
                ", yas=" + yas +
                '}';




    }
}
