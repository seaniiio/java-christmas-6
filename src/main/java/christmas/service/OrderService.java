package christmas.service;

import christmas.repository.OrderRepository;
import christmas.util.Parser;

public class OrderService {

    private final OrderRepository orderRepository = OrderRepository.getInstance();

    public void setVisitDay(String visitDayInput) {
        int day = Parser.parseDay(visitDayInput);
        orderRepository.saveVisitDay(day);
    }
}
