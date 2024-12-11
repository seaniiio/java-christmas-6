package christmas.repository;

import christmas.domain.VisitDay;

public class OrderRepository {

    private static final OrderRepository instance = new OrderRepository();
    private VisitDay visitDay;

    private OrderRepository() {};

    public static OrderRepository getInstance() {
        return instance;
    }

    public void saveVisitDay(int visitDayRaw) {
        this.visitDay = new VisitDay(visitDayRaw);
    }
}
