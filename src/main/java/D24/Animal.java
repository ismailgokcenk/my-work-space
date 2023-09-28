package D24;

public class Animal {
    /*
    OOP conceptin 4 tane prensibi vardir
    1) Inheritance
    2) Polymorphism
    3) Encapsulation
    4) Abstraction

       1) Inharitance in faydalari
            a) Code tekrarlarindan kurtuluruz
            b) Code tamiri(maintenance) kolay olur
            c) Chilt class lari daha atomic yapmis oluruz
        2) Bir classi baska bir classin child classi yapmak icin extends keyword kullanilir
        3) Child class objectleri Parent Class dan method ve variable lari kullanabilirler
        4) Parent class objectleri chlid class dan method ve variable lari kullanamazlar
        5) Javada bir classin sadece bir tane parenti olabilir, java  coklu parenti (==>Multiple inheritance) desteklemez
            tekli parent i ( single inheritance) destekler, java single inheritance kullanir
       6) Apartman seklindeki inheritance yapisina Multilevel inheritance denir, java multilevel inheritance i destekler
       7) Object class her classin parentidir, javada object class haric her classin parenti vardir
       8) Javada parent tan childa olan iliskilere HAS-A Relationship denir
          Javada child tan parenta olan iliskilere IS-A Relationship denir
       9) java da her classin bir tane default constructor i vardir. Bu default constructor class icinde gorunmez
          cunku default constructor Object class icindedir


     */

    public void eat(){
        System.out.println("Animals eat..");
    }
    public void drink(){
        System.out.println("Animals drink..");
    }





















}