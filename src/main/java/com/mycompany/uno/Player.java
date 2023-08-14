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

public abstract class Player {
    private String name;
    private ArrayList<UnoCard> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<UnoCard> getHand() {
        return hand;
    }

    public void addCardToHand(UnoCard card) {
        hand.add(card);
    }

    public void removeCardFromHand(UnoCard card) {
        hand.remove(card);
    }

    public void displayHand() {
        System.out.println("Your hand:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println((i + 1) + ". " + hand.get(i).getFace());
        }
    }

    public abstract UnoCard chooseCard(UnoCard topCard, String currentColor);

    public abstract boolean uno();
}
