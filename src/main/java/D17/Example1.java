package D17;

public class Example1 {

    private String marka;

    private String model;

    private int yil;


    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    @Override
    public String toString() {
        return "Example1{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", yil=" + yil +
                '}';
    }

    public Example1(String marka, String model, int yil) {
        this.marka = marka;
        this.model = model;
        this.yil = yil;


        //////




    }
}
