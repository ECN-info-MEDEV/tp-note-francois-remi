/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale;

/**
 *
 * @author remir
 */
public class Clue {
    public final static int MISPLACED = 0;
    public final static int CORRECT = 1;
    
    private int type;
    
    public Clue(int type) throws Exception {
        if (type == 0 || type == 1) {
            this.type = type;
        } else {
            throw new Exception("Wrong value thrown");
        }    
    }
    public int getType() {
        return type;
    }
}
