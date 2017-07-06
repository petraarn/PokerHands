package lt.pokerhands.ranks;

import java.util.Comparator;
import java.util.stream.Collectors;

import lt.pokerhands.Card;
import lt.pokerhands.PokerGameHand;
import lt.pokerhands.PokerRank;
import lt.pokerhands.PokerRankUtils;

public class FullHouseRank implements PokerRank {

    @Override
    public boolean isMatch(PokerGameHand hand) {
        return hand.getCards()
                .map(Card::getValue)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .values()
                .stream()
                .filter(count -> count.equals(3L) || count.equals(2L))
                .collect(Collectors.toSet())
                .size() == 2;
    }

    @Override
    public Comparator<PokerGameHand> getComparator() {
        return (hand1, hand2) -> {
            return PokerRankUtils.getRepeatedCards(hand1, 3L).compareTo(PokerRankUtils.getRepeatedCards(hand2, 3L));
        };
    }

}
