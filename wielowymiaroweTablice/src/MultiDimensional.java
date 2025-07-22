public class MultiDimensional {
    public static void main(String[] args) {


       double[][] numbers=new double[3][3];
       numbers[0][0]=1;
       numbers[0][1]=1.5;
       numbers[0][2]=2;
       numbers[1][0]=1.5;
       numbers[1][1]=2.0;
       numbers[1][2]=2.5;
       numbers[2][0]=2;
       numbers[2][1]=2.5;
       numbers[2][2]=3;

        System.out.println((numbers[0][0]*numbers[1][1]*numbers[2][2])+ (numbers[0][2]*  numbers[1][1]*numbers[2][0]));
        System.out.println((numbers[1][0]+numbers[1][1]+numbers[1][2])*( numbers[1][0]+ numbers[1][1]+numbers[2][1]));




    }
}
