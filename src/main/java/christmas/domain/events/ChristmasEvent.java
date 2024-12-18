package christmas.domain.events;

public class ChristmasEvent implements Event {

    private static final int DEFAULT_DISCOUNT_AMOUNT = 1_000;
    private static final int ADDITIONAL_DISCOUNT_AMOUNT = 100;
    private static final int APPLY_DAY_MAX = 25;

    private final int day;

    public ChristmasEvent(int day) {
        this.day = day;
    }

    @Override
    public int getDiscountAmount() {
        if (day > APPLY_DAY_MAX) {
            return 0;
        }
        return DEFAULT_DISCOUNT_AMOUNT + (day - 1) * ADDITIONAL_DISCOUNT_AMOUNT;
    }

    @Override
    public String getInformation() {
        if (getDiscountAmount() == 0) {
            return "";
        }
        return String.format("크리스마스 디데이 할인: -%,d원", getDiscountAmount());
    }
}
