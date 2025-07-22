import java.util.concurrent.CompletableFuture;

public class Asynchroniczność {
    public static void main(String[] args) throws InterruptedException {
    Numbers numbers=new Numbers();

    CompletableFuture<Integer> future=numbers.calculateAsync();

    future.thenAccept(wynik-> System.out.println(wynik));

    future.join();

    }
}

class Numbers extends Thread{
private int x=5;
private int y=10;

    public CompletableFuture<Integer> calculateAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return x + y;
        });
    }

}

