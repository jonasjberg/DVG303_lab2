/**
 * DVG303 :: Objektorienterad design och programmering
 * 860224 Jonas Sjöberg
 * Högskolan i Gävle
 * tel12jsg@student.hig.se
 *
 * Lab #1    Uppgift 1
 */

package se.hig.oodp.lab.model.simplefigure;

import se.hig.oodp.lab.model.Vertex2D;
import se.hig.oodp.lab.model.figure.Constants;

/**
 * @author  Jonas Sjöberg
 *		    tel12jsg@student.hig.se
 * @date	Sep 27, 2015
 */
public class Point extends SimpleFigure
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

    /**
     * Returns the object data in a somewhat more "human readable" format.
     * @return      object data as a string
     */
    @Override
    public String toString()
    {
        final String NEWLINE = Constants.NEWLINE;
        StringBuilder str = new StringBuilder();

        /* Anropa först superklassens 'toString()'-metod. */
        // str.append(super.toString());

        /* Utöka sedan med 'Point'-objektets data. */
        str.append("Point:  " + this.hashCode() + NEWLINE);
        str.append("  pos: (" + getCenter().getX() + ", " + getCenter().getY()
                   + ")" + NEWLINE);
        str.append(NEWLINE);
        return str.toString();
    }
}
