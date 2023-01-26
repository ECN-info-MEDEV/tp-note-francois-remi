package org.centrale;

/**
 *
 * @author François
 * @author Rémi
 */
public class Clue extends Pawn{
    
    private static final int maxColor = 2;
    
    @Override
    public int maxColor(){
        return 2;
    }
    /**
     * Le pion est mal placé
     */
    public final static int MISPLACED = Pawn.WHITE;
    /**
     * Le pion est bien placé
     */
    public final static int CORRECT = Pawn.BLACK;
    
    public Clue(){
        super();
    }
    
    public Clue(int color){
        super(color);
    }
    /**
     * Affiche la couleur de l'indice.
     * @return 
     */
    @Override
    public String toString() {
        return  Integer.toString(this.getColor());
    }
    
}
