package com.techreturner.pokerhands;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
    public void checkStrightFlushTest() {
        hands = new PokerHands("3D 5D 2D 4D AD");
        assertEquals(Ranking.STRAIGHT_FLUSH, hands.getRanking());
        hands = new PokerHands("JD 10D QD AD KD");
        assertEquals(Ranking.STRAIGHT_FLUSH, hands.getRanking());
        hands = new PokerHands("JD 10D 3D AD KD");
        assertNotEquals(Ranking.STRAIGHT_FLUSH, hands.getRanking());
   }

    @Test
    public void checkRankingFourOfAKindTest(){
        hands = new PokerHands("AD AS AH KD AC");
        assertEquals(Ranking.FOUR_OF_A_KIND, hands.getRanking());
        hands = new PokerHands("3D AS 3H 3S 3C");
        assertEquals(Ranking.FOUR_OF_A_KIND, hands.getRanking());
        hands = new PokerHands("3D AS AH 3S 3C");
        assertNotEquals(Ranking.FOUR_OF_A_KIND.score, hands.getRanking());
    }

    @Test
    public void checkFlushTest(){
        hands = new PokerHands("AD 3D KD 5D 7D");
        assertEquals(Ranking.FLUSH, hands.getRanking());
        hands = new PokerHands("QS 9S 8S 3S AS");
        assertEquals(Ranking.FLUSH, hands.getRanking());
        hands = new PokerHands("3D AS AH 3S 2C");
        assertNotEquals(Ranking.FLUSH, hands.getRanking());
    }

    @Test
    public void checkStraightTest(){
        hands = new PokerHands("AD 3S 2D 5C 4D");
        assertEquals(Ranking.STRAIGHT, hands.getRanking());
        hands = new PokerHands("QS 9S 8S 10C JD");
        assertEquals(Ranking.STRAIGHT, hands.getRanking());
        hands = new PokerHands("3D AS AH 3S 2C");
        assertNotEquals(Ranking.STRAIGHT, hands.getRanking());
    }

    @Test
    public void checkThreeOfAKindTest(){
        hands = new PokerHands("AD AS 2D AC 4D");
        assertEquals(Ranking.THREE_OF_A_KIND, hands.getRanking());
        hands = new PokerHands("10S 9S 8S 10C 10D");
        assertEquals(Ranking.THREE_OF_A_KIND, hands.getRanking());
        hands = new PokerHands("3D AS AH 3S 2C");
        assertNotEquals(Ranking.THREE_OF_A_KIND, hands.getRanking());
    }

    @Test
    public void checkTwoPairsTest(){
        hands = new PokerHands("AD 2S 2D AC 4D");
        assertEquals(Ranking.TWO_PAIRS, hands.getRanking());
        hands = new PokerHands("10S 9S 8S 10C 9D");
        assertEquals(Ranking.TWO_PAIRS, hands.getRanking());
        hands = new PokerHands("3D AS 9H 3S 2C");
        assertNotEquals(Ranking.TWO_PAIRS, hands.getRanking());
    }

    @Test
    public void checkOnePairTest(){
        hands = new PokerHands("AD 2S 2D 7C 4D");
        assertEquals(Ranking.PAIR, hands.getRanking());
        hands = new PokerHands("10S 9S 8S KC 9D");
        assertEquals(Ranking.PAIR, hands.getRanking());
        hands = new PokerHands("3D AS 9H 7S 2C");
        assertNotEquals(Ranking.PAIR, hands.getRanking());
    }

    @Test
    public void checkHighCardTest(){
        hands = new PokerHands("AD 2S JD 7C 4D");
        assertEquals(Ranking.HIGH_CARD, hands.getRanking());
        hands = new PokerHands("10S 9S 8S KC 2D");
        assertEquals(Ranking.HIGH_CARD, hands.getRanking());
        hands = new PokerHands("3D AS 9H 7S AC");
        assertNotEquals(Ranking.HIGH_CARD, hands.getRanking());
    }

}
