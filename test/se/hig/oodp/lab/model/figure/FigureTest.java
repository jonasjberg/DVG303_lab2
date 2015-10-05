/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Lab #1
 */

package se.hig.oodp.lab.model.figure;

import static org.junit.Assert.assertEquals;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date    Oct 1, 2015
 */
public class FigureTest
{
    private static final double PRECISION = TestConstants.PRECISION;

    public FigureTest()
    { /* TODO: implement this .. */ }

    /**
     * Helper method for checking individual Vertex2D positions.
     * @param figure    figure under test
     * @param expectX   expected X-position
     * @param expectY   expected Y-position
     * @param n         index of this Vertex in the ArrayList 'vertices'
     */
    protected void checkVertex(Figure figure, double expectX, double expectY, int n)
    {
        final String MSG_X = "v" + n + " X-position is wrong!";
        final String MSG_Y = "v" + n + " Y-position is wrong!";
        assertEquals(MSG_X, expectX, figure.getVertex(n).getX(), PRECISION);
        assertEquals(MSG_Y, expectY, figure.getVertex(n).getY(), PRECISION);
    }

    /**
     * Helper method for checking individual Vertex2D positions with a
     * specified precision.
     * @param figure    figure under test
     * @param expectX   expected X-position
     * @param expectY   expected Y-position
     * @param n         index of this Vertex in the ArrayList 'vertices'
     * @param precision precision when comparing doubles, etc.
     */
    protected void checkVertex(Figure figure, double expectX, double expectY, int n, int precision)
    {
        final String MSG_X = "v" + n + " X-position is wrong!";
        final String MSG_Y = "v" + n + " Y-position is wrong!";
        assertEquals(MSG_X, expectX, figure.getVertex(n).getX(), precision);
        assertEquals(MSG_Y, expectY, figure.getVertex(n).getY(), precision);
    }
}
