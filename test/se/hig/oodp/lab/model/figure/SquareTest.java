package se.hig.oodp.lab.model.figure;

/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Lab #1    Uppgift 2
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import se.hig.oodp.lab.model.Vertex2D;
import se.hig.oodp.lab.model.utility.DebugLogger;

import static org.junit.Assert.*;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Oct 1, 2015
 */
public class SquareTest extends FigureTest
{
    private static final double PRECISION = TestConstants.PRECISION;
    private static Square       square;

    @Before
    public void setUp() throws Exception
    {
        DebugLogger.log.fine("Testing Square");
        square = new Square(new Vertex2D(2.0, 1.0), 4);
    }

    @After
    public void tearDown() throws Exception
    {
        square = null;
    }

    @Test
    public void testSquare()
    {
        /*        |
         *   v3 o~~~~~~~o v2        v0: (0.0, -1.0)
         *      | |     |           v1: (4.0, -1.0)
         * -----|-+-----|-----      v2: (4.0, 3.0)
         *      | |     |           v3: (0.0, 3.0)
         *   v0 o~~~~~~~o v1
         *        |
         */

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, square.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, square.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(square, 0.0, -1.0, 0);
        checkVertex(square, 4.0, -1.0, 1);
        checkVertex(square, 4.0, 3.0, 2);
        checkVertex(square, 0.0, 3.0, 3);
    }

    @Test
    public void testRotate() throws Exception
    {
        square.rotate(30.0);

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, square.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, square.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(square, 1.268, -1.732, 0);
        checkVertex(square, 4.732, 0.268, 1);
        checkVertex(square, 2.732, 3.732, 2);
        checkVertex(square, -0.732, 1.732, 3);
    }

    @Test
    public void testScale() throws Exception
    {
        square.scale(1.21, 1.21);

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, square.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, square.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(square, -0.42, -1.42, 0);
        checkVertex(square, 4.42, -1.42, 1);
        checkVertex(square, 4.42, 3.42, 2);
        checkVertex(square, -0.42, 3.42, 3);

    }

    @Test
    public void testMoveBy() throws Exception
    {
        square.moveBy(3.0, 3.0);

        /* Test center */
        assertEquals("Wrong X-position!", 5.0, square.getCenter().getX(),
                     PRECISION);
        assertEquals("Wrong Y-position!", 4.0, square.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(square, 3.0, 2.0, 0);
        checkVertex(square, 7.0, 2.0, 1);
        checkVertex(square, 7.0, 6.0, 2);
        checkVertex(square, 3.0, 6.0, 3);
    }

    @Test
    public void testGetCenter() throws Exception
    {
        /* Test center */
        assertEquals("Wrong X-position!", 2.0, square.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, square.getCenter().getY(), PRECISION);
    }

    @Ignore
    @Test
    public void testToString() throws Exception
    {
        // fail("Not yet implemented!");
    }
}
