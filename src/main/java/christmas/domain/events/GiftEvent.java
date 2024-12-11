package christmas.domain.events;

import christmas.domain.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GiftEvent {

    private static final Menu GIFT_MENU = Menu.CHAMPAGNE;
    private static final int GIFT_COUNT = 1;
    private static final int MINIMUM_AMOUNT_TO_GET_GIFT = 120_000;
    private final int totalAmount;

    public GiftEvent(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Map<Menu, Integer> getGifts() {
        Map<Menu, Integer> gifts = new HashMap<>();
        if (totalAmount >= MINIMUM_AMOUNT_TO_GET_GIFT) {
            gifts.put(GIFT_MENU, GIFT_COUNT);
        }
        return gifts;
    }

    public int getGiftAmount() {
        Map<Menu, Integer> gifts = getGifts();
        int amount = 0;
        for (Menu menu : gifts.keySet()) {
            amount += (menu.getPrice() * gifts.get(menu));
        }
        return amount;
    }

    public List<String> formatGifts() {
        Map<Menu, Integer> gifts = getGifts();
        List<String> formattedGifts = new ArrayList<>();

        for (Menu menu : gifts.keySet()) {
            formattedGifts.add(menu.getName() + " " + gifts.get(menu) + "개");
        }
        return formattedGifts;
    }

    public String getInformation() {
        if (getGiftAmount() == 0) {
            return "";
        }
        return String.format("증정 이벤트: -%,d원", getGiftAmount());
    }
}
