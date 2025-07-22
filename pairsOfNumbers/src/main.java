public class main {
    public static void main(String[] args) {
        int[] numbers = new int[]{-5, 0, 5, -10, 5, 15};
        int[] minResult = minPair(numbers);
        System.out.println("Najmniejsza para liczb to "+minResult[0] +"oraz "+minResult[1]);
        int[] maxResult=maxPair(numbers);
        System.out.println("Najwieksza para liczb to "+maxResult[0]+"oraz "+maxResult[1]);





    }




        public static int[] minPair(int[] numbers) {
        int[] min = new int[2];
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int number : numbers) {
            if (number < firstMin) {
                secondMin = firstMin;
                firstMin = number;
            }else if (number>firstMin&&number<secondMin){
                secondMin=number;
            }
        }
        min[0] = firstMin;
        min[1] = secondMin;
        return min;
    }
    public static int[] maxPair(int[] numbers) {
        int[] max = new int[2];
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > firstMax) {
                secondMax = firstMax;
                firstMax = number;
            } else if (number < firstMax && number > secondMax) {
                secondMax = number;
            }
        }
        max[0]=firstMax;
        max[1]=secondMax;

        return max;
    }
}






