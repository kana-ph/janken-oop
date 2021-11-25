package ph.kana.jankenoop.app;

import ph.kana.jankenoop.game.Attack;
import ph.kana.jankenoop.game.BattleLogic;
import ph.kana.jankenoop.game.BattleResult;

import java.util.*;

import static ph.kana.jankenoop.game.Attack.*;

public class Game {

    private final static Map<String, Attack> ATTACK_MAP = Map.of(
        "1", ROCK,
        "2", PAPER,
        "3", SCISSORS
    );
    private final BattleLogic battleLogic = new BattleLogic();
    private final Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    public void playRound() {
        System.out.println("JANKEN-POY ROUND!");

        Attack playerAttack = askForAttack();
        System.out.println("You chose: " + playerAttack);

        Attack computerAttack = randomAttack();
        System.out.println("Computer chose: " + computerAttack);

        BattleResult result = battleLogic.execute(playerAttack, computerAttack);
        System.out.println("Result: " + result + "!");
    }

    public void askPlayAgain() {
        System.out.print("Play again [Y/n]? ");
        String choice = scanner.nextLine();

        if (!choice.isBlank() && !"y".equalsIgnoreCase(choice)) {
            running = false;
        }
    }

    public boolean isRunning() {
        return running;
    }

    private Attack askForAttack() {
        System.out.println("  Pick your move:");
        System.out.println("   1. ROCK");
        System.out.println("   2. PAPER");
        System.out.println("   3. SCISSORS");

        for (;;) {
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            Attack attack = ATTACK_MAP.get(choice);

            if (attack != null) {
                return attack;
            } else {
                System.out.println("\nInvalid choice: '" + choice + "'. Choose 1 or 2 or 3 only!");
            }
        }
    }

    private Attack randomAttack() {
        List<Attack> attacks = new ArrayList<>(ATTACK_MAP.values());
        Collections.shuffle(attacks);
        return attacks.get(0);
    }
}
