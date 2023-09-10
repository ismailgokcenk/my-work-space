package D13;

public class Phone {

    String name;
    int age;
    String phone;

    Phone(){

    }

    Phone(String name,int age,String phone){
        this.phone=phone;
        this.name=name;
    }

    public static void main(String[] args) {
        Phone p1 =new Phone();
        Phone p2 = new Phone("John",25,"017615035067");

        System.out.println(p2.name + "," + p2.age + "," + p2.phone);
    }



}
