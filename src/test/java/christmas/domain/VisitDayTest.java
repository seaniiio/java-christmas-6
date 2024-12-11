package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VisitDayTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 32})
    void 날짜_범위_예외_테스트(int day) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new VisitDay(day))
                .withMessageContaining(ErrorMessage.DAY_INPUT_ERROR.getMessage());
    }
}
