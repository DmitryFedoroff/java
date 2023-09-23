package client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Abstract class designed for validating user input data.
 * Contains methods for entering and checking various types of data: integers, long integers, strings, and dates.
 */
public abstract class UserInputValidator {

    /**
     * Method for inputting and validating an integer within a specified range.
     * The user enters a number that is checked for compliance with the specified range.
     *
     * @param minVariant the minimum allowable value
     * @param maxVariant the maximum allowable value
     * @return the integer entered by the user
     * @throws RuntimeException if an out-of-range value is entered or if it is not a number
     */
    protected int inputInt(int minVariant, int maxVariant) throws RuntimeException {
        int num;
        Scanner in = new Scanner(System.in);
        try {
            num = in.nextInt();
            if (num < minVariant || num > maxVariant) {
                throw new RuntimeException("An invalid value has been entered. Please enter a number in the range from " + minVariant + " to " + maxVariant + ".");
            }
        } catch (InputMismatchException ex) {
            throw new RuntimeException("Not a number entered. Please try again.");
        }
        return num;
    }

    /**
     * Method for inputting and validating a long integer within a specified range.
     * The user enters a number that is checked for compliance with the specified range.
     *
     * @param minVariant the minimum allowable value
     * @param maxVariant the maximum allowable value
     * @return the long integer entered by the user
     * @throws RuntimeException if an out-of-range value is entered or if it is not a number
     */
    protected long inputLong(long minVariant, long maxVariant) throws RuntimeException {
        long num;
        Scanner in = new Scanner(System.in);
        try {
            num = in.nextLong();
            if (num < minVariant || num > maxVariant) {
                throw new RuntimeException("An invalid value has been entered. Please enter a number in the range from " + minVariant + " to " + maxVariant + ".");
            }
        } catch (InputMismatchException ex) {
            throw new RuntimeException("Not a number entered. Please try again.");
        }
        return num;
    }

    /**
     * Method for inputting a string followed by validation for an empty string.
     * The user enters a string that is checked for the absence of text (only spaces or an empty string).
     *
     * @return the string entered by the user
     * @throws RuntimeException if an empty string is entered or a string containing only spaces
     */
    protected String inputString() throws RuntimeException {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.trim().isEmpty()) {
            throw new RuntimeException("The string cannot be empty. Please try again.");
        }
        return str;
    }

    /**
     * Method for inputting a date followed by validation.
     * The user enters a date in the "yyyy-MM-dd" format, which is checked for compliance with this format.
     *
     * @return the date entered by the user
     * @throws RuntimeException if an incorrect date is entered
     */
    protected Date inputDate() throws RuntimeException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        ft.setLenient(false); // Setting strict date format checking
        Scanner in = new Scanner(System.in);
        String str;
        Date date;
        try {
            str = in.nextLine();
            date = ft.parse(str);
        } catch (ParseException ex) {
            throw new RuntimeException("An incorrect date has been entered. Please enter the date in the yyyy-MM-dd format.");
        }
        return date;
    }
}
