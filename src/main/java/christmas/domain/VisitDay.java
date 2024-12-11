package christmas.domain;

import christmas.constant.ErrorMessage;

public class VisitDay {

    private static final int MIN_DAY_VALUE = 1;
    private static final int MAX_DAY_VALUE = 31;

    private final int visitDay;

    public VisitDay(int visitDay) {
        validate(visitDay);
        this.visitDay = visitDay;
    }

    private void validate(int visitDay) {
        if (visitDay < MIN_DAY_VALUE || visitDay > MAX_DAY_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.DAY_INPUT_ERROR.getMessage());
        }
    }
}
