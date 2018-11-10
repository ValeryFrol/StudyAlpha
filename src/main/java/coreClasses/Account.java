package coreClasses;

import java.util.*;

public final class Account {
    private final String bankAccount;
    private final Currency currency;
    private final String controlNumber;
    private static final String codeBranch = "1954";
    private final String userId;
    private final Money balance;
    private Locale locale;
    private final HashSet<User> allUsers = new HashSet<User>();
    private final boolean blocked = false;
    private final String accountNumber = this.createAccountNumber();

    public Account(Locale locale, String bankAccount, String userId) {
        this.locale = locale;
        this.currency = Currency.getInstance(locale);
        this.bankAccount = bankAccount;
        Random rand = new Random();
        this.controlNumber = Integer.toString(rand.nextInt(10));
        this.userId = userId;
        balance = new Money(0, Currency.getInstance(locale));
    }

    public int hashCode(String accountNumber) {
        return Objects.hash(accountNumber);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        if (this.bankAccount != account.bankAccount ||
                this.currency != account.currency ||
                this.controlNumber != account.controlNumber ||
                this.userId != account.userId ||
                this.allUsers != account.allUsers) {
            return false;
        }
        return true;
    }

    public Currency getCurrency() {
        return currency;
    }

    public boolean getBlocked() {
        return blocked;
    }

    public String getCurrentAccount() {
        return bankAccount;
    }

    public String getControlNumber() {
        return controlNumber;
    }

    public String getUserId() {
        return userId;
    }

    public Money getBalance() {
        return balance;
    }

    public Locale getLocale() {
        return locale;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Object getAllUsers() {
        return allUsers.clone();
    }

    public void addNewUser(User user) {
        this.allUsers.add(user);
    }

    public boolean removeUser(User user) {
        boolean remove = this.allUsers.remove(user);
        return remove;
    }

    public String createAccountNumber() {
        if (this.userId.length() < 7) {
            StringBuffer sb = new StringBuffer(7);
            for (int i = 0; i < (7 - this.userId.length()); i++) {
                sb.append("0");
            }
            return this.bankAccount + this.currency.getNumericCodeAsString() + this.controlNumber + codeBranch + sb.append(this.userId);
        }
        return this.bankAccount + this.currency + this.controlNumber + codeBranch + userId.substring(0, 7);
    }
}
