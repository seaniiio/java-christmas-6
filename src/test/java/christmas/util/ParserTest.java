package christmas.util;

import static org.junit.jupiter.api.Assertions.*;

import christmas.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void 날짜_예외_테스트() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Parser.parseDay("1일"))
                .withMessageContaining(ErrorMessage.DAY_INPUT_ERROR.getMessage());
    }
}
