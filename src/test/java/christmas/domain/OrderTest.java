package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void 주문_수_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Order(Menu.BARBECUE_RIBS, 0))
                .withMessageContaining(ErrorMessage.MENU_INPUT_ERROR.getMessage());
    }
}
