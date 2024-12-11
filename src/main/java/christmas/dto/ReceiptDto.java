package christmas.dto;

import java.util.List;
import java.util.Map;

public class ReceiptDto {

    private List<String> orders;
    private int totalAmount;
    private List<String> gifts;
    private List<String> events;
    private int totalDiscountAmount;
    private int expectedPayment;
    private String badge;

    public ReceiptDto(List<String> orders, int totalAmount, List<String> gifts, List<String> events,
                      int totalDiscountAmount, int expectedPayment, String badge) {
        this.orders = orders;
        this.totalAmount = totalAmount;
        this.gifts = gifts;
        this.events = events;
        this.totalDiscountAmount = totalDiscountAmount;
        this.expectedPayment = expectedPayment;
        this.badge = badge;
    }
}
