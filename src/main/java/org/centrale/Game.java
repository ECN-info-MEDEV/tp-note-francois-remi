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
    private LinkedList<LinkedList<Clue>> clues;
    private Guess code;
    private static final Scanner scan = new Scanner(System.in);
    private int guesser;
    private static final String SEP = "---------------------------------------------------------------------------------------------------------";
    
    public Game() {
        guesses = new LinkedList<>();
        players = new LinkedList<>();
        clues = new LinkedList<>();
        code = new Guess();
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
        code.reset();
        System.out.println(players.get(guesser).getName() + " choisi un code");
        for (int pawn=0; pawn < 4; pawn++) {
            System.out.println("Pion n°" + Integer.toString(pawn + 1));
            System.out.println("Choisir parmi 0 : JAUNE, 1 : BLEU, 2 : ROUGE, 3 : VERT, 4 : BLANC, 5 : NOIR");
            Pawn choice = null;
            while (choice == null) {
                String input = scan.nextLine(); 
                try {
                   choice = new Pawn(Integer.parseInt(input));
                } catch(Exception e) {
                    System.out.println("Invalid Expression");
                }   
            }
            code.add(choice);
            
        }
        System.out.println("La combinaison finale est " + code.toString());
        System.out.println("Appuyer sur ENTREE pour commencer la partie.");
        scan.nextLine();
        for (int i=0; i < 200; i++) {
            System.out.println(SEP);
        }
    }
    
    public void nextRound() {
        boolean win = false;
        Guess currentGuess = new Guess();
        guesses.clear();
        clues.clear();
        
        while(!win && guesses.size() < 12) {
            System.out.println(SEP);
            System.out.println("Essai " + (guesses.size() + 1) + "(" + (12 - guesses.size()) + " restants)");
            printGuesses();
            System.out.println(SEP);
            currentGuess.reset();
            
            for (int pawn=0; pawn < 4; pawn++) {
                System.out.println("Pion n°" + Integer.toString(pawn + 1));
                System.out.println("Choisir parmi 0 : JAUNE, 1 : BLEU, 2 : ROUGE, 3 : VERT, 4 : BLANC, 5 : NOIR");
                Pawn choice = null;
                while (choice == null) {
                    String input = scan.nextLine(); 
                    try {
                        choice = new Pawn(Integer.parseInt(input));
                    } catch(Exception e) {
                        System.out.println("Invalid Expression");
                    }   
                }
                currentGuess.add(choice);
            }
            System.out.println("Votre choix " + currentGuess);
            LinkedList<Clue> clue = currentGuess.getClues(code);
            System.out.println("INDICATIONS : "+ cluesToString(clue));
            
            guesses.add(currentGuess);
            clues.add(clue);
            
            win = combinationCorrect(clue);
        }
        if (win) {
            System.out.println("Voues avez trouvé le code du " + guesses.size() + "eme coups");
        } else {
            System.out.println("Dommage ! La combinaison était " + code.toString());
        }
        System.out.println(players.get(1 - guesser).getName() + " récupère " + guesses.size() + " points");
        players.get(1 - guesser).addScore(guesses.size());
    }
    
    private void printGuesses() {
        for (int i=0; i < guesses.size(); i++) {
            System.out.println((i+1) + " : " + guesses.get(i).toString() + " -> " + cluesToString(clues.get(i)));
        }
    }
    
    private String cluesToString(LinkedList<Clue> clue) {
        String str = "";
        for (Clue c : clue) {
            str += Clue.getColorName(c.getColor());
            str += ' ';
        }
        return str;
    }
   
    private boolean combinationCorrect(LinkedList<Clue> clue) {
        return (clue.size() == 4 && clue.get(0).getColor() == Clue.BLACK && clue.get(1).getColor() == Clue.BLACK && clue.get(2).getColor() == Clue.BLACK && clue.get(3).getColor() == Clue.BLACK);
    } 
    
    public void start() {
        choosePlayers();
        boolean finish = false;
        while(!finish) {
            chooseCode();
            System.out.println("Point sur les scores");
            System.out.println("    -"+players.get(0));
            System.out.println("    -"+players.get(1) + "\n"); 
            System.out.println(players.get(guesser).getName() + " devine le code");
            nextRound();
            guesser = 1 - guesser;
        }
    }
    
    
    
}
