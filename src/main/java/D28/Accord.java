package D28;

public class Accord implements Ac,Security,Engine {
    @Override
    public void cold() {
        System.out.println("Accord cools supper");
    }

    @Override
    public void run() {
        System.out.println("Engine runs super");

    }
}
