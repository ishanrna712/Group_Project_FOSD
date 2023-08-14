/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.uno;

/*
 * @author Ishan Rana
 */
public class Main {
    public static void main(String[] args) {
        UnoGame unoGame = new UnoGame("Uno");
        HumanPlayer player1 = new HumanPlayer("Player 1");
        ComputerPlayer player2 = new ComputerPlayer("Computer 1");
        ComputerPlayer player3 = new ComputerPlayer("Computer 2");

        unoGame.addPlayer(player1);
        unoGame.addPlayer(player2);
        unoGame.addPlayer(player3);

        unoGame.initializeGame();
        unoGame.playGame();
    }
}
