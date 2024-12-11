package christmas.domain.events;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SpecialEventTest {

    @ParameterizedTest
    @CsvSource({
            "3, 1000",
            "4, 0",
            "25, 1000"
    })
    void 특별_할인_적용_테스트(int day, int expected) {
        SpecialEvent specialEvent = new SpecialEvent(day);

        Assertions.assertThat(specialEvent.getDiscountAmount())
                .isEqualTo(expected);
    }
}
