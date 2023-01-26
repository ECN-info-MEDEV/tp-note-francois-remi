/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author remir
 */
public class Game {
    private LinkedList<Guess> guesses;
    private LinkedList<Player> players;
    private Guess code;
    private static final Scanner scan = new Scanner(System.in);
    private int guesser;
    
    public Game() {
        guesses = new LinkedList<>();
        players = new LinkedList<>();
        code = null;
        guesser = 0;
    }
    
    public void choosePlayers() {
        String name = null;
        
        System.out.println("Comment s'appelle le premier joueur ?");
        name = null;
        while (name == null) {
            name = scan.next();
        }
        players.add(new Player(name));
        System.out.println("Comment s'appelle le second joueur ?");
        name = null;
        while (name == null) {
            name = scan.next();
        }
        players.add(new Player(name));
    }
    
    public void chooseCode() {
        System.out.println(players.get(guesser).getName() + " choisi un code");
        for (int pawn=0; pawn < 4; pawn++) {
            System.out.println("Pion n°" + Integer.toString(pawn + 1));
            System.out.println("Choisir parmi 0 : JAUNE, 1 : BLEU, 2 : ROUGE, 3 : VERT, 4 : BLANC, 5 : NOIR");
            Integer color = null;
            while (color == null) {
                String input = scan.nextLine(); 
                try {
                   color = Integer.parseInt(input);
                } catch(Exception e) {
                    System.out.println("Invalid Expression");
                }   
            }
            
        }
//        System.out.println("La combinaison finale est " + code.toString());
        System.out.println("Appuyer sur ENTREE pour commencer la partie.");
        scan.nextLine();
        for (int i=0; i < 200; i++) {
            System.out.println("---------------------------------------------------------------------------------------------------------");
        }
    }
   
    
    public void start() {
        choosePlayers();
        chooseCode();
    }
    
    
    
}
