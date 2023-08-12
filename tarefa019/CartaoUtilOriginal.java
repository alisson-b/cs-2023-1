package org.example._05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CardUtilRefactored {
    public static final int VISA = 1;
    public static final int MASTERCARD = 2;
    public static final int AMEX = 3;
    public static final int DINERS = 4;
    public static final String CARD_OK = "Valid card";
    public static final String CARD_ERROR = "Invalid card";

    public String validate(int cardBrand, String number, String expirationDate) {
        if (!isValidDate(expirationDate)) {
            return CARD_ERROR;
        }

        String formattedNumber = removeNonNumericChars(number);

        if (!isValidFormat(cardBrand, formattedNumber)) {
            return CARD_ERROR;
        }

        if (!isValidLuhnAlgorithm(formattedNumber)) {
            return CARD_ERROR;
        }

        return CARD_OK;
    }

    private boolean isValidDate(String expirationDate) {
        try {
            Date expiryDate = new SimpleDateFormat("MM/yyyy").parse(expirationDate);
            Calendar calExpiry = new GregorianCalendar();
            calExpiry.setTime(expiryDate);

            Calendar calToday = Calendar.getInstance();
            calToday.set(Calendar.DAY_OF_MONTH, 1); // Only month and year are relevant
            calToday.set(Calendar.HOUR_OF_DAY, 0);
            calToday.set(Calendar.MINUTE, 0);
            calToday.set(Calendar.SECOND, 0);
            calToday.set(Calendar.MILLISECOND, 0);

            return calToday.before(calExpiry);
        } catch (ParseException e) {
            return false;
        }
    }

    private String removeNonNumericChars(String number) {
        StringBuilder formattedNumber = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (Character.isDigit(c)) {
                formattedNumber.append(c);
            }
        }
        return formattedNumber.toString();
    }

    private boolean isValidFormat(int cardBrand, String formattedNumber) {
        switch (cardBrand) {
            case VISA:
                return (formattedNumber.startsWith("4") && (formattedNumber.length() == 13 || formattedNumber.length() == 16));
            case MASTERCARD:
                return ((formattedNumber.startsWith("51") || formattedNumber.startsWith("52") || formattedNumber.startsWith("53") ||
                        formattedNumber.startsWith("54") || formattedNumber.startsWith("55")) && formattedNumber.length() == 16);
            case AMEX:
                return ((formattedNumber.startsWith("34") || formattedNumber.startsWith("37")) && formattedNumber.length() == 15);
            case DINERS:
                return ((formattedNumber.startsWith("300") || formattedNumber.startsWith("301") || formattedNumber.startsWith("302") ||
                        formattedNumber.startsWith("303") || formattedNumber.startsWith("304") || formattedNumber.startsWith("305") ||
                        formattedNumber.startsWith("36") || formattedNumber.startsWith("38")) && formattedNumber.length() == 14);
            default:
                return false;
        }
    }

    private boolean isValidLuhnAlgorithm(String formattedNumber) {
        int sum = 0;
        int digit;
        int tempSum = 0;
        boolean multiply = false;

        for (int i = formattedNumber.length() - 1; i >= 0; i--) {
            digit = Integer.parseInt(formattedNumber.substring(i, i + 1));
            if (multiply) {
                tempSum = digit * 2;
                if (tempSum > 9) {
                    tempSum -= 9;
                }
            } else {
                tempSum = digit;
            }
            sum += tempSum;
            multiply = !multiply;
        }

        int remainder = sum % 10;
        return remainder == 0;
    }
}

