import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ObuforMuteks {
    private static final int ROZMIAR_BUFORA=10;
    private static final int[] bufor=new int[ROZMIAR_BUFORA];

    private static int poczatek=0;
    private static int koniec=0;
    private static final ReentrantLock lock=new ReentrantLock();
    private static final Condition notFull=lock.newCondition();
    private static final Condition notEmpty= lock.newCondition();
    private static int licznik = 0;

    public static void producent(int wartosc) throws InterruptedException {
        lock.lock();
        while (licznik==ROZMIAR_BUFORA){
            notFull.await();
            System.out.println("Bufor jest pełny");
        }
        bufor[koniec]=wartosc;
        koniec=(koniec+1)%ROZMIAR_BUFORA;
        licznik++;
        notEmpty.signal();

        lock.unlock();
    }


    private static int konsument() throws InterruptedException {
        try{
            lock.lock();
            while (licznik==0){
                notEmpty.await();
                System.out.println("Bufor jest pusty");
            }

            int wartosc=bufor[poczatek];
            poczatek=(poczatek+1)%ROZMIAR_BUFORA;
            licznik--;

            notFull.signal();
            return wartosc;


        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread producentWątek=new Thread(()->{
            for (int i=1;i<100;i++){
                try {
                    producent(i);
                    System.out.println("Producent dodał"+i);
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        Thread konsumentWątek=new Thread(()->{
            for (int i=1;i<=100;i++){
                try {
                    int wartosc=konsument();
                    System.out.println("Konsument odebral"+wartosc);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producentWątek.start();
        konsumentWątek.start();
    }



}
