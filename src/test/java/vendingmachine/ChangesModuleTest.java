package vendingmachine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/*
  Red 질문 >  Green 응답  > Refactor 정제
 */
class ChangesModuleTest {
    @ParameterizedTest
    @CsvSource({"10,_10_COIN", "50,_50_COIN", "100,_100_COIN", "500,_500_COIN"})
    void _n원이_남았으면_n원을_돌려준다(int value, CoinSet coin) {
        Changes changes = new Changes(value);
        List<CoinSet> coinSet = changes.coin();
        assertThat(coinSet).containsExactlyInAnyOrder(coin);
    }

    @Test
    @DisplayName("1000원이 남아있다면 500원동전 2개를 돌려준다. ")
    void _1() {
        Changes changes = new Changes(1000);
        List<CoinSet> coinSet = changes.coin();
        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._500_COIN, CoinSet._500_COIN);
    }

    @Test
    @DisplayName("20원이 남아있다면 10원동전 2개를 돌려준다. ")
    void _2() {
        Changes changes = new Changes(20);
        List<CoinSet> coinSet = changes.coin();
        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._10_COIN, CoinSet._10_COIN);
    }

    @Test
    @DisplayName("600원이 남아있다면 500원 동전 1개와 100원 동전 한개를 돌려준다 ")
    void _3() {
        Changes changes = new Changes(600);
        List<CoinSet> coinSet = changes.coin();
        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._500_COIN, CoinSet._100_COIN);
    }

    @Test
    @DisplayName("650원이 남아 있다면 500원 동전 1개와 100원 동전 1개 50원 동전 1개를 돌려준다")
    void _4() {
        Changes changes = new Changes(650);
        List<CoinSet> coinSet = changes.coin();
        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._500_COIN, CoinSet._100_COIN, CoinSet._50_COIN);
    }


    //    @Test
//    void _10원이_남았으면_10원을_돌려준다() {
//        Changes changes = new Changes(10);
//        List<CoinSet> coinSet = changes.coin();
//        assertThat(coinSet.size()).isEqualTo(1);
//        assertThat(coinSet.get(0)).isEqualTo(CoinSet._10_COIN);
//    }
//
//    @Test
//    void _50원이_남았으면_10원을_돌려준다() {
//        Changes changes = new Changes(50);
//        List<CoinSet> coinSet = changes.coin();
//
//        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._50_COIN);
//    }
//
//    @Test
//    void _100원이_남았으면_100원을_돌려준다() {
//        Changes changes = new Changes(100);
//        List<CoinSet> coinSet = changes.coin();
//
//        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._100_COIN);
//    }
//
//    @Test
//    void _500원이_남았으면_500원을_돌려준다() {
//        Changes changes = new Changes(500);
//        List<CoinSet> coinSet = changes.coin();
//
//        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._500_COIN);
//    }
}