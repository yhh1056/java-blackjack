package blackjack.domain.entry;

import blackjack.domain.PlayerOutcome;

public class BettingMoney {
    private static final double BLACKJACK_RATIO = 1.5;

    private static final int MINIMUM_AMOUNT_UNIT = 1000;
    private static final int MAXIMUM_AMOUNT = 5_000_000;

    private final int amount;

    public BettingMoney(int amount) {
        validateRange(amount);
        this.amount = amount;
    }

    public int countBlackjackPay() {
        return (int) (this.amount * BLACKJACK_RATIO);
    }

    public int bet(PlayerOutcome playerOutcome) {
        return playerOutcome.betting(this);
    }

    private void validateRange(int amount) {
        if (Math.floorMod(amount, MINIMUM_AMOUNT_UNIT) != 0) {
            throw new IllegalArgumentException("배팅 금액은 1000단위어야 합니다.");
        }
        if (amount > MAXIMUM_AMOUNT) {
            throw new IllegalArgumentException("배팅 금액은 500만을 넘을 수 없습니다.");
        }
    }

    public int getAmount() {
        return this.amount;
    }
}