public class CompareNumbers {
    public static void main(String[] args) {
        int[] tab={-7,1000,2984,40};
        BiggestNumber nc=new BiggestNumber() {
            @Override
            public int takeBiggest(int[] tab) {
                if(tab==null){
                    throw new NullPointerException("Array is null");
                }if(tab.length==0)
                    throw new IllegalArgumentException("Array has to have at leasr 1 value");

                int biggestNumber=tab[0];
                for (int i = 0; i < tab.length; i++) {
                    if(biggestNumber<tab[i]){
                        biggestNumber=tab[i];
                    }
                }
                return biggestNumber;
            }
        };
        System.out.println("Najwieksza liczba to:"+nc.takeBiggest(tab));

    }
}
