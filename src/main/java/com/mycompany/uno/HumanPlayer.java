/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

/**
 *
 * @author Ishan Rana
 */
import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public UnoCard chooseCard(UnoCard topCard, String currentColor) {
        Scanner input = new Scanner(System.in);
        int choiceIndex;
        UnoCard chosenCard = null;

        do {
            System.out.print("Choose a card to play (enter the index, or 0 to draw a card): ");
            if (input.hasNextInt()) {
                choiceIndex = input.nextInt();
                if (choiceIndex >= 1 && choiceIndex <= getHand().size()) {
                    chosenCard = getHand().get(choiceIndex - 1);
                    if (!chosenCard.canPlace(topCard, currentColor)) {
                        System.out.println("Invalid choice. You cannot play that card.");
                        chosenCard = null;
                    }
                } else if (choiceIndex == 0) {
                    return null;
                } else {
                    System.out.println("Invalid choice. Please choose a valid index.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                input.next();
            }
        } while (chosenCard == null);

        return chosenCard;
    }

    @Override
    public boolean uno() {
        return getHand().size() == 1;
    }
}

