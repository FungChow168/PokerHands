package com.techreturner.pokerhands;

public class PokerHandsGame {
    private PokerHands handOne;
    private PokerHands handTwo;


    public PokerHandsGame(String handOne, String firstPlayerName, String handTwo, String secondPlayerName){
        this.handOne = new PokerHands(handOne, firstPlayerName);
        this.handTwo = new PokerHands(handTwo, secondPlayerName);
    }

    public String getWinner(){
        String message = "";
        if (handOne.getRanking().score > handTwo.getRanking().score)
            return handOne.getWinningMessage();
        else if (handTwo.getRanking().score > handOne.getRanking().score)
            return handTwo.getWinningMessage();
        else
            return "Tile";
    }

}
