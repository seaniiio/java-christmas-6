package christmas.repository;

import christmas.domain.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private static final OrderRepository instance = new OrderRepository();
    private List<Order> orders;

    private OrderRepository() {
        this.orders = new ArrayList<>();
    };

    public static OrderRepository getInstance() {
        return instance;
    }

    public void saveOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }
}
