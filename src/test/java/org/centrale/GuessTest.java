package org.centrale;

import java.util.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author inky19
 */
public class GuessTest {
    
    public GuessTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of get method, of class Guess.
     */
    @Test
    public void testAddGet() {
        System.out.println("[Guess] add and get");
        int i = 0;
        Guess guess = new Guess();
        Pawn pawn = new Pawn(Pawn.BLUE);
        guess.add(pawn);
        Pawn result = guess.get(0);
        assertEquals(pawn, result);
    }

    /**
     * Test of toString method, of class Guess.
     */
    @Test
    public void testToString() {
        System.out.println("[Guess] toString");
        Guess guess = new Guess();
        guess.add(new Pawn(Pawn.YELLOW));
        guess.add(new Pawn(Pawn.BLUE));
        guess.add(new Pawn(Pawn.GREEN));
        String result = guess.toString();
        String expResult = "[ yellow, blue, green, null ]";
        assertEquals(expResult, result);
    }

    /**
     * Test of reset method, of class Guess.
     */
    @Test
    public void testReset() {
        System.out.println("[Guess] reset");
        Guess guess = new Guess();
        guess.add(new Pawn(Pawn.YELLOW));
        guess.add(new Pawn(Pawn.BLUE));
        guess.add(new Pawn(Pawn.GREEN));
        guess.reset();
        String expResult = "[ null, null, null, null ]";
        assertEquals(expResult, guess.toString());
    }

    /**
     * Test of getClues method, of class Guess.
     */
    @Test
    public void testGetClues() {
        System.out.println("[Guess] getClues");
        Guess code = new Guess();
        code.add(new Pawn(Pawn.YELLOW));
        code.add(new Pawn(Pawn.BLUE));
        code.add(new Pawn(Pawn.GREEN));
        code.add(new Pawn(Pawn.YELLOW));
        
        Guess guess = new Guess();
        guess.add(new Pawn(Pawn.YELLOW));
        guess.add(new Pawn(Pawn.BLACK));
        guess.add(new Pawn(Pawn.BLUE));
        guess.add(new Pawn(Pawn.WHITE));
        
        
        LinkedList<Clue> result = guess.getClues(code);
        for (Clue i : result){
            System.out.println(Pawn.getColorName(i.getColor()));
        }
        
        LinkedList<Clue> expResult = new LinkedList();
        expResult.add(new Clue(Clue.CORRECT));
        expResult.add(new Clue(Clue.MISPLACED));
        
        boolean equals = expResult.size() == result.size();
        if (equals){
            for (int i=0; i<result.size(); i++){
                equals = equals && expResult.get(i).getColor() == result.get(i).getColor();
            }
        }
        assertEquals(true, equals);
    }
    
}
