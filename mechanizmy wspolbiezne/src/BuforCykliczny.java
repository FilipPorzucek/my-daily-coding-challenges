import java.util.concurrent.Semaphore;

public class BuforCykliczny {
    private static final int ROZMIAR_BUFORA = 10;
    private static final int[] bufor = new int[ROZMIAR_BUFORA];

    private static int poczatek = 0;
    private static int koniec = 0;

    private static final Semaphore wolneMiejsca = new Semaphore(ROZMIAR_BUFORA);
    private static final Semaphore zajeteMiejsca = new Semaphore(0);
    private static final Semaphore mutex = new Semaphore(1);


    static class Producent extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 1; i <= 100; i++) {
                    wolneMiejsca.acquire();
                    mutex.acquire();

                    bufor[koniec] = i;
                    System.out.println("Producent: Wstawiono " + i + " na pozycję " + koniec);
                    koniec = (koniec + 1) % ROZMIAR_BUFORA;

                    mutex.release();
                    zajeteMiejsca.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class Konsument extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 1; i <= 100; i++) {
                    zajeteMiejsca.acquire();
                    mutex.acquire();

                    int wartosc = bufor[poczatek];
                    System.out.println("Konsument: Odczytano " + wartosc + " z pozycji " + poczatek);
                    poczatek = (poczatek + 1) % ROZMIAR_BUFORA;

                    mutex.release();
                    wolneMiejsca.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Producent producent = new Producent();
        Konsument konsument = new Konsument();

        producent.start();
        konsument.start();
    }
}
