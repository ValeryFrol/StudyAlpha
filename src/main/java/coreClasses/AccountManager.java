package coreClasses;

import exceptionsPackage.BlockException;
import exceptionsPackage.NotEnoughMoneyException;

import java.util.Locale;

public class AccountManager {
       public Account newAccount(Locale locale, String bankAccount, String userId) {
           Account newAccount = new Account(locale, bankAccount, userId);
        //insert it in the accounts table in the DB
        return newAccount;
    }

    public boolean removeAccount(Account account) {
        //go to DB and delete all info about this account from working bases and transfer it to the archive
        //check if it was deleted and transfered, then return true or false (if exceptions take place, catch them and process them
        account=null;
        return true;
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
    public Account  changeLocale(Account account, Locale locale){
           Account newAccount = new Account(locale,account.getBankAccount(),account.getUserId());
           return newAccount;
    }
    public Account  changeBankAccount(Account account, String bankAccount){
        Account newAccount = new Account(account.getLocale(),bankAccount,account.getUserId());
        return newAccount;
    }
    public Account  changeUserId(Account account, String userId){
        Account newAccount = new Account(account.getLocale(),account.getBankAccount(),userId);
        return newAccount;
    }


}
