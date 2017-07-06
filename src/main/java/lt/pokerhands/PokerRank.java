package lt.pokerhands;

import java.util.Comparator;

public interface PokerRank {

    boolean isMatch(PokerGameHand hand);

    Comparator<PokerGameHand> getComparator();

}
