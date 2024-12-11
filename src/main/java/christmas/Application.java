package christmas;

import christmas.config.AppConfig;
import christmas.controller.OrderController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        OrderController orderController = appConfig.orderController();
        orderController.run();
    }
}
