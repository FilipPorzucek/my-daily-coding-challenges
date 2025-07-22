public class NoteBookShop {
    public static void main(String[] args) {
        DataStore dataStore=new DataStore();
        Computer computer1=new Computer(2,"Samsung");
        Computer computer2=new Computer(2,"Samsung");
        Computer computer3=new Computer(4,"Lenovo");
        Computer computer4=new Computer(8,"Huwawei");
        Computer computer5=new Computer(12,"Apple");



        dataStore.add(computer1);
        dataStore.add(computer2);
        dataStore.add(computer3);
        dataStore.add(computer4);
        dataStore.add(computer5);

        Computer compToFind=new Computer(2,"Samsung");
        int computersFound= dataStore.checkAvailability(compToFind);
        System.out.println("liczba kompoterow"+compToFind+computersFound);

    dataStore.print();


    }
}
