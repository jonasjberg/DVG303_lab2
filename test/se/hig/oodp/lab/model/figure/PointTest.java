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
public class PointTest extends TestCase
{
    private Point point;

    @Before
    public void setUp() throws Exception
    {
        point = new Point(new Vertex2D(2.0, 1.0));
    }

    @After
    public void tearDown() throws Exception
    { }

    @Test
    public void testPoint() throws Exception
    {
        assertEquals("Wrong X-position!", 2.0, point.getCenter().getX());
        assertEquals("Wrong Y-position!", 1.0, point.getCenter().getY());
    }

    @Test
    public void testMoveBy() throws Exception
    {
        point.moveBy(3.0, 3.0);
        assertEquals("Wrong X-position!", 5.0, point.getCenter().getX());
        assertEquals("Wrong Y-position!", 4.0, point.getCenter().getY());
    }

    @Test
    public void testGetCenter() throws Exception
    {
        assertEquals("Wrong X-position!", 2.0, point.getCenter().getX());
        assertEquals("Wrong Y-position!", 1.0, point.getCenter().getY());
    }
}
