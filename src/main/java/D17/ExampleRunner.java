package D17;

public class ExampleRunner {


    public static void main(String[] args) {



        Example1 araba = new Example1("mercedes" , "E220" , 2015);
        System.out.println(araba.getMarka());
        System.out.println(araba.getModel());
        System.out.println(araba.getYil());
        System.out.println(araba);



        araba.setYil(2020);
        System.out.println(araba);




    }





}
