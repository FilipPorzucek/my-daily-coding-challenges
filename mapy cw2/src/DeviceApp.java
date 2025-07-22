import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DeviceApp {
    public static void main(String[] args) {
        Map<String, TreeSet<Device>> stringSetMap = ProdyctImporter.readFile("C:\\Users\\Filip\\Desktop\\javaStart\\mapy cw2\\src\\devices.txt");
        String category=readCategory();
        printCategoryStats(stringSetMap,category);

    }

    private static void printCategoryStats(Map<String, TreeSet<Device>> stringSetMap, String category) {
        TreeSet<Device> devices = stringSetMap.get(category);
        
        if(devices==null){
            System.out.println("Brak produktow z kategori");
        }else {
            printAll(devices);
            printAveragePrice(devices);
            CheapestAndExpensiceProducts(devices);
        }
    }

    private static void CheapestAndExpensiceProducts(TreeSet<Device> devices) {
        System.out.println("Najtanszy produkt "+devices.first());
        System.out.println("Najdrozszy produkt "+devices.last());
    }

    private static void printAveragePrice(Set<Device> devices) {
        double sumPrice=0;
        for (Device device : devices) {
            sumPrice+=device.getPrice();
        }
        double avgPrice=sumPrice/ devices.size();
        System.out.println("Srednia to "+avgPrice);
    }

    private static void printAll(Set<Device> devices) {
        for (Device device : devices) {
            System.out.println(device);
        }
    }

    private static String readCategory() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj nazwe kategori");
        return scanner.nextLine();
    }
}
