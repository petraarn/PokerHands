package lt.pokerhands.ranks;

import lt.pokerhands.CardValue;
import lt.pokerhands.PokerGameHand;

public class RoyalFlushRank extends StraightFlushRank {

    @Override
    public boolean isMatch(PokerGameHand hand) {
        return super.isMatch(hand) && hand.getCard(0).getValue() == CardValue.ACE;
    }

}
