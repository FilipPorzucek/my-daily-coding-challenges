import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class diabelskaKolejka {
    public static final int N = 10;
    public static final int P = 4;

    private final Lock mutex = new ReentrantLock();
    private final Condition condition = mutex.newCondition();

    private int pasazerowieNaPokladzie = 0;
    private int pasazerowieWysiedli = 0;

    public void pasazer(int id) {
        System.out.println("Pasażer " + id + " próbuje wejść do wagonika");

        mutex.lock();
        try {
            while (pasazerowieNaPokladzie >= P) {
                condition.await();
            }

            pasazerowieNaPokladzie++;
            System.out.println("Pasażer " + id + " wszedł do wagonika. Liczba pasażerów: " + pasazerowieNaPokladzie);

            if (pasazerowieNaPokladzie == P) {
                System.out.println("Wagonik rusza z " + P + " pasażerami...");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Wagonik zakończył przejazd.");
                pasazerowieWysiedli = 0;
                condition.signalAll();
            } else {
                while (pasazerowieNaPokladzie != P) {
                    condition.await();
                }
            }

            pasazerowieWysiedli++;
            System.out.println("Pasażer " + id + " wyszedł z wagonika.");

            if (pasazerowieWysiedli == P) {
                pasazerowieNaPokladzie = 0;
                condition.signalAll();
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            mutex.unlock();
        }
    }

    public static void main(String[] args) {
        diabelskaKolejka kolejka = new diabelskaKolejka();
        for (int i = 0; i < N; i++) {
            final int id = i;
            new Thread(() -> kolejka.pasazer(id)).start();
        }
    }
}





