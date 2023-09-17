package D18;

public class Cat extends Animals{

    @Override
    public void eat() {

        System.out.println("Cats eat...");
    }

    @Override
    public void drink() {

        System.out.println("Cats drink...");
    }

    public void meow(){
        System.out.println("Cats meow");
    }

}
