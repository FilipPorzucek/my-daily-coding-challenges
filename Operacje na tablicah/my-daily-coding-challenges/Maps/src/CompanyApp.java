import java.util.Scanner;

public class CompanyApp {
    private static final int ADD_EMPLOYEE=0;
    private static final int FIND_EMPLOYEE=1;
    private static final int EXIT=2;

    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        Company company=new Company();
        int userOption;
        do{
            printOptions();
            System.out.println("Wybierz opcje");
            userOption=scanner.nextInt();
            scanner.nextLine();
            switch (userOption){
                case ADD_EMPLOYEE:
                    Employee employee=readAndCreateEmployee();
                    company.addEmployee(employee);
                    break;
                case FIND_EMPLOYEE:
                    findEmployee(company);
                    break;
                case EXIT:
                    System.out.println("Dowidzenia");
            }
        }while (userOption!=EXIT);
    }

    private static void findEmployee(Company company) {
        System.out.println("Podaj imie");
        String firstName=scanner.nextLine();
        System.out.println("Podaj nazwisko");
        String lastName=scanner.nextLine();
        Employee employee = company.getEmployee(firstName, lastName);
        if(employee==null)
            System.out.println("Brak takiego pracownika");
        else System.out.println(employee);
    }


    private static Employee readAndCreateEmployee() {
        System.out.println("Podaj imie");
        String firstName=scanner.nextLine();
        System.out.println("Podaj nazwisko");
        String lastName=scanner.nextLine();
        System.out.println("Podaj wypłatę");
        int salary= scanner.nextInt();
        scanner.nextLine();

        return new Employee(firstName,lastName,salary);
    }

    private static void printOptions() {
        System.out.println(ADD_EMPLOYEE+"-dodanie pracownika");
        System.out.println(FIND_EMPLOYEE+"-znajdz pracownika");
        System.out.println(EXIT+"-wyjście z programu");
    }

}
