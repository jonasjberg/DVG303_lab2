/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Lab #1
 */

package se.hig.oodp.lab.model.simplefigure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.hig.oodp.lab.model.Vertex2D;
import se.hig.oodp.lab.model.figure.TestConstants;
import se.hig.oodp.lab.model.utility.DebugLogger;

import static org.junit.Assert.*;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Oct 1, 2015
 */
public class EllipseTest
{
    private static final double PRECISION = TestConstants.PRECISION;
    private static Ellipse      ellipse;

    @Before
    public void setUp() throws Exception
    {
        DebugLogger.log.fine("Testing Ellipse");
        ellipse = new Ellipse(new Vertex2D(2.0, 1.0), 1.0, 0.7);
    }

    @After
    public void tearDown() throws Exception
    {
        ellipse = null;
    }

    @Test public void testEllipse()
    {
        /* Test center */
        assertEquals("Wrong X-position!", 2.0, ellipse.getPosition().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, ellipse.getPosition().getY(), PRECISION);

        /* Test "width" (a) and "height" (b) */
        assertEquals("Wrong width (a)!", 1.0, ellipse.getWidth(), PRECISION);
        assertEquals("Wrong height (b)!", 0.7, ellipse.getHeight(), PRECISION);
    }

    @Test
    public void testScale() throws Exception
    {
        ellipse.scale(1.21, 1.21);

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, ellipse.getPosition().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, ellipse.getPosition().getY(), PRECISION);

        /* Test "width" (a) and "height" (b) */
        assertEquals("Wrong width (a)!", 1.21, ellipse.getWidth(), PRECISION);
        assertEquals("Wrong height (b)!", 0.847, ellipse.getHeight(), PRECISION);
    }

    @Test public void testMoveBy() throws Exception
    {
        ellipse.moveBy(3.0, 3.0);

        /* Test center */
        assertEquals("Wrong X-position!", 5.0, ellipse.getPosition().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 4.0, ellipse.getPosition().getY(), PRECISION);

        /* Test "width" (a) and "height" (b) */
        assertEquals("Wrong width (a)!", 1.0, ellipse.getWidth(), PRECISION);
        assertEquals("Wrong height (b)!", 0.7, ellipse.getHeight(), PRECISION);
    }

    @Test public void testGetPosition() throws Exception
    {
        /* Test center */
        assertEquals("Wrong X-position!", 2.0, ellipse.getPosition().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, ellipse.getPosition().getY(), PRECISION);
    }
}
