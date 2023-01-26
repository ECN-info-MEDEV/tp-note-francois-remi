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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of addScore method, of class Player.
     */
    @Test
    public void testAddScore() {
        System.out.println("[Player] addScore");
        int point = 10;
        Player instance = new Player("test");
        instance.addScore(point);
        assertEquals(instance.getScore(), point);
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("[Player] getName");
        Player instance = new Player("test");
        String expResult = "test";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Player.
     */
    @Test
    public void testToString() {
        System.out.println("[Player] toString");
        Player instance = new Player("test");
        instance.addScore(5);
        String expResult = "test 5 points";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
