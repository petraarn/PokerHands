package lt.pokerhands.ranks;

import static org.junit.Assert.*;

import org.junit.Test;

import lt.pokerhands.RanksTestUtils;

public class ThreeOfAKindRankTest {

    private static final String THREE_OF_5S = "5C 5S 7S AH 5D";
    private static final String THREE_OF_ACES = "AC 5S AS QH AD";

    private final ThreeOfAKindRank rank = new ThreeOfAKindRank();

    @Test
    public void testIsMatch() {
        assertTrue(rank.isMatch(RanksTestUtils.createHand(THREE_OF_5S)));
        assertTrue(rank.isMatch(RanksTestUtils.createHand(THREE_OF_ACES)));
    }

    @Test
    public void testIsNotMatch() {
        assertFalse(rank.isMatch(RanksTestUtils.createHand("5C 5S 7S 7H AD")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("5C 6S 7S QH AD")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("QC 6S QS QH QD")));
    }

    @Test
    public void testComparatorLess() {
        assertTrue(rank.getComparator().compare(RanksTestUtils.createHand(THREE_OF_5S),
                        RanksTestUtils.createHand(THREE_OF_ACES)) < 0);

    }

    @Test
    public void testComparatorMore() {
        assertTrue(rank.getComparator().compare(RanksTestUtils.createHand(THREE_OF_ACES),
                RanksTestUtils.createHand(THREE_OF_5S)) > 0);
    }

}
