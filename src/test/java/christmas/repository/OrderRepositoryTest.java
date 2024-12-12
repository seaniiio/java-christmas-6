package christmas.repository;

import christmas.constant.ErrorMessage;
import christmas.domain.Menu;
import christmas.domain.Order;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderRepositoryTest {

    OrderRepository orderRepository = OrderRepository.getInstance();

    @Test
    void 음료만_주문_예외_테스트() {
        List<Order> orders = List.of(new Order(Menu.ZERO_COKE, 2), new Order(Menu.RED_WINE, 1));

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> orderRepository.saveOrders(orders))
                .withMessageContaining(ErrorMessage.MENU_INPUT_ERROR.getMessage());
    }

    @Test
    void 총_주문_개수_예외_테스트() {
        List<Order> orders = List.of(new Order(Menu.ZERO_COKE, 20), new Order(Menu.RED_WINE, 1));

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> orderRepository.saveOrders(orders))
                .withMessageContaining(ErrorMessage.MENU_INPUT_ERROR.getMessage());
    }

//    @Test
//    void 디저트_메뉴_수_탐색() {
//        List<Order> orders = List.of(new Order(Menu.CHOCOLATE_CAKE, 2), new Order(Menu.RED_WINE, 1));
//        orderRepository.saveOrders(orders);
//
//        Assertions.assertThat(orderRepository.getDessertNumbers())
//                .isEqualTo(2);
//    }
//
//    @Test
//    void 메인_메뉴_수_탐색() {
//        List<Order> orders = List.of(new Order(Menu.BARBECUE_RIBS, 2), new Order(Menu.CHRISTMAS_PASTA, 1));
//        orderRepository.saveOrders(orders);
//
//        Assertions.assertThat(orderRepository.getMainNumbers())
//                .isEqualTo(3);
//    }

//    @Test
//    void 총_금액_탐색() {
//        Map<String, Integer> menus = new HashMap<>();
//        menus.put("타파스", 2);
//        menus.put("아이스크림", 1);
//        orderRepository.saveOrders(menus);
//
//        Assertions.assertThat(orderRepository.getTotalAmount())
//                .isEqualTo(16000);
//    }
}
