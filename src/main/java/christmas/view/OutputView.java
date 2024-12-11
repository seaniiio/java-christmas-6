package christmas.view;

import christmas.dto.ReceiptDto;
import java.util.List;

public class OutputView {

    public void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printReceipt(ReceiptDto receiptDto) {
        printReceiptHeader(receiptDto);
        printOrders(receiptDto);
        printTotalAmount(receiptDto);
        printGifts(receiptDto);
        printEvents(receiptDto);
        printTotalDiscount(receiptDto);
        printPayment(receiptDto);
        printBadge(receiptDto);
    }

    private void printBadge(ReceiptDto receiptDto) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(receiptDto.getBadge());
    }

    private void printPayment(ReceiptDto receiptDto) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d원", receiptDto.getExpectedPayment()));
        System.out.println();
    }

    private void printTotalDiscount(ReceiptDto receiptDto) {
        System.out.println("<총혜택 금액>");
        int totalDiscountAmount = receiptDto.getTotalDiscountAmount();
        if (totalDiscountAmount == 0) {
            System.out.println("0원" + System.lineSeparator());
            return;
        }
        System.out.println(String.format("-%,d원", totalDiscountAmount));
        System.out.println();
    }

    private void printEvents(ReceiptDto receiptDto) {
        System.out.println("<혜택 내역>");
        List<String> events = receiptDto.getEvents();
        for (String event : events) {
            System.out.println(event);
        }

        if (events.size() == 0) {
            System.out.println("없음");
        }
        System.out.println();
    }

    private void printGifts(ReceiptDto receiptDto) {
        System.out.println("<증정 메뉴>");
        List<String> gifts = receiptDto.getGifts();
        for (String gift : gifts) {
            System.out.println(gift);
        }

        if (gifts.size() == 0) {
            System.out.println("없음");
        }
        System.out.println();
    }

    private void printTotalAmount(ReceiptDto receiptDto) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(String.format("%,d원", receiptDto.getTotalAmount()));
        System.out.println();
    }

    private void printReceiptHeader(ReceiptDto receiptDto) {
        System.out.println(String.format("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", receiptDto.getDay()));
        System.out.println();
    }

    private void printOrders(ReceiptDto receiptDto) {
        System.out.println("<주문 메뉴>");
        List<String> orders = receiptDto.getOrders();
        for (String order : orders) {
            System.out.println(order);
        }
        System.out.println();
    }
}
