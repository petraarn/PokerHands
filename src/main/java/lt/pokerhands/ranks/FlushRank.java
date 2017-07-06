package lt.pokerhands.ranks;

import static lt.pokerhands.PokerRankUtils.HIGH_CARD_COMPARATOR;

import java.util.Comparator;

import lt.pokerhands.Card;
import lt.pokerhands.CardKind;
import lt.pokerhands.PokerGameHand;
import lt.pokerhands.PokerRank;

public class FlushRank implements PokerRank {

    @Override
    public boolean isMatch(PokerGameHand hand) {
        CardKind firstKind = hand.getCard(0).getKind();
        return hand.getCards()
                .map(Card::getKind)
                .filter(firstKind::equals)
                .count() == 5;
    }

    @Override
    public Comparator<PokerGameHand> getComparator() {
        return HIGH_CARD_COMPARATOR;
    }

}
