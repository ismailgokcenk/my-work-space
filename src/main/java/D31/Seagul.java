package D31;

public class Seagul extends Bird{



    private void renk(){
        System.out.println("Seaguls is white");
        return;
    }

    @Override
    public String setAnimalAge(String animalAge) {
        super.setAnimalAge(animalAge);

        setAnimalAge("Seagul 10 years old");
        return animalAge;
    }
}
