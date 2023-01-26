package org.centrale;

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
public class PawnTest {
    
    public PawnTest() {
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
     * Test of getColor method, of class Pawn.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Pawn instance = new Pawn(Pawn.RED);
        int expResult = Pawn.RED;
        int result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setColor method, of class Pawn.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        int color = Pawn.RED;
        Pawn instance = new Pawn();
        instance.setColor(color);
        assertEquals(color, instance.getColor());
    }
    
    /**
     * Test of setColor method with invalid color, of class Pawn.
     */
    @Test
    public void testWrongColorValue() {
        System.out.println("wrongColorValue");
        int color = -1;
        Pawn instance = new Pawn();
        instance.setColor(color);
        assertEquals(Pawn.RED, instance.getColor());
    }
    
}
