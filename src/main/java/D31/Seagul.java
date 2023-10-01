package D31;

public class Seagul extends Bird{

    @Override
    protected void sount() {
        super.sount();
        System.out.println("Bird soun is cik cik" );
    }

    @Override
    protected int kg(int a, int b) {
        return super.kg(a, b);
    }

    public Seagul() {
        super();
    }

    @Override
    protected void age() {
        super.age();
        System.out.println("Seagul is 10");
    }

}
