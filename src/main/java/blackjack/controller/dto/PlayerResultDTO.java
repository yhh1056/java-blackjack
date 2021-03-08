package blackjack.controller.dto;

import blackjack.domain.card.Card;
import blackjack.domain.player.Name;
import blackjack.domain.player.Player;
import java.util.ArrayList;
import java.util.List;

public class PlayerResultDTO {
    private final Name name;
    private final List<Card> cards;
    private final int score;

    public PlayerResultDTO(Player player) {
        name = player.getName();
        cards = new ArrayList<>(player.getCards());
        score = player.getScore();
    }

    public String getName() {
        return name.getName();
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getScore() {
        return score;
    }
}
