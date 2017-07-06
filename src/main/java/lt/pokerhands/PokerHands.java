package lt.pokerhands;

public class PokerHands {

    private GamesReader gamesReader;

    public static void main(String[] args) {
        new PokerHands().execute();
    }

    private void execute() {
        loadGames();
        long player1Won = gamesReader.getGames()
                .stream()
                .peek(PokerGame::findWinner)
                .map(PokerGame::getWinnerPlayerNumber)
                .filter(playerNumber -> playerNumber == 0)
                .count();
        System.out.printf("Player 1 won %d times\n", player1Won);
    }

    private void loadGames() {
        gamesReader = new GamesReader();
        gamesReader.init();
    }

}
