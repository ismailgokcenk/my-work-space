package D09;

import java.util.Scanner;

public class forLoop7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen bir kelime gitin");
        String kelime = input.next();

        String tersKelime = "";

        for (int i =kelime.length()-1; i >=0 ; i--) {
        tersKelime=tersKelime+ kelime.charAt(i);
            System.out.println(tersKelime);

        }
        String t = "Java";
        String ters = "";

        for (int i = t.length()-1;         i >=0 ;             i--) {
            ters= ters+t.charAt(i);

        }
        System.out.println(ters);
            
        }
        
        
    }

