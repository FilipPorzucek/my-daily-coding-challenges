import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Names {

    public static void main(String[] args) {
        File file=new File("C:\\Users\\Filip\\Desktop\\javaStart\\zbiory cw1\\src\\namespl.txt");
        Scanner scanner= null;
        try {
            scanner = new Scanner(file);
            TreeSet<String> set=new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return -o1.compareTo(o2);
                }
            });
            while (scanner.hasNext()){
                String line= scanner.nextLine();
                set.add(line);
            }

            System.out.println(set);
            System.out.println(set.size());
        } catch (FileNotFoundException e) {
            System.out.println("Nie udalo sie wyswietlic");
        }


    }
}
