package lt.pokerhands.ranks;

import static org.junit.Assert.*;

import org.junit.Test;

import lt.pokerhands.RanksTestUtils;

public class FullHouseRankTest {

    private final FullHouseRank rank = new FullHouseRank();

    @Test
    public void testIsMatch() {
        assertTrue(rank.isMatch(RanksTestUtils.createHand("5C 5S 7S 7H 5D")));
        assertTrue(rank.isMatch(RanksTestUtils.createHand("AC QS AS QH AD")));
    }

    @Test
    public void testIsNotMatch() {
        assertFalse(rank.isMatch(RanksTestUtils.createHand("5C 5S 7S 7H AD")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("5C 6S 7S QH AD")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("QC 6S QS QH QD")));
    }

}
