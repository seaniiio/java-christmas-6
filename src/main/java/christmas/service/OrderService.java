package christmas.service;

import christmas.domain.Badge;
import christmas.domain.events.Event;
import christmas.domain.events.GiftEvent;
import christmas.dto.ReceiptDto;
import christmas.repository.EventRepository;
import christmas.repository.OrderRepository;
import christmas.util.Parser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {

    private final EventRepository eventRepository = EventRepository.getInstance();
    private final OrderRepository orderRepository = OrderRepository.getInstance();

    public void setVisitDay(String visitDayInput) {
        int day = Parser.parseDay(visitDayInput);
        eventRepository.saveVisitDay(day);
    }

    public void setMenus(String menusInput) {
        Map<String, Integer> menus = Parser.parseMenu(menusInput);
        orderRepository.saveMenus(menus);
    }

    public ReceiptDto calculate() {
        List<String> ordersInformation = orderRepository.parseOrders();
        int totalAmount = orderRepository.getTotalAmount();
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

    private int calculateDiscountAmountWithoutGift(List<Event> events) {
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

    private int calculateTotalDiscountAmount(List<Event> events) {
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
}
