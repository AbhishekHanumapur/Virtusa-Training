import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int arr[]={1,2,2,3,4};
        Set<Integer>set=new HashSet<>();
        for(int n:arr){
            set.add(n);

        }
        System.out.println(set);

    }
}
