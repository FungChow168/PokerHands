package com.techreturner.pokerhands;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CheckCardTest {

    Card card = new Card("2","S");

    @Test
    public void checkValueTest() {
        assertEquals("2", card.value());
        assertEquals("S", card.suit());
        assertEquals("2S", card.getFullName());
    }
}
