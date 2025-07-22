import java.util.Random;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                Random random = new Random();
                try {
                    for (int j = 0; j < 5; j++) {
                        System.out.println(Thread.currentThread().getName() + " generated: " + random.nextInt(100));
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    System.err.println("Thread interrupted.");
                }
            }, "Thread-" + i).start();
        }
    }
}