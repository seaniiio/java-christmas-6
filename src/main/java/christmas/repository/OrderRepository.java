package christmas.repository;

import christmas.constant.ErrorMessage;
import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.Order;
import christmas.domain.VisitDay;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderRepository {

    private static final int MAX_QUANTITY = 20;
    private static final OrderRepository instance = new OrderRepository();
    private List<Order> orders;
    private VisitDay visitDay;

    private OrderRepository() {
        this.orders = new ArrayList<>();
    };

    public static OrderRepository getInstance() {
        return instance;
    }

    public void saveVisitDay(int visitDayRaw) {
        this.visitDay = new VisitDay(visitDayRaw);
    }

    public void saveMenus(Map<String, Integer> menus) {
        List<Order> ordersBeforeValidate = new ArrayList<>();
        for (String menu : menus.keySet()) {
            ordersBeforeValidate.add(new Order(Menu.findMenu(menu), menus.get(menu)));
        }

        validateOrders(ordersBeforeValidate);
        this.orders = ordersBeforeValidate;
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
