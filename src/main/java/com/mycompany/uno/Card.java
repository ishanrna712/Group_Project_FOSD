/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uno;

/**
 *
 * @author Ishan Rana
 */
public class Card {
    private String color;
    private int value;

    public Card(String color, int value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    public String getFace() {
        String face = "[";

        if (!color.equals("none")) {
            face += color + " ";
        }

        switch (value) {
            default:
                face += String.valueOf(value);
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

    public boolean canPlace(Card card, String currentColor) {
        return color.equals(card.getColor()) || value == card.getValue() || color.equals(currentColor);
    }
}
