import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader= null;
        try {
            fileReader = new FileReader("tekst.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        List<String> slowa=new ArrayList<>();
        readFile(bufferedReader, slowa);
        slowa=  slowa.stream()
                .map(s->s.replaceAll(",","").replaceAll("\\."," "))
                .collect(Collectors.toList());

        showStats(slowa);
    }

    private static void showStats(List<String> slowa) {
        long countSWords = slowa.stream()
                .filter(s -> s.startsWith("s"))
                .count();

        long count = slowa.stream()
                .filter(s -> s.length() == 5)
                .count();

        System.out.println("Liczba wyrazow z 5 znakami"+count);

        System.out.println("Liczba wyrazwo na s:"+countSWords);
    }

    private static void readFile(BufferedReader bufferedReader, List<String> slowa) throws IOException {
        String temp=null;
        while ((temp= bufferedReader.readLine())!=null){
            slowa.addAll(Arrays.asList(temp.split(" ")));
        }

    }
}
