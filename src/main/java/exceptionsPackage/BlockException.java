package exceptionsPackage;

import coreClasses.Account;

public class BlockException extends Exception {
    Account from, where;
    public BlockException(Account from, Account where){
            this.from=from;
            this.where=where;
    }
    public String getMessage(){
        if(from.getBlocked()==true)return "Account you want to transfer money from is blocked";
        else return "Account you want to transfer money to is blocked";
        //add the second if, because both of them can be blocked
    }
}
