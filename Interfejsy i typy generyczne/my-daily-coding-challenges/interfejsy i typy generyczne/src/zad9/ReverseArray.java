package zad9;
import java.lang.reflect.Array;
public class ReverseArray<T>{
    // Pole do przechowywania tablicy typu T
    private T[] array;

    // Konstruktor przyjmujący tablicę typu T
    public ReverseArray(T[] array) {
        this.array = array;
    }

    // Metoda odwracająca tablicę
    public T[] reverseArray() {
        int length = array.length;
        T[] reversedArray = (T[]) Array.newInstance(array.getClass().getComponentType(), length); // Tworzenie nowej tablicy typu T

        for (int i = 0; i < length; i++) {
            reversedArray[i] = array[length - 1 - i]; // Odwracanie elementów tablicy
        }

        return reversedArray; // Zwracamy odwróconą tablicę
    }


}
