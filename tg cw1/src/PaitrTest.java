public class PaitrTest {
    public static void main(String[] args) {
        Pair<String,String> pair1=new Pair<>("Ania","Kowalska");
      printPair(pair1);
    }

    static <T,V> void printPair(Pair<T,V> pair){
        System.out.println(pair.getT()+" "+pair.getV());
    }
}
