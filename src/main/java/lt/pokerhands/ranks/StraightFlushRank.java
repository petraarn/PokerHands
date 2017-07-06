package lt.pokerhands.ranks;

import lt.pokerhands.PokerGameHand;

public class StraightFlushRank extends FlushRank {

    private final StraightRank straightRank = new StraightRank();
    private final FlushRank flushRank = new FlushRank();

    @Override
    public boolean isMatch(PokerGameHand hand) {
        return straightRank.isMatch(hand) && flushRank.isMatch(hand);
    }

}
