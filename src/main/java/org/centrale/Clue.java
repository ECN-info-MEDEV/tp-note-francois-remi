/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale;

/**
 *
 * @author remir
 */
public class Clue extends Pawn{
    
    private static final int maxColor = 2;
    
    @Override
    public int maxColor(){
        return 2;
    }
    
    public final static int MISPLACED = Pawn.WHITE;
    public final static int CORRECT = Pawn.BLACK;
    
    public Clue(){
        super();
    }
    
    public Clue(int color){
        super(color);
    }  
    
}
