package D29;

public class Cat {

    public String name ;
    public String color ;

    private int age ;

    int hungry;


    public Cat(String name, String color, int age, int hungry) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.hungry = hungry;
    }

    public Cat() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}



