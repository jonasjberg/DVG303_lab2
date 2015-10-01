/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Labb #1
 */

package se.hig.oodp.lab.model.figure;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import se.hig.oodp.lab.model.utility.DebugLogger;
import se.hig.oodp.lab.model.Vertex2D;

import static org.junit.Assert.assertEquals;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public class LineTest extends FigureTest
{
    private static final double PRECISION = TestConstants.PRECISION;
    private static Line         line;

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
    public void testLine()
    {
        /* Test center */
        assertEquals("Wrong X-position!", 2.0, line.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, line.getCenter().getY(), PRECISION);
    }

    @Test
    public void testMoveBy() throws Exception
    {
        line.moveBy(3.0, 3.0);

        /* Test center */
        assertEquals("Wrong X-position!", 5.0, line.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 4.0, line.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(line, 3.0, 3.0, 0);
        checkVertex(line, 7.0, 5.0, 1);
    }

    @Test
    public void testScale() throws Exception
    {
        line.scale(1.21, 1.21);

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, line.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, line.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(line, -0.42, -0.21, 0);
        checkVertex(line, 4.42, 2.21, 1);
    }

    @Test
    public void testRotate() throws Exception
    {
        line.rotate(30.0);

        /* Test center */
        assertEquals("Wrong X-position!", 2.0, line.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, line.getCenter().getY(), PRECISION);

        /* Test individual vertices */
        checkVertex(line, 0.768, -0.866, 0);
        checkVertex(line, 3.232, 2.866, 1);
    }

    @Test
    public void testGetCenter() throws Exception
    {
        /* Test center */
        assertEquals("Wrong X-position!", 2.0, line.getCenter().getX(), PRECISION);
        assertEquals("Wrong Y-position!", 1.0, line.getCenter().getY(), PRECISION);
    }
}
