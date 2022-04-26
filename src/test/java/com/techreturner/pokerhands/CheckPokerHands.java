package com.techreturner.pokerhands;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class CheckPokerHands {

    PokerHands hands = new PokerHands("2H 3D 5S 9C KD");

    @Test
    public void checkHandsTest(){
        assertEquals("2H", hands.getHands().get(0).getFullName());
        assertEquals("3D", hands.getHands().get(1).getFullName());
        assertEquals("5S", hands.getHands().get(2).getFullName());
        assertEquals("9C", hands.getHands().get(3).getFullName());
        assertEquals("KD", hands.getHands().get(4).getFullName());
        assertEquals("2H 3D 5S 9C KD", hands.getHandsString());
    }


    @Test
    public void checkRankingTest(){
//        hands = new PokerHands("10D JD QD KD AD");
//        assertEquals(Ranking.STRAIGHT_FLUSH, hands.getRanking());
//        assertEquals(Ranking.STRAIGHT_FLUSH.score, hands.getScore());
        hands = new PokerHands("AD AS AH KD AC");
        assertEquals(Ranking.FOUR_OF_A_KIND, hands.getRanking());
//        assertEquals(Ranking.FOUR_OF_A_KIND.score, hands.getScore());

    }

}
