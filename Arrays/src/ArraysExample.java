import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        String[] names={"Jacek","Zygmunt","Asia","Basia","kasia"};
        Integer[] numbers={4,1,4,5,6};

        System.out.println("Names");
        System.out.println(Arrays.toString(names));
        System.out.println("Numbers");
        System.out.println(Arrays.toString(numbers));

      String[] names2=Arrays.copyOf(names,names.length);
     Integer[] numbers2=Arrays.copyOf(numbers,numbers.length);
        System.out.println(Arrays.equals(numbers,numbers2));

        Arrays.sort(names);
        System.out.println(Arrays.toString(names));

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        String[] strings=new String[5];
        Arrays.fill(strings,"Wacek");
        printArray(strings);


    }

    public static<T> void printArray(T[] arr){
        for (T t : arr) {
            System.out.println(t+" ");
        }
        System.out.println();
    }
}
