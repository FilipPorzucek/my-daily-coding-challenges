public class Test {
    public static void main(String[] args) {

        Sortable sorter=new Sortable() {
            @Override
            public void sort(int[] array) {

                for (int i=0;i<array.length;i++){
                    for (int j = 1; j < array.length-i; j++) {
                        if(array[j-1]>array[j]){
                            int temp=array[j];
                            array[j]=array[j-1];
                            array[j-1]=temp;
                        }
                    }
                }
            }
        };
        int[] tab = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        priintArray(tab);
        sorter.sort(tab);
       priintArray(tab);
    }

static void priintArray(int[] array){
        for(int value:array){
            System.out.println(value+" ");
        }
}


       private interface Sortable {

            void sort(int[] array);


    }
}
