package christmas.service;

import christmas.repository.OrderRepository;
import christmas.util.Parser;
import java.util.Map;

public class OrderService {

    private final OrderRepository orderRepository = OrderRepository.getInstance();

    public void setVisitDay(String visitDayInput) {
        int day = Parser.parseDay(visitDayInput);
        orderRepository.saveVisitDay(day);
    }

    public void setMenus(String menusInput) {
        Map<String, Integer> menus = Parser.parseMenu(menusInput);
        orderRepository.saveMenus(menus);
    }
}
