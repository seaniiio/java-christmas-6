package christmas.repository;

import christmas.domain.VisitDay;
import christmas.domain.events.Event;
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

    public void saveEvents(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return new ArrayList<>(events);
    }

    public VisitDay getVisitDay() {
        return visitDay;
    }
}
