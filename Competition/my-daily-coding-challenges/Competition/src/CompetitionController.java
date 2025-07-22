import java.util.InputMismatchException;
import java.util.Scanner;

class CompetitionController {
    private Scanner scanner = new Scanner(System.in);

    void run() {
        Competition competition = createCompetition();
        fillParticipantsInfo(competition);
        printCompetition(competition);
    }

    private Competition createCompetition() {
        System.out.print("Podaj nazwę zawodów: ");
        String competitionName = scanner.nextLine();
        System.out.print("Podaj maksymalną liczbę uczestników: ");
        int maxParticipants = readPosotiveNumber();
        System.out.print("Podaj ograniczenie wiekowe: ");
        int ageLimit = readPosotiveNumber();
        scanner.nextLine();
        return new Competition(competitionName, maxParticipants, ageLimit);
    }

    private void fillParticipantsInfo(Competition competition)  {
        while (competition.hasFreeSpots()) {
            System.out.println("Dodaj nowego uczestnika");
            Participant participant = createParticipant();
            try {
                competition.addParticipant(participant);
            }catch (MaxCompetitorsException e){
                System.err.println(e.getMessage());
            }catch (AgeViolationException e){
                System.out.println("Nieprawidlowy wiek");
            }
        }
    }

    private Participant createParticipant() {
        System.out.print("Podaj imię: ");
        String firstName = scanner.nextLine();
        System.out.print("Podaj nazwisko: ");
        String lastName = scanner.nextLine();
        System.out.print("Podaj id (np. pesel): ");
        String id = scanner.nextLine();
        System.out.print("Podaj wiek: ");
        int age = readPosotiveNumber();
        if(age<=0){

        }
        scanner.nextLine();
        return new Participant(firstName, lastName, id, age);
    }

    private void printCompetition(Competition competition) {
        System.out.println(competition.toString());
    }

    private int readPosotiveNumber(){
        int number=-1;
        while (number<0){
            try{
                number=scanner.nextInt();
                if (number<0)
                    System.err.println("Liczba musi byc dodatnia");

            }catch (InputMismatchException e){
                System.out.println("Musisz podac liczbe");
            }finally {
                scanner.nextLine();
            }
        }
        return number;
    }
}
