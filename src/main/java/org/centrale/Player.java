/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale;

/**
 *
 * @author remir
 */
public class Player {
    private String name;
    private int score;
    
    public Player(String name) {
        this.name = name;
        score = 0;
    }
    
    public void addScore(int point) {
        score += point;
    }
    
    public int getScore() {
        return score;
    }
    
    @Override
    public String toString() {
        return name + " " + score + " points"; 
    }
}
