package lt.pokerhands.ranks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lt.pokerhands.RanksTestUtils;

public class TwoPairRankTest {

    private static final String PAIRS_OF_5S_AND_ACES = "5C 5S AS QH AD";
    private static final String PAIRS_OF_5S_AND_7S_ACE_HIGH = "7C 7S AS 5H 5D";
    private static final String PAIRS_OF_5S_AND_7S_TEN_HIGH = "5C 5S 7S 7H TD";
    private static final String PAIRS_OF_5S_AND_7S_TEN_HIGH2 = "7C 7S TS 5H 5D";

    private final TwoPairRank rank = new TwoPairRank();

    @Test
    public void testIsMatch() {
        assertTrue(rank.isMatch(RanksTestUtils.createHand(PAIRS_OF_5S_AND_7S_ACE_HIGH)));
        assertTrue(rank.isMatch(RanksTestUtils.createHand(PAIRS_OF_5S_AND_ACES)));
        assertTrue(rank.isMatch(RanksTestUtils.createHand(PAIRS_OF_5S_AND_7S_TEN_HIGH)));
        assertTrue(rank.isMatch(RanksTestUtils.createHand(PAIRS_OF_5S_AND_7S_TEN_HIGH2)));
    }

    @Test
    public void testIsNotMatch() {
        assertFalse(rank.isMatch(RanksTestUtils.createHand("5C 5S 7S QH 5D")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("5C 6S 7S QH AD")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("QC 6S QS QH QD")));
    }

    @Test
    public void testComparatorLess() {
        assertTrue("Equal pair",
                rank.getComparator().compare(RanksTestUtils.createHand(PAIRS_OF_5S_AND_7S_TEN_HIGH),
                        RanksTestUtils.createHand(PAIRS_OF_5S_AND_7S_ACE_HIGH)) < 0);
        assertTrue("Not equal pair",
                rank.getComparator().compare(RanksTestUtils.createHand(PAIRS_OF_5S_AND_7S_ACE_HIGH),
                        RanksTestUtils.createHand(PAIRS_OF_5S_AND_ACES)) < 0);
    }

    @Test
    public void testComparatorMore() {
        assertTrue("Equal pair",
                rank.getComparator().compare(RanksTestUtils.createHand(PAIRS_OF_5S_AND_7S_ACE_HIGH),
                        RanksTestUtils.createHand(PAIRS_OF_5S_AND_7S_TEN_HIGH)) > 0);
        assertTrue("Not equal pair",
                rank.getComparator().compare(RanksTestUtils.createHand(PAIRS_OF_5S_AND_ACES),
                        RanksTestUtils.createHand(PAIRS_OF_5S_AND_7S_ACE_HIGH)) > 0);
    }

    @Test
    public void testComparatorEqual() {
        assertTrue("Equal pair",
                rank.getComparator().compare(RanksTestUtils.createHand(PAIRS_OF_5S_AND_7S_TEN_HIGH),
                        RanksTestUtils.createHand(PAIRS_OF_5S_AND_7S_TEN_HIGH2)) == 0);
    }

}
