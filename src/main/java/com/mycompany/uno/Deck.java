/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

/**
 *
 * @author Ishan Rana
 */
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<UnoCard> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (int i = 0; i < 2; i++) {
            for (int value = 0; value <= 14; value++) {
                for (String color : new String[]{"Red", "Green", "Blue", "Yellow"}) {
                    UnoCard card = new UnoCard(value, color);
                    cards.add(card);
                }
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public UnoCard drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        }
        return null;
    }
}

