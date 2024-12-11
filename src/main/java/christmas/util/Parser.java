package christmas.util;

import christmas.constant.ErrorMessage;

public class Parser {

    public static int parseDay(String visitDayInput) {
        try {
            return Integer.parseInt(visitDayInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.DAY_INPUT_ERROR.getMessage());
        }
    }
}
