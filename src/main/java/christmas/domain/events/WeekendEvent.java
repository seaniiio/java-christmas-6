package christmas.domain.events;

public class WeekendEvent {

    private static final int DISCOUNT_UNIT = 2_023;
    private final boolean isWeekend;
    private final int mainCount;

    public WeekendEvent(boolean isWeekend, int mainCount) {
        this.isWeekend = isWeekend;
        this.mainCount = mainCount;
    }

    public int getDiscountAmount() {
        if (isWeekend) {
            return mainCount * DISCOUNT_UNIT;
        }
        return 0;
    }

    public String getInformation() {
        return "주말 할인: -" + getDiscountAmount() + "원";
    }
}
