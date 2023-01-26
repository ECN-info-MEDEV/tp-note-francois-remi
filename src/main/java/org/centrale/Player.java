package org.centrale;

/**
 *
 * @author François
 * @author Rémi
 */
public class Player {
    private String name;
    private int score;
    
    public Player(String name) {
        this.name = name;
        score = 0;
    }
    /**
     * Ajoute des points au score du joueur
     * @param point 
     */
    public void addScore(int point) {
        score += point;
    }
    /**
     * Getter du score du joueur
     * @return 
     */
    public int getScore() {
        return score;
    }
    /**
     * Getter du nom du joueur
     * @return 
     */
    public String getName() {
        return this.name;
    }
    /**
     * Affiche le nom du joueur ainsi que son score
     * @return 
     */
    @Override
    public String toString() {
        return name + " " + score + " points"; 
    }
}
