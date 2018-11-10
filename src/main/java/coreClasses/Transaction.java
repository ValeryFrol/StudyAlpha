package coreClasses;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;


public final class Transaction {

    public Transaction(Account from, Account where, Money balanceChange) {
        this.id = Math.round(Math.random()); //Need something less stupid
        this.from = from;
        this.where = where;
        this.balanceChange = balanceChange;
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

    private final long id;
    private final Money balanceChange;
    private final Account from, where;

    public long getId() {
        return id;
    }

    public Money getBalanceChange() {
        return balanceChange;
    }

    public Account getFrom() {
        return from;
    }

    public Account getWhere() {
        return where;
    }
}
