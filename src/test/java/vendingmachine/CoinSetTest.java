package vendingmachine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CoinSetTest {
    @Test
    void 동전을_생성한다() {
        CoinSet coin = CoinSet._100_COIN;
        assertThat(coin).isEqualTo(new Coin(100));
    }

    @ParameterizedTest
    @MethodSource("coinSet")
    void 동전은_500원_100_50_10원이_있다(int value, CoinSet coin) {
        assertThat(coin.value).isEqualTo(value);
    }

    @Test
    void 동전() {
        CoinSet coin = CoinSet.valueOf(10);
        assertThat(coin).isEqualTo(CoinSet._10_COIN);

    }

    static List<Arguments> coinSet() {
        return Arrays.asList(
                Arguments.of(500, CoinSet._500_COIN),
                Arguments.of(100, CoinSet._100_COIN),
                Arguments.of(50, CoinSet._50_COIN),
                Arguments.of(10, CoinSet._10_COIN)
        );

    }
}