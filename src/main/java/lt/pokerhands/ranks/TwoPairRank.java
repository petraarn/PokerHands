package lt.pokerhands.ranks;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lt.pokerhands.Card;
import lt.pokerhands.CardValue;
import lt.pokerhands.PokerGameHand;
import lt.pokerhands.PokerRank;
import lt.pokerhands.PokerRankUtils;

public class TwoPairRank implements PokerRank {

    @Override
    public boolean isMatch(PokerGameHand hand) {
        return hand.getCards()
                .map(Card::getValue)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .values()
                .stream()
                .filter(count -> count.equals(2L))
                .count() == 2;
    }

    @Override
    public Comparator<PokerGameHand> getComparator() {
        return (hand1, hand2) -> {
            List<CardValue> cardsOfPairs1 = getCardsOfPair(hand1);
            List<CardValue> cardsOfPairs2 = getCardsOfPair(hand2);
            int compare = cardsOfPairs1.get(1).compareTo(cardsOfPairs2.get(1));
            if (compare != 0) {
                return compare;
            }
            compare = cardsOfPairs1.get(0).compareTo(cardsOfPairs2.get(0));
            if (compare != 0) {
                return compare;
            }
            return PokerRankUtils.HIGH_CARD_COMPARATOR.compare(hand1, hand2);
        };
    }

    private List<CardValue> getCardsOfPair(PokerGameHand hand1) {
        return hand1.getCards()
                .map(Card::getValue)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(2L))
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }

}
