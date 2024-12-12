package christmas.service;

import christmas.domain.Badge;
import christmas.domain.MenuCategory;
import christmas.domain.Order;
import christmas.domain.events.Event;
import christmas.domain.events.GiftEvent;
import christmas.dto.ReceiptDto;
import christmas.repository.EventRepository;
import christmas.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;

public class EventService {

    private final OrderRepository orderRepository;
    private final EventRepository eventRepository;

    public EventService() {
        this.orderRepository = OrderRepository.getInstance();
        this.eventRepository = EventRepository.getInstance();
    }

    public ReceiptDto calculate() {
        List<String> ordersInformation = parseOrders();
        int totalAmount = getTotalAmount();

        eventRepository.saveEvents(getDessertNumbers(), getMainNumbers(), totalAmount);
        List<Event> events = eventRepository.getEvents();

        int totalDiscountAmount = calculateTotalDiscountAmount(events);
        int discountAmountWithoutGift = calculateDiscountAmountWithoutGift(events);
        int payment = totalAmount - discountAmountWithoutGift;
        Badge badge = Badge.getBadge(totalDiscountAmount);

        return new ReceiptDto(eventRepository.getVisitDay()
                , ordersInformation, totalAmount, formatGifts(events)
                , formatEvents(events)
                , totalDiscountAmount, payment, badge.getName());
    }

    private List<String> parseOrders() {
        return orderRepository.getOrders().stream()
                .map(Order::getInformation)
                .toList();
    }

    private int getTotalAmount() {
        int totalAmount = 0;
        for (Order order : orderRepository.getOrders()) {
            totalAmount += (order.getMenu().getPrice() * order.getQuantity());
        }
        return totalAmount;
    }

    private int calculateTotalDiscountAmount(List<Event> events) {
        return events.stream()
                .mapToInt(Event::getDiscountAmount)
                .sum();
    }

    private List<String> formatGifts(List<Event> events) {
        for (Event event : events) {
            if (event.getClass().equals(GiftEvent.class)) {
                return ((GiftEvent) event).formatGifts();
            }
        }
        return new ArrayList<>();
    }

    private int calculateDiscountAmountWithoutGift(List<Event> events) {
        int discountAmountWithoutGift = 0;
        for (Event event : events) {
            if (event.getClass().equals(GiftEvent.class)) {
                continue;
            }
            discountAmountWithoutGift += event.getDiscountAmount();
        }
        return discountAmountWithoutGift;
    }

    private List<String> formatEvents(List<Event> events) {
        return events.stream()
                .map(Event::getInformation)
                .toList();
    }

    private int getDessertNumbers() {
        int dessertCount = 0;
        for (Order order : orderRepository.getOrders()) {
            if (order.getMenu().getMenuCategory().equals(MenuCategory.DESSERT)) {
                dessertCount += order.getQuantity();
            }
        }
        return dessertCount;
    }

    private int getMainNumbers() {
        int mainCount = 0;
        for (Order order : orderRepository.getOrders()) {
            if (order.getMenu().getMenuCategory().equals(MenuCategory.MAIN)) {
                mainCount += order.getQuantity();
            }
        }
        return mainCount;
    }
}
