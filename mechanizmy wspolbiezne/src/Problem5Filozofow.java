import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Problem5Filozofow {

   static ReentrantLock[] widelce=new ReentrantLock[5];

    static class Filozof implements Runnable {

        private int nr;

        public Filozof(int nr) {
            this.nr = nr;
        }

        @Override
        public void run() {
            int lewy = nr;
            int prawy = (nr + 1) % 5;

            while (true) {
                System.out.println("Filozof " + nr + " Myśli");
                try {
                    Thread.sleep(1000);
                    System.out.println("Filozof " + nr + " Głodny");
                    Thread.sleep(1000);

                    widelce[lewy].lock();

                    boolean prawyZdobyty = widelce[prawy].tryLock();

                    if (prawyZdobyty) {
                        System.out.println("Filozof " + nr + " je – zdobył widelce " + lewy + " i " + prawy);
                        Thread.sleep(1000);
                        widelce[prawy].unlock();
                        widelce[lewy].unlock();
                    } else {

                        widelce[lewy].unlock();
                        Thread.sleep(10);
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void filozof() {
        for(int i=0;i<5;i++){
            Thread thread=new Thread(new Filozof(i));
            thread.start();

        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i=0;i<5;i++){
            widelce[i]=new ReentrantLock();
        }

        filozof();
    }

}


