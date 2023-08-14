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

public abstract class Game {
    private String name;
    private ArrayList<Player> players;

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public abstract void initializeGame();
    public abstract void playGame();
    public abstract void declareWinner();

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
