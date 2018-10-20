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

    public Account(Locale locale, String bankAccount, String userId, User user) {
        this.locale=locale;
        this.currency = Currency.getInstance(locale);
        this.bankAccount = bankAccount;
        Random rand = new Random();
        this.controlNumber = Integer.toString(rand.nextInt(10));
        this.userId = userId;
        balance = new Money(0);
        this.allUsers.put(Integer.valueOf(user.hashCode(user.getDateOfBirth(), user.getSex())), user);
    }

    public int hashCode(String accountNumber) {
        return Objects.hash(accountNumber);
    }
    public void addUser(User user){
        this.allUsers.put(Integer.valueOf(user.hashCode(user.getDateOfBirth(), user.getSex())), user);
    }
    public boolean removeUser(User user){
        boolean remove = this.allUsers.remove(Integer.valueOf(user.hashCode(user.getDateOfBirth(), user.getSex())), user);
        return remove;
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

    public Currency getCurrency() {
        return currency;
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

    public Locale getLocale() {return locale;}

    public Map<Integer, User> getAllUsers() {return allUsers;}

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
    public void changeBalance(Transaction transaction){

    }

   public static void main(String[] args) {
        /*Currency currency = Currency.getInstance(Locale.GERMANY);
       System.out.println(currency.getNumericCodeAsString());*/

      //  Account ac = new Account(978, 40817, 558924789,0);
        //System.out.println(ac.createAccountNumber());
    }
}
