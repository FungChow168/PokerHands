package com.techreturner.pokerhands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckRankingTest {

    @Test
    public void checkRankingScore(){
        assertEquals(10, Ranking.STRAIGHT_FLUSH.score);
        assertEquals(9, Ranking.FOUR_OF_A_KIND.score);
        assertEquals(8, Ranking.FULL_HOUSE.score);
        assertEquals(7, Ranking.FLUSH.score);
        assertEquals(6, Ranking.STRAIGHT.score);
        assertEquals(5, Ranking.THREE_OF_A_KIND.score);
        assertEquals(4, Ranking.TWO_PAIRS.score);
        assertEquals(3, Ranking.PAIR.score);
        assertEquals(2, Ranking.HIGH_CARD.score);

    }
}
