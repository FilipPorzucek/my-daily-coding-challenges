import java.time.LocalDateTime;

public class TransactionExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        Transaction transaction = new Transaction(123L, 123.45, now);
        Transaction transaction2 = new Transaction(123L, 123.45, now);
        String s = transaction.idAsString();

        System.out.println(s);


    }
}
