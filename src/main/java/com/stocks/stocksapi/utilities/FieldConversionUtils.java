package com.stocks.stocksapi.utilities;

import io.micrometer.core.instrument.util.StringUtils;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class FieldConversionUtils {

    public static final String dateFormatPattern = "M/d/yyyy";
    private static final DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatPattern);

    public static String getCurrencyString(BigDecimal value) {
        return value == null
                ? ""
                : NumberFormat.getCurrencyInstance().format(value);
    }

    public static BigDecimal getCurrency(String currencyString) {
        return StringUtils.isEmpty(currencyString)
                ? null
                : BigDecimal.valueOf(Double.parseDouble(currencyString.replace("$","")));
    }

    public static String getDateString(Date date) {
        return dateFormat.format(date);
    }

    public static Date getDateFromString(String dateString) {
        return Date.valueOf(LocalDate.parse(dateString, formatter));
    }

}
