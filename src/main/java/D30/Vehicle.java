package D30;

public abstract class Vehicle {

    public void yakit(){
        System.out.println("Araclar yakıt tüketir");
    }

    protected String carMarka;

    protected String carModel;

    protected String plaka (){
        return "Lütfen plaka giriniz";
    }

    private int km;

    protected Vehicle() {
    }


    public Vehicle(String carMarka, String carModel, String plaka, int km) {
        this.carMarka = carMarka;
        this.carModel = carModel;

        this.km = km;
    }

    public String getCarMarka() {
        return carMarka;
    }

    public void setCarMarka(String carMarka) {
        this.carMarka = carMarka;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }


    public int getKm() {
        return km;
    }

    public int setKm(int km) {
        this.km = km;
        return km;
    }

     protected int carYear(int a , int b){
        return (a-b);
     }

}
