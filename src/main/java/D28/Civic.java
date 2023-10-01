package D28;

public class Civic implements Ac,Security,Engine {
    @Override
    public void cold() {
        System.out.println("Civic cools perfectly");

    }

    @Override
    public void run() {
        System.out.println("Ac runs super");
    }


    //extends olmuyor
                    //extend da 1 tae parent oluyor
                    //1 child ın 1 parenti olur
                    //ama implements fazla olabilir



}
