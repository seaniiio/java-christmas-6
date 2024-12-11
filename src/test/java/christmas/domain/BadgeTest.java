package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BadgeTest {

    @Test
    void 배지_발급_테스트() {
        Assertions.assertThat(Badge.getBadge(2000))
                .isEqualTo(Badge.NONE);

        Assertions.assertThat(Badge.getBadge(7000))
                .isEqualTo(Badge.STAR);

        Assertions.assertThat(Badge.getBadge(12000))
                .isEqualTo(Badge.TREE);

        Assertions.assertThat(Badge.getBadge(20000))
                .isEqualTo(Badge.SANTA);
    }
}
