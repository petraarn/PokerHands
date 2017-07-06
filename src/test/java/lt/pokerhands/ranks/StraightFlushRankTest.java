package lt.pokerhands.ranks;

import static org.junit.Assert.*;

import org.junit.Test;

import lt.pokerhands.RanksTestUtils;

public class StraightFlushRankTest {

    private final StraightFlushRank rank = new StraightFlushRank();

    @Test
    public void testIsMatch() {
        assertTrue(rank.isMatch(RanksTestUtils.createHand("4D 5D 7D 8D 6D")));
        assertTrue(rank.isMatch(RanksTestUtils.createHand("9C KC QC JC TC")));
    }

    @Test
    public void testIsNotMatch() {
        assertFalse(rank.isMatch(RanksTestUtils.createHand("5C 6C 7C 2C AC")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("5H 6H 7H QH AH")));
        assertFalse(rank.isMatch(RanksTestUtils.createHand("2C 3S 4S 5H 6D")));
    }

}
