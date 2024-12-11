package christmas.repository;

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
                .isThrownBy(() -> orderRepository.saveOrders(menus))
                .withMessageContaining(ErrorMessage.MENU_INPUT_ERROR.getMessage());
    }

    @Test
    void 총_주문_개수_예외_테스트() {
        Map<String, Integer> menus = new HashMap<>();
        menus.put("제로콜라", 20);
        menus.put("레드와인", 1);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> orderRepository.saveOrders(menus))
                .withMessageContaining(ErrorMessage.MENU_INPUT_ERROR.getMessage());
    }

    @Test
    void 디저트_메뉴_수_탐색() {
        Map<String, Integer> menus = new HashMap<>();
        menus.put("초코케이크", 2);
        menus.put("레드와인", 1);
        orderRepository.saveOrders(menus);

        Assertions.assertThat(orderRepository.getDessertNumbers())
                .isEqualTo(2);
    }

    @Test
    void 메인_메뉴_수_탐색() {
        Map<String, Integer> menus = new HashMap<>();
        menus.put("바비큐립", 2);
        menus.put("크리스마스파스타", 1);
        orderRepository.saveOrders(menus);

        Assertions.assertThat(orderRepository.getMainNumbers())
                .isEqualTo(3);
    }

    @Test
    void 총_금액_탐색() {
        Map<String, Integer> menus = new HashMap<>();
        menus.put("타파스", 2);
        menus.put("아이스크림", 1);
        orderRepository.saveOrders(menus);

        Assertions.assertThat(orderRepository.getTotalAmount())
                .isEqualTo(16000);
    }
}
