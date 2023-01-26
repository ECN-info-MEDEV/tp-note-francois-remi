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
        Guess guess = new Guess();
        guess.add(pawn1);
        System.out.println(guess);
        Clue aled = new Clue(3);
        System.out.println(pawn1.maxColor());
        System.out.println(aled.maxColor());
        int[] test = new int[4]; 
        test[0] = 2;
        System.out.println(test);
    }
}
