package org.centrale;

/**
 * Pawn
 * @author Rémi Ravelli
 * @author François Marie
 */
public class Pawn {
    
    private static final int minColor = 0;
    
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    public static final int RED = 2;
    public static final int GREEN = 3;
    public static final int YELLOW = 4;
    public static final int BLUE = 5;
    
    
    private int color;
    
    /**
     * Default constructor.
     * The color is set as red.
     */
    public Pawn () {
        color = RED;
    }
    
    /**
     * Constructor with a given color.
     * The color must be between minColor and maxColor().
     * @param color Color of the pawn.
     */
    public Pawn (int color){
        setColor(color);
    }
    
    /**
     * Get maxColor constant for the class.
     * Is impletement as a method so it can be overriden by children classes.
     * @return maxColor
     */
    public int maxColor(){
        return 5;
    }
    
    /**
     * Get color of pawn
     * @return color
     */
    public int getColor() {
        return color;
    }

    /**
     * Set the color of the pawn.
     * Color must be between minColor and maxColor.
     * @param color new color
     */
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
    
    /**
     * Convert index-based color into a string.
     * @param color Color to convert
     * @return name of the color
     */
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
