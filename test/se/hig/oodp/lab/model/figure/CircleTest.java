/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Labb #1    Uppgift 1
 */

package se.hig.oodp.lab.model.figure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.hig.oodp.lab.model.Vertex2D;
import se.hig.oodp.lab.model.simplefigure.Circle;

import static org.junit.Assert.*;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public class CircleTest
{
    private static final double PRECISION = TestConstants.PRECISION;
    private static Circle circle;

    @Before public void setUp() throws Exception
    {
        circle = new Circle(new Vertex2D(2.0, 1.0), 1.0);
    }

    @After public void tearDown() throws Exception
    {
    }

    @Test public void testCircle()
    {
        assertEquals("Wrong X-position!", 2.0, circle.getPosition().getX(),
                     PRECISION);
        assertEquals("Wrong Y-position!", 1.0, circle.getPosition().getY(),
                     PRECISION);
        assertEquals("Wrong radius!", 1.0, circle.getRadius(), PRECISION);
    }

    @Test public void testMoveBy() throws Exception
    {
        circle.moveBy(3.0, 3.0);

        assertEquals("Wrong X-position!", 5.0, circle.getPosition().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 4.0, circle.getPosition().getY(), PRECISION);
        assertEquals("Wrong radius!", 1.0, circle.getRadius(), PRECISION);
    }

    @Test
    public void testScale() throws Exception
    {
        circle.scale(1.21);

        assertEquals("Wrong X-position!", 2.0, circle.getPosition().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, circle.getPosition().getY(), PRECISION);
        assertEquals("Wrong radius!", 1.21, circle.getRadius(), PRECISION);
    }

    @Test
    public void testGetCenter() throws Exception
    {
        assertEquals("Wrong X-position!", 2.0, circle.getPosition().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, circle.getPosition().getY(), PRECISION);
    }

    @Test
    public void testGetRadius() throws Exception
    {
        assertEquals("Wrong radius!", 1.0, circle.getRadius(), PRECISION);
    }
}
