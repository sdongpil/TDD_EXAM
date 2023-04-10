package vendingmachine;

public enum CoinSet {
    _500_COIN(500), _100_COIN(100), _50_COIN(50), _10_COIN(10);

    int value;

    CoinSet(int value) {
        this.value = value;
    }


    public static CoinSet valueOf(int amount) {
        if (amount == 10) {
            return CoinSet._10_COIN;
        }
        if (amount == 50) {
            return CoinSet._50_COIN;
        }
        if (amount == 100) {
            return CoinSet._100_COIN;
        }
        if (amount == 500) {
            return CoinSet._500_COIN;
        }
        throw new IllegalArgumentException("원의 동전은 존재하지 않습니다");
    }
}
