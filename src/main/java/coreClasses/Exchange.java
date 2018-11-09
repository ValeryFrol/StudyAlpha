package coreClasses;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Currency;


public class Exchange {
    //todo create a structure which stores rates from DB
    public static double getExchangeRateForDateFromDB(Currency currencyFrom, Currency currencyTo, LocalDate date, LocalTime time){
        //connects to DB and loads an exchange rate for the date needed
        //todo add exception, exchange rate can be out of date, we have to check it
        return 1;
        //todo create a structure for storing exchange rates, which are to be downloaded from DB periodically
    }
    //todo method which gets rates from the structure with rates
    //think about updating of rates
}
