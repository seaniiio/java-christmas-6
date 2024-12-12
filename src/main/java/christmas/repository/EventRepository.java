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
    private VisitDay visitDay;
    private List<Event> events;

    private EventRepository() {
        this.events = new ArrayList<>();
    };

    public static EventRepository getInstance() {
        return instance;
    }

    public void saveVisitDay(int visitDayRaw) {
        this.visitDay = new VisitDay(visitDayRaw);
    }

    public void saveEvents(int dessertNumbers, int mainNumbers, int totalAmount) {
        events.add(new ChristmasEvent(visitDay.getVisitDay()));
        events.add(new GiftEvent(totalAmount));
        events.add(new WeekdayEvent(visitDay.isWeekend(), dessertNumbers));
        events.add(new WeekendEvent(visitDay.isWeekend(), mainNumbers));
        events.add(new SpecialEvent(visitDay.getVisitDay()));
    }

    public List<Event> getEvents() {
        return new ArrayList<>(events);
    }

    public int getVisitDay() {
        return visitDay.getVisitDay();
    }
}
