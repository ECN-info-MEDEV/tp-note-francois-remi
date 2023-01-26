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
    
    private static final int minColor = 0;
    private static final int maxColor = 5;
    
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    public static final int RED = 2;
    public static final int GREEN = 3;
    public static final int YELLOW = 4;
    public static final int BLUE = 5;
    
    
    private int color;
    
    public Pawn () {
        color = RED;
    }

    public Pawn (int color){
        setColor(color);
    }
    
    public int maxColor(){
        return 5;
    }
    
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        try{
            if (color < minColor || color > maxColor()){
                throw new WrongValueException(color);
            }
            this.color = color;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Defaulting to RED.");
            this.color = RED;
        }
    }

    public static int getMaxColor() {
        return maxColor;
    }
    
    
        
    public static String getColorName(int color){
        switch(color){
            case 0:
                return "white";
            case 1:
                return "black";
            case 2:
                return "red";
            case 3:
                return "green";
            case 4:
                return "yellow";
            case 5:
                return "blue";
            default:
                return "unknown";
                
        }
    }
}
