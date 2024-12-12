package christmas.controller;

import christmas.dto.ReceiptDto;
import christmas.service.EventService;
import christmas.service.OrderService;
import christmas.util.InputProcessor;
import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final OrderService orderService;
    private final EventService eventService;

    public OrderController(InputView inputView, OutputView outputView, OrderService orderService, EventService eventService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.orderService = orderService;
        this.eventService = eventService;
    }

    public void run() {
        outputView.printWelcomeMessage();
        InputProcessor.continueUntilNormalInput(this::processVisitDay, outputView::printErrorMessage);
        InputProcessor.continueUntilNormalInput(this::processMenuInput, outputView::printErrorMessage);

        ReceiptDto receiptDto = eventService.calculate();
        outputView.printReceipt(receiptDto);
    }

    private void processVisitDay() {
        orderService.setVisitDay(inputView.getVisitDayInput());
    }

    private void processMenuInput() {
        orderService.setMenus(inputView.getMenusInput());
    }
}
