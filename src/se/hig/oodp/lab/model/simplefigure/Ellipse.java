/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Lab #1    Uppgift 3
 */

package se.hig.oodp.lab.model.simplefigure;

import se.hig.oodp.lab.model.Vertex2D;
import se.hig.oodp.lab.model.figure.Rotatable;
import se.hig.oodp.lab.model.figure.Scalable;
import se.hig.oodp.lab.model.simplefigure.SimpleFigure;
import se.hig.oodp.lab.model.utility.DebugLogger;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public class Ellipse extends SimpleFigure implements Scalable, Rotatable
{
    private double width, height, angle;

    /**
     * Creates a new instance of a 'Ellipse'.
     * @param position  center point
     *
     */
    public Ellipse(Vertex2D position, double width, double height)
    {
        super(position);

        this.width = width;
        this.height = height;
//        calculateAngle();
    }

    /**
     * Scale the Ellipse by 'xFactor' and 'yFactor' from a reference point.
     * @param xFactor       amount to scale in the X-axis
     * @param yFactor       amount to scale in the Y-axis
     */
    @Override
    public void scale(double xFactor, double yFactor)
    {
        if (xFactor == 0 || yFactor == 0) {
            DebugLogger.log.warning("scaling factor is 0");
        }

        width = width * xFactor;
        height = height * yFactor;
    }

    /**
     * Returns the width or horizontal size of the ellipse.
     * @return      the width or horizontal size of the ellipse.
     */
    public double getWidth()
    {
        return width;
    }

    /**
     * Return the height or vertical size of the ellipse
     * @return      the height or vertical size of the ellipse
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * Rotate the Rectangle by 'angle' degrees clockwise the center point.
     * @param angle         rotate clockwise by this angle in degrees
     */
    @Override
    public void rotate(double angle)
    {
        angle %= 360;
        this.angle += angle;
    }
}
