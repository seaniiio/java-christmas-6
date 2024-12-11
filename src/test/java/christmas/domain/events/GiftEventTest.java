package christmas.domain.events;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GiftEventTest {

    @ParameterizedTest
    @CsvSource({
            "119000, 0",
            "120000, 25000"
    })
    void 증정품_적용_테스트(int totalAmount, int expected) {
        GiftEvent giftEvent = new GiftEvent(totalAmount);
        Assertions.assertThat(giftEvent.getDiscountAmount())
                .isEqualTo(expected);
    }
}
