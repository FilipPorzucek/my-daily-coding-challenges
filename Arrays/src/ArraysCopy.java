import java.util.Arrays;

public class ArraysCopy {
    public static void main(String[] args) {
        int numbers[]={1,2,3,4,5,6,7,8,9};
        int numbers2[]=new int[numbers.length];
        System.arraycopy(numbers,4,numbers2,0,numbers.length-4);
        System.out.println(Arrays.toString(numbers2));
    }
}
