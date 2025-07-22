import java.util.concurrent.locks.ReentrantLock;

class SharedLock {
    public static final ReentrantLock lock = new ReentrantLock();
}

class MyTask implements Runnable {

    private int nr;


    public MyTask(int nr) {
        this.nr = nr;
    }

    @Override
    public void run() {
        System.out.println("Wątek:"+ Thread.currentThread().getName()+ "nr "+nr);
        SharedLock.lock.lock();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            SharedLock.lock.unlock();
        }
    }

}

class MyTask2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Wątek:"+ Thread.currentThread().getName());
       SharedLock.lock.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            SharedLock.lock.unlock();
        }
    }
}


public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new MyTask(5));
        thread.setName("Wątek pierwszy");
        Thread thread1=new Thread(new MyTask2());
        thread1.setName("Wątek drugi");

        thread.start();

       thread1.start();
        thread.join();
       thread1.join();



        System.out.println("Główny wątek:"+Thread.currentThread().getName());


    }
}


