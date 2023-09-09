package D10;

import java.util.Arrays;

public class arrays4 {
    public static void main(String[] args) {

    int numbers[] = {5,3,4,1,2};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.binarySearch(numbers,4));

        String str[] = {"a","f","e","d"};
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
        System.out.println(Arrays.binarySearch(str,"e"));
        System.out.println(Arrays.binarySearch(str,"f"));



    }
}
