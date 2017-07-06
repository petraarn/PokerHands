package lt.pokerhands.ranks;

import static org.junit.Assert.*;

import org.junit.Test;

import lt.pokerhands.RanksTestUtils;

public class FlushRankTest {

    private final FlushRank rank = new FlushRank();

    @Test
    public void testIsMatch() {
        assertTrue(rank.isMatch(RanksTestUtils.createHand("4C 5C 7C 8C 6C")));
        assertTrue(rank.isMatch(RanksTestUtils.createHand("AD KD 4D JD 7D")));
    }

    @Test
    public void testIsNotMatch() {
        assertFalse(rank.isMatch(RanksTestUtils.createHand("5S 5S 7S 7H AD")));
    }

}
