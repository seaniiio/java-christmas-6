package christmas.repository;

import christmas.constant.ErrorMessage;
import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderRepository {

    private static final int MAX_QUANTITY = 20;
    private static final OrderRepository instance = new OrderRepository();
    private List<Order> orders;

    private OrderRepository() {
        this.orders = new ArrayList<>();
    };

    public static OrderRepository getInstance() {
        return instance;
    }

    public void saveMenus(Map<String, Integer> menus) {
        List<Order> ordersBeforeValidate = new ArrayList<>();
        for (String menu : menus.keySet()) {
            ordersBeforeValidate.add(new Order(Menu.findMenu(menu), menus.get(menu)));
        }

        validateOrders(ordersBeforeValidate);
        this.orders = ordersBeforeValidate;
    }

    public List<String> parseOrders() {
        return orders.stream()
                .map(Order::getInformation)
                .toList();
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (Order order : orders) {
            totalAmount += (order.getMenu().getPrice() * order.getQuantity());
        }
        return totalAmount;
    }

    public int getDessertNumbers() {
        int dessertCount = 0;
        for (Order order : orders) {
            if (order.getMenu().getMenuCategory().equals(MenuCategory.DESSERT)) {
                dessertCount += order.getQuantity();
            }
        }
        return dessertCount;
    }

    public int getMainNumbers() {
        int mainCount = 0;
        for (Order order : orders) {
            if (order.getMenu().getMenuCategory().equals(MenuCategory.MAIN)) {
                mainCount += order.getQuantity();
            }
        }
        return mainCount;
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
