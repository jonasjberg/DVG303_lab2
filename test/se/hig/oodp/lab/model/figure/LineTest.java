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

    public void setUp() throws Exception
    {
        DebugLogger.log.info("Testing Line");
        line = new Line(new Vertex2D(0.0, 0.0), new Vertex2D(4.0, 2.0));
    }

    public void tearDown() throws Exception
    {
        line = null;
    }

    public void testMoveBy() throws Exception
    {
        double dx = 3.0;
        double dy = 3.0;
        double expectedX = 5.0;
        double expectedY = 4.0;

        line.moveBy(dx, dy);
        assertEquals("Wrong X-position!", expectedX, line.getCenter().getX());
        assertEquals("Wrong Y-position!", expectedY, line.getCenter().getY());

        /* Test v0*/
        assertEquals("v0 X-position is wrong!", 3.0, line.getVertex(0).getX());
        assertEquals("v0 Y-position is wrong!", 3.0, line.getVertex(0).getY());

        /* Test v1*/
        assertEquals("v1 X-position is wrong!", 7.0, line.getVertex(1).getX());
        assertEquals("v1 Y-position is wrong!", 5.0, line.getVertex(1).getY());
    }

    public void testRotate() throws Exception
    {

    }

    public void testScale() throws Exception
    {

    }

    public void testGetCenter() throws Exception
    {

    }

    public void testToString() throws Exception
    {

    }
}
