import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProdyctImporter {
    static Map<String, TreeSet<Device>> readFile(String fileName){
        Map<String,TreeSet<Device>>productsMap=new HashMap<>();
        try(Scanner scanner=new Scanner(new File(fileName))) {
            scanner.nextLine();
            while (scanner.hasNextLine()){
                String[] split = scanner.nextLine().split(";");
                String category=split[0];
               Device device= new Device(category,split[1],Integer.parseInt(split[2]) );
                insertProductIntoMap(productsMap, category, device);

            }

        } catch (FileNotFoundException e) {
            System.err.println("Brak pliku");
        }

        return productsMap;
    }

    private static void insertProductIntoMap(Map<String, TreeSet<Device>> productsMap, String category, Device device) {
        if(productsMap.containsKey(category)){
            productsMap.get(category).add(device);
        }else {
            TreeSet<Device> devices = new TreeSet<>();
            devices.add(device);
             productsMap.put(category,devices);
        }
    }
}
