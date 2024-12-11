package christmas.domain.events;

import java.util.List;

public class SpecialEvent implements Event{

    private final List<Integer> specialDay = List.of(3, 10, 17, 24, 25, 31);
    private static final int DISCOUNT_AMOUNT = 1_000;
    private final int day;

    public SpecialEvent(int day) {
        this.day = day;
    }

    @Override
    public int getDiscountAmount() {
        if (specialDay.contains(day)) {
            return DISCOUNT_AMOUNT;
        }
        return 0;
    }

    @Override
    public String getInformation() {
        if (getDiscountAmount() == 0) {
            return "";
        }
        return String.format("특별 할인: -%,d원", getDiscountAmount());
    }
}
