package lt.pokerhands;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerGameHand {

    private final Card[] cards = new Card[5];
    private int handSize = 0;

    public PokerGameHand addCard(Card card) {
        if (handSize >= 5) {
            throw new RuntimeException("Hand already contais 5 cards");
        }
        cards[handSize++] = card;
        if (handSize == 5) {
            Arrays.sort(cards, Collections.reverseOrder());
        }
        return this;
    }

    public Stream<Card> getCards() {
        return Stream.of(cards);
    }

    public Card getCard(int index) {
        return cards[index];
    }

    @Override
    public String toString() {
        return getCards().map(Card::toString).collect(Collectors.joining(","));
    }

}
