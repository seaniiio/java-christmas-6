package christmas.domain;

import christmas.constant.ErrorMessage;

public class Order {

    private static final int MIN_QUANTITY = 1;

    private final Menu menu;
    private final int quantity;

    public Order(Menu menu, int quantity) {
        validateQuantity(quantity);
        this.menu = menu;
        this.quantity = quantity;
    }

    private void validateQuantity(int quantity) {
        if (quantity < MIN_QUANTITY) {
            throw new IllegalArgumentException(ErrorMessage.MENU_INPUT_ERROR.getMessage());
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getInformation() {
        return menu.getName() + " " + quantity + "개";
    }
}
