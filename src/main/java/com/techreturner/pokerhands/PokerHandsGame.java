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

    public static void main(String[] args) {
        PokerHandsGame  a = new PokerHandsGame("2C 9C 8S JC QH", "Black",
                "2D 3D 10H JH QD", "White");
//        PokerHandsGame  a = new PokerHandsGame("3S 4S 4H 3C 6D", "Black",
//                "4C 8S 4D 3D 3H", "White");
        System.out.println(a.getWinner());
    }

}
