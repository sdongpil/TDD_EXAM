package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Changes {
    private int amount;

    public Changes(int amount) {
        this.amount = amount;
    }

    public List<CoinSet> coin() {
        List<CoinSet> list = new ArrayList<>();
        for (CoinSet coin : CoinSet.values()) {
            if (amount % coin.value == 0) {
                list.addAll(getCoinSets(coin));
                return list;
            } else {
                extracted(list, coin);
            }
        }
        return list;
    }

    private void extracted(List<CoinSet> list, CoinSet coin) {
        int count = amount / coin.value;
        if (count > 0) {
            amount = amount - (count * coin.value);
            for (int i = 0; i < count; i++) {
                list.add(coin);
            }
        }
    }

    private List<CoinSet> getCoinSets(CoinSet coin) {
        List<CoinSet> list = new ArrayList<>();
        int quantity = amount / coin.value;
        for (int i = 0; i < quantity; i++) {
            list.add(coin);
        }
        return list;
    }
}
