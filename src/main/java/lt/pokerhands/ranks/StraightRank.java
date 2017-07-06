package lt.pokerhands.ranks;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

import lt.pokerhands.Card;
import lt.pokerhands.CardValue;
import lt.pokerhands.PokerGameHand;
import lt.pokerhands.PokerRank;
import lt.pokerhands.PokerRankUtils;

public class StraightRank implements PokerRank {

    @Override
    public boolean isMatch(PokerGameHand hand) {
        TreeSet<CardValue> sortedHand = hand.getCards()
                .map(Card::getValue)
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));
        return sortedHand.size() == 5 && sortedHand.last().ordinal() - sortedHand.first().ordinal() == 4;
    }

    @Override
    public Comparator<PokerGameHand> getComparator() {
        return PokerRankUtils.HIGH_CARD_COMPARATOR;
    }

}
