package christmas.repository;

import christmas.domain.VisitDay;
import christmas.domain.events.ChristmasEvent;
import christmas.domain.events.GiftEvent;
import christmas.domain.events.SpecialEvent;
import christmas.domain.events.WeekdayEvent;
import christmas.domain.events.WeekendEvent;

public class EventRepository {

    private static final EventRepository instance = new EventRepository();
    private static final OrderRepository orderRepository = OrderRepository.getInstance();
    private VisitDay visitDay;

    private EventRepository() {};

    public static EventRepository getInstance() {
        return instance;
    }

    public void saveVisitDay(int visitDayRaw) {
        this.visitDay = new VisitDay(visitDayRaw);
    }

    public ChristmasEvent getChristmasEvent() {
        return new ChristmasEvent(visitDay.getVisitDay());
    }

    public WeekdayEvent getWeekdayEvent() {
        return new WeekdayEvent(visitDay.isWeekend(), orderRepository.getDessertNumbers());
    }

    public WeekendEvent getWeekendEvent() {
        return new WeekendEvent(visitDay.isWeekend(), orderRepository.getMainNumbers());
    }

    public SpecialEvent getSpecialEvent() {
        return new SpecialEvent(visitDay.getVisitDay());
    }

    public GiftEvent getGiftEvent() {
        return new GiftEvent(orderRepository.getTotalAmount());
    }

    public int getVisitDay() {
        return visitDay.getVisitDay();
    }
}
