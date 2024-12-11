package christmas.domain.events;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ChristmasEventTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1000",
            "2, 1100",
            "25, 3400",
            "26, 0"
    })
    void 크리스마스_디데이_할인_테스트(int day, int expected) {
        ChristmasEvent christmasEvent = new ChristmasEvent(day);
        Assertions.assertThat(christmasEvent.getDiscountAmount())
                .isEqualTo(expected);
    }
}
