public class IntContainer {
    private int array[];

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void printArray(){
        for (int i : array) {
            System.out.println(i);
        }
    }

}
