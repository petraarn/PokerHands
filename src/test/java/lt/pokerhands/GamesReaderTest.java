package lt.pokerhands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class GamesReaderTest {

    private static final Card EIGHT_OF_HEARTS = new Card(CardValue.EIGHT, CardKind.HEARTS);
    private static final Card FIVE_OF_SPADES = new Card(CardValue.FIVE, CardKind.SPADES);

    @Test
    public void testReadCard() {
        assertEquals(FIVE_OF_SPADES, GamesReader.parseCard("5S"));
        assertEquals(EIGHT_OF_HEARTS, GamesReader.parseCard("8H"));
    }

    @Test
    public void testReadAllCards() {
        StringBuilder line = new StringBuilder();
        for (CardValue cardValue : CardValue.values()) {
            for (CardKind cardKind : CardKind.values()) {
                line.append(cardValue.code)
                        .append(cardKind.code)
                        .append(" ");
            }
        }
        List<Card> cards = GamesReader.readCards(line.toString());
        assertEquals(52, cards.size());
        assertTrue(cards.indexOf(FIVE_OF_SPADES) > 0);
        assertTrue(cards.indexOf(EIGHT_OF_HEARTS) > 0);
    }

    @Test
    public void testInitGame() {
        GamesReader gamesReader = new GamesReader();
        gamesReader.initGame("5H 5C 6S 7S KD 2C 3S 8S 8D TD");
        gamesReader.initGame("5D 8C 9S JS AC 2C 5C 7D 8S QH");
        gamesReader.initGame("2D 9C AS AH AC 3D 6D 7D TD QD");
        gamesReader.getGames().forEach(game -> {
            assertEquals(5, game.getPlayerHand(0).getCards().count());
            assertEquals(5, game.getPlayerHand(1).getCards().count());
        });
    }

}
