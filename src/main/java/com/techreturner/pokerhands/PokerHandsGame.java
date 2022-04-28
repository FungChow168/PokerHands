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
            return compareSameRanking();
    }

    private String compareSameRanking(){
        for(int i= handOne.getCardCountByValue().size() -1; i>=0; i--){
            if(handOne.getCardCountByValue().get(i).rank() >  handTwo.getCardCountByValue().get(i).rank()){
                return handOne.getWinningMessage();
            }else if (handOne.getCardCountByValue().get(i).rank() <  handTwo.getCardCountByValue().get(i).rank()){
                return handTwo.getWinningMessage();
            }
        }
        return "Tile";
    }

}
