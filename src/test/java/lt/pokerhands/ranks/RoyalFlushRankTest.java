package lt.pokerhands.ranks;

import static org.junit.Assert.*;

import org.junit.Test;

import lt.pokerhands.RanksTestUtils;

public class RoyalFlushRankTest {

    private final RoyalFlushRank rank = new RoyalFlushRank();

    @Test
    public void testIsMatch() {
        assertTrue(rank.isMatch(RanksTestUtils.createHand("QD TD JD AD KD")));
    }

    @Test
    public void testIsNotMatch() {
        assertFalse(rank.isMatch(RanksTestUtils.createHand("4D 5D 7D 8D 6D")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("9C KC QC JC TC")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("2C 3S 4S 5H 6D")));
    }

}
