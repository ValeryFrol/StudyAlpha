package coreClasses;

import exceptionsPackage.BlockException;
import exceptionsPackage.NotEnoughMoneyException;

import java.util.Locale;

public class AccountManager {
       public Account newAccount(Locale locale, String bankAccount, String userId, User user) {
        Account newAccount = new Account(locale, bankAccount, userId, user);
        //insert it in the accounts table in the DB
        return newAccount;
    }

    public void removeAccount(Account account) {
        //go to the DB, delete this account from Accounts table and from corresponding users table
    }
    //How to monitor queries from for example shops or other people and how to process them?
    //AccountManager tells transaction manager that there is going to be a transaction: it needs to be checked and approved, if approved then - done
    public String notifyTransactionManager(Account from, Account where, Money balanceChange) {
        try {
            TransactionManager.commitTransaction(new Transaction(from, where, balanceChange));
        } catch (NullPointerException nullEx) {
            return nullEx.getMessage();
        } catch (BlockException blockEx) {
            return blockEx.getMessage();
        } catch (NotEnoughMoneyException notEx) {
            return notEx.getMessage();
        } catch (Exception ex) {
            return "Error during the transaction";
        }
    return "Transaction has been completed successfully";
    }


}
