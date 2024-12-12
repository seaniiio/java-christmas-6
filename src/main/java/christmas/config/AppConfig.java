package christmas.config;

import christmas.controller.OrderController;
import christmas.service.EventService;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {

    public OrderController orderController() {
        return new OrderController(inputView(), outputView(), orderService(), eventService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private OrderService orderService() {
        return new OrderService();
    }

    private EventService eventService() {
        return new EventService();
    }
}
