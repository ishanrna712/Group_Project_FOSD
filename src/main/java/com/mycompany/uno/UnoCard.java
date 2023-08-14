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

public class UnoCard {
    public String color;
    public int value;
    private String face;

    public UnoCard(int value, String color) {
        this.value = value;
        this.color = color;
    }

    public UnoCard() {
        Random rand = new Random();
        value = rand.nextInt(15);
        if (value >= 13) {
            value -= 13;
            color = "none";
        } else {
            switch (rand.nextInt(4)) {
                case 0:
                    color = "Red";
                    break;
                case 1:
                    color = "Green";
                    break;
                case 2:
                    color = "Blue";
                    break;
                case 3:
                    color = "Yellow";
                    break;
            }
        }
    }

    public String getFace() {
        face = "[";
        if (!color.equals("none")) {
            face += color + " ";
        }

        switch (value) {
            default:
                face += value;
                break;
            case 10:
                face += "Skip";
                break;
            case 11:
                face += "Reverse";
                break;
            case 12:
                face += "Draw 2";
                break;
            case 13:
                face += "Wild";
                break;
            case 14:
                face += "Wild Draw 4";
                break;
        }
        face += "]";
        return face;
    }

    public boolean canPlace(UnoCard card, String currentColor) {
        if (this.color.equals(currentColor))
            return true;
        else if (this.value == card.value)
            return true;
        else return this.color.equals("none");
    }
}
