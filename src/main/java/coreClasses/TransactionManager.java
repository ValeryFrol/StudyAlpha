import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionManager {


    public static boolean commitTransaction(Transaction transaction) {
        if (transaction.getFrom() == null || transaction.getWhere() == null) {
            System.out.println("Invalid transation participants.\n");
            return false;
        }
        if (transaction.getFrom().getBlock() == true || transaction.getWhere().getBlock() == true) return false;
        if (transaction.getFrom().getBalance().getAmount() < transaction.getBalanceChange().getAmount()) return false;
        if (transaction.getFrom().getCurrency().getCurrencyCode().equals(transaction.getWhere().getCurrency().getCurrencyCode()) == false) {
            transaction.getFrom().getBalance().subtract(transaction.getBalanceChange().multiply(Exchange.getExchangeRateForDateFromDB(transaction.getFrom().getCurrency(),
                                                                                    transaction.getWhere().getCurrency(), LocalDate.now(), LocalTime.now())));
            transaction.getWhere().getBalance().add(transaction.getBalanceChange());
            return true;
        } else {
            transaction.getFrom().getBalance().subtract(transaction.getBalanceChange());
            transaction.getWhere().getBalance().add(transaction.getBalanceChange());
            return true;
        }
    }

    public void writeToDatabase(Transaction transaction) {
        ///
    }
}
