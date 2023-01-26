package org.centrale;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author François
 * @author Rémi
 */
public class Game {
    /**
     * Les essai du décodeur
     */
    private final LinkedList<Guess> guesses;
    /**
     * Les joueurs de la partie
     */
    private final LinkedList<Player> players;
    /**
     * Les indications
     */
    private final LinkedList<LinkedList<Clue>> clues;
    /**
     * Le code à trouver
     */
    private final Guess code;
    /**
     * 
     */
    private Integer roundNumber;
    
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
    
    
    private void choosePlayers() {
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
        System.out.println("Choisir le nombre de tour.");
        roundNumber = null;
        while (roundNumber == null) {
            String input = scan.next();
            try {
                roundNumber = Integer.parseInt(input);
                if (roundNumber % 2 == 1 && roundNumber > 0) {
                    roundNumber = null;
                    System.out.println("Le nombre doit être paire");
                }
            } catch(Exception e) {
                System.out.println("Invalid Expression");
            }   
        }
    }
    
    private void chooseCode() {
        code.reset();
        System.out.println(players.get(guesser).getName() + " choisi un code");
        for (int pawn=0; pawn < 4; pawn++) {
            System.out.println("Pion n°" + Integer.toString(pawn + 1));
            System.out.println("Choisir parmi :");
            for (int i=0; i<6; i++) {
                System.out.println(i + " : " + Pawn.getColorName(i));
            }
            Pawn choice = null;
            while (choice == null) {
                String input = scan.next(); 
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
    
    private void nextRound() {
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
                System.out.println("Choisir parmi :");
                for (int i=0; i<6; i++) {
                    System.out.println(i + " : " + Pawn.getColorName(i));
                }
                String input = null;
                Pawn choice = null;
                while (choice == null) {
                    input = scan.nextLine(); 
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
        System.out.println(SEP);
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
        if (clue.isEmpty()) {
            return "Auucune indication";
        }
        for (Clue c : clue) {
            str += Clue.getColorName(c.getColor());
            str += ' ';
        }
        return str;
    }
   
    private boolean combinationCorrect(LinkedList<Clue> clue) {
        return (clue.size() == 4 && clue.get(0).getColor() == Clue.BLACK && clue.get(1).getColor() == Clue.BLACK && clue.get(2).getColor() == Clue.BLACK && clue.get(3).getColor() == Clue.BLACK);
    } 
    /**
     * Fontion de lancement de la partie
     */
    public void start() {
        choosePlayers();
        int round = 0;
        while(round < roundNumber) {
            System.out.println(SEP);
            System.out.println("tour " + (round+1) + "/" + roundNumber);
            System.out.println(SEP);
            chooseCode();
            System.out.println("Point sur les scores");
            System.out.println("    -"+players.get(0));
            System.out.println("    -"+players.get(1) + "\n"); 
            System.out.println(players.get(guesser).getName() + " devine le code");
            nextRound();
            guesser = 1 - guesser;
            round++;
        }
        System.out.println(SEP);
        System.out.println("Fin de la partie");
        int score1 = players.get(0).getScore();
        int score2 = players.get(1).getScore();
        
        if ( score1 > score2) {
            System.out.println(players.get(0).getName() + " gagne la partie avec " + score1 + " points");
        } else if (score1 == score2) {
            System.out.println("Egalité, les deux joueurs gagnent");
        } else {
            System.out.println(players.get(1).getName() + " gagne la partie" + score2 + " points");
        }
    }
    
    
    
}
