package org.centrale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Pawn pawn1 = new Pawn(Pawn.YELLOW);
        Pawn pawn2 = new Pawn(8);
        Game g = new Game();
        g.start();
    }
}
