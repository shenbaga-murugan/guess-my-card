package com.shenba.games.service;

import com.shenba.games.deck.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GuessMyCardService {

    public static List<ArrayList<String>> deal(List<String> cards, int count) {
        List<ArrayList<String>> deals = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < count; i++) {
            deals.add(new ArrayList<String>());
        }
        for(int i = 0; i < cards.size(); i = i + count) {
            for(int j = 0; j < count; j++) {
                deals.get(j).add(cards.get(j + i));
            }
        }
        return deals;
    }

    public static List<String> putSetInMiddle(List<ArrayList<String>> deals, int setToPutInMiddle) {
        List<String> cards = new ArrayList<String>();
        cards.addAll(deals.remove(setToPutInMiddle));
        for(int i = 0; i < deals.size(); i++) {
            if(i % 2 == 0) {
                cards.addAll(deals.get(i));
            } else {
                cards.addAll(0, deals.get(i));
            }
        }
        return cards;
    }

    public static List<String> getRandomCards(int count) {
        List<String> shuffledDeck = new ArrayList<String>();
        shuffledDeck.addAll(Deck.getDeck());
        Collections.shuffle(shuffledDeck);
        return shuffledDeck.subList(0, count);
    }
}
