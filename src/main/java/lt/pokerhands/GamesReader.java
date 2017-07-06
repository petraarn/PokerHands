package lt.pokerhands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GamesReader {

    private final List<PokerGame> games = new ArrayList<>();

    public void init() {
        try (BufferedReader br = getGamesFileReader()) {
            String line;
            while ((line = br.readLine()) != null) {
                initGame(line);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Cannot read data file", ex);
        }
    }

    private BufferedReader getGamesFileReader() {
        return new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/poker.txt")));
    }

    void initGame(String line) {
        PokerGame pokerGame = new PokerGame();
        List<Card> cards = readCards(line);
        for (int i = 0; i < cards.size(); i++) {
            pokerGame.addPlayerCard(i / 5, cards.get(i));
        }
        games.add(pokerGame);
    }

    static List<Card> readCards(String line) {
        return Stream.of(line.split(" "))
                .map(GamesReader::parseCard)
                .collect(Collectors.toList());
    }

    static Card parseCard(String cardCode) {
        return new Card(
                CardValue.of(cardCode.charAt(0)),
                CardKind.of(cardCode.charAt(1)));
    }

    public List<PokerGame> getGames() {
        return games;
    }

}
