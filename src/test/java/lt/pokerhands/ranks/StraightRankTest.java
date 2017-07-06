package lt.pokerhands.ranks;

import static org.junit.Assert.*;

import org.junit.Test;

import lt.pokerhands.RanksTestUtils;

public class StraightRankTest {

    private static final String STRAIGHT_TO_8 = "4C 5S 7S 8H 6D";
    private static final String STRAIGHT_TO_ACE = "AC KS QS JH TD";

    private final StraightRank rank = new StraightRank();

    @Test
    public void testIsMatch() {
        assertTrue(rank.isMatch(RanksTestUtils.createHand(STRAIGHT_TO_8)));
        assertTrue(rank.isMatch(RanksTestUtils.createHand(STRAIGHT_TO_ACE)));
    }

    @Test
    public void testIsNotMatch() {
        assertFalse(rank.isMatch(RanksTestUtils.createHand("8D 8S 6S 6C 4C")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("5C 5S 7S 7H AD")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("5C 6S 7S QH AD")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("QC 6S QS QH QD")));
    }

    @Test
    public void testComparatorLess() {
        assertTrue(rank.getComparator().compare(RanksTestUtils.createHand(STRAIGHT_TO_8),
                        RanksTestUtils.createHand(STRAIGHT_TO_ACE)) < 0);

    }

}
