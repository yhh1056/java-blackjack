package blackjack.dto.response;

import blackjack.domain.PlayerOutcome;

public class PlayerGameResult {
    private final String playerName;
//    private final String outcome;

    public PlayerGameResult(String playerName, PlayerOutcome outcome) {
        this.playerName = playerName;
//        this.outcome = outcome.g();
    }

    public String getPlayerName() {
        return playerName;
    }

//    public String getOutcome() {
//        return outcome;
//    }
}
