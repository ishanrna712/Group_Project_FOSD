/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

/**
 *
 * @author Ishan Rana
 */
import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public UnoCard chooseCard(UnoCard topCard, String currentColor) {
        UnoCard chosenCard = null;

        for (UnoCard card : getHand()) {
            if (card.canPlace(topCard, currentColor)) {
                chosenCard = card;
                break;
            }
        }

        if (chosenCard == null) {
            return null;
        }

        return chosenCard;
    }

    @Override
    public boolean uno() {
        return getHand().size() == 1;
    }
}

