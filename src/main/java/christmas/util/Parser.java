package christmas.util;

import christmas.constant.ErrorMessage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    private static final int MENU_NAME_INDEX = 0;
    private static final int MENU_QUANTITY_INDEX = 1;

    public static int parseDay(String visitDayInput) {
        try {
            return Integer.parseInt(visitDayInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.DAY_INPUT_ERROR.getMessage());
        }
    }

    public static Map<String, Integer> parseMenu(String menusInput) {
        try {
            Map<String, Integer> orders = new HashMap<>();
            List<String> menus = Arrays.stream(menusInput.split(",")).toList();
            setMenus(menus, orders);
            return orders;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MENU_INPUT_ERROR.getMessage());
        }
    }

    private static void setMenus(List<String> menus, Map<String, Integer> orders) {
        for (String menu : menus) {
            String[] oneMenu = menu.split("-");
            String menuName = oneMenu[MENU_NAME_INDEX];
            int quantity = Integer.parseInt(oneMenu[MENU_QUANTITY_INDEX]);
            if (orders.keySet().contains(menuName)) {
                throw new IllegalArgumentException(ErrorMessage.MENU_INPUT_ERROR.getMessage());
            }
            orders.put(menuName, quantity);

        }
    }
}
