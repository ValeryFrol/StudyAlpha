package coreClasses;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;



public class Transaction {

    public Transaction(Account from, Account where, Money balanceChange) {
        this.id = Math.round(Math.random()); //Need something less stupid
        this.from = from;
        this.where = where;
        this.balanceChange = balanceChange;
    }


    public boolean commitTransaction() {
        if (this.from == null || this.where == null) {
            System.out.println("Invalid transation participants.\n");
            return false;
        }
        if (from.getBalance().getAmount() < this.balanceChange.getAmount()) {
            return false;
        }
        if(from.getCurrency().getNumericCodeAsString().equals(where.getCurrency().getNumericCodeAsString())==false){
            Date date = new Date();
            Time time = new Time();
            from.getBalance().subtract(this.balanceChange*Exchange.getExchangeRateFromDB(from.getCurrency(),where.getCurrency(),date,time));
            where.getBalance().add(this.balanceChange);
            return true;
        }
        from.getBalance().subtract(this.balanceChange);
        where.getBalance().add(this.balanceChange);
        return true;
    }

    public int hashCode() {
        return Objects.hash(id, from, where, balanceChange);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Transaction transaction = (Transaction) o;

        if (this.id != transaction.id || !this.balanceChange.equals(transaction.balanceChange) ||
                !this.where.equals(transaction.where) || !this.from.equals(transaction.from)) return false;

        return true;
    }

    /************************************************************/

    private long id;
    private Money balanceChange;
    private Account from, where;
}
