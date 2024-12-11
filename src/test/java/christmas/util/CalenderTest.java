package christmas.util;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalenderTest {

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "3, false",
            "4, false",
            "29, true",
            "30, true",
    })
    void 주말_찾기_테스트(int day, boolean expected) {
        Assertions.assertThat(Calender.isWeekend(1, day))
                .isEqualTo(expected);
    }
}
