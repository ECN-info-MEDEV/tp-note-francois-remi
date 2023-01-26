/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale;

/**
 *
 * @author remir
 */
public class Pawn {
    
    public static int YELLOW = 0;
    public static int BLUE = 1;
    public static int RED = 2;
    public static int GREEN = 3;
    public static int WHITE = 4;
    public static int BLACK = 5;
    
    
    private int color;
    
    public Pawn () {
        color = RED;
    }

    public Pawn (int color){
        try{
            if (color < 0 || color > 5){
                throw new WrongValueException(color);
            }
            this.color = color;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Defaulting to RED.");
            this.color = RED;
        }
    }
    
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
        
}
