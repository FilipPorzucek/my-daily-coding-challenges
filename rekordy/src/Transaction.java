import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;

public record Transaction(long id,
                          double value,
                          LocalDateTime purchaseAt) {

    String idAsString(){
     return  String.valueOf(id);
    }

    static class TransactionComparator implements Comparator<Transaction>{

        @Override
        public int compare(Transaction o1, Transaction o2) {
            return Double.compare(o1.value,o2.value );
        }
    }
}

