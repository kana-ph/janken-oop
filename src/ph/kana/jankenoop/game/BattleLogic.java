package ph.kana.jankenoop.game;

import static ph.kana.jankenoop.game.BattleResult.*;

public class BattleLogic {
    public BattleResult execute(Attack player, Attack opponent) {
        return switch (player) {
            case ROCK -> switch (opponent) {
                case ROCK -> DRAW;
                case PAPER -> LOSE;
                case SCISSORS -> WIN;
            };
            case PAPER -> switch (opponent) {
                case ROCK -> WIN;
                case PAPER -> DRAW;
                case SCISSORS -> LOSE;
            };
            case SCISSORS -> switch (opponent) {
                case ROCK -> LOSE;
                case PAPER -> WIN;
                case SCISSORS -> DRAW;
            };
        };
    }
}
