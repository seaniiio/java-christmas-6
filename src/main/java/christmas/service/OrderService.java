package christmas.service;

import christmas.constant.Week;
import christmas.domain.Badge;
import christmas.domain.Menu;
import christmas.domain.events.ChristmasEvent;
import christmas.domain.events.GiftEvent;
import christmas.domain.events.SpecialEvent;
import christmas.domain.events.WeekdayEvent;
import christmas.domain.events.WeekendEvent;
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

        ChristmasEvent christmasEvent = eventRepository.getChristmasEvent();
        WeekdayEvent weekdayEvent = eventRepository.getWeekdayEvent();
        WeekendEvent weekendEvent = eventRepository.getWeekendEvent();
        SpecialEvent specialEvent = eventRepository.getSpecialEvent();
        GiftEvent giftEvent = eventRepository.getGiftEvent();

        int totalDiscountAmount = christmasEvent.getDiscountAmount()
                + weekdayEvent.getDiscountAmount()
                + weekendEvent.getDiscountAmount()
                + specialEvent.getDiscountAmount()
                + giftEvent.getGiftAmount();

        int payment = totalAmount - totalDiscountAmount;
        Badge badge = Badge.getBadge(totalDiscountAmount);

        return new ReceiptDto(eventRepository.getVisitDay()
                , ordersInformation, totalAmount, giftEvent.formatGifts()
                , formatEvents(christmasEvent, weekdayEvent, weekendEvent, specialEvent, giftEvent)
                , totalDiscountAmount, payment, badge.getName());
    }

    private List<String> formatEvents(ChristmasEvent christmasEvent, WeekdayEvent weekdayEvent, WeekendEvent weekendEvent, SpecialEvent specialEvent, GiftEvent giftEvent) {
        List<String> events = new ArrayList<>();
        events.add(christmasEvent.getInformation());
        events.add(weekdayEvent.getInformation());
        events.add(weekendEvent.getInformation());
        events.add(specialEvent.getInformation());
        events.add(giftEvent.getInformation());
        return events;
    }
}
