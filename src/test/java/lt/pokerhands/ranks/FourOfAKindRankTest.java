package lt.pokerhands.ranks;

import static org.junit.Assert.*;

import org.junit.Test;

import lt.pokerhands.RanksTestUtils;

public class FourOfAKindRankTest {

    private static final String FOUR_OF_5S = "5C 5S 7S 5H 5D";
    private static final String FOUR_OF_ACES = "AC 5S AS AH AD";

    FourOfAKindRank rank = new FourOfAKindRank();

    @Test
    public void testIsMatch() {
        assertTrue(rank.isMatch(RanksTestUtils.createHand(FOUR_OF_5S)));
        assertTrue(rank.isMatch(RanksTestUtils.createHand(FOUR_OF_ACES)));
    }

    @Test
    public void testIsNotMatch() {
        assertFalse(rank.isMatch(RanksTestUtils.createHand("5C 5S 7S 7H AD")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("5C 6S 7S QH AD")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("QC 6S QS 2H QD")));
    }

    @Test
    public void testComparatorLess() {
        assertTrue(rank.getComparator().compare(RanksTestUtils.createHand(FOUR_OF_5S),
                        RanksTestUtils.createHand(FOUR_OF_ACES)) < 0);

    }

    @Test
    public void testComparatorMore() {
        assertTrue(rank.getComparator().compare(RanksTestUtils.createHand(FOUR_OF_ACES),
                RanksTestUtils.createHand(FOUR_OF_5S)) > 0);
    }

}
