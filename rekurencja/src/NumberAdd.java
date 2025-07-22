public class NumberAdd {
    public static void main(String[] args) {
        int number = sum(4);
        System.out.println(number);
    }

   static int sum(int n){
        return n>1? n+sum(n-1) : 1;
   }
}
