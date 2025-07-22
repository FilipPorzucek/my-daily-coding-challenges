import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Task> tasksList = new ArrayList<>();
        addTaskRecursivly(tasksList);


    }

    private static void addTaskRecursivly(ArrayList<Task> tasksList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Czy chcesz dodać zadanie?(TAK/)");
        String response=scanner.nextLine();
        switch (response){
            case "TAK"-> {
                tasksList.add(createTask());
                addTaskRecursivly(tasksList);
            }
            case "KONIEC"->{
                printTasks(tasksList,0);
            }
            default -> throw new IllegalArgumentException("Niepoprawna odpowiedź podaj TAK lub KONIEC");

        }
    }

    private static Task createTask() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Podaj treść zadania");
        String description=scanner.nextLine();
        System.out.println("Podaj priorytet: NISKI,SREDNI,WYSOKI,PILNY");
        String priorityInput=scanner.nextLine();
       Priority priority=switch (priorityInput){
            case "NISKI"->Priority.LOW;
            case "SREDNI"->Priority.MEDIUM;
            case "WYSOKI"->Priority.HIGH;
            case "PILNY"->Priority.URGENT;
           default -> throw new IllegalArgumentException("Niepoprawny Priorytet");
        };
return new Task(description,priority);

    }

    private static void printTasks(ArrayList<Task> tasksList,int index) {
        if(index>=tasksList.size())return;
        Task task=tasksList.get(index);
        System.out.println(task);
        printTasks(tasksList,index+1);

    }
}
