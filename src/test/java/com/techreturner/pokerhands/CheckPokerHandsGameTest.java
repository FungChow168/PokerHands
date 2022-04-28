package com.techreturner.pokerhands;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CheckPokerHandsGameTest {

    PokerHandsGame game;

    @Test
    public void checkSuggestedTestCasesTest(){
        game = new PokerHandsGame("2H 3D 5S 9C KD", "Black", "2C 3H 4S 8C AH", "White");
        assertEquals("White wins. - with high card", game.getWinner());
        game = new PokerHandsGame("2H 4S 4C 2D 4H", "Black", "2S 8S AS QS 3S", "White");
        assertEquals("Black wins. - with full house.", game.getWinner());
        game = new PokerHandsGame("2H 3D 5S 9C KD", "Black", "2C 3H 4S 8C KH", "White");
        assertEquals("Black wins. - with high card", game.getWinner());
        game = new PokerHandsGame("2H 3D 5S 9C KD", "Black", "2D 3H 5C 9S KH", "White");
        assertEquals("Tile", game.getWinner());
    }

    @Test
    public void checkStraightFlushVSFourOfAKind(){
        game = new PokerHandsGame("AS JS KS 10S QS", "Black", "9H 9D 7S 9S 9C", "White");
        assertEquals("Black wins. - with straight flush.", game.getWinner());
    }

    @Test
    public void checkStraightFlushVSStraightFlushSameStraightDiffSuit() {
        game = new PokerHandsGame("AS JS KS 10S QS", "Black", "KD 10D JD QD AD", "White");
        assertEquals("Tile", game.getWinner());
    }

    @Test
    public void checkFourOfAKindVSStraightFlush() {
        game = new PokerHandsGame("3D AS 3H 3S 3C", "Black", "9D 10D 6D 8D 7D", "White");
        assertEquals("White wins. - with straight flush.", game.getWinner());
    }

    @Test
    public void checkFourOfAKindVSFlush() {
        game = new PokerHandsGame("3D AS 3H 3S 3C", "Black", "2D 10D KD 8D 7D", "White");
        assertEquals("Black wins. - with four of a kind.", game.getWinner());
    }

    @Test
    public void checkStraightVSThreeOfAKind(){
        game = new PokerHandsGame("AS JS KH 10S QD", "Black", "7D 6S 6D QD 6H", "White");
        assertEquals("Black wins. - with straight.", game.getWinner());
    }

    @Test
    public void checkTwoPairsVSTwoPairsSameTwoPairsDiffHighCard(){
        game = new PokerHandsGame("3S 4S 4H 3C 6D", "Black", "4C 8S 4D 3D 3H", "White");
        assertEquals("White wins. - with two pairs.", game.getWinner());
    }

    @Test
    public void checkHighCardVSHighCardTile(){
        game = new PokerHandsGame("2C 9H 10C JD QC", "Black", "2D 9S 10D JC QD", "White");
        assertEquals("Tile", game.getWinner());
    }

    @Test
    public void checkHighCardVSHighCard(){
        game = new PokerHandsGame("2C 9C 8S JC QH", "Black", "2D 3D 10H JH QD", "White");
        assertEquals("White wins. - with high card", game.getWinner());
    }

}
