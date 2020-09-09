package com.shenba.games;

import com.shenba.games.service.GuessMyCardService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Shenbaga Murugan
 */
public class GuessMyCard {
    public static void main(String[] args) throws IOException {
        int size = 15;
        int count = (size / (3 * 2)) + 1;
        List<String> cards = GuessMyCardService.getRandomCards(size);
        List<ArrayList<String>> deals;
        int set;

        System.out.print("Choose a card from below and keep it in your mind:\n");
        cards.forEach(e -> System.out.print("[" + e + "] "));
        System.out.println();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Guessed? Hit enter to continue!\n");
        reader.readLine();

        for(int i = 0; i < count; i++) {
            deals = GuessMyCardService.deal(cards, 3);
            printSets(deals);
            System.out.print("Enter set containing your guessed card: ");
            set = Integer.parseInt(reader.readLine());
            cards = GuessMyCardService.putSetInMiddle(deals, set - 1);
        }

        System.out.print("The card you have chosen is: ");
        System.out.print(cards.get(cards.size()/2));
    }

    private static void printSets(List<ArrayList<String>> deals) {
        int setNum = 1;
        List<String> scrambledList;
        for(List<String> deal : deals) {
            System.out.println();
            System.out.println("Set " + setNum++ + ":");
            System.out.println("======");
            scrambledList = new ArrayList<String>();
            scrambledList.addAll(deal);
            Collections.shuffle(scrambledList);
            scrambledList.forEach(f -> System.out.println("[" + f + "]"));
        }
    }

}
