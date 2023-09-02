package D05;

import java.util.Scanner;

public class if5 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please add a year");
        int year = input.nextInt();

        if (year % 4 == 0 && year%100!=0){
            System.out.println("Artık yıl");
        } else if (year%4==0 && year%100==0 && year%400==0) {
            System.out.println("Artık yıl");
        } else if (year%4!=0 ){
            System.out.println("Artık yıl değildir");
        } else {
            System.out.println("Artık yıl degıldır");
        }

        }

    }



