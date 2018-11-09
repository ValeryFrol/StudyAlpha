package exceptionsPackage;

public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException(){

    }
    public String getMessage(){
        return "Not enough money for transaction";
    }
}
