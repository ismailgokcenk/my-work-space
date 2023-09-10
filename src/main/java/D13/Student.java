package D13;

public class Student {

    String name ="Ali";
    int age = 20;

    Student(String name, int age){
        this.name=name;
        this.age=age;
    }

    public static void main(String[] args) {

        Student st = new Student("İsmail" , 25);
        System.out.print(st.name);
        System.out.print("," + st.age);

    }

}
