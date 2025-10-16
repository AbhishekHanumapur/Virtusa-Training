import java.util.Arrays;

public class SortArray {
    public static void main(String[] args)
    {
        int[] arr = {45, 10, 25, 5, 89};
        Arrays.sort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}