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
import java.util.Scanner;

public class UnoGame {
    private String name;
    private ArrayList<Player> players;
    private Deck deck;
    private UnoCard topCard;
    private String currentColor;
    private boolean gameOver;

    public UnoGame(String name) {
        this.name = name;
        players = new ArrayList<>();
        deck = new Deck();
        topCard = deck.drawCard();
        currentColor = topCard.color;
        gameOver = false;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void initializeGame() {
        deck.shuffle();
        for (Player player : players) {
            drawCards(7, player);
        }
    }

    private void drawCards(int numCards, Player player) {
        for (int i = 0; i < numCards; i++) {
            UnoCard card = deck.drawCard();
            player.addCardToHand(card);
        }
    }

    private void displayTopCard() {
        System.out.println("Top card: " + topCard.getFace());
    }

    private void displayCurrentColor() {
        System.out.println("Current color: " + currentColor);
    }

    public void playGame() {
        int currentPlayerIndex = 0;

        while (!gameOver) {
            Player currentPlayer = players.get(currentPlayerIndex);
            displayTopCard();
            displayCurrentColor();
            currentPlayer.displayHand();

            UnoCard chosenCard;
            do {
                chosenCard = currentPlayer.chooseCard(topCard, currentColor);
                if (chosenCard == null) {
                    UnoCard drawnCard = deck.drawCard();
                    currentPlayer.addCardToHand(drawnCard);
                    System.out.println(currentPlayer.getName() + " draws a card.");
                    if (canPlay(drawnCard)) {
                        processCardPlayed(currentPlayer, drawnCard);
                    }
                } else if (canPlay(chosenCard)) {
                    processCardPlayed(currentPlayer, chosenCard);
                    System.out.println(currentPlayer.getName() + " plays " + chosenCard.getFace());
                }
            } while (chosenCard == null || !canPlay(chosenCard));

            if (currentPlayer.uno()) {
                System.out.println(currentPlayer.getName() + " says UNO!");
            }

            if (currentPlayer.getHand().isEmpty()) {
                System.out.println(currentPlayer.getName() + " wins!");
                gameOver = true;
            } else {
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            }
        }
    }

    private void processCardPlayed(Player player, UnoCard card) {
        player.removeCardFromHand(card);
        topCard = card;
        currentColor = card.color;
        if (card.value >= 10) {
            switch (card.value) {
                case 10: // Skip
                    skipPlayer();
                    break;
                case 11: // Reverse
                    reversePlayers();
                    break;
                case 12: // Draw 2
                    drawCards(2, getNextPlayer());
                    break;
                case 13: // Wild
                    chooseColor();
                    break;
                case 14: // Wild Draw 4
                    chooseColor();
                    drawCards(4, getNextPlayer());
                    break;
            }
        }
    }

    private boolean canPlay(UnoCard card) {
        return card.color.equals(currentColor) || card.value == topCard.value || card.color.equals("none");
    }

    private Player getNextPlayer() {
        int currentPlayerIndex = players.indexOf(getCurrentPlayer());
        int nextPlayerIndex = (currentPlayerIndex + 1) % players.size();
        return players.get(nextPlayerIndex);
    }

    private Player getCurrentPlayer() {
        int currentPlayerIndex = players.indexOf(players);
        return players.get(currentPlayerIndex);
    }

    private void skipPlayer() {
        Player nextPlayer = getNextPlayer();
        int nextPlayerIndex = players.indexOf(nextPlayer);
        int nextNextPlayerIndex = (nextPlayerIndex + 1) % players.size();
        Player nextNextPlayer = players.get(nextNextPlayerIndex);
        int currentPlayerIndex = nextNextPlayerIndex;
    }

    private void reversePlayers() {
        ArrayList<Player> reversedPlayers = new ArrayList<>();
        for (int i = players.size() - 1; i >= 0; i--) {
            reversedPlayers.add(players.get(i));
        }
        players = reversedPlayers;
    }

    private void chooseColor() {
        Scanner input = new Scanner(System.in);
        System.out.print("Choose a color (Red, Green, Blue, Yellow): ");
        String chosenColor = input.nextLine();
        while (!chosenColor.equals("Red") && !chosenColor.equals("Green")
                && !chosenColor.equals("Blue") && !chosenColor.equals("Yellow")) {
            System.out.print("Invalid color choice. Please choose a valid color: ");
            chosenColor = input.nextLine();
        }
        currentColor = chosenColor;
    }
}

