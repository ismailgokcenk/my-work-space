package D26;

public class StudentRunner {
    public static void main(String[] args) {
        Student s1 = new Student();


        System.out.println(s1.getStdId());//AC20231212121
        System.out.println(s1.getNotOrt());//3.13
        System.out.println(s1.isSuccesful());//false

        System.out.println("==================================");

        s1.setStdId("VH123456789");
        s1.setNotOrt(4.4);
        s1.setSuccesful(true);

        System.out.println(s1.getStdId());
        System.out.println(s1.getNotOrt());
        System.out.println(s1.isSuccesful());

        System.out.println("==================================");

        s1.setStdId("SA548755559");
        s1.setNotOrt(2.99);
        s1.setSuccesful(false);

        System.out.println(s1.getStdId());
        System.out.println(s1.getNotOrt());
        System.out.println(s1.isSuccesful());

    }
}