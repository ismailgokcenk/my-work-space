package D31;

public class Sheep extends Mammal{

    @Override
    protected void age() {
        super.age();
        System.out.println("Sheep is 5");
    }
}
