package lt.pokerhands.ranks;

import java.util.Comparator;

import lt.pokerhands.PokerGameHand;
import lt.pokerhands.PokerRank;
import lt.pokerhands.PokerRankUtils;

public class HighCardRank implements PokerRank {

    @Override
    public boolean isMatch(PokerGameHand hand) {
        return true;
    }

    @Override
    public Comparator<PokerGameHand> getComparator() {
        return PokerRankUtils.HIGH_CARD_COMPARATOR;
    }

}
