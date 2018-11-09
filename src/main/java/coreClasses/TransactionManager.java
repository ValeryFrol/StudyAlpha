package coreClasses;

import exceptionsPackage.BlockException;
import exceptionsPackage.NotEnoughMoneyException;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionManager {

    public static boolean commitTransaction(Transaction transaction) throws Exception {
        if (transaction.getFrom() == null) throw new NullPointerException("Account you want to withdraw money from doesn't exist");
        else if(transaction.getWhere() == null)throw new NullPointerException("Account you want to transfer money to doesn't exist");
        if (transaction.getFrom().getBlocked() || transaction.getWhere().getBlocked()) throw new BlockException(transaction.getFrom(),transaction.getWhere());
        if (transaction.getFrom().getBalance().getAmount() < transaction.getBalanceChange().getAmount())throw new NotEnoughMoneyException();
        if (!transaction.getFrom().getCurrency().getCurrencyCode().equals(transaction.getWhere().getCurrency().getCurrencyCode())) {
            transaction.getFrom().getBalance().subtract(transaction.getBalanceChange().multiply(Exchange.getExchangeRateForDateFromDB(transaction.getFrom().getCurrency(), transaction.getWhere().getCurrency(), LocalDate.now(), LocalTime.now())));
            transaction.getWhere().getBalance().add(transaction.getBalanceChange());
            writeToDatabase(transaction);
            return true;
        } else {
            transaction.getFrom().getBalance().subtract(transaction.getBalanceChange());
            transaction.getWhere().getBalance().add(transaction.getBalanceChange());
            writeToDatabase(transaction);
            return true;
        }

    }

    private static void writeToDatabase(Transaction transaction) {
        ///
    }
}
