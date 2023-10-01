package D30;

public class Mercedes extends Vehicle{

    @Override
    public void yakit() {
        System.out.println("Mercedes diesel yakit tuketir");

        setCarMarka("Bu mercede E200");

        setCarModel("Bu Mercedes 2015 model");


    }

    @Override
    protected String plaka() {
        System.out.println("RT LA 1330");
        return null;
    }



    }



