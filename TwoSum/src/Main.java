import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int target=9;
int result[]=twoSum(nums,target);
        System.out.println("Liczby mają indeksy "+result[0]+"oraz "+result[1]);



}

    private static int[] twoSum(int[] nums, int target) {
        for(int i=0;i< nums.length;i++){
            for(int j=i+1;j< nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[] {i,j};
                }
            }
        }


    throw new IllegalArgumentException("Nie znaleziono pary liczb");
    }


}
