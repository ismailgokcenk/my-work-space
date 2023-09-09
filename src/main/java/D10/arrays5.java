package D10;

import java.util.Arrays;

public class arrays5 {

    public static void main(String[] args) {


        int arr1[] = {2,1,7,8};
        int arr2[] = {7,1,6,2};
        System.out.println(Arrays.equals(arr1,arr2));

        int arr3[]={3,5,7,9};
        int arr4[]={7,3,9,5};
        Arrays.sort(arr3);
        Arrays.sort(arr4);
        System.out.println(Arrays.equals(arr3,arr4));  //sort ile sıralamassak false verir





    }

}
