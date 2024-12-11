package christmas.domain.events;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WeekdayEventTest {

    @ParameterizedTest
    @CsvSource({
            "true, 2, 0",
            "false, 1, 2023",
            "false, 2, 4046",
    })
    void 평일_할인_적용_테스트(boolean isWeekend, int dessertCount, int expected) {
        WeekdayEvent weekdayEvent = new WeekdayEvent(isWeekend, dessertCount);
        Assertions.assertThat(weekdayEvent.getDiscountAmount())
                .isEqualTo(expected);
    }
}
