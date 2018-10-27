package coreClasses;

import java.util.Locale;

public class AccountManager {
    public Account newAccount(Locale locale, String bankAccount, String userId, User user) {
        Account newAccount = new Account(locale, bankAccount, userId, user);
        //insert it in the accounts table in the DB
        return newAccount;
    }
    public void removeAccount(Account account){
       //go to the DB, delete this account from Accounts table and from corresponding users table
    }

}
