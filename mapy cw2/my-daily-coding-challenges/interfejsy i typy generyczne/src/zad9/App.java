package zad9;

public class App {
    public static void main(String[] args) {

        // Przykład z tablicą Integer
        Integer[] intArray = {1, 2, 3, 4, 5};
        ReverseArray<Integer> reverseInt = new ReverseArray<>(intArray);
        Integer[] reversedIntArray = reverseInt.reverseArray();

        System.out.println("Odwrócona tablica Integer:");
        for (Integer i : reversedIntArray) {
            System.out.println(i);

        }
        }
}
