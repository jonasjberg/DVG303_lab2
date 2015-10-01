/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Labb #1
 */

package se.hig.oodp.lab.model.figure;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import se.hig.oodp.lab.model.Vertex2D;

import static org.junit.Assert.*;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 28, 2015
 */
public class TriangleTest extends FigureTest
{
    private static final double PRECISION = 0.1;   /* work around rounding .. */
    private static Triangle     triangle;
    private static Vertex2D     v0, v1, v2;

    @Before public void setUp() throws Exception
    {
        v0 = new Vertex2D(-1.0, 1.0);
        v1 = new Vertex2D(3.0, -1.0);
        v2 = new Vertex2D(5.0, 3.0);
        triangle = new Triangle(v0, v1, v2);
    }

    @After
    public void tearDown() throws Exception
    {
        triangle = null;
    }

    @Test
    public void testMoveBy() throws Exception
    {
        triangle.moveBy(3.0, 3.0);

        /* Test center */
        assertEquals("Wrong X-position!", 5.0, triangle.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 4.0, triangle.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(triangle, 2.0, 4.0, 0);
        checkVertex(triangle, 6.0, 2.0, 1);
        checkVertex(triangle, 8.0, 6.0, 2);
    }

    @Test
    public void testRotate() throws Exception
    {
        triangle.rotate(30.0);

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, triangle.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, triangle.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(triangle, -0.598, -0.5, 0);
        checkVertex(triangle, 3.866, -0.232, 1);
        checkVertex(triangle, 3.598, 4.232, 2);
    }

    @Test
    public void testScale() throws Exception
    {
        triangle.scale(1.21, 1.21);

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, triangle.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, triangle.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(triangle, -1.63, 1.0, 0);
        checkVertex(triangle, 3.21, -1.42, 1);
        checkVertex(triangle, 5.63, 3.42, 2);
    }

    @Test
    public void testTriangle() throws Exception
    {
        /*            |
         *            |   o v2             v0: (-1.0, 1.0)
         *            |  / \               v1: (3.0, -1.0)
         *            | /   \              v2: (5.0, 3.0)
         * -----------+/-----\-----
         *            /   X   \
         *           /| center \
         *          / |         \
         *      v0 o~~~~~~~~~~~~~o v1
         *            |
         */

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, triangle.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, triangle.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(triangle, -1.0, 1.0, 0);
        checkVertex(triangle, 3.0, -1.0, 1);
        checkVertex(triangle, 5.0, 3.0, 2);
    }

    @Test
    public void testGetVertex() throws Exception
    {
        checkVertex(triangle, -1.0, 1.0, 0);
        checkVertex(triangle, 3.0, -1.0, 1);
        checkVertex(triangle, 5.0, 3.0, 2);
    }

    @Test
    public void testGetCenter() throws Exception
    {
        assertEquals("Wrong X-position!", 2.0, triangle.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, triangle.getCenter().getY(), PRECISION);
    }
}
