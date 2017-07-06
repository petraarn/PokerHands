package lt.pokerhands.ranks;

import java.util.Comparator;
import java.util.stream.Collectors;

import lt.pokerhands.Card;
import lt.pokerhands.CardValue;
import lt.pokerhands.PokerGameHand;
import lt.pokerhands.PokerRank;
import lt.pokerhands.PokerRankUtils;

public class OnePairRank implements PokerRank {

    @Override
    public boolean isMatch(PokerGameHand hand) {
        return hand.getCards().map(Card::getValue).collect(Collectors.toSet()).size() == 4;
    }

    @Override
    public Comparator<PokerGameHand> getComparator() {
        return (hand1, hand2) -> {
            CardValue cardOfPair1 = PokerRankUtils.getRepeatedCards(hand1, 2L);
            CardValue cardOfPair2 = PokerRankUtils.getRepeatedCards(hand2, 2L);
            int cardPairComparison = cardOfPair1.compareTo(cardOfPair2);
            return cardPairComparison == 0
                    ? PokerRankUtils.HIGH_CARD_COMPARATOR.compare(hand1, hand2)
                    : cardPairComparison;
        };
    }

}
