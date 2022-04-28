package com.techreturner.pokerhands;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class PokerHands {

    private String playerName, winningMessage;
    private Ranking ranking;
    private boolean isFlush = false;
    private boolean isStraight = false;
    private record pairs (String value, int count){};
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<CardCount> cardCountByValue = new ArrayList<>();
    private Map<String, Long> cardCountBySuit ;

    public PokerHands (String cards, String playerName){
        this.playerName = playerName;
        String [] cardStack = cards.split(" ");
        for (String card: cardStack) {
            this.cards.add(new Card(card.substring(0, card.length() - 1), card.substring(card.length() - 1, card.length())));
        }
        rankTheHands();
    }

    public String getPlayerName(){return playerName;}

    public String getWinningMessage(){return winningMessage;}

    public ArrayList<Card> getHands(){return cards;}

    public ArrayList<CardCount> getCardCountByValue(){return cardCountByValue;};

    public Ranking getRanking(){
        return ranking;
    }

    public String getHandsString(){
        String list = "";
        for (Card card: cards){
            list += card.getFullName() + " ";
        }
        return list.trim();
    }

    private Ranking rankTheHands(){
        cardCountBySuit = cards.stream().map(card -> card.suit()).collect(groupingBy(Function.identity(), counting()));
        Map<String, Long> result = cards.stream().map(card -> card.value()).collect(groupingBy(Function.identity(), counting()));
        result.forEach((k,v)-> cardCountByValue.add(new CardCount(k, convertToHighCardRanking(k), (int)(long)v)));

        Comparator<CardCount> comparator = Comparator.comparing(CardCount::count)
                .thenComparing(CardCount::rank);
        cardCountByValue.sort(comparator);

        if (cardCountBySuit.size() == 1)
            isFlush = true;



        switch (cardCountByValue.size()){
            case 2 -> {if ((int) cardCountByValue.get(cardCountByValue.size()-1).count() == 4) {
                         ranking = Ranking.FOUR_OF_A_KIND;
                         winningMessage = String.format("%s wins. - with four of a kind.", playerName);
                      }else{
                          ranking = Ranking.FULL_HOUSE;
                          winningMessage = String.format("%s wins. - with full house.", playerName);
                      }
                      break;}
            case 3 -> { if ((int) cardCountByValue.get(cardCountByValue.size()-1).count() == 3){
                            ranking = Ranking.THREE_OF_A_KIND;
                           winningMessage = String.format("%s wins. - with three of a kind.", playerName);
                        }else {
                            ranking = Ranking.TWO_PAIRS;
                            winningMessage = String.format("%s wins. - with two pairs.", playerName);
                        }
                        break;}
            case 4 -> {ranking = Ranking.PAIR;
                        winningMessage = String.format("%s wins. - with pair.", playerName);
                        break;}
            case 5 -> {isStraight();
                        if(isStraight && isFlush) {
                            ranking = Ranking.STRAIGHT_FLUSH;
                            winningMessage = String.format("%s wins. - with straight flush.", playerName);
                        }else if (isFlush) {
                            ranking = Ranking.FLUSH;
                            winningMessage = String.format("%s wins. - with flush.", playerName);
                        }else if (isStraight) {
                            ranking = Ranking.STRAIGHT;
                            winningMessage = String.format("%s wins. - with straight.", playerName);
                        }else {
                            ranking = Ranking.HIGH_CARD;
                            winningMessage = String.format("%s wins. - with high card", playerName);
                        }
                        break;}
            default -> throw new IllegalArgumentException();
        }
        return ranking;
    }

    private void isStraight(){
        ArrayList <String> oddCase = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "A"));
        ArrayList <String> cardValueOnly = new ArrayList<>();
        for (int i =0; i < oddCase.size(); i++)
            cardValueOnly.add(cardCountByValue.get(i).cardValue());
        if (oddCase.equals(cardValueOnly)) {
            isStraight = true;
        }else{
            for(int i=0; i<= cardCountByValue.size()-2; i++)
                if (cardCountByValue.get(i).rank()+1 != cardCountByValue.get(i+1).rank())
                    break;
                else if (i == cardCountByValue.size()-2)
                    isStraight = true;
        }
    }

    private int convertToHighCardRanking(String value){
        return
                switch(value){
                    case "A"-> 14;
                    case "K"-> 13;
                    case "Q"-> 12;
                    case "J"-> 11;
                    case "10"-> 10;
                    case "9"-> 9;
                    case "8"-> 8;
                    case "7"-> 7;
                    case "6"-> 6;
                    case "5"-> 5;
                    case "4"-> 4;
                    case "3"-> 3;
                    case "2"-> 2;
                    default -> throw new IllegalArgumentException();
                };

    }

}
