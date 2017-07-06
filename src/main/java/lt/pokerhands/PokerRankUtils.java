package lt.pokerhands;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerRankUtils {

    public static Comparator<PokerGameHand> HIGH_CARD_COMPARATOR = (h1, h2) -> {
        for (int i = 0; i < 5; i++) {
            int compare = h1.getCard(i).compareTo(h2.getCard(i));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    };

    public static CardValue getRepeatedCards(PokerGameHand hand, Long repeatTimes) {
        return hand.getCards()
                .map(Card::getValue)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(repeatTimes))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }
}
