package lt.pokerhands;

public class RanksTestUtils {

    public static PokerGameHand createHand(String cardsLine) {
        PokerGameHand hand = new PokerGameHand();
        GamesReader.readCards(cardsLine).forEach(hand::addCard);
        return hand;
    }
}
