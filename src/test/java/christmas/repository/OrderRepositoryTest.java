package christmas.repository;

import static org.junit.jupiter.api.Assertions.*;

import christmas.constant.ErrorMessage;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderRepositoryTest {

    OrderRepository orderRepository = OrderRepository.getInstance();

    @Test
    void 음료만_주문_예외_테스트() {
        Map<String, Integer> menus = new HashMap<>();
        menus.put("제로콜라", 2);
        menus.put("레드와인", 1);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> orderRepository.saveMenus(menus))
                .withMessageContaining(ErrorMessage.MENU_INPUT_ERROR.getMessage());
    }

    @Test
    void 총_주문_개수_예외_테스트() {
        Map<String, Integer> menus = new HashMap<>();
        menus.put("제로콜라", 20);
        menus.put("레드와인", 1);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> orderRepository.saveMenus(menus))
                .withMessageContaining(ErrorMessage.MENU_INPUT_ERROR.getMessage());
    }
}
