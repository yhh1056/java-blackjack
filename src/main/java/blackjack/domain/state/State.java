package blackjack.domain.state;

import blackjack.domain.card.Card;
import blackjack.domain.card.HoldCards;
import blackjack.domain.entry.BettingMoney;

public interface State {

    State draw(Card card);

    State stay();

    State blackjack();

    boolean isReady();

    boolean isFinished();

    double profit(BettingMoney bettingMoney);

    HoldCards getHoldCards();
}
