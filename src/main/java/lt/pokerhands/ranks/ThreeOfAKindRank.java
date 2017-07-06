package lt.pokerhands.ranks;

import java.util.Comparator;
import java.util.stream.Collectors;

import lt.pokerhands.Card;
import lt.pokerhands.PokerGameHand;
import lt.pokerhands.PokerRank;
import lt.pokerhands.PokerRankUtils;

public class ThreeOfAKindRank implements PokerRank {

    @Override
    public boolean isMatch(PokerGameHand hand) {
        return hand.getCards()
                .map(Card::getValue)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .values()
                .contains(3L);
    }

    @Override
    public Comparator<PokerGameHand> getComparator() {
        return (hand1, hand2) -> {
            return PokerRankUtils.getRepeatedCards(hand1, 3L).compareTo(PokerRankUtils.getRepeatedCards(hand2, 3L));
        };
    }

}
