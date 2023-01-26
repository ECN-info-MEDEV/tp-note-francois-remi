package org.centrale;

import java.util.LinkedList;

/**
 *
 * @author remir
 */
public class Guess {
    
    private Pawn[] pawns;
    private int index; // Index of next pawn to modify
    
    public Guess() {
        pawns = new Pawn[4];
        index = 0;
    }
    
    public Pawn get(int i){
        if (i>=0 && i<pawns.length){
            return pawns[i];
        } else {
            System.out.println("Invalid index ! Must be between 0 and " + pawns.length);
            return null;
        }
        
    }
    
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
    
    public void reset(){
        index = 0;
    }
    
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
