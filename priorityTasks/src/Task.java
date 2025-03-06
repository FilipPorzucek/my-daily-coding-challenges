public class Task {
    private String description;
    Priority priority;

    public Task(String description, Priority priority) {
        this.description = description;
        this.priority = priority;
    }



    @Override
    public String toString() {
        String priorityText=switch (priority){
            case LOW -> "Priorytet: Niski";
            case MEDIUM -> "Priorytet: Średni";
            case HIGH -> "Priorytet: Wysoki";
            case URGENT -> "Priorytet: Pilny!";
        };
        return "Zadanie: "+description+" "+priorityText;
    }
}
