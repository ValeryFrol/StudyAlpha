package coreClasses;

import java.util.*;

public class Account {
    private String bankAccount;
    private Currency currency;
    private String controlNumber;
    private static final String codeBranch = "1954";
    private String userId;
    private Money balance;
    private Locale locale;
    private Map<Integer, User> allUsers = new HashMap<Integer, User>();
    private boolean blocked = false;
    private String accountNumber = this.createAccountNumber();

    public Account(Locale locale, String bankAccount, String userId, User user) {
        this.locale = locale;
        this.currency = Currency.getInstance(locale);
        this.bankAccount = bankAccount;
        Random rand = new Random();
        this.controlNumber = Integer.toString(rand.nextInt(10));
        this.userId = userId;
        balance = new Money(0, Currency.getInstance(locale));
        this.allUsers.put(Integer.valueOf(user.hashCode(user.getDateOfBirth(), user.getSex())), user);
    }

    public int hashCode(String accountNumber) {
        return Objects.hash(accountNumber);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        if (this.bankAccount != account.bankAccount || this.currency != account.currency || this.controlNumber != account.controlNumber || this.userId != account.userId || this.allUsers != account.allUsers) {
            return false;
        }
        return true;
    }

    //todo change getters: we have to get info from DB

    public Currency getCurrency() {
        return currency;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
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

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Map<Integer, User> getAllUsers() {
        return allUsers;
    }

    public void addNewUser(User user) {
        this.allUsers.put(Integer.valueOf(user.hashCode(user.getDateOfBirth(), user.getSex())), user);
    }
    public boolean removeUser(User user) {
        boolean remove = this.allUsers.remove(Integer.valueOf(user.hashCode(user.getDateOfBirth(), user.getSex())), user);
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
