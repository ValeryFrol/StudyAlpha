package coreClasses;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Currency;


public class Exchange {
    public static double getExchangeRateForDateFromDB(Currency currencyFrom, Currency currencyTo, LocalDate date, LocalTime time){
        //connects to DB and loads an exchange rate for the date needed
        return 1;
    }
}
