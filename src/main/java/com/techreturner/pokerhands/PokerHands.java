package com.techreturner.pokerhands;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class PokerHands {

    private Ranking ranking;
    private record pairs (String value, int count){};
    private ArrayList<Card> cards = new ArrayList<>();

    public PokerHands (String cards){
        String [] cardStack = cards.split(" ");
        for (String card: cardStack) {
            this.cards.add(new Card(card.substring(0, card.length() - 1), card.substring(card.length() - 1, card.length())));
        }
        System.out.println(Ranking.STRAIGHT_FLUSH);
    }

    public ArrayList<Card> getHands(){return cards;}

    public Ranking getRanking(){
        ranking = Ranking.FOUR_OF_A_KIND;
        return ranking;
    }

    public String getHandsString(){
        String list = "";
        for (Card card: cards){
            list += card.getFullName() + " ";
        }
        return list.trim();
    }

    private void rankTheHands(){
//        cards.stream().collect(groupingBy(Card::value));
        Map<String, Long> result = cards.stream().map(card -> card.value()).collect(groupingBy(Function.identity(), counting()));
        result = result.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(e->(String) e.getKey(), e->(Long) e.getValue() ));

        System.out.println(result);
//        System.out.println(result.get("K"));

        //works
//        ArrayList<Map.Entry<String, Long>> resultList = new ArrayList<Map.Entry<String, Long>>(result.entrySet());
//        System.out.println(resultList.get(0).getKey());
        // works
        result.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(System.out::println);


    }

    public static void main(String[] args) {
//        PokerHands a = new PokerHands("10D JD QD KD AD");
        PokerHands a = new PokerHands("KH AS AH KD KC");
        a.rankTheHands();

    }


}
