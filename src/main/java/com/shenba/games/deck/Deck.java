package com.shenba.games.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Shenbaga Murugan
 */
public class Deck {

    public static final String[] suits = {"♣", "♦", "♥", "♠"};
    public static final String[] cards = {"Ace", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private static List<String> deck;

    public static List<String> getDeck() {
        if(deck != null) {
            return deck;
        }
        deck = new ArrayList<String>();
        for(String suit : suits) {
            for(String card : cards) {
                deck.add(card + " of " + suit);
            }
        }
        return deck;
    }

}
