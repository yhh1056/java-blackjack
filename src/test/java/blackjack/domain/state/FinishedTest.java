package blackjack.domain.state;

import static blackjack.fixtures.BlackjackFixtures.SPADE_ACE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import blackjack.domain.card.HoldCards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FinishedTest {

    @Test
    @DisplayName("Finished 상태에서 카드를 뽑는 경우 예외를 발생한다.")
    void drawByFinishedSate() {
        State finished = new Blackjack(new HoldCards());

        assertThatIllegalStateException()
            .isThrownBy(() -> finished.draw(SPADE_ACE))
            .withMessage("Finish 상태에서 카드를 뽑을 수 없습니다.");
    }

    @Test
    @DisplayName("Finished 상태에서 stay를 하는 경우 예외를 발생한다.")
    void stayByFinishedSate() {
        State finished = new Blackjack(new HoldCards());

        assertThatIllegalStateException()
            .isThrownBy(finished::stay)
            .withMessage("Finish 상태에서 Stay 할 수 없습니다.");
    }

    @Test
    @DisplayName("Finished 상태에서 블랙잭인지 확인하는 경우 예외를 발생한다.")
    void isBlackjackByFinishedSate() {
        State finished = new Blackjack(new HoldCards());

        assertThatIllegalStateException()
            .isThrownBy(finished::blackjack)
            .withMessage("Finish 상태에서 블랙잭을 확인할 수 없습니다.");
    }

    @Test
    @DisplayName("Finished 상태인지 확인할 수 있다.")
    void isFinished() {
        State finished = new Blackjack(new HoldCards());

        assertThat(finished.isFinished()).isTrue();
    }

}
