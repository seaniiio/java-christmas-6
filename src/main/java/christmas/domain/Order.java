package christmas.domain;

import christmas.constant.ErrorMessage;

public record Order(Menu menu, int quantity) {

    private static final int MIN_QUANTITY = 1;

    public Order {
        validateQuantity(quantity);
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
