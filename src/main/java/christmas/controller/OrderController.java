package christmas.controller;

import christmas.dto.ReceiptDto;
import christmas.service.OrderService;
import christmas.util.InputProcessor;
import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final OrderService orderService;

    public OrderController(InputView inputView, OutputView outputView, OrderService orderService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.orderService = orderService;
    }

    public void run() {
        outputView.printWelcomeMessage();
        InputProcessor.continueUntilNormalInput(this::processVisitDay, outputView::printErrorMessage);
        InputProcessor.continueUntilNormalInput(this::processMenuInput, outputView::printErrorMessage);

        ReceiptDto receiptDto = orderService.calculate();
        outputView.printReceipt(receiptDto);
    }

    private void processVisitDay() {
        orderService.setVisitDay(inputView.getVisitDayInput());
    }

    private void processMenuInput() {
        orderService.setMenus(inputView.getMenusInput());
    }
}
