package D31;

public class Bird extends Animal{

Bird bird1=new Bird();

    @Override
    public String setAnimalAge(String animalAge) {
        super.setAnimalAge(animalAge);
        bird1.animalAge="bird1 10 yasinda";
        return animalAge;
    }

    @Override
    protected void sound() {
        super.sound();
        System.out.println("Bird sond is click click");
    }
}
