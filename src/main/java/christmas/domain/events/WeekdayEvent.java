package christmas.domain.events;

public class WeekdayEvent {

    private static final int DISCOUNT_UNIT = 2_023;
    private final boolean isWeekend;
    private final int dessertCount;

    public WeekdayEvent(boolean isWeekend, int dessertCount) {
        this.isWeekend = isWeekend;
        this.dessertCount = dessertCount;
    }

    public int getDiscountAmount() {
        if (!isWeekend) {
            return dessertCount * DISCOUNT_UNIT;
        }
        return 0;
    }

    public String getInformation() {
        return "평일 할인: -" + getDiscountAmount() + "원";
    }
}
