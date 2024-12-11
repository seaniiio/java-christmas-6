package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void 이름으로_메뉴_탐색_테스트() {
        Assertions.assertThat(Menu.findMenu("바비큐립"))
                .isEqualTo(Menu.BARBECUE_RIBS);
    }

    @Test
    void 존재하지_않는_메뉴_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Menu.findMenu("짜장면"))
                .withMessageContaining(ErrorMessage.MENU_INPUT_ERROR.getMessage());
    }
}
