public class Company {
    public static void main(String[] args) {
        Emplyee[] emplyees = new Emplyee[30];
        emplyees[0] = new Emplyee("Jan", "Kowalski", 3500);
        emplyees[1] = new Emplyee("Marta", "Nowak", 3700);
        emplyees[2] = new Emplyee("Karol", "Wojak", 4500);

        int employeeIndex = 2;
        if(employeeIndex>=0 && employeeIndex<emplyees.length) {
            System.out.println(emplyees[employeeIndex].getFirstName() + " " +
                    emplyees[employeeIndex].getLastName() + " " + emplyees[employeeIndex].getSalary());
        }
    }
}
