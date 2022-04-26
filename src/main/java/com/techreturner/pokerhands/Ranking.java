package com.techreturner.pokerhands;

public enum Ranking {
    STRAIGHT_FLUSH(10),
    FOUR_OF_A_KIND(9),
    FULL_HOUSE(8),
    FLUSH(7),
    STRAIGHT(6),
    THREE_OF_A_KIND(5),
    TWO_PAIRS(4),
    PAIR(3),
    HIGH_CARD(2);

    int score;

    Ranking(int score){
        this.score = score;
    }

}
