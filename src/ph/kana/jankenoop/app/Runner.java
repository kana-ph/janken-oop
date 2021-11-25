package ph.kana.jankenoop.app;

public class Runner {

    public static void main(String[] args) {
        Game game = new Game();

        System.out.println("Welcome!\n");

        while (game.isRunning()) {
            game.playRound();
            System.out.println();
            game.askPlayAgain();
        }
        System.out.println("Thank you!");
    }
}
