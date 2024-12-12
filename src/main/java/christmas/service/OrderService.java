package christmas.service;

import christmas.constant.ErrorMessage;
import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.Order;
import christmas.repository.EventRepository;
import christmas.repository.OrderRepository;
import christmas.util.Parser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {

    private static final int MAX_QUANTITY = 20;
    private final EventRepository eventRepository;
    private final OrderRepository orderRepository;

    public OrderService() {
        this.eventRepository = EventRepository.getInstance();
        this.orderRepository = OrderRepository.getInstance();
    }

    public void setVisitDay(String visitDayInput) {
        int day = Parser.parseDay(visitDayInput);
        eventRepository.saveVisitDay(day);
    }

    public void setMenus(String menusInput) {
        Map<String, Integer> ordersRaw = Parser.parseOrders(menusInput);
        List<Order> orders = new ArrayList<>();
        for (String order : ordersRaw.keySet()) {
            orders.add(new Order(Menu.findMenu(order), ordersRaw.get(order)));
        }
        validateOrders(orders);
        orderRepository.saveOrders(orders);
    }

    private void validateOrders(List<Order> orders) {
        validateOnlyBeverage(orders);
        validateOverQuantity(orders);
    }

    private void validateOnlyBeverage(List<Order> orders) {
        for (Order order : orders) {
            Menu menu = order.getMenu();
            if (!menu.getMenuCategory().equals(MenuCategory.BEVERAGE)) {
                return;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.MENU_INPUT_ERROR.getMessage());
    }

    private void validateOverQuantity(List<Order> orders) {
        int totalQuantity = orders.stream()
                .mapToInt(Order::getQuantity)
                .sum();
        if (totalQuantity > MAX_QUANTITY) {
            throw new IllegalArgumentException(ErrorMessage.MENU_INPUT_ERROR.getMessage());
        }
    }
}
