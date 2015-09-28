/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Labb #1    Uppgift 1
 */

package se.hig.oodp.lab.model.figure;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.hig.oodp.lab.model.Vertex2D;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 28, 2015
 */
public class RectangleTest extends TestCase
{
    private static final double PRECISION = TestConstants.PRECISION;
    private static Rectangle rectangle;

    @Before
    public void setUp() throws Exception
    {
        rectangle = new Rectangle(new Vertex2D(-1.0, 3.0), 6, 4);
    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void testRectangle() throws Exception
    {
        /*        |
         *   v3 o~|~~~~~~~~~o v2            v0: (-1.0, -1.0)
         *      | |         |               v1: (5.0, -1.0)
         * -----|-+---------|-----          v2: (5.0, 3.0)
         *   v0 o~|~~~~~~~~~o v1            v3: (-1.0, 3.0)
         *        |                     center: (2.0, 1.0)
         */

        /* Test center */
        System.out.println("center: " + rectangle.getCenter().toString());
        assertEquals("Wrong X-position!", 2.0, rectangle.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, rectangle.getCenter().getY(), PRECISION);

        /* Test v0 */
        assertEquals("v0 X-position is wrong!", -1.0, rectangle.getVertex(0).getX(), PRECISION);
        assertEquals("v0 Y-position is wrong!", -1.0, rectangle.getVertex(0).getY(), PRECISION);
        /* Test v1 */
        assertEquals("v1 X-position is wrong!", 5.0, rectangle.getVertex(1).getX(), PRECISION);
        assertEquals("v1 Y-position is wrong!", -1.0, rectangle.getVertex(1).getY(), PRECISION);
        /* Test v2 */
        assertEquals("v2 X-position is wrong!", 5.0, rectangle.getVertex(2).getX(), PRECISION);
        assertEquals("v2 Y-position is wrong!", 3.0, rectangle.getVertex(2).getY(), PRECISION);
        /* Test v3 */
        assertEquals("v3 X-position is wrong!", -1.0, rectangle.getVertex(3).getX(), PRECISION);
        assertEquals("v3 Y-position is wrong!", 3.0, rectangle.getVertex(3).getY(), PRECISION);
    }

    @Test
    public void testMoveBy() throws Exception
    {
        rectangle.moveBy(3.0, 3.0);

        /* Test center */
        assertEquals("Wrong X-position!", 5.0, rectangle.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 4.0, rectangle.getCenter().getY(), PRECISION);

        /* Test v0 */
        assertEquals("v0 X-position is wrong!", 2.0, rectangle.getVertex(0).getX(), PRECISION);
        assertEquals("v0 Y-position is wrong!", 2.0, rectangle.getVertex(0).getY(), PRECISION);
        /* Test v1 */
        assertEquals("v1 X-position is wrong!", 8.0, rectangle.getVertex(1).getX(), PRECISION);
        assertEquals("v1 Y-position is wrong!", 2.0, rectangle.getVertex(1).getY(), PRECISION);
        /* Test v2 */
        assertEquals("v2 X-position is wrong!", 8.0, rectangle.getVertex(2).getX(), PRECISION);
        assertEquals("v2 Y-position is wrong!", 6.0, rectangle.getVertex(2).getY(), PRECISION);
        /* Test v3 */
        assertEquals("v3 X-position is wrong!", 2.0, rectangle.getVertex(3).getX(), PRECISION);
        assertEquals("v3 Y-position is wrong!", 6.0, rectangle.getVertex(3).getY(), PRECISION);
    }

    @Test
    public void testScale() throws Exception
    {
        rectangle.scale(1.21, 1.21);

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, rectangle.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, rectangle.getCenter().getY(), PRECISION);

        /* Test v0 */
        assertEquals("v0 X-position is wrong!", -1.63, rectangle.getVertex(0).getX(), PRECISION);
        assertEquals("v0 Y-position is wrong!", -1.42, rectangle.getVertex(0).getY(), PRECISION);
        /* Test v1 */
        assertEquals("v1 X-position is wrong!", 5.63, rectangle.getVertex(1).getX(), PRECISION);
        assertEquals("v1 Y-position is wrong!", -1.42, rectangle.getVertex(1).getY(), PRECISION);
        /* Test v2 */
        assertEquals("v2 X-position is wrong!", 5.63, rectangle.getVertex(2).getX(), PRECISION);
        assertEquals("v2 Y-position is wrong!", 3.42, rectangle.getVertex(2).getY(), PRECISION);
        /* Test v3 */
        assertEquals("v3 X-position is wrong!", -1.63, rectangle.getVertex(3).getX(), PRECISION);
        assertEquals("v3 Y-position is wrong!", 3.42, rectangle.getVertex(3).getY(), PRECISION);
    }

    @Test
    public void testRotate() throws Exception
    {
        rectangle.rotate(30.0);

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, rectangle.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, rectangle.getCenter().getY(), PRECISION);

        /* Test v0 */
        assertEquals("v0 X-position is wrong!", 0.402, rectangle.getVertex(0).getX(), PRECISION);
        assertEquals("v0 Y-position is wrong!", -2.232, rectangle.getVertex(0).getY(), PRECISION);
        /* Test v1 */
        assertEquals("v1 X-position is wrong!", 5.598, rectangle.getVertex(1).getX(), PRECISION);
        assertEquals("v1 Y-position is wrong!", 0.768, rectangle.getVertex(1).getY(), PRECISION);
        /* Test v2 */
        assertEquals("v2 X-position is wrong!", 3.598, rectangle.getVertex(2).getX(), PRECISION);
        assertEquals("v2 Y-position is wrong!", 4.232, rectangle.getVertex(2).getY(), PRECISION);
        /* Test v3 */
        assertEquals("v3 X-position is wrong!", -1.598, rectangle.getVertex(3).getX(), PRECISION);
        assertEquals("v3 Y-position is wrong!", 1.232, rectangle.getVertex(3).getY(), PRECISION);

    }
}
