package lt.pokerhands.ranks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lt.pokerhands.RanksTestUtils;

public class OnePairRankTest {

    static final String PAIR_OF_8S_TEN_HIGH = "2C 3S 8S 8D TD";
    static final String PAIR_OF_5S_KING_HIGH_7_SECOND_6 = "5H 5C 6S 7S KD";
    static final String PAIR_OF_5S_KING_HIGH_7_SECOND_2 = "KH 2C 5S 7S 5D";
    static final String PAIR_OF_5S_QUEEN_HIGH = "QH 2C 5S 7S 5D";

    private final OnePairRank rank = new OnePairRank();

    @Test
    public void testIsMatch() {
        assertTrue(rank.isMatch(RanksTestUtils.createHand(PAIR_OF_8S_TEN_HIGH)));
        assertTrue(rank.isMatch(RanksTestUtils.createHand(PAIR_OF_5S_KING_HIGH_7_SECOND_6)));
        assertTrue(rank.isMatch(RanksTestUtils.createHand(PAIR_OF_5S_KING_HIGH_7_SECOND_2)));
        assertTrue(rank.isMatch(RanksTestUtils.createHand(PAIR_OF_5S_QUEEN_HIGH)));
        assertTrue(rank.isMatch(RanksTestUtils.createHand("AD AS QS 8H 2H")));
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
                rank.getComparator().compare(RanksTestUtils.createHand(PAIR_OF_5S_QUEEN_HIGH),
                        RanksTestUtils.createHand(PAIR_OF_5S_KING_HIGH_7_SECOND_6)) < 0);
        assertTrue("Not equal pair",
                rank.getComparator().compare(RanksTestUtils.createHand(PAIR_OF_5S_KING_HIGH_7_SECOND_6),
                        RanksTestUtils.createHand(PAIR_OF_8S_TEN_HIGH)) < 0);
        assertTrue("Secound high card",
                rank.getComparator().compare(RanksTestUtils.createHand(PAIR_OF_5S_KING_HIGH_7_SECOND_2),
                        RanksTestUtils.createHand(PAIR_OF_5S_KING_HIGH_7_SECOND_6)) < 0);
    }

    @Test
    public void testComparatorMore() {
        assertTrue("Equal pair",
                rank.getComparator().compare(RanksTestUtils.createHand(PAIR_OF_5S_KING_HIGH_7_SECOND_6),
                        RanksTestUtils.createHand(PAIR_OF_5S_QUEEN_HIGH)) > 0);
        assertTrue("Not equal pair",
                rank.getComparator().compare(RanksTestUtils.createHand(PAIR_OF_8S_TEN_HIGH),
                        RanksTestUtils.createHand(PAIR_OF_5S_KING_HIGH_7_SECOND_6)) > 0);
        assertTrue("Second high card",
                rank.getComparator().compare(RanksTestUtils.createHand(PAIR_OF_5S_KING_HIGH_7_SECOND_6),
                        RanksTestUtils.createHand(PAIR_OF_5S_KING_HIGH_7_SECOND_2)) > 0);
    }

}
