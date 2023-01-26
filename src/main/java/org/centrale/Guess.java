package org.centrale;

import java.util.LinkedList;

/**
 * Guess of the player that must be compared to the current code.
 * @author Rémi Ravelli
 * @author François Marie
 */
public class Guess {
    
    private Pawn[] pawns; // List of guessed pawns
    private int index; // Index of next pawn to modify
    
    public Guess() {
        pawns = new Pawn[4];
        index = 0;
    }
    
    /**
     * Get pawn with index.
     * The pawn's index must be inferior to the index of the last added pawn.
     * @param i index of pawn
     * @return pawn
     */
    public Pawn get(int i){
        if (i>=0 && i<index){
            return pawns[i];
        } else {
            System.out.println("Invalid index ! Must be between 0 and " + index);
            return null;
        }
        
    }
    
    /**
     * Add a pawn to the guess.
     * Throw a wrong value execption if the guess is already completed.
     * @param pawn Pawn to add
     */
    public void add(Pawn pawn){
        try{
            if (index > 3){
                throw new WrongValueException(index+1);
            }
            pawns[index] = pawn;
            index++;
        } catch (WrongValueException e) {
            System.out.println("Guess already completed !");
        }
    }
    
    /**
     * Print each pawn color in a array-like shape.
     * @return string
     */
    public String toString(){
        String res = "[ ";
        for (int i=0; i<index; i++){
            res += Pawn.getColorName(pawns[i].getColor()) + ", ";
        }
        for (int i=index; i<4; i++){
            res += "null, ";
        }
        res = res.substring(0, res.length()-2) +  " ]";
        return res;
    }
    
    /**
     * Reset the guess
     */
    public void reset(){
        index = 0;
    }
    
    /**
     * Compute the list of clues with a given code to compare with.
     * @param code Code to compare
     * @return LinkedList of clues.
     */
    public LinkedList<Clue> getClues(Guess code){
        LinkedList<Clue> clues = new LinkedList<>();
        try {
            if (index < 3){
                throw new Exception("Guess not completed");
            }
            boolean[] checkedPosCode = {false, false, false, false};
            boolean[] checkedPosGuess = {false, false, false, false};
            
            for (int i=0; i<4; i++){
                if (code.get(i).getColor() == pawns[i].getColor()){
                    clues.add(new Clue(Clue.CORRECT));
                    checkedPosGuess[i] = true;
                    checkedPosCode[i] = true;
                }
            }
            
            for (int i=0; i<4; i++){
                for (int j=0; j<4; j++){
                    if ((i!=j) && !checkedPosGuess[j] && !checkedPosCode[i] && code.get(i).getColor() == pawns[j].getColor()){
                        clues.add(new Clue(Clue.MISPLACED));
                        checkedPosGuess[j] = true;
                        checkedPosCode[i] = true;
                    }
                }
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clues;
    }
}
