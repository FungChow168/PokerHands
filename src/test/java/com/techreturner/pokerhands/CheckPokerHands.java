package com.techreturner.pokerhands;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CheckPokerHands {

    PokerHands hands = new PokerHands("2H 3D 5S 9C KD", "Black");

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
        hands = new PokerHands("3D 5D 2D 4D AD", "Black");
        assertEquals(Ranking.STRAIGHT_FLUSH, hands.getRanking());
        assertEquals("Black wins. - with straight flush.", hands.getWinningMessage());
        hands = new PokerHands("JD 10D QD AD KD", "Black");
        assertEquals(Ranking.STRAIGHT_FLUSH, hands.getRanking());
        hands = new PokerHands("JD 10D 3D AD KD", "Black");
        assertNotEquals(Ranking.STRAIGHT_FLUSH, hands.getRanking());
   }

    @Test
    public void checkRankingFourOfAKindTest(){
        hands = new PokerHands("AD AS AH KD AC", "Black");
        assertEquals(Ranking.FOUR_OF_A_KIND, hands.getRanking());
        assertEquals("Black wins. - with four of a kind.", hands.getWinningMessage());
        hands = new PokerHands("3D AS 3H 3S 3C", "Black");
        assertEquals(Ranking.FOUR_OF_A_KIND, hands.getRanking());
        hands = new PokerHands("3D AS AH 3S 3C", "Black");
        assertNotEquals(Ranking.FOUR_OF_A_KIND.score, hands.getRanking());
    }

    @Test
    public void checkFlushTest(){
        hands = new PokerHands("AD 3D KD 5D 7D", "Black");
        assertEquals(Ranking.FLUSH, hands.getRanking());
        assertEquals("Black wins. - with flush.", hands.getWinningMessage());
        hands = new PokerHands("QS 9S 8S 3S AS", "Black");
        assertEquals(Ranking.FLUSH, hands.getRanking());
        hands = new PokerHands("3D AS AH 3S 2C", "Black");
        assertNotEquals(Ranking.FLUSH, hands.getRanking());
    }

    @Test
    public void checkStraightTest(){
        hands = new PokerHands("AD 3S 2D 5C 4D", "Black");
        assertEquals(Ranking.STRAIGHT, hands.getRanking());
        assertEquals("Black wins. - with straight.", hands.getWinningMessage());
        hands = new PokerHands("QS 9S 8S 10C JD", "Black");
        assertEquals(Ranking.STRAIGHT, hands.getRanking());
        hands = new PokerHands("3D AS AH 3S 2C", "Black");
        assertNotEquals(Ranking.STRAIGHT, hands.getRanking());
    }

    @Test
    public void checkThreeOfAKindTest(){
        hands = new PokerHands("AD AS 2D AC 4D", "Black");
        assertEquals(Ranking.THREE_OF_A_KIND, hands.getRanking());
        assertEquals("Black wins. - with three of a kind.", hands.getWinningMessage());
        hands = new PokerHands("10S 9S 8S 10C 10D", "Black");
        assertEquals(Ranking.THREE_OF_A_KIND, hands.getRanking());
        hands = new PokerHands("3D AS AH 3S 2C", "Black");
        assertNotEquals(Ranking.THREE_OF_A_KIND, hands.getRanking());
    }

    @Test
    public void checkTwoPairsTest(){
        hands = new PokerHands("AD 2S 2D AC 4D", "Black");
        assertEquals(Ranking.TWO_PAIRS, hands.getRanking());
        assertEquals("Black wins. - with two pairs.", hands.getWinningMessage());
        hands = new PokerHands("10S 9S 8S 10C 9D", "Black");
        assertEquals(Ranking.TWO_PAIRS, hands.getRanking());
        hands = new PokerHands("3D AS 9H 3S 2C", "Black");
        assertNotEquals(Ranking.TWO_PAIRS, hands.getRanking());
    }

    @Test
    public void checkOnePairTest(){
        hands = new PokerHands("AD 2S 2D 7C 4D", "Black");
        assertEquals(Ranking.PAIR, hands.getRanking());
        assertEquals("Black wins. - with pair.", hands.getWinningMessage());
        hands = new PokerHands("10S 9S 8S KC 9D", "Black");
        assertEquals(Ranking.PAIR, hands.getRanking());
        hands = new PokerHands("3D AS 9H 7S 2C", "Black");
        assertNotEquals(Ranking.PAIR, hands.getRanking());
    }

    @Test
    public void checkHighCardTest(){
        hands = new PokerHands("AD 2S JD 7C 4D", "Black");
        assertEquals(Ranking.HIGH_CARD, hands.getRanking());
        assertEquals("Black wins. - with high card", hands.getWinningMessage());
        hands = new PokerHands("10S 9S 8S KC 2D", "Black");
        assertEquals(Ranking.HIGH_CARD, hands.getRanking());
        hands = new PokerHands("3D AS 9H 7S AC", "Black");
        assertNotEquals(Ranking.HIGH_CARD, hands.getRanking());
    }

}
