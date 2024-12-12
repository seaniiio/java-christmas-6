package christmas.util;

import christmas.constant.ErrorMessage;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void 날짜_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Parser.parseDay("1일"))
                .withMessageContaining(ErrorMessage.DAY_INPUT_ERROR.getMessage());
    }

    @Test
    void 메뉴_파싱_테스트() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("감자", 2);
        expected.put("설탕", 3);

        Assertions.assertThat(Parser.parseOrders("감자-2,설탕-3"))
                .containsAllEntriesOf(expected);
    }

    @Test
    void 중복_메뉴_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Parser.parseOrders("라면-1,라면-1"))
                .withMessageContaining(ErrorMessage.MENU_INPUT_ERROR.getMessage());
    }

    @Test
    void 메뉴_수_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Parser.parseOrders("라면-1개"))
                .withMessageContaining(ErrorMessage.MENU_INPUT_ERROR.getMessage());
    }
}
