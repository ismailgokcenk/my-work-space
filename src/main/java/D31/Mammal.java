package D31;

public class Mammal extends Animal{

    @Override
    protected void age() {
        super.age();
        System.out.println("Mammal have age");
    }
}
