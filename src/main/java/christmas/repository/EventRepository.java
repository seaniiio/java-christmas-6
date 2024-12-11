package christmas.repository;

import christmas.domain.VisitDay;
import christmas.domain.events.ChristmasEvent;
import christmas.domain.events.Event;
import christmas.domain.events.GiftEvent;
import christmas.domain.events.SpecialEvent;
import christmas.domain.events.WeekdayEvent;
import christmas.domain.events.WeekendEvent;
import java.util.ArrayList;
import java.util.List;

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

    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new ChristmasEvent(visitDay.getVisitDay()));
        events.add(new WeekdayEvent(visitDay.isWeekend(), orderRepository.getDessertNumbers()));
        events.add(new WeekendEvent(visitDay.isWeekend(), orderRepository.getMainNumbers()));
        events.add(new SpecialEvent(visitDay.getVisitDay()));
        events.add(new GiftEvent(orderRepository.getTotalAmount()));
        return events;
    }

    public int getVisitDay() {
        return visitDay.getVisitDay();
    }
}
