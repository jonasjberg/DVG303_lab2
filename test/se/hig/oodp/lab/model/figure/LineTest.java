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
import se.hig.oodp.lab.model.Utility.DebugLogger;
import se.hig.oodp.lab.model.Vertex2D;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public class LineTest extends TestCase
{
    private static Line line;

    @Before
    public void setUp() throws Exception
    {
        DebugLogger.log.fine("Testing Line");
        line = new Line(new Vertex2D(0.0, 0.0), new Vertex2D(4.0, 2.0));
    }

    @After
    public void tearDown() throws Exception
    {
        line = null;
    }

    @Test
    public void testMoveBy() throws Exception
    {
        line.moveBy(3.0, 3.0);

        /* Test center */
        assertEquals("Wrong X-position!", 5.0, line.getCenter().getX());
        assertEquals("Wrong Y-position!", 4.0, line.getCenter().getY());

        /* Test v0*/
        assertEquals("v0 X-position is wrong!", 3.0, line.getVertex(0).getX());
        assertEquals("v0 Y-position is wrong!", 3.0, line.getVertex(0).getY());

        /* Test v1*/
        assertEquals("v1 X-position is wrong!", 7.0, line.getVertex(1).getX());
        assertEquals("v1 Y-position is wrong!", 5.0, line.getVertex(1).getY());
    }

    @Test
    public void testScale() throws Exception
    {
        line.scale(1.21, 1.21);

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, line.getCenter().getX());
        assertEquals("Wrong Y-position!", 1.0, line.getCenter().getY());

        /* Test v0*/
        assertEquals("v0 X-position is wrong!", -0.42, line.getVertex(0).getX());
        assertEquals("v0 Y-position is wrong!", -0.21, line.getVertex(0).getY());

        /* Test v1*/
        assertEquals("v1 X-position is wrong!", 4.42, line.getVertex(1).getX());
        assertEquals("v1 Y-position is wrong!", 2.21, line.getVertex(1).getY());
    }

    @Test
    public void testRotate() throws Exception
    {
        line.rotate(30.0);

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, line.getCenter().getX());
        assertEquals("Wrong Y-position!", 1.0, line.getCenter().getY());

        /* Test v0*/
        assertEquals("v0 X-position is wrong!", 0.768, line.getVertex(0).getX());
        assertEquals("v0 Y-position is wrong!", -0.866, line.getVertex(0).getY());

        /* Test v1*/
        assertEquals("v1 X-position is wrong!", 3.232, line.getVertex(1).getX());
        assertEquals("v1 Y-position is wrong!", 2.866, line.getVertex(1).getY());
    }

    @Test
    public void testGetCenter() throws Exception
    {
        fail("Not yet implemented!");
    }

    @Test
    public void testToString() throws Exception
    {
        fail("Not yet implemented!");
    }
}
