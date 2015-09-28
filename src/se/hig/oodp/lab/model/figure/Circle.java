/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Labb #1    Uppgift 1
 */

package se.hig.oodp.lab.model.figure;

import se.hig.oodp.lab.model.Utility.DebugLogger;
import se.hig.oodp.lab.model.Vertex2D;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public class Circle
{
    private Vertex2D center;
    private double radius;

    /**
     * Creates a new instance of a 'Circle'.
     * @param center    center point
     */
    public Circle(Vertex2D center, double radius)
    {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Move (translate) the Circle by [dx, dy] from its current position.
     * @param dx    the distance to move along the X-axis
     * @param dy    the distance to move along the Y-axis
     */
    public void moveBy(double dx, double dy)
    {
        center = center.moveBy(dx, dy);
    }

    /**
     * Rotate the Circle by 'angle' degrees clockwise from a reference point.
     * @param angle         rotate clockwise by this angle in degrees
     */
    public void rotate(double angle)
    {
        angle %= 360;
        center = center.rotate(center, angle);
    }

    /**
     * Scale the Circle by 'factor' from a reference point.
     * @param factor    scaling factor
     */
    public void scale(double factor)
    {
        if (factor == 0) {
            DebugLogger.log.warning("Scaling factor is 0");
        }
        radius = radius * factor;
    }

    /**
     * Calculates and returns the center point of this Circle.
     * @return      the center point of this Circle
     */
    public Vertex2D getCenter()
    {
        return center;
    }

    /**
     * Return the radius of this Circle
     * @return      radius of the circle
     */
    public double getRadius()
    {
        return radius;
    }

    @Override
    public String toString()
    {
        /* TODO: */
        return null;
    }
}
