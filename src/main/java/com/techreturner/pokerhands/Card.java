package com.techreturner.pokerhands;

public record Card (String value, String suit){
    public String getFullName(){
        return value + suit;
    }
}
