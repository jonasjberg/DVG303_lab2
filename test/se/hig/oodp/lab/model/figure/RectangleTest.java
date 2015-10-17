/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Lab #2
 */

package se.hig.oodp.lab.model.figure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import se.hig.oodp.lab.model.Vertex2D;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 28, 2015
 */
public class RectangleTest extends FigureTest
{
    private static final double PRECISION = TestConstants.PRECISION;
    private static Rectangle    rectangle;

    @Before
    public void setUp() throws Exception
    {
        rectangle = new Rectangle(new Vertex2D(2.0, 1.0), 6, 4);
    }

    @After
    public void tearDown() throws Exception
    {
        rectangle = null;
    }

    @Test
    public void testRectangle() throws Exception
    {
        /*        |
         *   v3 o~~~~~~~~~~~o v2            v0: (-1.0, -1.0)
         *      | |         |               v1: (5.0, -1.0)
         * -----|-+---------|-----          v2: (5.0, 3.0)
         *   v0 o~~~~~~~~~~~o v1            v3: (-1.0, 3.0)
         *        |                     center: (2.0, 1.0)
         */

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, rectangle.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, rectangle.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(rectangle, -1.0, -1.0, 0);
        checkVertex(rectangle, 5.0, -1.0, 1);
        checkVertex(rectangle, 5.0, 3.0, 2);
        checkVertex(rectangle, -1.0, 3.0, 3);
    }

    @Test
    public void testMoveBy() throws Exception
    {
        rectangle.moveBy(3.0, 3.0);

        /* Test center */
        assertEquals("Wrong X-position!", 5.0, rectangle.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 4.0, rectangle.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(rectangle, 2.0, 2.0, 0);
        checkVertex(rectangle, 8.0, 2.0, 1);
        checkVertex(rectangle, 8.0, 6.0, 2);
        checkVertex(rectangle, 2.0, 6.0, 3);
    }

    @Test
    public void testScale() throws Exception
    {
        rectangle.scale(1.21, 1.21);

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, rectangle.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, rectangle.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(rectangle, -1.63, -1.42, 0);
        checkVertex(rectangle, 5.63, -1.42, 1);
        checkVertex(rectangle, 5.63, 3.42, 2);
        checkVertex(rectangle, -1.63, 3.42, 3);
    }

    @Test
    public void testRotate() throws Exception
    {
        rectangle.rotate(30.0);

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, rectangle.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, rectangle.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(rectangle, 0.402, -2.232, 0);
        checkVertex(rectangle, 5.598, 0.768, 1);
        checkVertex(rectangle, 3.598, 4.232, 2);
        checkVertex(rectangle, -1.598, 1.232, 3);
    }
}
