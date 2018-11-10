package coreClasses;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Currency;


public class Exchange {
    private static double getExchangeRateForDateFromDB(Currency currencyFrom, Currency currencyTo, LocalDate date, LocalTime time) {
        //connects to DB and loads exchange rates for the date needed
        return 1;
    }

    private static LocalTime lastUpdateTime = LocalTime.now();

    private static final long updatePeriodNanos = 2 * 60 * 60 * 1000000000L; //2 hours in nanoseconds, every 2 hours rates are to be updated

    private static final Object[] currencyArray = Currency.getAvailableCurrencies().toArray();

    private static double[][] rates;

    private static void updateRates() {
        for (int i = 0; i < rates.length; i++)
            for (int j = 0; j < rates.length; j++)
                rates[i][j] = getExchangeRateForDateFromDB((Currency) currencyArray[i], (Currency) currencyArray[j], LocalDate.now(), LocalTime.now());
    }

    public static double getExchangeRate(Currency currencyFrom, Currency currencyTo) {
        //if there is no rates matrix it is created and updated
        if (rates.length == 0) {
            rates = new double[currencyArray.length][currencyArray.length];
            updateRates();
            lastUpdateTime = LocalTime.now();
        }
        //checking when the lsat update took place, if it was to long ago, rates are updated
        if (LocalTime.now().minusNanos(lastUpdateTime.toNanoOfDay()).toNanoOfDay() >= updatePeriodNanos) {
            updateRates();
            lastUpdateTime = LocalTime.now();
        }
        //getting a rate needed
        int i = Arrays.binarySearch(currencyArray, currencyFrom);
        int j = Arrays.binarySearch(currencyArray, currencyTo);
        return rates[i][j];
    }
}
