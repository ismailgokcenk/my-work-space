package D31;

public class Animal {

    protected void sound (){
        System.out.println("Animal sound");
    }

    protected String animalAge;

    public String getAnimalAge() {
        return animalAge;
    }

    public String setAnimalAge(String animalAge) {
        this.animalAge = animalAge;
        return animalAge;
    }

    public Animal(String animalAge) {
        this.animalAge = animalAge;
    }

    public Animal() {
    }
}
