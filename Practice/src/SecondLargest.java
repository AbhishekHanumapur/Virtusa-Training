import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int arr[]={1,3,4,2};
        Arrays.sort(arr);
        int secLar= arr[arr.length-2];
        System.out.println(secLar);
    }
}
