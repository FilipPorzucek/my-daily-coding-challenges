public class Tester {
    public static void main(String[] args) {
   
        printFiveTimes(5);
        printFiveTimes("Krzysio");
        

    }

    private static <T> void printFiveTimes(T arg) {
        for(int i=0;i<5;i++){
            System.out.println(arg);
        }
    }
}
