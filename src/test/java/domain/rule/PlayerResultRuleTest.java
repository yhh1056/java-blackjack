package domain.rule;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import domain.card.Card;
import domain.card.Symbol;
import domain.card.Type;
import domain.result.ResultType;
import domain.user.Dealer;
import domain.user.Player;

class PlayerResultRuleTest {

    private Dealer dealer;
    private Player player;

    @BeforeEach
    void setUp() {
        dealer = Dealer.appoint();
        player = new Player("이름");
    }

    @ParameterizedTest
    @DisplayName("포인트 비교로 승자 확인")
    @MethodSource("createCardSet")
    void reflect(Card playerCard, Card dealerCard, ResultType expected) {
        player.draw(new Card(Symbol.DIAMOND, Type.KING));
        player.draw(new Card(Symbol.DIAMOND, Type.SIX));
        player.draw(playerCard);

        dealer.draw(new Card(Symbol.CLOVER, Type.KING));
        dealer.draw(new Card(Symbol.CLOVER, Type.SIX));
        dealer.draw(dealerCard);

        Rules rules = new Rules(Arrays.asList(PlayerResultRule.values()));

        assertThat(rules.decideResultType(player, dealer)).isEqualTo(expected);
    }

    private static Stream<Arguments> createCardSet() {
        return Stream.of(
                //플레이어가 21점인 경우
                createCardsAndWinningResult(Type.FIVE, Type.FIVE, ResultType.DRAW),
                createCardsAndWinningResult(Type.FIVE, Type.FOUR, ResultType.WIN),
                createCardsAndWinningResult(Type.FIVE, Type.SIX, ResultType.WIN),

                //플레이어가 버스트인 경우
                createCardsAndWinningResult(Type.SIX, Type.SIX, ResultType.LOSE),
                createCardsAndWinningResult(Type.SIX, Type.FIVE, ResultType.LOSE),
                createCardsAndWinningResult(Type.SIX, Type.FOUR, ResultType.LOSE),

                //플레이어가 21미만인 경우
                createCardsAndWinningResult(Type.THREE, Type.TWO, ResultType.WIN),
                createCardsAndWinningResult(Type.THREE, Type.THREE, ResultType.DRAW),
                createCardsAndWinningResult(Type.THREE, Type.FOUR, ResultType.LOSE),
                createCardsAndWinningResult(Type.THREE, Type.FIVE, ResultType.LOSE),
                createCardsAndWinningResult(Type.THREE, Type.SIX, ResultType.WIN)
        );
    }

    private static Arguments createCardsAndWinningResult(Type player, Type dealer, ResultType resultType) {
        return Arguments.of(
                new Card(Symbol.HEART, player),
                new Card(Symbol.SPADE, dealer),
                resultType
        );
    }

    @Test
    @DisplayName("점수가 같고 모두 블랙잭인 경우")
    void drawIfBothBlackJack() {
        player.draw(new Card(Symbol.DIAMOND, Type.KING));
        player.draw(new Card(Symbol.HEART, Type.ACE));

        dealer.draw(new Card(Symbol.CLOVER, Type.KING));
        dealer.draw(new Card(Symbol.SPADE, Type.ACE));

        Rules rules = new Rules(Arrays.asList(PlayerResultRule.values()));

        assertThat(rules.decideResultType(player, dealer)).isEqualTo(ResultType.DRAW);
    }

    @Test
    @DisplayName("점수가 같고 플레이어만 블랙잭인 경우")
    void drawIfPlayerBlackJack() {
        player.draw(new Card(Symbol.DIAMOND, Type.KING));
        player.draw(new Card(Symbol.HEART, Type.ACE));

        dealer.draw(new Card(Symbol.CLOVER, Type.KING));
        dealer.draw(new Card(Symbol.SPADE, Type.SIX));
        dealer.draw(new Card(Symbol.HEART, Type.FIVE));

        Rules rules = new Rules(Arrays.asList(PlayerResultRule.values()));

        assertThat(rules.decideResultType(player, dealer)).isEqualTo(ResultType.WIN);
    }

    @Test
    @DisplayName("점수가 같고 딜러만 블랙잭인 경우")
    void drawIfDealerBlackJack() {
        player.draw(new Card(Symbol.DIAMOND, Type.KING));
        player.draw(new Card(Symbol.HEART, Type.SIX));
        player.draw(new Card(Symbol.CLOVER, Type.FIVE));

        dealer.draw(new Card(Symbol.CLOVER, Type.KING));
        dealer.draw(new Card(Symbol.SPADE, Type.ACE));

        Rules rules = new Rules(Arrays.asList(PlayerResultRule.values()));

        assertThat(rules.decideResultType(player, dealer)).isEqualTo(ResultType.LOSE);
    }
}