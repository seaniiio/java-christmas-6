package christmas.domain;

import christmas.constant.ErrorMessage;

public enum Menu {
    YANG_SONG_SOUP(MenuCategory.APPETIZER, "양송이수프", 6_000),
    TAPAS(MenuCategory.APPETIZER, "타파스", 5_500),
    CAESAR_SALAD(MenuCategory.APPETIZER, "시저샐러드", 8_000),

    TBONE_STEAK(MenuCategory.MAIN, "티본스테이크", 55_000),
    BARBECUE_RIBS(MenuCategory.MAIN, "바베큐립", 54_000),
    SEAFOOD_PASTA(MenuCategory.MAIN, "해산물파스타", 35_000),
    CHRISTMAS_PASTA(MenuCategory.MAIN, "크리스마스파스타", 25_000),

    CHOCOLATE_CAKE(MenuCategory.DESSERT, "초코케이크", 15_000),
    ICE_CREAM(MenuCategory.DESSERT, "아이스크림", 5_000),

    ZERO_COKE(MenuCategory.BEVERAGE, "제로콜라", 3_000),
    RED_WINE(MenuCategory.BEVERAGE, "레드와인", 60_000),
    CHAMPAGNE(MenuCategory.BEVERAGE, "샴페인", 25_000),
    ;

    private final MenuCategory menuCategory;
    private final String name;
    private final int price;

    Menu(MenuCategory menuCategory, String name, int price) {
        this.menuCategory = menuCategory;
        this.name = name;
        this.price = price;
    }

    public static Menu findMenu(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.MENU_INPUT_ERROR.getMessage());
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }
}
