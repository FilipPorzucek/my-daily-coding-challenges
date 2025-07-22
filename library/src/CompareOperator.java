public class CompareOperator {
    public static void main(String[] args) {
        int x=5;
        int y=5;

        System.out.println("Czy x jest wiekszy od y");
        boolean isXGreaterThanY= x>y;
        System.out.println(isXGreaterThanY);

        boolean xEqualY= x!=y;
        System.out.println("Czy x jest rowne y");
        System.out.println(xEqualY);
    }
}
