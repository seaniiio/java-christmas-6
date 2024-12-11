package christmas.dto;

import christmas.domain.Badge;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReceiptDto {

    private int day;
    private List<String> orders;
    private int totalAmount;
    private List<String> gifts = new ArrayList<>();
    private List<String> events = new ArrayList<>();
    private int totalDiscountAmount = 0;
    private int expectedPayment = 0;
    private String badge = Badge.NONE.getName();

    public ReceiptDto(int day, List<String> orders, int totalAmount, List<String> gifts, List<String> events,
                      int totalDiscountAmount, int expectedPayment, String badge) {
        this.orders = orders;
        this.totalAmount = totalAmount;
        this.expectedPayment = totalAmount;
        if (totalAmount > 10000) {
            this.day = day;
            this.totalAmount = totalAmount;
            this.gifts = gifts;
            this.events = events;
            this.totalDiscountAmount = totalDiscountAmount;
            this.expectedPayment = expectedPayment;
            this.badge = badge;
        }
    }

    public int getDay() {
        return day;
    }

    public List<String> getOrders() {
        return orders;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public List<String> getGifts() {
        return gifts;
    }

    public List<String> getEvents() {
        List<String> appliedEvents = new ArrayList<>();
        for (String event : events) {
            if (!event.isBlank()) {
                appliedEvents.add(event);
            }
        }
        return appliedEvents;
    }

    public int getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public int getExpectedPayment() {
        return expectedPayment;
    }

    public String getBadge() {
        return badge;
    }
}
