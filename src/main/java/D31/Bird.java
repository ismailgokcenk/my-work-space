package D31;

public class Bird extends Animal{

    @Override
    protected void age() {
        super.age();
        System.out.println("Birds have age");
    }

    public Bird() {
    }

    protected  int kg(int a , int b){
        return(a-b);

    }

}

