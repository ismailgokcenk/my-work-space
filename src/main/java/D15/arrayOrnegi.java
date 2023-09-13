package D15;

import java.util.Arrays;

public class arrayOrnegi {

    public static void main(String[] args) {

        int num[] = {10,11,12};
        System.out.println(Arrays.toString(num));
        degisArr(num);
        System.out.println(Arrays.toString(num));


    }

    public static void degisArr(int num[]){
        num=new int[100];
        System.out.println(Arrays.toString(num));
    }


}
