/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Labb #1    Uppgift 1
 */

package se.hig.oodp.lab.model.figure;

import se.hig.oodp.lab.model.Vertex2D;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public class Point
{
    private Vertex2D center;

    /**
     * Creates a new instance of 'Point'.
     * @param center    position of the Point
     */
    public Point(Vertex2D center)
    {
        this.center = center;
    }

    /**
     * Move (translate) the Point by [dx, dy] from its current position.
     * @param dx    the distance to move along the X-axis
     * @param dy    the distance to move along the Y-axis
     */
    public void moveBy(double dx, double dy)
    {
        center = center.moveBy(dx, dy);
    }

    /**
     * Calculates and returns the center point of this Point.
     * @return      the center point of this Point
     */
    public Vertex2D getCenter()
    {
        return center;
    }

    @Override
    public String toString()
    {
        /* TODO: */
        return null;
    }
}
