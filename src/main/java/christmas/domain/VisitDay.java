package christmas.domain;

import christmas.constant.ErrorMessage;
import christmas.util.Calender;

public record VisitDay(int visitDay) {

    private static final int MIN_DAY_VALUE = 1;
    private static final int MAX_DAY_VALUE = 31;
    private static final int DECEMBER_WEEKEND_START_DATE = 1;


    public VisitDay {
        validate(visitDay);
    }

    public int getDay() {
        return visitDay;
    }

    public boolean isWeekend() {
        return Calender.isWeekend(DECEMBER_WEEKEND_START_DATE, visitDay);
    }

    private void validate(int visitDay) {
        if (visitDay < MIN_DAY_VALUE || visitDay > MAX_DAY_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.DAY_INPUT_ERROR.getMessage());
        }
    }
}
