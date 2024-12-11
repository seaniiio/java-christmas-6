package christmas.domain.events;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WeekendEventTest {

    @ParameterizedTest
    @CsvSource({
            "true, 2, 4046",
            "true, 1, 2023",
            "false, 2, 0",
    })
    void 평일_할인_적용_테스트(boolean isWeekend, int dessertCount, int expected) {
        WeekendEvent weekendEvent = new WeekendEvent(isWeekend, dessertCount);
        Assertions.assertThat(weekendEvent.getDiscountAmount())
                .isEqualTo(expected);
    }
}
